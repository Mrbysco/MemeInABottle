package com.mrbysco.miab.init;


import com.mrbysco.miab.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MemeTab {
	public static final ItemGroup MEME_TAB = new ItemGroup(Reference.MOD_ID + ".tab") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MemeItems.splash_meme_in_a_bottle);
		}
	};
}
