package com.Mrbysco.miab.entities.passive;

import javax.annotation.Nullable;

import com.Mrbysco.miab.init.MemeLoot;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityBongoCat extends EntityCreature
{
	private static final DataParameter<Boolean> TAPPING = EntityDataManager.<Boolean>createKey(EntityBongoCat.class, DataSerializers.BOOLEAN);
	
	public static String NAME = "Bongo Cat";
	private boolean isMounted = false;
	private int TickSinceTap = 0;
	private int TicksNotTapped = 0;
	
	public EntityBongoCat(World worldIn) {
		super(worldIn);
        this.setSize(0.6F, 1.5F);
	}
	
	@Override
	protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(10, new EntityAIWanderAvoidWater(this, 0.8D, 1.0000001E-5F));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityChicken.class, false));
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
    }

	@Override
	protected void entityInit() {
		super.entityInit();
        this.dataManager.register(TAPPING, Boolean.valueOf(false));
	}

    public void setTapping(boolean isTapping)
    {
        this.getDataManager().set(TAPPING, Boolean.valueOf(isTapping));
    }

    public boolean isTapping()
    {
        return ((Boolean)this.getDataManager().get(TAPPING)).booleanValue();
    }
    
    @Override
    public void onLivingUpdate() {
    	if(isTapping())
    	{
    		TickSinceTap++;
    		
    		if(world.rand.nextInt(50) < 4)
    		{
				this.playSound(SoundEvents.BLOCK_NOTE_BASEDRUM, getSoundVolume(), getSoundPitch());
    		}
    		
    		if(TickSinceTap > 30)
    		{
    			this.setTapping(false);
    			TickSinceTap = 0;
    		}    	
    	}
    	else
    	{
    		TicksNotTapped++;
    	}
    	
    	if(TicksNotTapped > 30)
    	{
    		this.setTapping(true);
    		TicksNotTapped = 0;
    	}
    	
    	super.onLivingUpdate();
    }
    
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.playSound(SoundEvents.BLOCK_NOTE_SNARE, 1F, 1F);
		if (rand.nextInt(1) < 1) 
		{
			setCustomNameTag(NAME);
		}
		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	@Nullable
    protected SoundEvent getAmbientSound()
    {
        return null;
    }

	@Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_CAT_HURT;
    }

	@Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_CAT_DEATH;
    }
	
	/**
     * Returns the volume for the sounds this mob makes.
     */
	@Override
    protected float getSoundVolume()
    {
        return 0.4F;
    }
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn)
    {
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0F);
    }

    /**
     * Called when the entity is attacked.
     */
	@Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            return super.attackEntityFrom(source, amount);
        }
    }

	@Override
    @Nullable
    protected ResourceLocation getLootTable()
    {
        return MemeLoot.BONGO_LOOT;
    }
}