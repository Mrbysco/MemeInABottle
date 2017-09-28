package com.Mrbysco.MIAB.worldgen;

import java.util.Random;

import com.Mrbysco.MIAB.config.MIABConfigGen;
import com.Mrbysco.MIAB.init.MIABBlocks;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BottleGen implements IWorldGenerator{

	public static BottleGen instance = new BottleGen();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		generateStuff(random, chunkZ, chunkZ, world, true);
	}

	public void generateStuff(Random random, int chunkX, int chunkZ, World world, boolean generate)
	{
		
		
		if (world.provider.getDimension() == DimensionType.OVERWORLD.getId()) {
			if (MIABConfigGen.general.GenerateBottles) {
				//TODO
			}
		}
	}

}
