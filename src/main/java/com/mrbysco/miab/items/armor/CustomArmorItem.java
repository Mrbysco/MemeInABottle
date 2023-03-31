package com.mrbysco.miab.items.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DispenserBlock;

public class CustomArmorItem extends ArmorItem {

	public CustomArmorItem(ArmorMaterial material, EquipmentSlot armorType, Item.Properties builder) {
		super(material, armorType, builder);
		DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);
	}
}
