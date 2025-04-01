package com.mrbysco.miab.datagen;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.datagen.data.MemeDatapackProvider;
import com.mrbysco.miab.datagen.data.MemeLootProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MemeDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<Provider> lookupProvider = event.getLookupProvider();

		if (event.includeServer()) {
			generator.addProvider(true, new MemeLootProvider(output, lookupProvider));
			generator.addProvider(true, new MemeDatapackProvider(output,
					lookupProvider,
					Set.of(Reference.MOD_ID)));
		}
	}
}
