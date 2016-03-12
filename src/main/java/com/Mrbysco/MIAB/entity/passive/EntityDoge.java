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

	}