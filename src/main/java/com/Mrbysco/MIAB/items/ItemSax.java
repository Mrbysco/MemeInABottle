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

public class ItemSax extends Item{
	public ItemSax() {
		setUnlocalizedName(Reference.MIABItems.SAX.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.SAX.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		playerIn.playSound(MiabSoundEvents.robbie_sax, 1F, 1F);
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
}
