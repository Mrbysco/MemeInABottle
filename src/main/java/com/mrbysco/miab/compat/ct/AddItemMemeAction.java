package com.mrbysco.miab.compat.ct;

import com.blamejared.crafttweaker.api.action.base.IRuntimeAction;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.memes.FunnyRegistry;
import com.mrbysco.miab.memes.actions.base.BasicItemTextMeme;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class AddItemMemeAction implements IRuntimeAction {
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
		if (!this.soundEvent.isEmpty())
			sound = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.tryParse(this.soundEvent));

		FunnyRegistry.instance().registerMeme(new BasicItemTextMeme(uniqueID, weight, sound, stack.getInternal(), message));
	}

	@Override
	public String describe() {
		if (FunnyRegistry.instance().isIDUnique(this.uniqueID)) {
			return "Added a meme with ID: " + this.uniqueID + " to the Meme Registry.";
		} else {
			return "Could not add meme with ID: " + this.uniqueID + " but that ID already exists.";
		}
	}

	@Override
	public String systemName() {
		return Reference.MOD_ID;
	}
}
