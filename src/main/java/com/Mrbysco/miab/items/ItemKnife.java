package com.Mrbysco.miab.items;

import com.Mrbysco.miab.items.base.ItemCustomWeapon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;

public class ItemKnife extends ItemCustomWeapon
{

	private boolean HotKnife;
	
	public ItemKnife(ToolMaterial material, String unlocalized, String registry, boolean isHotKnife) 
	{
		super(material, unlocalized, registry);
		this.HotKnife = isHotKnife;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{
		if(this.HotKnife == true)
		{
			target.setFire(3);
			attacker.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
			return true;
		}
		else
		return false;
	}
}
