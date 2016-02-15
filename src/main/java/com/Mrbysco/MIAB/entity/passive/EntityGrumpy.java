package com.Mrbysco.MIAB.entity.passive;

import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.World;

public class EntityGrumpy extends EntityOcelot
	{
		public static String NAME = "GrumpyCat";
		private boolean isMounted = false;
		
		public EntityGrumpy(World worldIn) {
		    super(worldIn);
		}
	}