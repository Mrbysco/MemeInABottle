package com.Mrbysco.miab.blocks;

import java.util.List;

import javax.annotation.Nullable;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.blocks.base.BaseRotatable;
import com.Mrbysco.miab.init.MemeSounds;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockKeyboardMechanical extends BaseRotatable{

	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 2, 0.0625 * 13);
	
	public BlockKeyboardMechanical(String unlocalised, String registry) 
	{
		super(Material.CLAY);
		setUnlocalizedName(unlocalised);
		setRegistryName(registry);
		this.setCreativeTab(MemeInABottle.memetab);
		this.setLightOpacity(0);
		this.setHardness(0.7F);
		this.setSoundType(SoundType.WOOD);
	}
    
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BOUNDING_BOX;
    }
	
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
    {
    	addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
    }
    
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
    	playerIn.playSound(MemeSounds.keyboard_mechanical, 1F, 1F);
    	super.onBlockClicked(worldIn, pos, playerIn);
    }
  
}