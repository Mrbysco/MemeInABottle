package com.Mrbysco.MIAB.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenMemebottle implements IWorldGenerator{

 @Override
	   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	       switch (world.provider.getDimensionId()) {
	           case -1:
	               break;
	           case 0:
	               /*  Disabled atm. Still figuring out
	        	   generateSurface(world, random, chunkX * 16, chunkZ * 16);
	        	   */
	               break;
	           case 1:
	               break;
        }
}
 /*	Disabled atm. Still figuring out
  private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
     for (int k = 0; k < 16; k++)
     {
         int firstBlockXCoord = chunkX + rand.nextInt(16);
         int firstBlockZCoord = chunkZ + rand.nextInt(16);
         //Will be found between y = 0 and y = 20
         int bottle_blockY = rand.nextInt(20);
         BlockPos bottle_blockPos = new BlockPos(firstBlockXCoord, bottle_blockY, firstBlockZCoord);
         new WorldGenMinable(MIABBlocks.bottle_block.getDefaultState(), 4).generate(world, rand, bottle_blockPos);
     }
 } */
}
