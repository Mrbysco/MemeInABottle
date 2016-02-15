package com.Mrbysco.MIAB.entity.passive;

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
	    protected String getLivingSound()
	    {
	        return this.isAngry() ? "miab:Doge.growl" : (this.rand.nextInt(3) == 0 ? (this.isTamed() && this.dataWatcher.getWatchableObjectFloat(18) < 10.0F ? "miab:Doge.whine" : "miab:Doge.panting") : "miab:Doge.bark");
	    }
		
		@Override
	    protected String getHurtSound()
	    {
	        return "miab:Doge.hurt";
	    }
		
		@Override
	    protected String getDeathSound()
	    {
	        return "miab:Doge.death";
	    }

	}