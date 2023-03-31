package com.mrbysco.miab.items.food;

import com.mrbysco.miab.items.MemeBaseItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class FoodWithSoundItem extends MemeBaseItem {
	private final Supplier<SoundEvent> sound;
	private final int cooldown;

	public FoodWithSoundItem(Item.Properties builder, Supplier<SoundEvent> soundIn, int cooldownIn) {
		super(builder);
		this.sound = soundIn;
		this.cooldown = cooldownIn;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		level.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), this.sound.get(), SoundSource.PLAYERS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);

		if (this.cooldown != 0) {
			playerIn.getCooldowns().addCooldown(this, this.cooldown);
		}
		return super.use(level, playerIn, handIn);
	}
}
