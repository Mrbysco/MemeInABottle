package com.Mrbysco.miab.init;

import com.Mrbysco.miab.gui.GuiFakeOver;
import com.Mrbysco.miab.gui.MemeGui;
import com.Mrbysco.miab.memes.MemeHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class MemeGuiHandler implements IGuiHandler {

	public static final int RANDOM_MEME_GUI = 0;
	public static final int WASTED_MEME_GUI = 1;
	public static final int CHOSEN_MEME_GUI = 2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == RANDOM_MEME_GUI)
		{
			return null;
		}
		if (ID == WASTED_MEME_GUI)
		{
			return null;
		}
		if (ID == CHOSEN_MEME_GUI)
		{
			return null;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == RANDOM_MEME_GUI)
		{
			return new MemeGui(MemeHelper.RandomMemeLocation());
		}
		if (ID == WASTED_MEME_GUI)
		{
			return new GuiFakeOver(new TextComponentTranslation("death.attack.generic", new Object[] {"You"}));
		}
		if (ID == CHOSEN_MEME_GUI)
		{
			return new MemeGui(MemeHelper.getMemeFromID(x));
		}
		else
		{
			return null;
		}
	}

}
