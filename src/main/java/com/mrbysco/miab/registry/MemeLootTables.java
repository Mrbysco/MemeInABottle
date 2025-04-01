package com.mrbysco.miab.registry;

import com.mrbysco.miab.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class MemeLootTables {
	public static final ResourceKey<LootTable> MEME_BASE = register("entities/memebase");

	private static ResourceKey<LootTable> register(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, Reference.modLoc(path));
	}
}
