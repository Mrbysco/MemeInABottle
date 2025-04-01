package com.mrbysco.miab.items.armor;

import com.mrbysco.miab.Reference;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SunglassesItem extends CustomArmorItem {
	public SunglassesItem(Holder<ArmorMaterial> material, ArmorItem.Type armorType, Item.Properties builder) {
		super(material, armorType, builder);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltip, tooltipFlag);
		tooltip.add(Component.translatable(Reference.MOD_PREFIX + "sunglasses.info").withStyle(ChatFormatting.WHITE));
	}
}
