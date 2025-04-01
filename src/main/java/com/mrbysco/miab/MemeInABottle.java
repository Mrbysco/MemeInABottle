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
import com.mrbysco.miab.registry.MemeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import org.slf4j.Logger;

@Mod(Reference.MOD_ID)
public class MemeInABottle {
	public static final Logger logger = LogUtils.getLogger();

	public MemeInABottle(IEventBus eventBus, Dist dist, ModContainer container) {
		container.registerConfig(ModConfig.Type.SERVER, MemeConfig.serverSpec);
		eventBus.register(MemeConfig.class);

		MemeEntities.ENTITIES.register(eventBus);
		MemeRegistry.ITEMS.register(eventBus);
		MemeRegistry.BLOCKS.register(eventBus);
		MemeTab.CREATIVE_MODE_TABS.register(eventBus);
		MemeSounds.SOUND_EVENTS.register(eventBus);

		NeoForge.EVENT_BUS.register(new MemeHandler());
		NeoForge.EVENT_BUS.register(new MemeReloadManager());
		NeoForge.EVENT_BUS.addListener(this::serverStart);

		eventBus.addListener(MemeEntities::registerEntityAttributes);

		if (dist.isClient()) {
			eventBus.addListener(ClientHandler::onClientSetup);
			eventBus.addListener(ClientHandler::registerEntityRenders);
			eventBus.addListener(ClientHandler::registerLayerDefinitions);
		}
	}

	public void serverStart(ServerStartedEvent event) {
		FunnyRegistry.instance().reloadMemes();
		FunnyRegistry.instance().checkDisabled();
	}
}
