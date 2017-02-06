package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemOnion extends ItemFood{

	public ItemOnion(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Reference.MIABItems.ONION.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.ONION.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving, EntityPlayer playerIn) {
		playerIn.playSound(MiabSoundEvents.shrek_onion, 1F, 1F);
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
}
