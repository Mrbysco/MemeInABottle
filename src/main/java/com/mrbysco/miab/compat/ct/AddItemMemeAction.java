package com.mrbysco.miab.compat.ct;

import com.blamejared.crafttweaker.api.actions.IAction;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.mrbysco.miab.memes.MemeRegistry;
import com.mrbysco.miab.memes.actions.base.BasicItemTextMeme;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

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
			sound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(this.soundEvent));

		MemeRegistry.instance().registerMeme(new BasicItemTextMeme(uniqueID, weight, sound, stack.getInternal(), message));
	}

	@Override
	public String describe() {
		if(MemeRegistry.instance().isIDUnique(this.uniqueID)) {
			return "Added a meme with ID: " + this.uniqueID + " to the Meme Registry.";
		} else {
			return "Could not add meme with ID: " + this.uniqueID + " but that ID already exists.";
		}
	}
}
