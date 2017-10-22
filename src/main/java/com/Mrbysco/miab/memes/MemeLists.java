package com.Mrbysco.miab.memes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.Mrbysco.miab.init.MemeItems;
import com.Mrbysco.miab.init.MemeSounds;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;

public class MemeLists {
	public static final Random rand = new Random();
	
	public static  List<SoundEvent> matureSounds = ImmutableList.of(
			MemeSounds.ninethousand,
			MemeSounds.barrelroll,
			MemeSounds.biwinning,
			MemeSounds.boomheadshot,
			MemeSounds.callinthenext,
			MemeSounds.charliebitme,
			MemeSounds.chocolate,
			MemeSounds.congratz,
			MemeSounds.dedidadedwam,
			MemeSounds.deeznuts,
			MemeSounds.doit,
			MemeSounds.dontletyourdreamsbedreams,
			MemeSounds.gaben,
			MemeSounds.getitoxyclean,
			MemeSounds.getnoscoped,
			MemeSounds.k,
			MemeSounds.leroyjenkins,
			MemeSounds.momscar,
			MemeSounds.nice,
			MemeSounds.nicememe,
			MemeSounds.noot,
			MemeSounds.nothisispatrick,
			MemeSounds.nothisispatrick2,
			MemeSounds.noticeme,
			MemeSounds.ohlongjohnson,
			MemeSounds.oldspicepower,
			MemeSounds.oxyclean,
			MemeSounds.sandwich,
			MemeSounds.snooppengas,
			MemeSounds.somebodystopme,
			MemeSounds.sparta,
			MemeSounds.spongebobsound,
			MemeSounds.triple,
			MemeSounds.trololo,
			MemeSounds.victoryscreech,
			MemeSounds.whiten,
			MemeSounds.wololo,
			MemeSounds.wombocombo,
			MemeSounds.wow,
			MemeSounds.wrong);
	
	public static final List<SoundEvent> safeSounds = new ArrayList<SoundEvent>(matureSounds);
	
	public static List<Item> memeBottles = ImmutableList.of(
			MemeItems.meme_in_a_bottle,
			MemeItems.splash_meme_in_a_bottle,
			MemeItems.lingering_meme_in_a_bottle);
			
	public static SoundEvent getRandomSafeSound()
	{
		safeSounds.remove(MemeSounds.cantbelieve);
		safeSounds.remove(MemeSounds.morningscrub);
		safeSounds.remove(MemeSounds.gotchab);
		safeSounds.remove(MemeSounds.hagay);
		safeSounds.remove(MemeSounds.rightinthe);
		safeSounds.remove(MemeSounds.smokeweed);
		safeSounds.remove(MemeSounds.snooppengas);
		SoundEvent sound = getRandomFromList(safeSounds);
		return sound;
	}
	
	public static SoundEvent getRandomMatureSound()
	{
		SoundEvent sound = getRandomFromList(matureSounds);
		return sound;
	}
	
	public static ItemStack getRandomMemeBottle()
	{
		Item bottle = getRandomFromList(memeBottles);
		ItemStack stack = new ItemStack(bottle);
		return stack;
	}
	
	public static <T> T getRandomFromList(List<T> list) {
        return getRandomFromList(list, rand);
    }

    public static <T> T getRandomFromList(List<T> list, Random rand) {
        final int size = list.size();
        Preconditions.checkArgument(size > 0, "Can't select from empty list");
        if (size == 0) return null;
        if (size == 1) return list.get(0);
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
