package com.Mrbysco.miab.entities.passive;

import javax.annotation.Nullable;

import com.Mrbysco.miab.entities.base.EntityKnucklesBase;
import com.Mrbysco.miab.init.MemeSounds;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityKnuckles extends EntityKnucklesBase
{
    private static final DataParameter<Integer> TYPE = EntityDataManager.<Integer>createKey(EntityKnuckles.class, DataSerializers.VARINT);
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityKnuckles(World world) {
	    super(world);
	    super.setSize(0.9F, 0.9F);
	}
	
	@Override
	public float getEyeHeight()
    {
        return 0.65F;
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
		this.tasks.addTask(4, new EntityAIFollow(new EntityKnucklesQueen(world), 1.25D, 15, 10.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        
        this.applyEntityAI();
	}
	
	@Override
	protected void entityInit() {
        super.entityInit();
        this.dataManager.register(TYPE, Integer.valueOf(0));
	}
	
	public void setType(int type)
    {
        this.dataManager.set(TYPE, Integer.valueOf(type));
    }
	
	public int getType()
    {
        return ((Integer)this.dataManager.get(TYPE)).intValue();
    }
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.6D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
	};
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.knuckles_passive;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return MemeSounds.knuckles_hurt;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.knuckles_death;
    }
	
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        this.setType(rand.nextInt(7));
        
		this.playSound(MemeSounds.knuckles_passive, 1F, 1F);

		if (rand.nextInt(6) < 1) 
		{
			setCustomNameTag(getTypeName());
		}

		return super.onInitialSpawn(difficulty, livingdata);
	}

	
	public String getTypeName() {
		switch (getType())
        {
            case 0:
                return "Knuckles";
            case 1:
                return "Tank Knuckles";
            case 2:
            	return "Blue Knuckles";
            case 3:
            	return "Aku Knuckles";
            case 4:
            	return "Yugi Knuckles";
            case 5:
            	return "Super Saiyan Knuckles";
            case 6:
            	return "Super Saiyan Blue Knuckles";
            case 7:
            default:
                return "Knuckles";
        }
	}
	
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
        compound.setInteger("Type", this.getType());
	}
	
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
        this.setType(compound.getInteger("Type"));
	}
	
}