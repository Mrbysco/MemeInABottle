package com.Mrbysco.MIAB.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLeather_belt extends Itemcustom_armor{

	public ItemLeather_belt(String unlocalizedName, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot armorType) {
		super(unlocalizedName, material, renderIndex, armorType);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo"));
        	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo1"));
        	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo2"));
        	tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("stats.belt.addInfo3"));
    }

}
