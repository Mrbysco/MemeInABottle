package com.Mrbysco.MIAB.init;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class MIABConfigGen {
	public static void configOptions(Configuration config) {
		config.load();
		// Mature Sounds
		MIABConfig.MatureSounds = config.get("Mature Sounds", "MatureSounds", true).getBoolean(true);
		
		Property maturesoundproperty = config.get("Mature Sounds", " ", false); 
		maturesoundproperty.comment = "If Mature Sounds is set to true, more mature meme sounds will play. (False by default for kid friendlyness)";
		config.save();
		config.load();
	}
}