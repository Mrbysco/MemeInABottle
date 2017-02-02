package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.handler.VillagerTradeHandler;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class MIABVillagers {
	public static void init() {
		VillagerRegistry villagerRegistry = VillagerRegistry.instance();
		
		VillagerRegistry.VillagerProfession prof = new VillagerRegistry.VillagerProfession("MIAB:Toby", Reference.MOD_ID + ":" + "entity/toby.png", "minecraft:textures/entity/zombie_villager/zombie_villager.png");
		villagerRegistry.register(prof);
		VillagerRegistry.VillagerCareer keyboardreviewer = new VillagerRegistry.VillagerCareer(prof, "keyboardreviewer");
		
		keyboardreviewer.addTrade(1,
                new VillagerTradeHandler.ItemstackForEmerald(new ItemStack(MIABBlocks.keyboard, 1), new EntityVillager.PriceInfo(2, 1)),
                new EntityVillager.ListItemForEmeralds(new ItemStack(MIABBlocks.keyboard, 1), new EntityVillager.PriceInfo(1, 2))
				);
		}
}