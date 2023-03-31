package com.mrbysco.miab.items.music;

import com.mrbysco.miab.items.MemeBaseItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class MusicalItem extends MemeBaseItem {
	private final Supplier<SoundEvent> sound;
	private final Supplier<SoundEvent> sound2;
	private final int cooldown;
	private final String info;

	public MusicalItem(Item.Properties builder, Supplier<SoundEvent> soundIn, @Nullable Supplier<SoundEvent> soundin2, int cooldownNumber, String textLocal) {
		super(builder);
		this.sound = soundIn;
		this.sound2 = soundin2;
		this.cooldown = cooldownNumber;
		this.info = textLocal;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);

		if (playerIn.isShiftKeyDown() && this.sound2.get() != null) {
			playerIn.playSound(this.sound2.get(), 1F, 1F);
		} else {
			playerIn.playSound(this.sound.get(), 1F, 1F);
		}

		if (this.sound2 == null) {
			playerIn.playSound(this.sound.get(), 1F, 1F);
		}

		if (this.cooldown != 0) {
			playerIn.getCooldowns().addCooldown(this, this.cooldown);
		}

		return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, level, tooltip, flagIn);
		if (this.info != null && !this.info.isEmpty()) {
			tooltip.add(Component.translatable(this.info).withStyle(ChatFormatting.YELLOW));
		}
	}
}
