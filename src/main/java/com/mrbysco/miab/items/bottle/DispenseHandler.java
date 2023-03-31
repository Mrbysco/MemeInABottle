package com.mrbysco.miab.items.bottle;

import com.mrbysco.miab.entity.projectile.SplashMemeEntity;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DispenseHandler implements DispenseItemBehavior {
	public ItemStack dispense(BlockSource source, ItemStack stack) {
		return (new AbstractProjectileDispenseBehavior() {
			/**
			 * Return the projectile entity spawned by this dispense behavior.
			 */
			protected Projectile getProjectile(Level level, Position position, ItemStack stackIn) {
				SplashMemeEntity meme = new SplashMemeEntity(level, position.x(), position.y(), position.z());
				meme.setItem(stackIn.copy());
				return new SplashMemeEntity(level, position.x(), position.y(), position.z());
			}

			protected float getUncertainty() {
				return super.getUncertainty() * 0.5F;
			}

			protected float getPower() {
				return super.getPower() * 1.25F;
			}
		}).dispense(source, stack);
	}
}
