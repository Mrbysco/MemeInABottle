package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class Itemcustom_armor extends ItemArmor{

	public Itemcustom_armor(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType) {
        super(material, renderIndex, armorType);
        this.setCreativeTab(MIAB.tabMIAB);
	}
	
	
}