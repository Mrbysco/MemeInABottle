package com.mrbysco.miab;

import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.handler.MemeHandler;
import com.mrbysco.miab.init.MemeLoot;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.init.MemeTab;
import com.mrbysco.miab.memes.MemeRegistry;
import com.mrbysco.miab.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, 
	name = Reference.MOD_NAME, 
	version = Reference.VERSION, 
	acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS,
	dependencies = Reference.DEPENDENCIES)

public class MemeInABottle {
	@Instance(Reference.MOD_ID)
	public static MemeInABottle instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

	public static MemeTab memeTab = new MemeTab();

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		logger.info("Registering Statues Config");
		MinecraftForge.EVENT_BUS.register(new MemeConfig());

		logger.info("Registering Statues Sounds");
		MemeSounds.registerSounds();
		
		proxy.PreInit();
	}
	
	@EventHandler
    public void init(FMLInitializationEvent event)
	{
//		logger.info("Registering Meme Gui Handler");
//		NetworkRegistry.INSTANCE.registerGuiHandler(this, new MemeGuiHandler()); TODO: Create Gui Handler

		//Initialize loot
		logger.info("Initialize Meme Loot");
		MemeLoot.registerLootTables();
		
		logger.info("Registering Meme Event Handlers");
		MinecraftForge.EVENT_BUS.register(new MemeHandler());

		proxy.Init();
    }
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		MemeRegistry.initializeMemes();
		proxy.PostInit();
    }
}
