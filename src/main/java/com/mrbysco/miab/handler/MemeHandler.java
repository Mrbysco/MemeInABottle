package com.mrbysco.miab.handler;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.memes.FunnyRegistry;
import com.mrbysco.miab.registry.MemeRegistry;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Predicate;

public class MemeHandler {
	@SubscribeEvent
	public void onBlockInteraction(PlayerInteractEvent.RightClickBlock event) {
		ItemStack itemStack = event.getItemStack();
		BlockPos pos = event.getPos();
		Level level = event.getLevel();
		BlockState state = level.getBlockState(pos);
		Block block = state.getBlock();
		if (!level.isClientSide && MemeConfig.SERVER.memesOnBeach.get()) {
			Holder<Biome> biomeHolder = level.getBiome(pos);
			if (biomeHolder.is(BiomeTags.IS_BEACH)) {
				if (state.is(BlockTags.SAND)) {
					if (itemStack.getItem() instanceof ShovelItem) {
						int itemDamage = itemStack.getDamageValue();

						int random = level.random.nextInt(1000);
						if (random < 30) {
							level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), getRandomMemeBottle(level.random)));
							itemStack.setDamageValue(itemDamage + 1);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityInteraction(EntityInteract event) {
		ItemStack itemStack = event.getItemStack();
		Level world = event.getLevel();
		if (!world.isClientSide && FunnyRegistry.nameList.contains(Reference.MOD_PREFIX + "pufferfish")) {
			Entity entity = event.getTarget();
			if (entity instanceof Pufferfish) {
				if (itemStack.getItem() == Items.CARROT) {
					world.playSound((Player) null, event.getPos(), MemeSounds.pufferfish.get(), SoundSource.RECORDS, 0.75F, 1.0F);
					entity.hurt(world.damageSources().generic(), 1.0F);
					if (!event.getEntity().getAbilities().instabuild) {
						itemStack.shrink(1);
					}
				}
			}
		}
	}

	public static List<Item> memeBottles = Lists.newArrayList();

	@Nonnull
	public static ItemStack getRandomMemeBottle(RandomSource rand) {
		if (memeBottles.isEmpty()) {
			memeBottles.add(MemeRegistry.MEME_IN_A_BOTTLE.get());
			memeBottles.add(MemeRegistry.SPLASH_MEME_IN_A_BOTTLE.get());
			memeBottles.add(MemeRegistry.LINGERING_MEME_IN_A_BOTTLE.get());
		}
		final int size = memeBottles.size();
		Preconditions.checkArgument(size > 0, "Can't select from empty list");
		if (size == 0) return null;
		if (size == 1) new ItemStack(memeBottles.getFirst());
		int randomIndex = rand.nextInt(memeBottles.size());
		return new ItemStack(memeBottles.get(randomIndex));
	}

	private static final Predicate<Entity> ALIVE_PREDICATE = Entity::isAlive;

	@SubscribeEvent
	public void onTick(LevelTickEvent.Post event) {
		if (event.getLevel() instanceof ServerLevel serverLevel && serverLevel.dimension().equals(Level.OVERWORLD)) {
			if (serverLevel.getGameTime() % 40 == 0) {
				for (Entity entity : serverLevel.getEntities(EntityType.AREA_EFFECT_CLOUD, ALIVE_PREDICATE)) {
					if (entity.getCustomName() != null && entity.getCustomName().getString().equals("dankcloud")) {
						Player player = serverLevel.getNearestPlayer(entity, 20);
						if (player != null) {
							int random = serverLevel.random.nextInt(10);

							if (random < 4) {
								FunnyRegistry.instance().triggerRandomMeme(serverLevel, entity.blockPosition(), player);
							}
						}
					}
				}
			}
		}
	}
}
