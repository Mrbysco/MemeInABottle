package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.handler.VillagerTradeHandler;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

public class MIABVillagers {
	public static VillagerProfession toby;

	public static void init() {		
		toby = new VillagerProfession("MIAB:Toby", Reference.MOD_ID + ":" + "entity/toby.png", "minecraft:textures/entity/zombie_villager/zombie_villager.png");
		//VillagerRegistry.instance().register(toby, 0);
		ForgeRegistries.VILLAGER_PROFESSIONS.register(toby);
		VillagerCareer career = new VillagerCareer(toby, "keyboardreviewer");
		
		career.addTrade(1,
                new VillagerTradeHandler.ItemstackForEmerald(new ItemStack(MIABBlocks.keyboard, 1), new EntityVillager.PriceInfo(2, 1)),
                new EntityVillager.ListItemForEmeralds(new ItemStack(MIABBlocks.keyboard, 1), new EntityVillager.PriceInfo(1, 2))
				);
		}
}
