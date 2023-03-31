package com.mrbysco.miab;

import com.mojang.logging.LogUtils;
import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.handler.MemeHandler;
import com.mrbysco.miab.memes.FunnyRegistry;
import com.mrbysco.miab.registry.MemeEntities;
import com.mrbysco.miab.registry.MemeRegistry;
import com.mrbysco.miab.registry.MemeReloadManager;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Reference.MOD_ID)
public class MemeInABottle {
	public static final Logger logger = LogUtils.getLogger();

	public MemeInABottle() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MemeConfig.serverSpec);
		FMLJavaModLoadingContext.get().getModEventBus().register(MemeConfig.class);

		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		MemeEntities.ENTITIES.register(eventBus);
		MemeRegistry.ITEMS.register(eventBus);
		MemeRegistry.BLOCKS.register(eventBus);
		MemeSounds.SOUND_EVENTS.register(eventBus);

		MinecraftForge.EVENT_BUS.register(new MemeHandler());
		MinecraftForge.EVENT_BUS.register(new MemeReloadManager());
		MinecraftForge.EVENT_BUS.addListener(this::serverStart);

		eventBus.addListener(MemeEntities::registerEntityAttributes);

		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
			eventBus.addListener(ClientHandler::onClientSetup);
			eventBus.addListener(ClientHandler::registerEntityRenders);
			eventBus.addListener(ClientHandler::registerLayerDefinitions);
		});
	}

	public void serverStart(ServerStartedEvent event) {
		FunnyRegistry.instance().reloadMemes();
		FunnyRegistry.instance().checkDisabled();
	}
}
