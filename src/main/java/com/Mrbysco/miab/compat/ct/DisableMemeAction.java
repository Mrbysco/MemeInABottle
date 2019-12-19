package com.mrbysco.miab.compat.ct;

import com.mrbysco.miab.memes.MemeRegistry;
import crafttweaker.IAction;

public class DisableMemeAction implements IAction {
	private final String[] memes;

	public DisableMemeAction(String[] memes) {
		this.memes = memes;
	}

	public DisableMemeAction(String memes) {
		this.memes = new String[]{memes};
	}

	@Override
	public void apply() {
		if(this.memes.length > 0) {
			MemeRegistry.INSTANCE.disableMeme(this.memes);
		}
	}

	@Override
	public String describe() {
		if(this.memes.length > 0) {
			return null;
		} else {
			return String.format("Could not remove memes. String array was empty.");
		}
	}
}
