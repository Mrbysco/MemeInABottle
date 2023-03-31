package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.entity.ai.CallForKnucklesGoal;
import com.mrbysco.miab.registry.MemeEntities;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class KnucklesQueenEntity extends AbstractMeme implements RangedAttackMob {

	public KnucklesQueenEntity(EntityType<? extends KnucklesQueenEntity> entityType, Level level) {
		super(entityType, level);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 15, 10.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(1, new CallForKnucklesGoal(this, true, new Class[0]));
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(KnucklesQueenEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AbstractMeme.registerAttributes()
				.add(Attributes.MAX_HEALTH, 22.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.23D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.4D)
				.add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {

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
		return MemeSounds.knuckles_passive.get();
	}

	@Override
	public boolean canPickupItems() {
		return false;
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData livingData, @Nullable CompoundTag dataTag) {
		livingData = super.finalizeSpawn(level, difficultyIn, reason, livingData, dataTag);
		if (!level.isClientSide()) {
			int knucklesAmount = random.nextInt(9);
			for (int i = 0; i < knucklesAmount; i++) {
				KnucklesEntity knuckles = MemeEntities.KNUCKLES.get().create(level.getLevel());
				knuckles.setKnucklesType(random.nextInt(7));
				knuckles.teleportTo(getX(), getY(), getZ());

				level.addFreshEntity(knuckles);
			}
		}

		return livingData;
	}
}
