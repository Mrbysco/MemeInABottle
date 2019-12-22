package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.entity.projectile.EntityKnucklesSpit;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityKnuckles extends AbstractMeme implements IRangedAttackMob{
	private static final DataParameter<Integer> TYPE = EntityDataManager.<Integer>createKey(EntityKnuckles.class, DataSerializers.VARINT);

	public EntityKnuckles(EntityType<? extends EntityKnuckles> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	@Override
	public float getEyeHeight(Pose pose) {
		return 0.65F;
	}

	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 15, 10.0F));
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(5, new LookAtGoal(this, EntityKnucklesQueen.class, 8.0F));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, false, 4, () -> false));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(EntityKnuckles.class));
	}
	
	@Override
	protected void registerAttributes()
	{
		super.registerAttributes();

		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.4D);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
	}


	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
		EntityKnucklesSpit entityknucklesspit = new EntityKnucklesSpit(this.world, this);
		double d0 = target.posX - this.posX;
		double d1 = target.getBoundingBox().minY + (double)(target.getHeight() / 3.0F) - entityknucklesspit.posY;
		double d2 = target.posZ - this.posZ;
		float f = MathHelper.sqrt(d0 * d0 + d2 * d2) * 0.2F;
		entityknucklesspit.shoot(d0, d1 + (double)f, d2, 1.5F, 10.0F);
		this.world.playSound((PlayerEntity)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_LLAMA_SPIT, this.getSoundCategory(), 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
		this.world.addEntity(entityknucklesspit);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(TYPE, Integer.valueOf(0));
	}

	public void setKnucklesType(int type)
	{
		this.dataManager.set(TYPE, Integer.valueOf(type));
	}

	public int getKnucklesType()
	{
		return this.dataManager.get(TYPE).intValue();
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable CompoundNBT tag) {
		this.setKnucklesType(rand.nextInt(7));
		return super.onInitialSpawn(worldIn, difficultyIn, reason, livingData, tag);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("Type", this.getKnucklesType());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setKnucklesType(compound.getInt("Type"));
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
