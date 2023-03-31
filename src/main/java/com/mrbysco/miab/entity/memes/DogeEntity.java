package com.mrbysco.miab.entity.memes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;

public class DogeEntity extends Wolf {

	public DogeEntity(EntityType<? extends DogeEntity> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public boolean canMate(Animal otherAnimal) {
		if (otherAnimal == this) {
			return false;
		} else if (!this.isTame()) {
			return false;
		} else if (!(otherAnimal instanceof DogeEntity entityDoge)) {
			return false;
		} else {

			if (!entityDoge.isTame()) {
				return false;
			} else if (entityDoge.isOrderedToSit()) {
				return false;
			} else {
				return this.isInLove() && entityDoge.isInLove();
			}
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Wolf.createAttributes();
	}
}
