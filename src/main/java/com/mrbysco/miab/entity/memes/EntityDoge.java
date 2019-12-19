package com.mrbysco.miab.entity.memes;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;

public class EntityDoge extends EntityWolf {

	public EntityDoge(World worldIn) {
		super(worldIn);
	}

	@Override
	public boolean canMateWith(EntityAnimal otherAnimal)
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
