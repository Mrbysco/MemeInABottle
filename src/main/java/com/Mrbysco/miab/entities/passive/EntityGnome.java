package com.Mrbysco.miab.entities.passive;

import javax.annotation.Nullable;

import com.Mrbysco.miab.init.MemeLoot;
import com.Mrbysco.miab.init.MemeSounds;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGnome extends EntityCreature
{	
	private static final DataParameter<Boolean> GNOMED = EntityDataManager.<Boolean>createKey(EntityGnome.class, DataSerializers.BOOLEAN);

	private static final DataParameter TAPPING = null;

	public static String NAME = "You've Been Gnomed";
	private boolean isMounted = false;
	private int gnomeTimer = 0;
	
	public EntityGnome(World worldIn) {
		super(worldIn);
        this.setSize(0.5F, 0.8F);
        this.setGnomed(false);
	}
	
	@Override
	protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
    	this.tasks.addTask(5, new EntityAIWander(this, 1.0));
    	this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(8, new EntityAIAttackMelee(this, 1.0F, false));
        this.tasks.addTask(10, new EntityAIWanderAvoidWater(this, 0.8D, 1.0000001E-5F));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
	}

	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
    }

	@Override
	protected void entityInit() {
		super.entityInit();
        this.dataManager.register(GNOMED, Boolean.valueOf(false));
	}

    public void setGnomed(boolean isGnomed)
    {
        this.getDataManager().set(GNOMED, Boolean.valueOf(isGnomed));
    }

    public boolean isGnomed()
    {
        return ((Boolean)this.getDataManager().get(GNOMED)).booleanValue();
    }
    
    @Override
    public void onLivingUpdate() {
    	if(!isGnomed())
    	{
    		gnomeTimer++;
    		
    		if(gnomeTimer >= 280)
    		{
    			this.setGnomed(true);
    		}
    	}
    	super.onLivingUpdate();
    }
    
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.playSound(MemeSounds.gnome_spawn, 1F, 1F);
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
        return isGnomed() ? MemeSounds.gnome_passive : null;
    }

	@Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return MemeSounds.gnome_hurt;
    }

	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.gnome_death;
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
        return MemeLoot.GNOME_LOOT;
    }
}