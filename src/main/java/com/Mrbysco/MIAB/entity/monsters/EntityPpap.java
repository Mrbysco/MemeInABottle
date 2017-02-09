package com.Mrbysco.MIAB.entity.monsters;

import com.Mrbysco.MIAB.entity.entitybases.EntityMemeBase;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityPpap extends EntityMemeBase 
{
	public static String NAME = "Kosaka Daimaou";
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityPpap(World world) {
	    super(world);
		}

	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	};
	
		@Override
	    protected SoundEvent getAmbientSound()
	    {
	        return MiabSoundEvents.ppap_sound;
	    }
		
		@Override
	    protected SoundEvent getHurtSound()
	    {
	        return MiabSoundEvents.ppap_sound;
	    }
		
		@Override
	    protected SoundEvent getDeathSound()
	    {
	        return MiabSoundEvents.ppap_death;
	    }
	    
}