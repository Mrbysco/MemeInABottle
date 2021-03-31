package com.mrbysco.miab;

import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.handler.MemeHandler;
import com.mrbysco.miab.init.MemeEntities;
import com.mrbysco.miab.init.MemeRegister;
import com.mrbysco.miab.init.MemeReloadManager;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.MOD_ID)
public class MemeInABottle {
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

	public MemeInABottle() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MemeConfig.serverSpec);
		FMLJavaModLoadingContext.get().getModEventBus().register(MemeConfig.class);

		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		MemeEntities.ENTITIES.register(eventBus);
		MemeRegister.ITEMS.register(eventBus);
		MemeRegister.BLOCKS.register(eventBus);
		MemeSounds.SOUND_EVENTS.register(eventBus);

		MinecraftForge.EVENT_BUS.register(new MemeHandler());
		MinecraftForge.EVENT_BUS.register(new MemeReloadManager());

		eventBus.addListener(MemeEntities::registerEntityAttributes);

		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
			eventBus.addListener(ClientHandler::onClientSetup);
			eventBus.addListener(ClientHandler::registerItemColors);
		});
	}

	@SubscribeEvent
	public void serverStart(FMLServerStartedEvent event) {
		MemeRegistry.instance().initializeMemes();
	}
}
