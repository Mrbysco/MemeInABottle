package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MiabSoundEvents {
	
	public static SoundEvent meme_soundMature;
	public static SoundEvent meme_sound;
	public static SoundEvent cena_spawn;
	public static SoundEvent cena_sound;
	public static SoundEvent bill_spawn;
	public static SoundEvent bill_sound;
	public static SoundEvent bill_hit;
	public static SoundEvent bill_death;
	public static SoundEvent trump_spawn;
	public static SoundEvent trump_sound;
	public static SoundEvent trump_hit;
	public static SoundEvent trump_death;
	public static SoundEvent ception_spawn;
	
	public static void registerSounds() {
		meme_soundMature = registerSound("meme.soundMature");
		meme_sound = registerSound("meme.sound");
		cena_spawn = registerSound("cena.spawn");
		cena_sound = registerSound("cena.sound");
		bill_spawn = registerSound("bill.spawn");
		bill_sound = registerSound("bill.sound");
		bill_hit = registerSound("bill.hit");
		bill_death = registerSound("bill.death");
		trump_spawn = registerSound("trump.spawn");
		trump_sound = registerSound("trump.sound");
		trump_hit = registerSound("trump.hit");
		trump_death = registerSound("trump.death");
		ception_spawn = registerSound("ception.spawn");
	}
	
	private static SoundEvent registerSound(String soundName) {
		final ResourceLocation soundID = new ResourceLocation(Reference.MOD_ID + ":" + soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
}
