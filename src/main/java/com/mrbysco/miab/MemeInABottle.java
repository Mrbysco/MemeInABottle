package com.mrbysco.miab;

import com.mrbysco.miab.client.ClientHandler;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.handler.MemeHandler;
import com.mrbysco.miab.init.MemeTab;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.MOD_ID)
public class MemeInABottle {
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

	public static MemeTab memeTab = new MemeTab();

	public MemeInABottle() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MemeConfig.serverSpec);
		FMLJavaModLoadingContext.get().getModEventBus().register(MemeConfig.class);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

		MinecraftForge.EVENT_BUS.register(new MemeHandler());

		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
			FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientHandler::registerRenders);
		});
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		MemeRegistry.initializeMemes();
	}

	private void enqueueIMC(final InterModEnqueueEvent event)
	{

	}

	private void processIMC(final InterModProcessEvent event)
	{

	}
}
