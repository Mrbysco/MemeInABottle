package com.Mrbysco.MIAB.init;

import net.minecraftforge.common.config.Configuration;

public class MIABConfigGen {
	public static void configOptions(Configuration config) {
		config.load();
		// Mature Sounds
		MIABConfig.MatureSounds = config.get("Mature Sounds", "MatureSounds", false).getBoolean(false);
		// Drop chance
		MIABConfig.DropChance = config.get("Special Drop Chance", "DropChance", 0.8).getDouble(0.8);
		// Use narrator
		MIABConfig.UseNarator = config.get("Use Narrator", "UseNarrator", true).getBoolean(true);
		// Meme Spawn percentage
		//MIABConfig.MemeSpawnPercentage = config.get("Meme Spawn Percentage", "MemeSpawnPercentage", 30).getInt(30);
		
		config.save();
		config.load();
	}
}