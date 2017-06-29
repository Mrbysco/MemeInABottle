package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPineapple extends ItemFood{

	public ItemPineapple(int amount, float saturation, boolean isWolfFood, String UnlocalisedName, String RegistryName) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(UnlocalisedName);
		setRegistryName(RegistryName);
		setCreativeTab(MIAB.tabMIAB);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.playSound(MiabSoundEvents.ppap_havepineapple, 1F, 1F);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
