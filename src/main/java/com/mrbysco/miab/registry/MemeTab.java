package com.mrbysco.miab.registry;


import com.mrbysco.miab.Reference;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MemeTab {
	public static final CreativeModeTab MEME_TAB = new CreativeModeTab(Reference.MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(MemeRegistry.SPLASH_MEME_IN_A_BOTTLE.get());
		}
	};
}
