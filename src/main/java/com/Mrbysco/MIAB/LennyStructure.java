package com.Mrbysco.MIAB;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LennyStructure {
	private static int posX;
	private static int posY;
	private static int posZ;



	public static void buildLenny(World worldObj)
	{
		worldObj.setBlockState(new BlockPos(posX, posY +10, posZ), Blocks.SAND.getDefaultState());

	}
}
