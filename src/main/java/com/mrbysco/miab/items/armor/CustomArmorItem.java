package com.mrbysco.miab.items.armor;

import com.mrbysco.miab.init.MemeTab;
import net.minecraft.block.DispenserBlock;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;

public class CustomArmorItem extends ArmorItem {

	public CustomArmorItem(IArmorMaterial material, EquipmentSlotType armorType, Item.Properties builder) {
		super(material, armorType, builder.group(MemeTab.MEME_TAB));
		DispenserBlock.registerDispenseBehavior(this, DISPENSER_BEHAVIOR);
	}
}
