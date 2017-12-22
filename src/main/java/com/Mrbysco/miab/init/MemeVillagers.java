package com.Mrbysco.miab.init;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.handlers.VillagerTradeHandler;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

public class MemeVillagers {
	public static VillagerProfession toby;

	public static void init() 
	{		
		toby = new VillagerProfession("memeinabottle:toby", Reference.MOD_ID + ":" + "textures/entity/toby.png", "minecraft:textures/entity/zombie_villager/zombie_villager.png");

		ForgeRegistries.VILLAGER_PROFESSIONS.register(toby);
		VillagerCareer career = new VillagerCareer(toby, "keyboardreviewer");
		
		career.addTrade(1,
        	new VillagerTradeHandler.ItemstackForEmerald(new ItemStack(MemeBlocks.keyboard, 1), new EntityVillager.PriceInfo(2, 1)),
        	new EntityVillager.ListItemForEmeralds(new ItemStack(MemeBlocks.keyboard, 1), new EntityVillager.PriceInfo(1, 2))
		);
	}
}
