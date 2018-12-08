package com.Mrbysco.miab.entities.passive;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityDoge extends EntityWolf
{
	public static String NAME = "Doge";
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
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.playSound(SoundEvents.ENTITY_WOLF_GROWL, 1F, 1F);
		if (rand.nextInt(1) < 1) 
		{
			setCustomNameTag(NAME);
		}
		return super.onInitialSpawn(difficulty, livingdata);
	}
}