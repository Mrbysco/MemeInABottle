package com.Mrbysco.MIAB.entity.passive;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;

public class EntityDoge extends EntityWolf
	{
		public static String NAME = "DogeWolf";
		private boolean isMounted = false;
		
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
	        	EntityDoge entitydoge = (EntityDoge)otherAnimal;
	            return !entitydoge.isTamed() ? false : (entitydoge.isSitting() ? false : this.isInLove() && entitydoge.isInLove());
	        }
	    }
	}