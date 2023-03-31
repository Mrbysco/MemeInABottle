package com.mrbysco.miab.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class KnifeItem extends SwordItem {
	private final boolean isHot;

	public KnifeItem(Properties properties, boolean isHotKnife) {
		super(Tiers.IRON, 1, -2.4F, properties.stacksTo(1));
		this.isHot = isHotKnife;
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (this.isHot) {
			target.setSecondsOnFire(3);
			attacker.playSound(SoundEvents.FIRE_EXTINGUISH, 1F, 1F);
			return true;
		} else {
			return false;
		}
	}
}
