package com.mrbysco.miab.compat.ct;

import com.blamejared.crafttweaker.api.actions.IUndoableAction;
import com.mrbysco.miab.memes.MemeRegistry;

public class DisableMemeAction implements IUndoableAction {
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
    public void undo() {
        if(this.memes.length > 0) {
            MemeRegistry.INSTANCE.enableMeme(this.memes);
        }
    }

    @Override
	public String describe() {
		if(this.memes.length > 0) {
			return String.format("The following memes have been disabled: " + this.memes.toString());
		} else {
			return String.format("Could not disable memes. String array was empty.");
		}
	}

    @Override
    public String describeUndo() {
        if(this.memes.length > 0) {
            return String.format("The following memes have been re-enabled: " + this.memes.toString());
        } else {
            return String.format("Could not re-enable memes. String array was empty.");
        }
    }
}
