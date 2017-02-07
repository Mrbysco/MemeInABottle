package com.Mrbysco.MIAB.entity.passive;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.World;

public class EntityGrumpy extends EntityOcelot
	{
		public static String NAME = "GrumpyCat";
		private boolean isMounted = false;
		
		public EntityGrumpy(World worldIn) {
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
	        else if (!(otherAnimal instanceof EntityGrumpy))
	        {
	            return false;
	        }
	        else
	        {
	        	EntityGrumpy EntityGrumpy = (EntityGrumpy)otherAnimal;
	            return !EntityGrumpy.isTamed() ? false : (EntityGrumpy.isSitting() ? false : this.isInLove() && EntityGrumpy.isInLove());
	        }
	    }
	}