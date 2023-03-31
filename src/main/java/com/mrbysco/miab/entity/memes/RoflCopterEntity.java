package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class RoflCopterEntity extends PathfinderMob {
	private static final EntityDataAccessor<Byte> LANDED = SynchedEntityData.<Byte>defineId(RoflCopterEntity.class, EntityDataSerializers.BYTE);

	/**
	 * Coordinates of where the rofl spawned.
	 */
	private BlockPos spawnPosition;

	public RoflCopterEntity(EntityType<? extends RoflCopterEntity> entityType, Level level) {
		super(entityType, level);
		this.setIsCopterLanded(true);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(LANDED, Byte.valueOf((byte) 0));
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.5F));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new RoflCopterEntity.RandomFlyGoal(this));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1.0F, false));
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, LivingEntity.class, 8.0F));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(RoflCopterEntity.class));
	}

	@Override
	public boolean canBeLeashed(Player player) {
		return true;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.3F;
	}

	@Nullable
	@Override
	public SoundEvent getAmbientSound() {
		return getIsCopterLanded() ? null : MemeSounds.rofl_passive.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return MemeSounds.rofl_hurt.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return MemeSounds.rofl_death.get();
	}

	/**
	 * Returns true if this entity should push and be pushed by other entities when colliding.
	 */
	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {

	}

	@Override
	protected void pushEntities() {

	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 30.0D);
	}

	public boolean getIsCopterLanded() {
		return (((Byte) this.entityData.get(LANDED)).byteValue() & 1) != 0;
	}

	public void setIsCopterLanded(boolean isHanging) {
		byte b0 = ((Byte) this.entityData.get(LANDED)).byteValue();

		if (isHanging) {
			this.entityData.set(LANDED, Byte.valueOf((byte) (b0 | 1)));
		} else {
			this.entityData.set(LANDED, Byte.valueOf((byte) (b0 & -2)));
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void tick() {
		super.tick();
		if (this.getIsCopterLanded()) {
			this.setDeltaMovement(0.0D, 0.0D, 0.0D);
			this.setPos(getX(), (double) Mth.floor(this.getY()) + 1.0D - (double) this.getBbHeight(), getZ());
		} else {
			Vec3 motion = getDeltaMovement();
			double motionY = motion.y;
			motionY *= 0.6000000238418579D;
			this.setDeltaMovement(motion.x, motionY, motion.z);
		}
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		BlockPos blockpos = blockPosition();
		BlockPos blockpos1 = blockpos.above();

		if (this.getIsCopterLanded()) {
			if (this.level.getBlockState(blockpos1).isRedstoneConductor(this.level, blockpos1)) {
				if (this.random.nextInt(200) == 0) {
					this.yHeadRot = (float) this.random.nextInt(360);
				}

				if (this.level.getNearestPlayer(this, 4.0D) != null) {
					this.setIsCopterLanded(false);
					this.level.levelEvent((Player) null, 1025, blockpos, 0);
				}
			} else {
				this.setIsCopterLanded(false);
				this.level.levelEvent((Player) null, 1025, blockpos, 0);
			}
		} else {
			if (this.spawnPosition != null && (!this.level.isEmptyBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
				this.spawnPosition = null;
			}

			if (this.spawnPosition == null || this.random.nextInt(30) == 0 ||
					this.spawnPosition.distSqr(blockPosition()) < 4.0D) {
				this.spawnPosition = new BlockPos((int) this.getX() + this.random.nextInt(7) - this.random.nextInt(7), (int) this.getY() + this.random.nextInt(6) - 2, (int) this.getZ() + this.random.nextInt(7) - this.random.nextInt(7));
			}

			double d0 = (double) this.spawnPosition.getX() + 0.5D - this.getX();
			double d1 = (double) this.spawnPosition.getY() + 0.1D - this.getY();
			double d2 = (double) this.spawnPosition.getZ() + 0.5D - this.getZ();
			Vec3 motion = getDeltaMovement();
			double motionX = motion.x;
			double motionY = motion.y;
			double motionZ = motion.z;
			motionX += (Math.signum(d0) * 0.5D - motionX) * 0.10000000149011612D;
			motionY += (Math.signum(d1) * 0.699999988079071D - motionY) * 0.10000000149011612D;
			motionZ += (Math.signum(d2) * 0.5D - motionZ) * 0.10000000149011612D;
			setDeltaMovement(motionX, motionY, motionZ);
			float f = (float) (Mth.atan2(motionZ, motionX) * (180D / Math.PI)) - 90.0F;
			float f1 = Mth.wrapDegrees(f - this.getYRot());
			this.zza = 0.5F;
			this.setYRot(getYRot() + f1);

			if (this.random.nextInt(100) == 0 && this.level.getBlockState(blockpos1).isRedstoneConductor(this.level, blockpos1)) {
				this.setIsCopterLanded(true);
			}
		}
	}

	protected Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.EVENTS;
	}

	@Override
	public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
		return false;
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {

	}

	/**
	 * Return whether this entity should NOT trigger a pressure plate or a tripwire.
	 */
	@Override
	public boolean isIgnoringBlockTriggers() {
		return true;
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else {
			if (!this.level.isClientSide && this.getIsCopterLanded()) {
				this.setIsCopterLanded(false);
			}
			return super.hurt(source, amount);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.entityData.set(LANDED, Byte.valueOf(compound.getByte("CopterFlags")));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putByte("CopterFlags", ((Byte) this.entityData.get(LANDED)).byteValue());
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	@Override
	public boolean checkSpawnRules(LevelAccessor level, MobSpawnType spawnReasonIn) {
		BlockPos blockpos = new BlockPos(this.getX(), this.getBoundingBox().minY, this.getZ());

		if (blockpos.getY() >= this.level.getSeaLevel()) {
			return false;
		} else {
			int i = this.level.getLightEmission(blockpos);

			return i > this.random.nextInt(4) ? false : super.checkSpawnRules(level, spawnReasonIn);
		}
	}

	@Override
	public float getEyeHeight(Pose pose) {
		return this.getBbHeight() / 1.5F;
	}


	static class RandomFlyGoal extends Goal {
		private final RoflCopterEntity parentEntity;

		public RandomFlyGoal(RoflCopterEntity copter) {
			this.parentEntity = copter;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			MoveControl movementcontroller = this.parentEntity.getMoveControl();
			if (!movementcontroller.hasWanted()) {
				return true;
			} else {
				double d0 = movementcontroller.getWantedX() - this.parentEntity.getX();
				double d1 = movementcontroller.getWantedY() - this.parentEntity.getY();
				double d2 = movementcontroller.getWantedZ() - this.parentEntity.getZ();
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			RandomSource random = this.parentEntity.getRandom();
			double d0 = this.parentEntity.getX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d1 = this.parentEntity.getY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d2 = this.parentEntity.getZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.parentEntity.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
		}
	}
}
