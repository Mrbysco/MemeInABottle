package com.Mrbysco.MIAB;

import com.Mrbysco.MIAB.init.MIABBlocks;
import com.Mrbysco.MIAB.init.MIABConfigGen;
import com.Mrbysco.MIAB.init.MIABEntities;
import com.Mrbysco.MIAB.init.MIABItems;
import com.Mrbysco.MIAB.init.MIABRecipes;
import com.Mrbysco.MIAB.init.MiabSoundEvents;
import com.Mrbysco.MIAB.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class MIAB {
	
	@Instance(Reference.MOD_ID)
	public static MIAB instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	public static final MIABTab tabMIAB = new MIABTab("tabMIAB");
	
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
    	Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
    	MIABConfigGen.configOptions(cfg);
    	
    	MiabSoundEvents.registerSounds();
    	
    	MIABBlocks.init();
    	MIABBlocks.register();
    	MIABItems.init();
    	MIABItems.register();
    	
    	//MIABRecipes.init();
    	MIABEntities.register();
    	//MIABVillagers.init();
    	    	
    	proxy.registerRenderingFactories();
    	proxy.registerRenders();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new com.Mrbysco.MIAB.handler.EventHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
}