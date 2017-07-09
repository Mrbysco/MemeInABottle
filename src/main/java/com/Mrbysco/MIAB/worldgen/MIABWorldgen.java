package com.Mrbysco.MIAB.worldgen;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MIABWorldgen {

	public static void init() {
		BottleGen generator = BottleGen.instance;
        GameRegistry.registerWorldGenerator(generator, 4);
        MinecraftForge.EVENT_BUS.register(generator);
	}
}
