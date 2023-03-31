package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.OcelotAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BongoCatEntity extends AbstractMeme {
	private static final EntityDataAccessor<Boolean> TAPPING = SynchedEntityData.<Boolean>defineId(BongoCatEntity.class, EntityDataSerializers.BOOLEAN);

	private int TickSinceTap = 0;
	private int TicksNotTapped = 0;

	public BongoCatEntity(EntityType<? extends BongoCatEntity> entityType, Level level) {
		super(entityType, level);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(7, new LeapAtTargetGoal(this, 0.3F));
		this.goalSelector.addGoal(8, new OcelotAttackGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Chicken.class, false));
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(BongoCatEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AbstractMeme.registerAttributes()
				.add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.30000001192092896D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.4D)
				.add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TAPPING, Boolean.valueOf(false));
	}

	public void setTapping(boolean isTapping) {
		this.getEntityData().set(TAPPING, Boolean.valueOf(isTapping));
	}

	public boolean isTapping() {
		return ((Boolean) this.getEntityData().get(TAPPING)).booleanValue();
	}

	@Override
	public void aiStep() {
		if (isTapping()) {
			TickSinceTap++;

			if (level.random.nextInt(50) < 4) {
				this.playSound(SoundEvents.NOTE_BLOCK_BASEDRUM, getSoundVolume(), getVoicePitch());
			}

			if (TickSinceTap > 30) {
				this.setTapping(false);
				TickSinceTap = 0;
			}
		} else {
			TicksNotTapped++;
		}

		if (TicksNotTapped > 30) {
			this.setTapping(true);
			TicksNotTapped = 0;
		}

		super.aiStep();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.CAT_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.CAT_DEATH;
	}

	@Override
	public boolean canPickupItems() {
		return false;
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}
}
