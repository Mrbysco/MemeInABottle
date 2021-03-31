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
			MemeRegistry.instance().disableMeme(this.memes);
		}
	}

    @Override
    public void undo() {
        if(this.memes.length > 0) {
            MemeRegistry.instance().enableMeme(this.memes);
        }
    }

    @Override
	public String describe() {
		if(this.memes.length > 0) {
			return "The following memes have been disabled: " + String.join(", ", this.memes);
		} else {
			return "Could not disable memes. String array was empty.";
		}
	}

    @Override
    public String describeUndo() {
        if(this.memes.length > 0) {
            return "The following memes have been re-enabled: " + String.join(", ", this.memes);
        } else {
            return "Could not re-enable memes. String array was empty.";
        }
    }
}
