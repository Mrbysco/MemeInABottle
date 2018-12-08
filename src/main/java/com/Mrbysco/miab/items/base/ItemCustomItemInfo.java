package com.Mrbysco.miab.items.base;

import java.util.List;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemCustomItemInfo extends Item
{
	private String info;

	public ItemCustomItemInfo(String registry, String infoText)
	{
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
		this.info = infoText;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		if (this.info != null)
		{
			tooltip.add(TextFormatting.YELLOW + I18n.format(this.info));
		}
	}
}
