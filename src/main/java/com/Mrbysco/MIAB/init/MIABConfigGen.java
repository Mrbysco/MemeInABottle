package com.Mrbysco.MIAB.init;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class MIABConfigGen {
	public static void configOptions(Configuration config) {
		config.load();
		// Mature Sounds
		MIABConfig.MatureSounds = config.get("Mature Sounds", "MatureSounds", false).getBoolean(false);
		
		config.save();
		config.load();
	}
}