package com.Mrbysco.miab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Mrbysco.miab.config.MemeConfigGen;
import com.Mrbysco.miab.handlers.MemeEventHandlers;
import com.Mrbysco.miab.init.MemeBlocks;
import com.Mrbysco.miab.init.MemeEntities;
import com.Mrbysco.miab.init.MemeItems;
import com.Mrbysco.miab.init.MemeRecipes;
import com.Mrbysco.miab.init.MemeSounds;
import com.Mrbysco.miab.init.MemeTab;
import com.Mrbysco.miab.init.MemeVillagers;
import com.Mrbysco.miab.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, 
	name = Reference.MOD_NAME, 
	version = Reference.VERSION, 
	acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)

public class MemeInABottle
{
	@Instance(Reference.MOD_ID)
	public static MemeInABottle instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
	
	public static MemeTab memetab = new MemeTab();
	
	@EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
		logger.debug("Registering Config");
		MinecraftForge.EVENT_BUS.register(new MemeConfigGen());
    	
		logger.debug("Registering sounds");
    	MemeSounds.registerSounds();
    	
    	logger.debug("Initialising blocks");
    	MemeBlocks.init();
    	logger.debug("Registering blocks");
    	MemeBlocks.register();
    	
    	logger.debug("Initialising items");
    	MemeItems.init();
    	
    	logger.debug("Registering items");
    	MemeItems.register();
    	
    	//MemePotions.init(); TODO: See if this is still needed
    	
    	logger.debug("Initialising recipes");
    	MemeRecipes.init();
    	
    	logger.debug("Registering entities");
    	MemeEntities.register();
    	
    	logger.debug("Initialising a lonely villager, so sad :(.");
    	MemeVillagers.init();
    	
    	proxy.Preinit();
    }
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		logger.debug("Registering the bottle handler");
		MinecraftForge.EVENT_BUS.register(new MemeEventHandlers());
		
		proxy.Init();
    }
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		
    }
}
