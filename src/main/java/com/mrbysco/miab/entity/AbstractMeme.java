package com.mrbysco.miab.entity;

import com.mrbysco.miab.Reference;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public abstract class AbstractMeme extends PathfinderMob {
	private static final ResourceLocation SPAWN_BOOST_ID = Reference.modLoc("spawn_boost");
	private static final ResourceLocation SPAWN_BONUS_ID = Reference.modLoc("spawn_bonus");
	protected int summonSoundTime = 100;

	public AbstractMeme(EntityType<? extends AbstractMeme> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.FOLLOW_RANGE, 20.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.2F)
				.add(Attributes.FOLLOW_RANGE, 20.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.23000000)
				.add(Attributes.ATTACK_DAMAGE, 2.0D)
				.add(Attributes.ARMOR, 2.0D);
	}

	@Override
	protected void defineSynchedData(Builder builder) {
		super.defineSynchedData(builder);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("summonSoundTime", this.summonSoundTime);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.summonSoundTime = compound.getInt("summonSoundTime");
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (!this.level().isClientSide) {
			int i = this.summonSoundTime;

			if (i > 0) {
				--i;
				summonSoundTime = i;
			}
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData livingData) {
		livingData = super.finalizeSpawn(level, difficultyIn, reason, livingData);
		float f = difficultyIn.getSpecialMultiplier();
		if (canPickupItems()) {
			this.setCanPickUpLoot(this.random.nextFloat() < 0.55F * f);
		}

		Objects.requireNonNull(this.getAttribute(Attributes.KNOCKBACK_RESISTANCE)).addTransientModifier(
				new AttributeModifier(
						SPAWN_BOOST_ID, this.random.nextDouble() * 0.5D, AttributeModifier.Operation.ADD_VALUE
				)
		);

		double d0 = this.random.nextDouble() * 1.5D * (double) f;
		if (d0 > 1.0D) {
			Objects.requireNonNull(this.getAttribute(Attributes.FOLLOW_RANGE)).addTransientModifier(
					new AttributeModifier(
							SPAWN_BONUS_ID, d0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
					)
			);
		}

		return livingData;
	}

	public boolean canPickupItems() {
		return false;
	}

	public Player getNearestPlayer(int range) {
		AABB aabb = (new AABB(getX(), getY(), getZ(), getX() + 1, getY() + 1, getZ() + 1)).inflate(range);
		List<Player> list = level().getEntitiesOfClass(Player.class, aabb);
		return !list.isEmpty() ? list.getFirst() : null;
	}

	public boolean isPlayerNearby(int range) {
		AABB aabb = (new AABB(getX(), getY(), getZ(), getX() + 1, getY() + 1, getZ() + 1)).inflate(range);
		List<Player> list = level().getEntitiesOfClass(Player.class, aabb);
		return !list.isEmpty();
	}

	@Override
	public void playAmbientSound() {
		if (this.summonSoundTime <= 0) {
			super.playAmbientSound();
		}
	}
}
