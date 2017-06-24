package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.potion.TrollPotion;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class MIABPotions {	    
	
	public static Potion memed;
	
    public static Potion registerPotion(String name, Potion instance)
    {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
        instance.setRegistryName(location);
        ForgeRegistries.POTIONS.register(instance);
        return instance;
    }

	public static void init() {
		memed = registerPotion("effect.miab.memed", new TrollPotion());
	}
}