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

public class ItemApple extends ItemFood {
	public ItemApple(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Reference.MIABItems.APPLE.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.APPLE.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.playSound(MiabSoundEvents.ppap_haveapple, 1F, 1F);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
