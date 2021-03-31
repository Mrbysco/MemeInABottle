package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.EnumSet;

public class ClippyEntity extends AbstractMeme {

	public float jumpAmount;
	public float jumpFactor;
	public float prevJumpFactor;
	private boolean wasOnGround;
	public ClippyEntity(EntityType<? extends ClippyEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		this.moveController = new ClippyEntity.ClippyMoverHelper(this);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(1, new ClippyEntity.AIHop(this));
		this.goalSelector.addGoal(2, new ClippyEntity.AIClippyAttack(this));
		this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(ClippyEntity.class));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AbstractMeme.registerAttributes()
			.createMutableAttribute(Attributes.MAX_HEALTH, 16.0D)
			.createMutableAttribute(Attributes.FOLLOW_RANGE, 30.0D)
			.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.30000001192092896D);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		Biome biome = this.world.getBiome(this.getPosition());
		SoundEvent sound = SoundEvents.ENTITY_SLIME_HURT;
		if(!this.dead) {
			if(!this.world.isDaytime()) {
				sound = MemeSounds.clippy_night.get();
			}
			RegistryKey<Biome> biomeKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, this.world.getBiome(getPosition()).getRegistryName());
			if(BiomeDictionary.hasType(biomeKey, Type.FOREST)) {
				if(isPlayerNearby(20) && getPlayerHealth() < 6) {
					sound = MemeSounds.clippy_health.get();
				} else if(!this.world.canBlockSeeSky(this.getPosition())) {
					sound = MemeSounds.clippy_cave.get();
				} else
				sound = MemeSounds.clippy_forest.get();
			} else if(isPlayerNearby(20) && getPlayerHealth() < 6) {
				sound = MemeSounds.clippy_health.get();
			} else if(this.getPosY() < 60) {
				sound = MemeSounds.clippy_cave.get();
			} else if(!this.world.isRemote && ((ServerWorld)this.world).getStructureLocation(Structure.MINESHAFT, this.getPosition(), 30, true) == this.getPosition()) {
				sound = MemeSounds.clippy_mineshaft.get();
			} else {
				sound = MemeSounds.clippy_passive.get();
			}
		}
		return sound;
	}

	private float getPlayerHealth() {
		PlayerEntity player = this.world.getClosestPlayer(this, 20);
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
	public void onCollideWithPlayer(PlayerEntity entityIn) {
		if (this.canDamagePlayer() && !this.dead) {
			this.dealDamage(entityIn);
		}
	}

	protected boolean canDamagePlayer() {
		return this.getAttackTarget() instanceof PlayerEntity;
	}

	protected void dealDamage(LivingEntity entityIn) {
		int i = 2;

		if (this.canEntityBeSeen(entityIn) && this.getDistanceSq(entityIn) < 0.6D * (double)i * 0.6D * (double)i && entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)2)) {
			this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.applyEnchantments(this, entityIn);
		}
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("wasOnGround", this.wasOnGround);
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.wasOnGround = compound.getBoolean("wasOnGround");
	}

	public void tick() {
		this.jumpFactor += (this.jumpAmount - this.jumpFactor) * 0.5F;
		this.prevJumpFactor = this.jumpFactor;
		super.tick();

		if (this.onGround && !this.wasOnGround) {
			int i = 2;
			for(int j = 0; j < i * 8; ++j) {
				float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
				float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
				float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
				float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
				World world = this.world;
				IParticleData iparticledata = ParticleTypes.FIREWORK;
				double d0 = this.getPosX() + (double)f2;
				double d1 = this.getPosZ() + (double)f3;
				world.addParticle(iparticledata, d0, this.getBoundingBox().minY, d1, 0.0D, 0.0D, 0.0D);
			}

			//this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			this.jumpAmount = -0.5F;
		}
		else if (!this.onGround && this.wasOnGround)
		{
			this.jumpAmount = 1.0F;
		}

		this.wasOnGround = this.onGround;
		this.alterJumpAmount();
	}

	protected void alterJumpAmount() {
		this.jumpAmount *= 0.6F;
	}

	protected void jump() {
		Vector3d vec3d = this.getMotion();
		this.setMotion(vec3d.x, (double)0.42F, vec3d.z);
		this.isAirBorne = true;
	}

	/**
	 * Gets the amount of time the clippy needs to wait between jumps.
	 */
	protected int getJumpDelay() {
		return this.rand.nextInt(20) + 10;
	}

	protected SoundEvent getJumpSound() {
		return MemeSounds.boing.get();
	}

	static class AIHop extends Goal {
		private final ClippyEntity clippy;

		public AIHop(ClippyEntity clippyIn) {
			this.clippy = clippyIn;
			this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			((ClippyEntity.ClippyMoverHelper)this.clippy.getMoveHelper()).setSpeed(1.0D);
		}
	}

	static class ClippyMoverHelper extends MovementController {
		private float yRot;
		private int jumpDelay;
		private final ClippyEntity clippy;
		private boolean isAggressive;

		public ClippyMoverHelper(ClippyEntity clippyIn) {
			super(clippyIn);
			this.clippy = clippyIn;
			this.yRot = 180.0F * clippyIn.rotationYaw / (float)Math.PI;
		}

		public void setDirection(float p_179920_1_, boolean p_179920_2_) {
			this.yRot = p_179920_1_;
			this.isAggressive = p_179920_2_;
		}

		public void setSpeed(double speedIn) {
			this.speed = speedIn;
			this.action = MovementController.Action.MOVE_TO;
		}

		public void tick() {
			this.mob.rotationYaw = this.limitAngle(this.mob.rotationYaw, this.yRot, 90.0F);
			this.mob.rotationYawHead = this.mob.rotationYaw;
			this.mob.renderYawOffset = this.mob.rotationYaw;

			if (this.action != MovementController.Action.MOVE_TO) {
				this.mob.setMoveForward(0.0F);
			} else {
				this.action = MovementController.Action.WAIT;

				if (this.mob.isOnGround()) {
					this.mob.setAIMoveSpeed((float)(this.speed * this.mob.getAttribute(Attributes.MOVEMENT_SPEED).getValue()));

					if (this.jumpDelay-- <= 0) {
						this.jumpDelay = this.clippy.getJumpDelay();

						if (this.isAggressive) {
							this.jumpDelay /= 3;
						}

						this.clippy.getJumpController().setJumping();

						this.clippy.playSound(this.clippy.getJumpSound(), this.clippy.getSoundVolume(), ((this.clippy.getRNG().nextFloat() - this.clippy.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
					} else {
						this.clippy.moveStrafing = 0.0F;
						this.clippy.moveForward = 0.0F;
						this.mob.setAIMoveSpeed(0.0F);
					}
				} else {
					this.mob.setAIMoveSpeed((float)(this.speed * this.mob.getAttribute(Attributes.MOVEMENT_SPEED).getValue()));
				}
			}
		}
	}

	static class AIClippyAttack extends Goal {
		private final ClippyEntity clippy;
		private int growTieredTimer;

		public AIClippyAttack(ClippyEntity clippyIn) {
			this.clippy = clippyIn;
			this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			LivingEntity LivingEntity = this.clippy.getAttackTarget();

			if (LivingEntity == null) {
				return false;
			} else if (!LivingEntity.isAlive()) {
				return false;
			} else {
				return !(LivingEntity instanceof PlayerEntity) || !((PlayerEntity)LivingEntity).abilities.disableDamage;
			}
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.growTieredTimer = 300;
			super.startExecuting();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			LivingEntity LivingEntity = this.clippy.getAttackTarget();

			if (LivingEntity == null) {
				return false;
			} else if (!LivingEntity.isAlive()) {
				return false;
			} else if (LivingEntity instanceof PlayerEntity && ((PlayerEntity)LivingEntity).abilities.disableDamage) {
				return false;
			} else {
				return --this.growTieredTimer > 0;
			}
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			this.clippy.faceEntity(this.clippy.getAttackTarget(), 10.0F, 10.0F);
			((ClippyEntity.ClippyMoverHelper)this.clippy.getMoveHelper()).setDirection(this.clippy.rotationYaw, true);
		}
	}
}
