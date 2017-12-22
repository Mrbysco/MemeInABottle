package com.Mrbysco.miab.items;

import java.util.List;

import com.Mrbysco.miab.items.base.ItemCustomArmor;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemSunglasses extends ItemCustomArmor
{

	public ItemSunglasses(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String unlocalized, String registry) 
	{
		super(material, renderIndex, armorType, unlocalized, registry);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("sunglasses.info"));
	}
}
