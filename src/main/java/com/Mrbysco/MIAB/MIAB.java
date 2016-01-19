package com.Mrbysco.MIAB;

import com.Mrbysco.MIAB.init.MIABBlocks;
import com.Mrbysco.MIAB.init.MIABEntities;
import com.Mrbysco.MIAB.init.MIABItems;
import com.Mrbysco.MIAB.proxy.CommonProxy;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MIAB {
	
	@Instance(Reference.MOD_ID)
	public static MIAB instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	public static final MIABTab tabMIAB = new MIABTab("tabMIAB");
	
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
    	MIABBlocks.init();
    	MIABBlocks.register();
    	MIABItems.init();
    	MIABItems.register();
    	
    	MIABEntities.register();
    	proxy.registerRenderingFactories();
    	
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.registerRenders();
    	GameRegistry.addRecipe(new ItemStack(MIABItems.meme_in_a_bottle), new Object[]
    		{" A"
    		," G", 'A', Items.arrow, 'G', Items.glass_bottle });
    	
    	GameRegistry.addRecipe(new ItemStack(MIABItems.splash_meme_in_a_bottle), new Object[]
        	{" G"
        	," S", 'G', Items.gunpowder, 'S', MIABItems.meme_in_a_bottle });
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
}