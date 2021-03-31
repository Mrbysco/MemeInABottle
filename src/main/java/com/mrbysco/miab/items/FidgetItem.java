package com.mrbysco.miab.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FidgetItem extends MemeBaseItem {
	public FidgetItem(Item.Properties builder) {
		super(builder.maxStackSize(1));
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 1200;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack heldItem = playerIn.getHeldItem(handIn);

		playerIn.setActiveHand(handIn);
		return new ActionResult<>(ActionResultType.SUCCESS, heldItem);
	}
}
