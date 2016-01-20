package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.items.Itemmeme_in_a_bottle;
import com.Mrbysco.MIAB.items.Itemsplash_meme_in_a_bottle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MIABItems {
	
	public static Item meme_in_a_bottle;
	public static Item splash_meme_in_a_bottle;
	public static Item WWE_Belt;
	
	public static void init(){
		meme_in_a_bottle = new Itemmeme_in_a_bottle().setUnlocalizedName("meme_in_a_bottle").setCreativeTab(MIAB.tabMIAB);
		splash_meme_in_a_bottle = new Itemsplash_meme_in_a_bottle().setUnlocalizedName("splash_meme_in_a_bottle").setCreativeTab(MIAB.tabMIAB);
		WWE_Belt = new Item().setUnlocalizedName("WWE_Belt").setCreativeTab(MIAB.tabMIAB);
	}
	
	public static void register()
	{
		GameRegistry.registerItem(meme_in_a_bottle, meme_in_a_bottle.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(splash_meme_in_a_bottle, splash_meme_in_a_bottle.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(WWE_Belt, WWE_Belt.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(meme_in_a_bottle);
		registerRender(splash_meme_in_a_bottle);
		registerRender(WWE_Belt);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
