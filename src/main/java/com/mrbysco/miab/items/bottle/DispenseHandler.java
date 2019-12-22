package com.mrbysco.miab.items.bottle;

import com.mrbysco.miab.entity.projectile.EntitySplashMeme;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DispenseHandler implements IDispenseItemBehavior {
	public ItemStack dispense(IBlockSource source, ItemStack stack) {
		return (new ProjectileDispenseBehavior()
        {
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn)
            {
            	EntitySplashMeme meme = new EntitySplashMeme(worldIn, position.getX(), position.getY(), position.getZ());
        		meme.setItem(stackIn.copy());
                return new EntitySplashMeme(worldIn, position.getX(), position.getY(), position.getZ());
            }
            protected float getProjectileInaccuracy()
            {
                return super.getProjectileInaccuracy() * 0.5F;
            }
            protected float getProjectileVelocity()
            {
                return super.getProjectileVelocity() * 1.25F;
            }
        }).dispense(source, stack);
	}
}
