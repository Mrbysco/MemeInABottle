package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.blocks.BottleBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MIABBlocks {
	
	public static Block bottle_block;
	
	public static void init()
	{
		bottle_block = new BottleBlock(Material.glass).setUnlocalizedName("bottle_block").setCreativeTab(MIAB.tabMIAB);;
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(bottle_block, bottle_block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(bottle_block);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
