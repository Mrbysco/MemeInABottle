package com.Mrbysco.MIAB;

import com.Mrbysco.MIAB.init.MIABItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MIABTab extends CreativeTabs {
	
	public MIABTab (String label) { 
		super(label);
		this.setBackgroundImageName("miab.png");
	}

	@Override
	public Item getTabIconItem() {
		return MIABItems.splash_meme_in_a_bottle;
	}

	public MIABTab setCreativeTab(MIABTab tabmiab) {
		// TODO Auto-generated method stub
		return null;
	}
}
