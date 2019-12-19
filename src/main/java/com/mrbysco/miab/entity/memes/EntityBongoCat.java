package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeLoot;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOcelotAttack;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
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
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityBongoCat extends AbstractMeme{
	private static final DataParameter<Boolean> TAPPING = EntityDataManager.<Boolean>createKey(EntityBongoCat.class, DataSerializers.BOOLEAN);

	private int TickSinceTap = 0;
	private int TicksNotTapped = 0;

	public EntityBongoCat(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 1.5F);
	}

	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3F));
		this.tasks.addTask(8, new EntityAIOcelotAttack(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(10, new EntityAIWanderAvoidWater(this, 0.8D, 1.0000001E-5F));
		this.applyEntityAI();
	}

	private void applyEntityAI() {
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityChicken.class, false));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.4D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
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
    protected SoundEvent getAmbientSound()
    {
        return null;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return SoundEvents.ENTITY_CAT_HURT;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_CAT_DEATH;
    }
	
	@Override
	public boolean canPickupItems() {
		return false;
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	@Nullable
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.BONGO_LOOT;
	}
}
