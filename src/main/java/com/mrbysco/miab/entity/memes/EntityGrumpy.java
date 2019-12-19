package com.mrbysco.miab.entity.memes;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityGrumpy extends EntityOcelot {

	public EntityGrumpy(World worldIn) {
		super(worldIn);
	}

	@Nullable
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		return super.onInitialSpawn(difficulty, livingdata);
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
