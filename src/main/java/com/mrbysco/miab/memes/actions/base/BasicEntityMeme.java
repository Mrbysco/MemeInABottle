package com.mrbysco.miab.memes.actions.base;

import com.mrbysco.miab.MemeInABottle;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BasicEntityMeme extends BasicFunny {

	private final EntityType<? extends LivingEntity> entry;
	private Supplier<SoundEvent> sound = () -> null;

	public BasicEntityMeme(String name, int rarity, EntityType<? extends LivingEntity> entry, @Nullable Supplier<SoundEvent> sound) {
		super(name, rarity);
		this.entry = entry;
		this.sound = sound;
	}

	public BasicEntityMeme(String name, int rarity, EntityType<? extends LivingEntity> entry) {
		super(name, rarity);
		this.entry = entry;
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			spawnEntity(world, entry.create(world), pos);
			if (this.sound.get() != null) {
				world.playSound((Player) null, pos, this.sound.get(), SoundSource.RECORDS, 0.75F, 1.0F);
			} else {
				MemeInABottle.logger.error("Meme sound by the name of: " + this.getName() + "has a null SoundEvent");
			}
		}
	}
}
