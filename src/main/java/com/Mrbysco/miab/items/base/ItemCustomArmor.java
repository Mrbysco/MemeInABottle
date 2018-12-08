package com.Mrbysco.miab.items.base;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.Reference;

import net.minecraft.block.BlockDispenser;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemCustomArmor extends ItemArmor
{
	public ItemCustomArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String registry) 
	{
        super(material, renderIndex, armorType);
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
		
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
	}
}