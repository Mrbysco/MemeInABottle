package com.Mrbysco.MIAB.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BottleBlock extends Block{

	public BottleBlock(Material materialIn) 
	{
		super(Material.glass);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
		this.setStepSound(Block.soundTypeGlass);
		this.setTickRandomly(true);
		this.setHardness(0.2F);
	}
	
	@Override
	public boolean isFullCube()
    {
        return false;
    }
	
	@Override
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid)
    {
        return this.isCollidable();
    }
	
	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() 
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		return super.getCollisionBoundingBox(worldIn, pos, state);
	}
	
}
