package com.Mrbysco.miab.proxy;

import com.Mrbysco.miab.init.MemeBlocks;
import com.Mrbysco.miab.init.MemeEntities;
import com.Mrbysco.miab.init.MemeItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
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
	@SideOnly(Side.CLIENT)
	public void displayClientGui(GuiScreen gui) {
		Minecraft.getMinecraft().displayGuiScreen(gui);
	}
}
