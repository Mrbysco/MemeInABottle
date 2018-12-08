package com.Mrbysco.miab.blocks;

import java.util.List;

import javax.annotation.Nullable;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.init.MemeItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BottleBlock extends Block
{	
    protected static final AxisAlignedBB BOTTLE_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    
	public BottleBlock(String registry)
	{
		super(Material.GLASS);
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
		this.setSoundType(SoundType.GLASS);
		this.setTickRandomly(true);
		this.setHardness(0.2F);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
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
        return true;
    }
	
	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BOTTLE_AABB;
    }
		
	@Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
    {
    	addCollisionBoxToList(pos, entityBox, collidingBoxes, BOTTLE_AABB);
    }
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) 
    {
		return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.DOWN);
    }
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        this.checkAndDropBlock(worldIn, pos, state);
    }

    private boolean checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.canPlaceBlockAt(worldIn, pos))
        {
            worldIn.setBlockToAir(pos);
            worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY(), pos.getZ(), new ItemStack(MemeItems.meme_in_a_bottle)));
            return false;
        }
        else
        {
            return true;
        }
    }
}
