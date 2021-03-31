package com.mrbysco.miab.entity.memes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.World;

public class DogeEntity extends WolfEntity {

	public DogeEntity(EntityType<? extends DogeEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	@Override
	public boolean canMateWith(AnimalEntity otherAnimal) {
		if (otherAnimal == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(otherAnimal instanceof DogeEntity)) {
			return false;
		} else {
			DogeEntity entityDoge = (DogeEntity)otherAnimal;

			if (!entityDoge.isTamed()) {
				return false;
			} else if (entityDoge.isQueuedToSit()) {
				return false;
			} else {
				return this.isInLove() && entityDoge.isInLove();
			}
		}
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return WolfEntity.registerAttributes();
	}
}
