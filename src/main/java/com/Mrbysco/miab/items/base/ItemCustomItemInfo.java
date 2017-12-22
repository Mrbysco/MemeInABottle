package com.Mrbysco.miab.items.base;

import java.util.List;

import com.Mrbysco.miab.MemeInABottle;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemCustomItemInfo extends Item
{
	private String info;

	public ItemCustomItemInfo(String unlocalized, String registry, String infoText)
	{
		setUnlocalizedName(unlocalized);
		setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
		this.info = infoText;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		if (this.info != null)
		{
			tooltip.add(TextFormatting.YELLOW + I18n.translateToLocal(this.info));
		}
	}
}
