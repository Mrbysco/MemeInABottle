package com.mrbysco.miab.items;

import com.mrbysco.miab.MemeInABottle;
import com.mrbysco.miab.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemKnife extends ItemSword {
	private final float attackDamage;
	private final Item.ToolMaterial material;
	private boolean isHot;

	public ItemKnife(Item.ToolMaterial material, String registry, boolean isHotKnife) {
		super(material);
		this.material = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		this.attackDamage = 3.0F + material.getAttackDamage();
		this.setTranslationKey(Reference.MOD_PREFIX + registry);
		this.setRegistryName(registry);
		this.setCreativeTab(MemeInABottle.memeTab);

		this.isHot = isHotKnife;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		if(this.isHot == true)
		{
			target.setFire(3);
			attacker.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
			return true;
		}
		else
			return false;
	}
}
