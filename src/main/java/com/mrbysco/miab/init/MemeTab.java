package com.mrbysco.miab.init;


import com.mrbysco.miab.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MemeTab {
	public static final ItemGroup MEME_TAB = new ItemGroup(Reference.MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MemeRegister.SPLASH_MEME_IN_A_BOTTLE.get());
		}
	};
}
