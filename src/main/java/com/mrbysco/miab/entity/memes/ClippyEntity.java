package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.StructureTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class ClippyEntity extends AbstractMeme {

	public float jumpAmount;
	public float jumpFactor;
	public float prevJumpFactor;
	private boolean wasOnGround;

	public ClippyEntity(EntityType<? extends ClippyEntity> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new ClippyEntity.ClippyMoverHelper(this);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new ClippyEntity.AIHop(this));
		this.goalSelector.addGoal(2, new ClippyEntity.AIClippyAttack(this));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ClippyEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AbstractMeme.registerAttributes()
				.add(Attributes.MAX_HEALTH, 16.0D)
				.add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.30000001192092896D);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		Holder<Biome> biome = this.level.getBiome(this.blockPosition());
		SoundEvent sound = SoundEvents.SLIME_HURT;
		if (!this.dead) {
			if (!this.level.isDay()) {
				sound = MemeSounds.clippy_night.get();
			} else if (biome.is(BiomeTags.IS_FOREST)) {
				if (isPlayerNearby(20) && getPlayerHealth() < 6) {
					sound = MemeSounds.clippy_health.get();
				} else if (!this.level.canSeeSkyFromBelowWater(this.blockPosition())) {
					sound = MemeSounds.clippy_cave.get();
				} else
					sound = MemeSounds.clippy_forest.get();
			} else if (isPlayerNearby(20) && getPlayerHealth() < 6) {
				sound = MemeSounds.clippy_health.get();
			} else if (this.getY() < 60) {
				sound = MemeSounds.clippy_cave.get();
			} else if (!this.level.isClientSide &&
					((ServerLevel) this.level).findNearestMapStructure(StructureTags.MINESHAFT, this.blockPosition(), 30, true) == this.blockPosition()) {
				sound = MemeSounds.clippy_mineshaft.get();
			} else {
				sound = MemeSounds.clippy_passive.get();
			}
		}
		return sound;
	}

	private float getPlayerHealth() {
		Player player = this.level.getNearestPlayer(this, 20);
		return player == null ? 0 : player.getHealth();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return MemeSounds.clippy_hurt.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return MemeSounds.clippy_death.get();
	}

	@Override
	public void playerTouch(Player entityIn) {
		if (this.canDamagePlayer() && !this.dead) {
			this.dealDamage(entityIn);
		}
	}

	protected boolean canDamagePlayer() {
		return this.getTarget() instanceof Player;
	}

	protected void dealDamage(LivingEntity entityIn) {
		int i = 2;

		if (this.hasLineOfSight(entityIn) && this.distanceToSqr(entityIn) < 0.6D * (double) i * 0.6D * (double) i && entityIn.hurt(DamageSource.mobAttack(this), (float) 2)) {
			this.playSound(SoundEvents.SLIME_ATTACK, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.doEnchantDamageEffects(this, entityIn);
		}
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("wasOnGround", this.wasOnGround);
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.wasOnGround = compound.getBoolean("wasOnGround");
	}

	public void tick() {
		this.jumpFactor += (this.jumpAmount - this.jumpFactor) * 0.5F;
		this.prevJumpFactor = this.jumpFactor;
		super.tick();

		if (this.onGround && !this.wasOnGround) {
			int i = 2;
			for (int j = 0; j < i * 8; ++j) {
				float f = this.random.nextFloat() * ((float) Math.PI * 2F);
				float f1 = this.random.nextFloat() * 0.5F + 0.5F;
				float f2 = Mth.sin(f) * (float) i * 0.5F * f1;
				float f3 = Mth.cos(f) * (float) i * 0.5F * f1;
				Level world = this.level;
				ParticleOptions iparticledata = ParticleTypes.FIREWORK;
				double d0 = this.getX() + (double) f2;
				double d1 = this.getZ() + (double) f3;
				world.addParticle(iparticledata, d0, this.getBoundingBox().minY, d1, 0.0D, 0.0D, 0.0D);
			}

			//this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			this.jumpAmount = -0.5F;
		} else if (!this.onGround && this.wasOnGround) {
			this.jumpAmount = 1.0F;
		}

		this.wasOnGround = this.onGround;
		this.alterJumpAmount();
	}

	protected void alterJumpAmount() {
		this.jumpAmount *= 0.6F;
	}

	protected void jumpFromGround() {
		Vec3 vec3d = this.getDeltaMovement();
		this.setDeltaMovement(vec3d.x, (double) 0.42F, vec3d.z);
		this.hasImpulse = true;
	}

	/**
	 * Gets the amount of time the clippy needs to wait between jumps.
	 */
	protected int getJumpDelay() {
		return this.random.nextInt(20) + 10;
	}

	protected SoundEvent getJumpSound() {
		return MemeSounds.boing.get();
	}

	static class AIHop extends Goal {
		private final ClippyEntity clippy;

		public AIHop(ClippyEntity clippyIn) {
			this.clippy = clippyIn;
			this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean canUse() {
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			((ClippyEntity.ClippyMoverHelper) this.clippy.getMoveControl()).setSpeed(1.0D);
		}
	}

	static class ClippyMoverHelper extends MoveControl {
		private float yRot;
		private int jumpDelay;
		private final ClippyEntity clippy;
		private boolean isAggressive;

		public ClippyMoverHelper(ClippyEntity clippyIn) {
			super(clippyIn);
			this.clippy = clippyIn;
			this.yRot = 180.0F * clippyIn.getYRot() / (float) Math.PI;
		}

		public void setDirection(float p_179920_1_, boolean p_179920_2_) {
			this.yRot = p_179920_1_;
			this.isAggressive = p_179920_2_;
		}

		public void setSpeed(double speedIn) {
			this.speedModifier = speedIn;
			this.operation = MoveControl.Operation.MOVE_TO;
		}

		public void tick() {
			this.mob.setYRot(this.rotlerp(this.mob.getYRot(), this.yRot, 90.0F));
			this.mob.yHeadRot = this.mob.getYRot();
			this.mob.yBodyRot = this.mob.getYRot();

			if (this.operation != MoveControl.Operation.MOVE_TO) {
				this.mob.setZza(0.0F);
			} else {
				this.operation = MoveControl.Operation.WAIT;

				if (this.mob.isOnGround()) {
					this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttribute(Attributes.MOVEMENT_SPEED).getValue()));

					if (this.jumpDelay-- <= 0) {
						this.jumpDelay = this.clippy.getJumpDelay();

						if (this.isAggressive) {
							this.jumpDelay /= 3;
						}

						this.clippy.getJumpControl().jump();

						this.clippy.playSound(this.clippy.getJumpSound(), this.clippy.getSoundVolume(), ((this.clippy.getRandom().nextFloat() - this.clippy.getRandom().nextFloat()) * 0.2F + 1.0F) * 0.8F);
					} else {
						this.clippy.xxa = 0.0F;
						this.clippy.zza = 0.0F;
						this.mob.setSpeed(0.0F);
					}
				} else {
					this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttribute(Attributes.MOVEMENT_SPEED).getValue()));
				}
			}
		}
	}

	static class AIClippyAttack extends Goal {
		private final ClippyEntity clippy;
		private int growTieredTimer;

		public AIClippyAttack(ClippyEntity clippyIn) {
			this.clippy = clippyIn;
			this.setFlags(EnumSet.of(Goal.Flag.LOOK));
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean canUse() {
			LivingEntity LivingEntity = this.clippy.getTarget();

			if (LivingEntity == null) {
				return false;
			} else if (!LivingEntity.isAlive()) {
				return false;
			} else {
				return !(LivingEntity instanceof Player) || !((Player) LivingEntity).getAbilities().instabuild;
			}
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.growTieredTimer = 300;
			super.start();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean canContinueToUse() {
			LivingEntity LivingEntity = this.clippy.getTarget();

			if (LivingEntity == null) {
				return false;
			} else if (!LivingEntity.isAlive()) {
				return false;
			} else if (LivingEntity instanceof Player && ((Player) LivingEntity).getAbilities().instabuild) {
				return false;
			} else {
				return --this.growTieredTimer > 0;
			}
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			this.clippy.lookAt(this.clippy.getTarget(), 10.0F, 10.0F);
			((ClippyEntity.ClippyMoverHelper) this.clippy.getMoveControl()).setDirection(this.clippy.getYRot(), true);
		}
	}
}
