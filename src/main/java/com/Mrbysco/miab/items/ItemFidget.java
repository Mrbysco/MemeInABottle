package com.mrbysco.miab.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemFidget extends ItemMemeBase {
	public ItemFidget(Item.Properties builder)
	{
		super(builder.maxStackSize(1));
		addPropertyOverride(new ResourceLocation("spinning"), new IItemPropertyGetter() {
			@Override
			public float call(ItemStack itemStack, @Nullable World world, @Nullable LivingEntity livingEntity) {
				return livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F;
			}
		});
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 1200;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack heldItem = playerIn.getHeldItem(handIn);

		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(ActionResultType.SUCCESS, heldItem);
	}
}
