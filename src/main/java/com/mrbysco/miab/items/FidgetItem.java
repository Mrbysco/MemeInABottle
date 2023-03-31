package com.mrbysco.miab.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FidgetItem extends MemeBaseItem {
	public FidgetItem(Item.Properties builder) {
		super(builder.stacksTo(1));
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 1200;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		ItemStack heldItem = playerIn.getItemInHand(handIn);

		playerIn.startUsingItem(handIn);
		return new InteractionResultHolder<>(InteractionResult.SUCCESS, heldItem);
	}
}
