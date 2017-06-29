package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;

import net.minecraft.block.BlockDispenser;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class Itemcustom_armor extends ItemArmor{

	public Itemcustom_armor(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String UnlocalisedName, String RegistryName) {
        super(material, renderIndex, armorType);
		setUnlocalizedName(UnlocalisedName);
		setRegistryName(RegistryName);
        this.setCreativeTab(MIAB.tabMIAB);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
	}
	
	
}