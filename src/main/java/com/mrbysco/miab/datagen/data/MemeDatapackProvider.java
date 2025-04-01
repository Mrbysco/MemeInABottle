package com.mrbysco.miab.datagen.data;

import com.mrbysco.miab.registry.MemeSongs;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class MemeDatapackProvider extends DatapackBuiltinEntriesProvider {
	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.JUKEBOX_SONG, MemeSongs::bootstrap);

	public MemeDatapackProvider(PackOutput output, CompletableFuture<Provider> registries, Set<String> modIds) {
		super(output, registries, BUILDER, modIds);
	}
}
