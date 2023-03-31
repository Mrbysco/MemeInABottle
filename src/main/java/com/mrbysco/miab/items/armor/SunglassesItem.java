package com.mrbysco.miab.items.armor;

import com.mrbysco.miab.Reference;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class SunglassesItem extends CustomArmorItem {
	public SunglassesItem(ArmorMaterial material, EquipmentSlot armorType, Item.Properties builder) {
		super(material, armorType, builder);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, level, tooltip, flagIn);
		tooltip.add(Component.translatable(Reference.MOD_PREFIX + "sunglasses.info").withStyle(ChatFormatting.WHITE));
	}
}
