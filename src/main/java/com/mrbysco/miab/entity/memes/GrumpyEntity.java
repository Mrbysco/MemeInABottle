package com.mrbysco.miab.entity.memes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.level.Level;

public class GrumpyEntity extends Cat {

	public GrumpyEntity(EntityType<? extends GrumpyEntity> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public boolean canMate(Animal otherAnimal) {
		if (otherAnimal == this) {
			return false;
		} else if (!this.isTame()) {
			return false;
		} else if (!(otherAnimal instanceof GrumpyEntity grumpyEntity)) {
			return false;
		} else {

			if (!grumpyEntity.isTame()) {
				return false;
			} else if (grumpyEntity.isOrderedToSit()) {
				return false;
			} else {
				return this.isInLove() && grumpyEntity.isInLove();
			}
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Cat.createAttributes();
	}
}
