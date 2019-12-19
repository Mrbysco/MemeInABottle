package com.mrbysco.miab.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ItemFoodWithSound extends ItemCustomFood
{
	private SoundEvent sound;
	private int cooldown;

	public ItemFoodWithSound(int amount, float saturation, boolean isWolfFood, String registry, SoundEvent soundIn, int cooldownIn)
	{
		super(amount, saturation, isWolfFood, registry);
		this.sound = soundIn;
		this.cooldown = cooldownIn;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, this.sound, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);

		if(this.cooldown != 0)
		{
			playerIn.getCooldownTracker().setCooldown(this, this.cooldown);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
