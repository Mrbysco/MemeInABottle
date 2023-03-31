package com.mrbysco.miab.items.food;

import com.mrbysco.miab.items.MemeBaseItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class PillsItem extends MemeBaseItem {
	private final Supplier<SoundEvent> sound;

	public PillsItem(Item.Properties builder, Supplier<SoundEvent> soundIn) {
		super(builder);
		this.sound = soundIn;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
		entityLiving.playSound(this.sound.get(), 1F, 1F);
		entityLiving.heal(4);
		return super.finishUsingItem(stack, level, entityLiving);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		playerIn.playSound(this.sound.get(), 1F, 1F);
		return super.use(level, playerIn, handIn);
	}
}
