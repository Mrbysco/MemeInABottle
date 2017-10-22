package com.Mrbysco.miab.entities.passive;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.init.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGrumpy extends EntityOcelot
{
	public static String NAME = "Grumpy Cat";
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
    
    @Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.playSound(SoundEvents.ENTITY_CAT_PURREOW, 1F, 1F);
		if (rand.nextInt(1) < 1) 
		{
			setCustomNameTag(NAME);
		}
		return super.onInitialSpawn(difficulty, livingdata);
	}
}