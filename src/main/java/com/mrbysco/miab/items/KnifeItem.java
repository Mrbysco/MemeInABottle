package com.mrbysco.miab.items;

import com.mrbysco.miab.init.MemeTab;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.SoundEvents;

public class KnifeItem extends SwordItem {
	private boolean isHot;

	public KnifeItem(Properties properties, boolean isHotKnife) {
		super(ItemTier.IRON, 1, -2.4F, properties.maxStackSize(1).group(MemeTab.MEME_TAB));
		this.isHot = isHotKnife;
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if(this.isHot) {
			target.setFire(3);
			attacker.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
			return true;
		} else {
			return false;
		}
	}
}
