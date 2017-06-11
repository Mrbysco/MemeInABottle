package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPen extends Item{
	public ItemPen() {
		setUnlocalizedName(Reference.MIABItems.PEN.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.PEN.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.playSound(MiabSoundEvents.ppap_havepen, 1F, 1F);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
