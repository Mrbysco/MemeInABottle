package com.Mrbysco.MIAB.handler;

import com.Mrbysco.MIAB.entity.EntityMeme;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class DispenseHandler extends BehaviorProjectileDispense {
	
	
	public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        IPosition iposition = BlockDispenser.getDispensePosition(source);
        EnumFacing enumfacing = (EnumFacing)source.getBlockState().getValue(BlockDispenser.FACING);
        IProjectile iprojectile = this.getProjectileEntity(world, iposition, stack);
        iprojectile.setThrowableHeading((double)enumfacing.getFrontOffsetX(), (double)((float)enumfacing.getFrontOffsetY() + 0.1F), (double)enumfacing.getFrontOffsetZ(), this.getProjectileVelocity(), this.getProjectileInaccuracy());
        world.spawnEntity((Entity)iprojectile);
        stack.shrink(1);
        return stack;
	}

	@Override
	protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
			EntityMeme meme = new EntityMeme(worldIn, position.getX(), position.getY(), position.getZ());
			return meme;
	}
}