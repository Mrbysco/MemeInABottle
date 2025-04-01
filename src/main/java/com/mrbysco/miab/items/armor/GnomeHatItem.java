package com.mrbysco.miab.items.armor;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.items.MemeBaseItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class GnomeHatItem extends MemeBaseItem {
	public GnomeHatItem(Item.Properties builder) {
		super(builder);
	}

	@Override
	public EquipmentSlot getEquipmentSlot(ItemStack stack) {
		return EquipmentSlot.HEAD;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltip, tooltipFlag);
		tooltip.add(Component.translatable(Reference.MOD_PREFIX + "equip.head").withStyle(ChatFormatting.YELLOW));
	}
}
