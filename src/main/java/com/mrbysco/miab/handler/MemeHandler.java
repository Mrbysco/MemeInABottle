package com.mrbysco.miab.handler;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.init.MemeRegister;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

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

	public static List<Item> memeBottles = Lists.newArrayList();

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

	private static final Predicate<Entity> ALIVE_PREDICATE = (entity) -> {
		return entity.isAlive();
	};

	@SubscribeEvent
	public void onTick(TickEvent.WorldTickEvent event)
	{
		if(event.phase == Phase.END && event.side == LogicalSide.SERVER) {
			ServerWorld world = (ServerWorld)event.world;
			if (world.getGameTime() % 40 == 0) {
				for(Entity entity : world.getEntities(EntityType.AREA_EFFECT_CLOUD, ALIVE_PREDICATE)) {
					if(entity.getCustomName().getFormattedText() == "dankcloud") {
						PlayerEntity player = world.getClosestPlayer(entity, 20);
						if(player != null)
						{
							int random = world.rand.nextInt(10);

							if(random < 4)
							{
								MemeRegistry.INSTANCE.triggerRandomMeme(world, entity.getPosition(), player);
							}
						}
					}
				}
			}
		}
	}
}
