package com.Mrbysco.miab.init;

import java.util.ArrayList;

import com.Mrbysco.miab.blocks.BlockKeyboardMechanical;
import com.Mrbysco.miab.blocks.BlockOscar;
import com.Mrbysco.miab.blocks.BottleBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class MemeBlocks {
	
	public static Block bottle_block;
	public static Block keyboard;
	public static Block oscar;
	
    public static ArrayList<Block> BLOCKS = new ArrayList<>();

	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
		IForgeRegistry<Block> registry = event.getRegistry();
		
		bottle_block = registerBlock(new BottleBlock("bottle_block"));
		keyboard = registerBlock(new BlockKeyboardMechanical("keyboard_mechanical"));
		oscar = registerBlock(new BlockOscar("oscar"));
		
		registry.registerAll(BLOCKS.toArray(new Block[0]));
	}
	
	public static <T extends Block> T registerBlock(T block)
    {
        return registerBlock(block, new ItemBlock(block));
    }
    
    public static <T extends Block> T registerBlock(T block, ItemBlock item)
    {
    	item.setRegistryName(block.getRegistryName());
    	MemeItems.ITEMS.add(item);
        BLOCKS.add(block);
        return block;
    }
}
