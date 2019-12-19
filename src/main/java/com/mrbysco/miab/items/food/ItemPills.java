package com.mrbysco.miab.items.food;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ItemPills extends ItemCustomFood {
	private SoundEvent sound;

	public ItemPills(int amount, float saturation, boolean isWolfFood, String registry, SoundEvent soundIn)
	{
		super(amount, saturation, isWolfFood, registry);
		this.sound = soundIn;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	{
		entityLiving.playSound(this.sound, 1F, 1F);
		entityLiving.heal(4);
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		playerIn.playSound(this.sound, 1F, 1F);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
