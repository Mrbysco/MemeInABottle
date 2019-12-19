package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.entity.projectile.EntityKnucklesSpit;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityKnuckles extends AbstractMeme implements IRangedAttackMob{
	private static final DataParameter<Integer> TYPE = EntityDataManager.<Integer>createKey(EntityKnuckles.class, DataSerializers.VARINT);

	public EntityKnuckles(World worldIn) {
		super(worldIn);
		super.setSize(0.9F, 0.9F);
	}

	@Override
	public float getEyeHeight()
	{
		return 0.65F;
	}

	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 15, 10.0F));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityKnucklesQueen.class, 8.0F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.applyEntityAI();
	}

	private void applyEntityAI() {
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true, new Class[0]));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();

		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.4D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
	}


	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		EntityKnucklesSpit entityknucklesspit = new EntityKnucklesSpit(this.world, this);
		double d0 = target.posX - this.posX;
		double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entityknucklesspit.posY;
		double d2 = target.posZ - this.posZ;
		float f = MathHelper.sqrt(d0 * d0 + d2 * d2) * 0.2F;
		entityknucklesspit.shoot(d0, d1 + (double)f, d2, 1.5F, 10.0F);
		this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_LLAMA_SPIT, this.getSoundCategory(), 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
		this.world.spawnEntity(entityknucklesspit);
	}

	@Override
	public void setSwingingArms(boolean swingingArms) { }

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

	@Nullable
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		this.setType(rand.nextInt(7));
		return super.onInitialSpawn(difficulty, livingdata);
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("Type", this.getType());
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setType(compound.getInteger("Type"));
	}
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.knuckles_passive;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return MemeSounds.knuckles_hurt;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.knuckles_death;
    }
	
	@Override
	public boolean canPickupItems() {
		return false;
	}
}
