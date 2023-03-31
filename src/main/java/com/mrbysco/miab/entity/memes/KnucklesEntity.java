package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.entity.projectile.KnucklesSpitEntity;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class KnucklesEntity extends AbstractMeme implements RangedAttackMob {
	private static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.<Integer>defineId(KnucklesEntity.class, EntityDataSerializers.INT);

	public KnucklesEntity(EntityType<? extends KnucklesEntity> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public float getEyeHeight(Pose pose) {
		return 0.65F;
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 15, 10.0F));
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, KnucklesQueenEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, false, 4, () -> false));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(KnucklesEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AbstractMeme.registerAttributes()
				.add(Attributes.MAX_HEALTH, 16.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.28D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.4D)
				.add(Attributes.FOLLOW_RANGE, 30.0D);
	}


	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		KnucklesSpitEntity entityknucklesspit = new KnucklesSpitEntity(this.level, this);
		double d0 = target.getX() - this.getX();
		double d1 = target.getBoundingBox().minY + (double) (target.getBbHeight() / 3.0F) - entityknucklesspit.getY();
		double d2 = target.getZ() - this.getZ();
		float f = Mth.sqrt((float) (d0 * d0 + d2 * d2)) * 0.2F;
		entityknucklesspit.shoot(d0, d1 + (double) f, d2, 1.5F, 10.0F);
		this.level.playSound((Player) null, this.getX(), this.getY(), this.getZ(), SoundEvents.LLAMA_SPIT, this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
		this.level.addFreshEntity(entityknucklesspit);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TYPE, Integer.valueOf(0));
	}

	public void setKnucklesType(int type) {
		this.entityData.set(TYPE, Integer.valueOf(type));
	}

	public int getKnucklesType() {
		return this.entityData.get(TYPE).intValue();
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData livingData, @Nullable CompoundTag dataTag) {
		livingData = super.finalizeSpawn(level, difficultyIn, reason, livingData, dataTag);
		this.setKnucklesType(random.nextInt(7));

		return livingData;
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Type", this.getKnucklesType());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setKnucklesType(compound.getInt("Type"));
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return MemeSounds.knuckles_passive.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return MemeSounds.knuckles_hurt.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return MemeSounds.knuckles_death.get();
	}

	@Override
	public boolean canPickupItems() {
		return false;
	}
}
