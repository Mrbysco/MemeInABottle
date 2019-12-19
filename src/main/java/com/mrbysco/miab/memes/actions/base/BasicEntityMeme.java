package com.mrbysco.miab.memes.actions.base;

import com.mrbysco.miab.MemeInABottle;
import com.mrbysco.miab.entity.memes.EntityCena;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;

import javax.annotation.Nullable;

public class BasicEntityMeme extends BasicFunny {

	private EntityEntry entry;
	private SoundEvent sound = null;

	public BasicEntityMeme(String name, int rarity, EntityEntry entry, @Nullable SoundEvent sound) {
		super(name, rarity);
		this.entry = entry;
		this.sound = sound;
	}

	public BasicEntityMeme(String name, int rarity, EntityEntry entry) {
		super(name, rarity);
		this.entry = entry;
	}

	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote) {
			spawnEntity(world, entry.newInstance(world), pos);
			if(this.sound != null) { 
				world.playSound((EntityPlayer)null, pos, this.sound, SoundCategory.RECORDS, 0.75F, 1.0F);
			} else {
				MemeInABottle.logger.error("Meme sound by the name of: " + this.getName() + "has a null SoundEvent" );
			}
		}
	}
}
