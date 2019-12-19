package com.mrbysco.miab.items.armor;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.EntityClippy;
import com.mrbysco.miab.items.ItemMemeBase;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemGnomeHat extends ItemMemeBase {
	public ItemGnomeHat(String registry ) {
		super(registry);
	}

	@Override
	public EntityEquipmentSlot getEquipmentSlot(ItemStack stack) {
		return EntityEquipmentSlot.HEAD;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		tooltip.add(TextFormatting.YELLOW + I18n.format(Reference.MOD_PREFIX + "equip.head"));
	}
}
