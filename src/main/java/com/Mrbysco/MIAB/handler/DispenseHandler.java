package com.Mrbysco.MIAB.handler;

import com.Mrbysco.MIAB.entity.EntityMeme;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class DispenseHandler extends BehaviorProjectileDispense  {
	public ItemStack dispenseStack(IBlockSource BlockSource, ItemStack stack) {
		World world = BlockSource.getWorld();
        IPosition iposition = BlockDispenser.getDispensePosition(BlockSource);
        EnumFacing enumfacing = (EnumFacing)BlockSource.getBlockState().getValue(BlockDispenser.FACING);
        IProjectile iprojectile = this.getProjectileEntity(world, iposition, stack);
        iprojectile.setThrowableHeading((double)enumfacing.getFrontOffsetX(), (double)((float)enumfacing.getFrontOffsetY() + 0.1F), (double)enumfacing.getFrontOffsetZ(), this.getProjectileVelocity(), this.getProjectileInaccuracy());
        world.spawnEntityInWorld((EntityMeme)iprojectile);
        stack.splitStack(1);
        return stack;
	}

	@Override
	protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
		return null;
	}
}