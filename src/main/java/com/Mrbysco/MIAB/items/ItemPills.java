package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPills extends ItemFood{
	public ItemPills(int amount, float saturation, boolean isWolfFood, String UnlocalisedName, String RegistryName) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(UnlocalisedName);
		setRegistryName(RegistryName);
		setMaxStackSize(8);
		setCreativeTab(MIAB.tabMIAB);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		entityLiving.playSound(MiabSoundEvents.pills, 1F, 1F);
		entityLiving.heal(4);
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.playSound(MiabSoundEvents.pills, 1F, 1F);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
