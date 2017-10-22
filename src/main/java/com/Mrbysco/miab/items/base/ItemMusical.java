package com.Mrbysco.miab.items.base;

import java.util.List;

import com.Mrbysco.miab.MemeInABottle;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemMusical extends Item{
	private SoundEvent sound;
	private SoundEvent sound2;
	private int cooldown;
	private String info;
	
	public ItemMusical(String unlocalized, String registry, SoundEvent soundIn, SoundEvent soundin2, int cooldownNumber, String textLocal) {
		setUnlocalizedName(unlocalized);
		setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
		this.sound = soundIn;
		this.sound2 = soundin2;
		this.cooldown = cooldownNumber;
		this.info = textLocal;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		if(playerIn.isSneaking() && this.sound2 != null)
		{
			playerIn.playSound(this.sound2, 1F, 1F);
		}
		else
		{
			playerIn.playSound(this.sound, 1F, 1F);
		}
		
		if(this.sound2 == null)
		{
			playerIn.playSound(this.sound, 1F, 1F);
		}
		
		if(this.cooldown != 0)
		{
			playerIn.getCooldownTracker().setCooldown(this, this.cooldown);
		}

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (this.info != null)
		{
			tooltip.add(TextFormatting.YELLOW + I18n.translateToLocal(this.info));
		}
	}
}