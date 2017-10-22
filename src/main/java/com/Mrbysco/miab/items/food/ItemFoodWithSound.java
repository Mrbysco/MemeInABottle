package com.Mrbysco.miab.items.food;

import com.Mrbysco.miab.items.base.ItemCustomFood;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ItemFoodWithSound extends ItemCustomFood{
	private SoundEvent sound;
	private int cooldown;
	
	public ItemFoodWithSound(int amount, float saturation, boolean isWolfFood, String unlocalized, String registry, SoundEvent soundIn, int cooldownNumber) {
		super(amount, saturation, isWolfFood, unlocalized, registry);
		this.sound = soundIn;
		this.cooldown = cooldownNumber;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.playSound(this.sound, 1F, 1F);
		
		if(this.cooldown != 0)
		{
			playerIn.getCooldownTracker().setCooldown(this, this.cooldown);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
