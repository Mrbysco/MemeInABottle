package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class Itemcustom_record extends ItemRecord{
    private final String file;
    
    public Itemcustom_record(String record, String name, SoundEvent soundIn) {
		super("miab:" + record, soundIn);
		setCreativeTab(MIAB.tabMIAB);
		setUnlocalizedName(name);
		file = "miab:music." + record;
	}
	
    @Override
	public ResourceLocation getRecordResource(String name) {
		return new ResourceLocation(file);
	}
}
