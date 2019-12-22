package com.mrbysco.miab.items.armor;

import com.mrbysco.miab.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemLeatherBelt extends ItemCustomArmor{
	public ItemLeatherBelt(IArmorMaterial material, EquipmentSlotType armorType, Item.Properties builder)
	{
		super(material, armorType, builder);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "stats.belt.addInfo").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "stats.belt.addInfo1").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "stats.belt.addInfo2").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "stats.belt.addInfo3").applyTextStyle(TextFormatting.GRAY));
	}
}
