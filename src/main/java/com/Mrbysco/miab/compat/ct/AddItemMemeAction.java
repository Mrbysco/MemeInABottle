package com.mrbysco.miab.compat.ct;

import com.mrbysco.miab.memes.MemeRegistry;
import com.mrbysco.miab.memes.actions.base.BasicItemTextMeme;
import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class AddItemMemeAction implements IAction {
	private final String uniqueID;
	private final int weight;
	private final IItemStack stack;
	private final String soundEvent;
	private final String message;

	public AddItemMemeAction(String uniqueID, int weight, IItemStack stack, String soundEvent, String message) {
		this.uniqueID = uniqueID;
		this.weight = weight;
		this.stack = stack;
		this.soundEvent = soundEvent;
		this.message = message;
	}

	@Override
	public void apply() {
		SoundEvent sound = null;
		if(!this.soundEvent.isEmpty())
			sound = SoundEvent.REGISTRY.getObject(new ResourceLocation(this.soundEvent));

		MemeRegistry.INSTANCE.registerMeme(new BasicItemTextMeme(uniqueID, weight, sound, CraftTweakerMC.getItemStack(stack), message));
	}

	@Override
	public String describe() {
		if(MemeRegistry.INSTANCE.isIDUnique(this.uniqueID)) {
			return String.format("Added a meme with ID: " + this.uniqueID + " to the Meme Registry.");
		} else {
			return String.format("Could not add meme with ID: " + this.uniqueID + " but that ID already exists.");
		}
	}
}
