package com.Mrbysco.MIAB.entity.monsters;

import com.Mrbysco.MIAB.entity.monsters.entityBase.EntityMemeBase;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityPepe extends EntityMemeBase 
{	
	public static String NAME = "Pepe";
	
	private boolean isMounted = false;
	
	public EntityPepe(World world) {
	    super(world);
	    }
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.245D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	};
	
		@Override
	    protected SoundEvent getAmbientSound()
	    {
		return MiabSoundEvents.dad_passive;
	    }
		
		@Override
	    protected SoundEvent getHurtSound()
	    {
	        return MiabSoundEvents.dad_hit;
	    }
		
		@Override
	    protected SoundEvent getDeathSound()
	    {
	        return MiabSoundEvents.dad_death;
	    }

}