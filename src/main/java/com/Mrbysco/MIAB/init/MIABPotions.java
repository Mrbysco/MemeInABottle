package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.potion.TrollPotion;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;

public class MIABPotions {	
	static void register(Potion instance, PotionType type) {
		Potion.REGISTRY.register(0, new ResourceLocation(Reference.MOD_ID, instance.getName()), instance);
	}

	public static void init() {
		register(TrollPotion.INSTANCE, TrollPotion.type);
	}

	public static PotionType getVanillaType(String name) {
		return PotionType.REGISTRY.getObject(new ResourceLocation(name));
	}
}