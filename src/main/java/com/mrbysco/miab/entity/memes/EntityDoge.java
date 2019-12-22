package com.mrbysco.miab.entity.memes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.World;

public class EntityDoge extends WolfEntity {

	public EntityDoge(EntityType<? extends EntityDoge> entityType, World worldIn) {
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
		else if (!(otherAnimal instanceof EntityDoge))
		{
			return false;
		}
		else
		{
			EntityDoge entityDoge = (EntityDoge)otherAnimal;

			if (!entityDoge.isTamed())
			{
				return false;
			}
			else if (entityDoge.isSitting())
			{
				return false;
			}
			else
			{
				return this.isInLove() && entityDoge.isInLove();
			}
		}
	}
}
