package com.Mrbysco.MIAB.entity.monsters;

import com.Mrbysco.MIAB.entity.entitybases.EntityMemeBase;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySanic extends EntityMemeBase 
{
	public static String NAME = "Sanic";
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntitySanic(World world) {
	    super(world);
	    super.setSize(1.2F, 1.2F);
		}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.40D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	};
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MiabSoundEvents.moonman_passive;
    }
	
	@Override
    protected SoundEvent getHurtSound()
    {
        return MiabSoundEvents.moonman_hit;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MiabSoundEvents.moonman_death;
    }

}