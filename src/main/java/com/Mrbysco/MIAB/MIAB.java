package com.Mrbysco.MIAB;

import com.Mrbysco.MIAB.config.MIABConfigGen;
import com.Mrbysco.MIAB.init.MIABBlocks;
import com.Mrbysco.MIAB.init.MIABEntities;
import com.Mrbysco.MIAB.init.MIABItems;
import com.Mrbysco.MIAB.init.MIABPotions;
import com.Mrbysco.MIAB.init.MIABRecipes;
import com.Mrbysco.MIAB.init.MIABVillagers;
import com.Mrbysco.MIAB.init.MiabSoundEvents;
import com.Mrbysco.MIAB.proxy.CommonProxy;
import com.Mrbysco.MIAB.worldgen.MIABWorldgen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
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
	acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, 
	dependencies = "required-after:forge@[14.21.1.2387,)")
public class MIAB {
	
	@Instance(Reference.MOD_ID)
	public static MIAB instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	public static CreativeTabs tabMIAB = new CreativeTabs("tabMIAB") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(MIABItems.splash_meme_in_a_bottle);
		}
	};
	
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new MIABConfigGen());
    	
    	MiabSoundEvents.registerSounds();
    	
    	MIABWorldgen.init();
    	
    	MIABBlocks.init();
    	MIABBlocks.register();
    	MIABItems.init();
    	MIABItems.register();
    	
    	MIABPotions.init();
    	
    	MIABRecipes.init();
    	
    	MIABEntities.register();
    	MIABVillagers.init();
    	
    	proxy.registerRenderingFactories();
    	proxy.registerRenders();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
}