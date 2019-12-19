package com.mrbysco.miab.handler;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.mrbysco.miab.init.MemeItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;

import java.util.List;
import java.util.Random;

public class MemeHandler {
	@SubscribeEvent
	public void OnBlockInteraction(PlayerInteractEvent.RightClickBlock event) {
		ItemStack itemStack = event.getItemStack();
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		Block block = world.getBlockState(pos).getBlock();

		if (!world.isRemote) {
			if (BiomeDictionary.hasType(world.getBiome(pos), BiomeDictionary.Type.BEACH)) {
				if (block instanceof BlockSand) {
					if (itemStack.getItem() instanceof ItemSpade) {
						int itemDamage = itemStack.getItemDamage();

						int random = world.rand.nextInt(1000);
						if (random < 30) {
							world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), getRandomMemeBottle(world.rand)));
							itemStack.setItemDamage(itemDamage + 1);
						}
					}
				}
			}
		}
	}

	public static List<Item> memeBottles = ImmutableList.of(
			MemeItems.meme_in_a_bottle,
			MemeItems.splash_meme_in_a_bottle,
			MemeItems.lingering_meme_in_a_bottle);

	public static ItemStack getRandomMemeBottle(Random rand)
	{
		final int size = memeBottles.size();
		Preconditions.checkArgument(size > 0, "Can't select from empty list");
		if (size == 0) return null;
		if (size == 1) new ItemStack(memeBottles.get(0));
		int randomIndex = rand.nextInt(memeBottles.size());
		return new ItemStack(memeBottles.get(randomIndex));
	}

	@SubscribeEvent
	public void onTick(TickEvent.WorldTickEvent event)
	{
		if(event.phase == Phase.END && event.side == Side.SERVER) {
			World world = event.world;
			if (world.getWorldTime() % 40 == 0) {
				for(EntityAreaEffectCloud entity : world.getEntities(EntityAreaEffectCloud.class, EntitySelectors.IS_ALIVE)) {
					if(entity.getCustomNameTag() == "dankcloud") {
						EntityPlayer player = world.getClosestPlayerToEntity(entity, 20);
						if(player != null)
						{
							int random = world.rand.nextInt(10);

							if(random < 4)
							{

							}
						}
					}
				}
			}
		}
	}
}
