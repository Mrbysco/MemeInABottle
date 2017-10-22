package com.Mrbysco.miab.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.util.text.ITextComponent;

public class GuiFakeOver extends GuiGameOver{

	private int ticksSinceOpened = 0;
	
	public GuiFakeOver(ITextComponent component) {
		super(component);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if(typedChar == Keyboard.KEY_ESCAPE)
    	{
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
    	}
	}
	
	@Override
    public void updateScreen()
    {
        ++this.ticksSinceOpened;

        if (this.ticksSinceOpened >= 60)
        {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        }
    }
}
