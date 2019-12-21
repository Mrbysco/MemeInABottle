package com.mrbysco.miab.items.armor;

import com.mrbysco.miab.MemeInABottle;
import com.mrbysco.miab.Reference;
import net.minecraft.block.BlockDispenser;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemCustomArmor extends ItemArmor {

	public ItemCustomArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String registry) {
		super(material, renderIndex, armorType);
		setTranslationKey(Reference.MOD_PREFIX + registry);
		setRegistryName(registry);
		setCreativeTab(MemeInABottle.memeTab);


		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
	}
}
