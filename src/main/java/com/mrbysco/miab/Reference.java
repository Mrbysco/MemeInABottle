package com.mrbysco.miab;

import net.minecraft.resources.ResourceLocation;

public class Reference {
	public static final String MOD_ID = "memeinabottle";
	public static final String MOD_PREFIX = MOD_ID + ":";

	public static ResourceLocation modLoc(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
