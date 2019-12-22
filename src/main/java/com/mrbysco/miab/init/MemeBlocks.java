package com.mrbysco.miab.init;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.blocks.BlockOscar;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@EventBusSubscriber
public class MemeBlocks {
	public static Block oscar;

	public static ArrayList<Block> BLOCKS = new ArrayList<>();
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

		oscar = registerBlock(new BlockOscar(Block.Properties.create(Material.IRON)), "oscar");

		registry.registerAll(BLOCKS.toArray(new Block[0]));
	}

	public static <T extends Block> T registerBlock(T block, String registry)
	{
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, registry));
		return registerBlock(block, new BlockItem(block, itemBuilder()));
	}

	public static <T extends Block> T registerBlock(T block, BlockItem item)
	{
		item.setRegistryName(((BlockItem) item).getBlock().getRegistryName());
		MemeItems.ITEMS.add(item);
		BLOCKS.add(block);
		return block;
	}

	private static Item.Properties itemBuilder()
	{
		return new Item.Properties().group(MemeTab.MEME_TAB);
	}
}
