package com.mrbysco.miab.compat.ct;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import org.openzen.zencode.java.ZenCodeType;
import org.openzen.zencode.java.ZenCodeType.Method;

@ZenRegister
@ZenCodeType.Name("mods.memeinabottle.Memes")
public class ChangeMemesCT {
	@Method
	public static void disableMeme(String meme) {
		CraftTweakerAPI.apply(new DisableMemeAction(meme));
	}

	@Method
	public static void disableMeme(String[] memes) {
		CraftTweakerAPI.apply(new DisableMemeAction(memes));
	}

	@Method
	public static void enableMeme(String meme) {
		CraftTweakerAPI.apply(new EnableMemeAction(meme));
	}

	@Method
	public static void enableMeme(String[] memes) {
		CraftTweakerAPI.apply(new EnableMemeAction(memes));
	}

	@Method
	public static void addItemMeme(String uniqueID, int weight, IItemStack stack) {
		CraftTweakerAPI.apply(new AddItemMemeAction(uniqueID, weight, stack, "", ""));
	}

	@Method
	public static void addItemSoundMeme(String uniqueID, int weight, IItemStack stack, String sound) {
		CraftTweakerAPI.apply(new AddItemMemeAction(uniqueID, weight, stack, sound, ""));
	}

	@Method
	public static void addItemMessageMeme(String uniqueID, int weight, IItemStack stack, String message) {
		CraftTweakerAPI.apply(new AddItemMemeAction(uniqueID, weight, stack, "", message));
	}

	@Method
	public static void addItemSoundAndMessageMeme(String uniqueID, int weight, IItemStack stack, String sound, String message) {
		CraftTweakerAPI.apply(new AddItemMemeAction(uniqueID, weight, stack, sound, message));
	}
}
