package com.Mrbysco.MIAB.memes;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BasicSummoning {
	
	public static void Summon(Entity entityIn, World worldObj, double x, double y, double z)
	{
		entityIn.setLocationAndAngles(x + 0.5, y, z + 0.5, 0,0); 
		worldObj.spawnEntityInWorld(entityIn);
	}

}
