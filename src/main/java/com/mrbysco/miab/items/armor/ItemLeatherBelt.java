package com.mrbysco.miab.items.armor;

import com.mrbysco.miab.Reference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemLeatherBelt extends ItemCustomArmor{
	public ItemLeatherBelt(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String registry)
	{
		super(material, renderIndex, armorType, registry);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		tooltip.add(TextFormatting.GRAY + I18n.format(Reference.MOD_PREFIX + "stats.belt.addInfo"));
		tooltip.add(TextFormatting.GRAY + I18n.format(Reference.MOD_PREFIX + "stats.belt.addInfo1"));
		tooltip.add(TextFormatting.GRAY + I18n.format(Reference.MOD_PREFIX + "stats.belt.addInfo2"));
		tooltip.add(TextFormatting.GRAY + I18n.format(Reference.MOD_PREFIX + "stats.belt.addInfo3"));
	}
}
