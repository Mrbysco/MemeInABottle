package com.Mrbysco.miab.init;

import com.Mrbysco.miab.blocks.BlockKeyboardMechanical;
import com.Mrbysco.miab.blocks.BlockOscar;
import com.Mrbysco.miab.blocks.BottleBlock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class MemeBlocks {
	
	public static Block bottle_block;
	public static Block keyboard;
	public static Block oscar;
	
	public static void init()
	{
		bottle_block = new BottleBlock("bottleblock", "bottle_block");
		keyboard = new BlockKeyboardMechanical("keyboardmechanical", "keyboard_mechanical");
		oscar = new BlockOscar("oscar", "oscar");
	}
	
	public static void register()
	{
		registerBlock(bottle_block);
		registerBlock(keyboard);
		registerBlock(oscar);
	}
	
	public static void registerBlock(Block block) 
	{
		registerBlock(block, new ItemBlock(block));
	}
	
	public static void registerBlock(Block block, ItemBlock item) 
	{
		ForgeRegistries.BLOCKS.register(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
	}
	
	public static void registerRenders()
	{
		registerRender(bottle_block);
		registerRender(keyboard);
		registerRender(oscar);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
