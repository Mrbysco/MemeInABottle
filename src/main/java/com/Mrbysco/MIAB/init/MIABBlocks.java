package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.blocks.BlockKeyboardMechanical;
import com.Mrbysco.MIAB.blocks.BottleBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MIABBlocks {
	
	public static Block bottle_block;
	public static Block keyboard;
	
	public static void init()
	{
		bottle_block = new BottleBlock(Material.GLASS);
		keyboard = new BlockKeyboardMechanical();
	}
	
	public static void register()
	{
		registerBlock(bottle_block);
		registerBlock(keyboard);
	}
	
	public static void registerBlock(Block block) 
	{
		registerBlock(block, new ItemBlock(block));
	}
	
	public static void registerBlock(Block block, ItemBlock item) 
	{
		GameRegistry.register(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders()
	{
		registerRender(bottle_block);
		registerRender(keyboard);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
