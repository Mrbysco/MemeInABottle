package com.Mrbysco.MIAB.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLeather_belt extends Itemcustom_armor{

	public ItemLeather_belt(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String UnlocalisedName, String RegistryName) {
		super(name, material, renderIndex, armorType, RegistryName, RegistryName);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo"));
    	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo1"));
    	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo2"));
    	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo3"));
	}
}
