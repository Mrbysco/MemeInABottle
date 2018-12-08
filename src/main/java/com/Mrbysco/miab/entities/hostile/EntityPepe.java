package com.Mrbysco.miab.entities.hostile;

import com.Mrbysco.miab.entities.base.EntityMemeBase;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.DifficultyInstance;
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
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		//this.playSound(MemeSounds.pepe, 1F, 1F);
		if (rand.nextInt(2) < 1) 
		{
			setCustomNameTag(NAME);
		}
		return super.onInitialSpawn(difficulty, livingdata);
	}
}