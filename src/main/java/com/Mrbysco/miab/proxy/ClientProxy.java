package com.Mrbysco.miab.proxy;

import com.Mrbysco.miab.gui.GuiFakeOver;
import com.Mrbysco.miab.gui.MemeGui;
import com.Mrbysco.miab.init.MemeBlocks;
import com.Mrbysco.miab.init.MemeEntities;
import com.Mrbysco.miab.init.MemeItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends ServerProxy{
	
	@Override
	public void Preinit(){
		MemeBlocks.registerRenders();
		MemeItems.registerRenders();
		MemeEntities.RegisterEntityRender();
	}
	
	
	@Override
	public void Init() {
		
	}
	
	@Override
	public void displayMemeGui(ResourceLocation location) {
	    Minecraft.getMinecraft().displayGuiScreen(new MemeGui(location));
	}

	@Override
	public void displayFakeGameOver(ITextComponent component) {
	    Minecraft.getMinecraft().displayGuiScreen(new GuiFakeOver(component));
	}
}
