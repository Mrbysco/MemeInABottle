package com.mrbysco.miab.entity.memes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.world.World;

public class GrumpyEntity extends CatEntity {

	public GrumpyEntity(EntityType<? extends GrumpyEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	@Override
	public boolean canMateWith(AnimalEntity otherAnimal) {
		if (otherAnimal == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(otherAnimal instanceof GrumpyEntity)) {
			return false;
		} else {
			GrumpyEntity grumpyEntity = (GrumpyEntity)otherAnimal;

			if (!grumpyEntity.isTamed()) {
				return false;
			} else if (grumpyEntity.isQueuedToSit()) {
				return false;
			} else {
				return this.isInLove() && grumpyEntity.isInLove();
			}
		}
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return CatEntity.func_234184_eY_();
	}
}
