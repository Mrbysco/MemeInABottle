package com.Mrbysco.MIAB;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LennyStructure {

	public static void buildLenny(World worldObj, double x, double y, double z)
	{
		worldObj.setBlockState(new BlockPos(x, y +10, z), Blocks.SAND.getDefaultState());

	}
}
