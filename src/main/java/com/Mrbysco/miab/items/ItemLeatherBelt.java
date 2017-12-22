package com.Mrbysco.miab.items;

import java.util.List;

import com.Mrbysco.miab.items.base.ItemCustomArmor;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemLeatherBelt extends ItemCustomArmor
{

	public ItemLeatherBelt(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String unlocalized, String registry) 
	{
		super(material, renderIndex, armorType, unlocalized, registry);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
    	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo"));
    	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo1"));
    	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo2"));
    	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo3"));
	}
}
