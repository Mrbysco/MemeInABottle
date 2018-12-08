package com.Mrbysco.miab.entities.passive;

import javax.annotation.Nullable;

import com.Mrbysco.miab.entities.AI.AICallForKnuckles;
import com.Mrbysco.miab.entities.base.EntityKnucklesBase;
import com.Mrbysco.miab.init.MemeSounds;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityKnucklesQueen extends EntityKnucklesBase
{	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityKnucklesQueen(World world) {
	    super(world);
	    super.setSize(1.0F, 1.9F);
	}

	@Override
	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackRanged((IRangedAttackMob) this, 1.25D, 15, 10.0F));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityKnucklesQueen.class, 8.0F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new AICallForKnuckles(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
        
        this.applyEntityAI();
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
	};
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return null;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return null; //MemeSounds.knuckles_hurt;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return null; //MemeSounds.knuckles_death;
    }
	
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        
		this.playSound(MemeSounds.knuckles_passive, 1F, 1F);

		if (rand.nextInt(2) < 1) 
		{
			setCustomNameTag("Da Queen");
		}
		
		if(world.isRemote)
		{
			for(int i = 0; i < 8; i++)
			{
				EntityKnuckles knuckles = new EntityKnuckles(world);
				knuckles.setPositionAndUpdate(posX, posY, posZ);

				world.spawnEntity(knuckles);
			}
		}

		return super.onInitialSpawn(difficulty, livingdata);
	}
}