package com.Mrbysco.MIAB.blocks;

import java.util.ArrayList;
import java.util.List;

import com.Mrbysco.MIAB.init.MIABItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BottleBlock extends Block{

	public BottleBlock(Material materialIn) 
	{
		super(Material.glass);
		//this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
		this.setStepSound(SoundType.GLASS);
		this.setTickRandomly(true);
		this.setHardness(0.2F);
	}
	
	@Override
	public boolean isFullBlock(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid)
    {
        return this.isCollidable();
    }
	
	@Override
	public boolean isFullyOpaque(IBlockState state)
	{
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState worldIn, World pos, BlockPos state)
    {
        return worldIn.getBoundingBox(pos, state).offset(state);
    }
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		ArrayList returnedStacks = new ArrayList(); returnedStacks.add(new ItemStack(MIABItems.meme_in_a_bottle)); return returnedStacks;
	}
}
