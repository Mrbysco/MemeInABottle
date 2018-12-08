package com.Mrbysco.miab.items;

import java.util.List;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemGnomeHat extends Item
{
	public ItemGnomeHat(String registry) 
	{
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
	}
	
	@Override
	public EntityEquipmentSlot getEquipmentSlot(ItemStack stack) {
		return EntityEquipmentSlot.HEAD;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add(TextFormatting.YELLOW + I18n.format(Reference.MOD_PREFIX + "equip.head"));
	}
}
