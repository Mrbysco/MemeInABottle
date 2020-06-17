package com.mrbysco.miab.handler;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.init.MemeRegister;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class MemeHandler {
	@SubscribeEvent
	public void OnBlockInteraction(PlayerInteractEvent.RightClickBlock event) {
		ItemStack itemStack = event.getItemStack();
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		Block block = world.getBlockState(pos).getBlock();
		if (!world.isRemote && MemeConfig.SERVER.MemesOnBeach.get()) {
			if (BiomeDictionary.hasType(world.getBiome(pos), BiomeDictionary.Type.BEACH)) {
				if (block instanceof SandBlock) {
					if (itemStack.getItem() instanceof ShovelItem) {
						int itemDamage = itemStack.getDamage();

						int random = world.rand.nextInt(1000);
						if (random < 30) {
							world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), getRandomMemeBottle(world.rand)));
							itemStack.setDamage(itemDamage + 1);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void OnEntityInteraction(EntityInteract event) {
		ItemStack itemStack = event.getItemStack();
//		System.out.println(itemStack.getItem());
		World world = event.getWorld();
		if (!world.isRemote && MemeRegistry.nameList.contains(Reference.MOD_PREFIX + "pufferfish")) {
			Entity entity = event.getTarget();
			if (entity instanceof PufferfishEntity) {
				if (itemStack.getItem() == Items.CARROT) {
					if(MemeSounds.pufferfish.get() != null) {
						world.playSound((PlayerEntity)null, event.getPos(), MemeSounds.pufferfish.get(), SoundCategory.RECORDS, 0.75F, 1.0F);
					}
					entity.attackEntityFrom(DamageSource.GENERIC, 1.0F);
					if(!event.getPlayer().abilities.isCreativeMode) {
						itemStack.shrink(1);
					}
				}
			}
		}
	}

	public static List<Item> memeBottles = Lists.newArrayList();

	@Nonnull
	public static ItemStack getRandomMemeBottle(Random rand)
	{
		if(memeBottles.isEmpty()) {
			memeBottles.add(MemeRegister.meme_in_a_bottle.get());
			memeBottles.add(MemeRegister.splash_meme_in_a_bottle.get());
			memeBottles.add(MemeRegister.lingering_meme_in_a_bottle.get());
		}
		final int size = memeBottles.size();
		Preconditions.checkArgument(size > 0, "Can't select from empty list");
		if (size == 0) return null;
		if (size == 1) new ItemStack(memeBottles.get(0));
		int randomIndex = rand.nextInt(memeBottles.size());
		return new ItemStack(memeBottles.get(randomIndex));
	}

	private static final Predicate<Entity> ALIVE_PREDICATE = Entity::isAlive;

	@SubscribeEvent
	public void onTick(TickEvent.WorldTickEvent event)
	{
		if(event.phase == Phase.END && event.side == LogicalSide.SERVER) {
			ServerWorld world = (ServerWorld)event.world;
			if (world.getGameTime() % 40 == 0) {
				for(Entity entity : world.getEntities(EntityType.AREA_EFFECT_CLOUD, ALIVE_PREDICATE)) {
					if(entity.getCustomName() != null && entity.getCustomName().getFormattedText().equals("dankcloud")) {
						PlayerEntity player = world.getClosestPlayer(entity, 20);
						if(player != null) {
							int random = world.rand.nextInt(10);

							if(random < 4) {
								MemeRegistry.INSTANCE.triggerRandomMeme(world, entity.getPosition(), player);
							}
						}
					}
				}
			}
		}
	}
}
