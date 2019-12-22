package com.mrbysco.miab.entity.memes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.world.World;

public class EntityGrumpy extends CatEntity {

	public EntityGrumpy(EntityType<? extends EntityGrumpy> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	@Override
	public boolean canMateWith(AnimalEntity otherAnimal)
	{
		if (otherAnimal == this)
		{
			return false;
		}
		else if (!this.isTamed())
		{
			return false;
		}
		else if (!(otherAnimal instanceof EntityGrumpy))
		{
			return false;
		}
		else
		{
			EntityGrumpy entityGrumpy = (EntityGrumpy)otherAnimal;

			if (!entityGrumpy.isTamed())
			{
				return false;
			}
			else if (entityGrumpy.isSitting())
			{
				return false;
			}
			else
			{
				return this.isInLove() && entityGrumpy.isInLove();
			}
		}
	}
}
