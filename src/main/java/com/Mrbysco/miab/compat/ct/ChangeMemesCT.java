package com.mrbysco.miab.compat.ct;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.memeinabottle")
@ZenRegister
public class ChangeMemesCT {
	@ZenMethod
	public static void disableMeme(String meme) {
		CraftTweakerAPI.apply(new DisableMemeAction(meme));
	}

	@ZenMethod
	public static void disableMeme(String[] memes) {
		CraftTweakerAPI.apply(new DisableMemeAction(memes));
	}

	@ZenMethod
	public static void enableMeme(String meme) {
		CraftTweakerAPI.apply(new EnableMemeAction(meme));
	}

	@ZenMethod
	public static void enableMeme(String[] memes) {
		CraftTweakerAPI.apply(new EnableMemeAction(memes));
	}

	@ZenMethod
	public static void addItemMeme(String uniqueID, int weight, IItemStack stack) {
		CraftTweakerAPI.apply(new AddItemMemeAction(uniqueID, weight, stack, "", ""));
	}

	@ZenMethod
	public static void addItemSoundMeme(String uniqueID, int weight, IItemStack stack, String sound) {
		CraftTweakerAPI.apply(new AddItemMemeAction(uniqueID, weight, stack, sound, ""));
	}

	@ZenMethod
	public static void addItemMessageMeme(String uniqueID, int weight, IItemStack stack, String message) {
		CraftTweakerAPI.apply(new AddItemMemeAction(uniqueID, weight, stack, "", message));
	}

	@ZenMethod
	public static void addItemSoundAndMessageMeme(String uniqueID, int weight, IItemStack stack, String sound, String message) {
		CraftTweakerAPI.apply(new AddItemMemeAction(uniqueID, weight, stack, sound, message));
	}
}
