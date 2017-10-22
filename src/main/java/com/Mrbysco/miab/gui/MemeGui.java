package com.Mrbysco.miab.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class MemeGui extends GuiScreen{
	public final int close = 0;
	
	private GuiButton closeButton;

	private ResourceLocation texture = new ResourceLocation("memeinabottle:textures/items/splash_meme_in_a_bottle.png");
	
	private int Guiwidth = 256;
	private int Guiheigth = 256;
	
	private int guiX = 0;
	private int guiY = 0;
	
	public MemeGui(ResourceLocation location) {
		this.texture = location;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		this.mc.getTextureManager().bindTexture(texture);
		
		this.drawTexturedModalRect(guiX, guiY, 0, 0, Guiwidth, Guiheigth);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		guiX = (width / 2) - Guiwidth / 2;
		guiY = (height / 2) - Guiheigth / 2;
		
		this.buttonList.clear();
	    this.buttonList.add(this.closeButton = new GuiButton(0, guiX + 96, guiY - 20, fontRenderer.getStringWidth("Close") + 30, 20, "Close"));
	    super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
        case close:
            Minecraft.getMinecraft().displayGuiScreen(null);
            break;
		}
    	super.actionPerformed(button);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
