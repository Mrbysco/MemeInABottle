package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.init.MemeLoot;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

public class EntityRoflCopter extends CreatureEntity {
	private static final DataParameter<Byte> LANDED = EntityDataManager.<Byte>createKey(EntityRoflCopter.class, DataSerializers.BYTE);

	/** Coordinates of where the rofl spawned. */
	private BlockPos spawnPosition;

	public EntityRoflCopter(EntityType<? extends EntityRoflCopter> entityType, World worldIn)
	{
		super(entityType, worldIn);
		//TODO: this.setSize(1F, 1.4F);
		this.setIsCopterLanded(true);
	}

	@Override
	protected void registerData()
	{
		super.registerData();
		this.dataManager.register(LANDED, Byte.valueOf((byte)0));
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.5F));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new EntityRoflCopter.RandomFlyGoal(this));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1.0F, false));
		this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
		this.goalSelector.addGoal(10, new LookAtGoal(this, LivingEntity.class, 8.0F));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(EntityRoflCopter.class));
	}

	@Override
	public boolean canBeLeashedTo(PlayerEntity player) {
		return true;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume()
	{
		return 0.3F;
	}

	@Nullable
	@Override
	public SoundEvent getAmbientSound()
	{
		return getIsCopterLanded() ? null : MemeSounds.rofl_passive;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return MemeSounds.rofl_hurt;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return MemeSounds.rofl_death;
	}

	/**
	 * Returns true if this entity should push and be pushed by other entities when colliding.
	 */
	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	protected void collideWithEntity(Entity entityIn) {

	}

	@Override
	protected void collideWithNearbyEntities() {

	}

	@Override
	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
	}

	public boolean getIsCopterLanded()
	{
		return (((Byte)this.dataManager.get(LANDED)).byteValue() & 1) != 0;
	}

	public void setIsCopterLanded(boolean isHanging)
	{
		byte b0 = ((Byte)this.dataManager.get(LANDED)).byteValue();

		if (isHanging)
		{
			this.dataManager.set(LANDED, Byte.valueOf((byte)(b0 | 1)));
		}
		else
		{
			this.dataManager.set(LANDED, Byte.valueOf((byte)(b0 & -2)));
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void tick()
	{
		super.tick();
		if (this.getIsCopterLanded())
		{
			this.setMotion(0.0D, 0.0D, 0.0D);
			this.posY = (double)MathHelper.floor(this.posY) + 1.0D - (double)this.getHeight();
		}
		else
		{
			Vec3d motion = getMotion();
			double motionY = motion.y;
			motionY *= 0.6000000238418579D;
			this.setMotion(motion.x, motionY, motion.z);
		}
	}

	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();
		BlockPos blockpos = new BlockPos(this);
		BlockPos blockpos1 = blockpos.up();

		if (this.getIsCopterLanded())
		{
			if (this.world.getBlockState(blockpos1).isNormalCube(this.world, blockpos1))
			{
				if (this.rand.nextInt(200) == 0)
				{
					this.rotationYawHead = (float)this.rand.nextInt(360);
				}

				if (this.world.getClosestPlayer(this, 4.0D) != null)
				{
					this.setIsCopterLanded(false);
					this.world.playEvent((PlayerEntity)null, 1025, blockpos, 0);
				}
			}
			else
			{
				this.setIsCopterLanded(false);
				this.world.playEvent((PlayerEntity) null, 1025, blockpos, 0);
			}
		}
		else
		{
			if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1))
			{
				this.spawnPosition = null;
			}

			if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((double)((int)this.posX), (double)((int)this.posY), (double)((int)this.posZ), true) < 4.0D)
			{
				this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
			}

			double d0 = (double)this.spawnPosition.getX() + 0.5D - this.posX;
			double d1 = (double)this.spawnPosition.getY() + 0.1D - this.posY;
			double d2 = (double)this.spawnPosition.getZ() + 0.5D - this.posZ;
			Vec3d motion = getMotion();
			double motionX = motion.x;
			double motionY = motion.y;
			double motionZ = motion.z;
			motionX += (Math.signum(d0) * 0.5D - motionX) * 0.10000000149011612D;
			motionY += (Math.signum(d1) * 0.699999988079071D - motionY) * 0.10000000149011612D;
			motionZ += (Math.signum(d2) * 0.5D - motionZ) * 0.10000000149011612D;
			setMotion(motionX, motionY, motionZ);
			float f = (float)(MathHelper.atan2(motionZ, motionX) * (180D / Math.PI)) - 90.0F;
			float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
			this.moveForward = 0.5F;
			this.rotationYaw += f1;

			if (this.rand.nextInt(100) == 0 && this.world.getBlockState(blockpos1).isNormalCube(this.world, blockpos1))
			{
				this.setIsCopterLanded(true);
			}
		}
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{

	}

	@Override
	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos)
	{

	}

	/**
	 * Return whether this entity should NOT trigger a pressure plate or a tripwire.
	 */
	@Override
	public boolean doesEntityNotTriggerPressurePlate()
	{
		return true;
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if (this.isInvulnerableTo(source)) {
			return false;
		} else {
			if (!this.world.isRemote && this.getIsCopterLanded()) {
				this.setIsCopterLanded(false);
			}
			return super.attackEntityFrom(source, amount);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		this.dataManager.set(LANDED, Byte.valueOf(compound.getByte("CopterFlags")));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeAdditional(CompoundNBT compound)
	{
		super.writeAdditional(compound);
		compound.putByte("CopterFlags", ((Byte)this.dataManager.get(LANDED)).byteValue());
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
		BlockPos blockpos = new BlockPos(this.posX, this.getBoundingBox().minY, this.posZ);

		if (blockpos.getY() >= this.world.getSeaLevel())
		{
			return false;
		}
		else
		{
			int i = this.world.getLightValue(blockpos);

			return i > this.rand.nextInt(4) ? false : super.canSpawn(worldIn, spawnReasonIn);
		}
	}

	@Override
	public float getEyeHeight(Pose pose)
	{
		return this.getHeight() / 1.5F;
	}

	@Nullable
	@Override
	protected ResourceLocation getLootTable() {
		return MemeLoot.ROFL_LOOT;
	}

	static class RandomFlyGoal extends Goal {
		private final EntityRoflCopter parentEntity;

		public RandomFlyGoal(EntityRoflCopter copter) {
			this.parentEntity = copter;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			MovementController movementcontroller = this.parentEntity.getMoveHelper();
			if (!movementcontroller.isUpdating()) {
				return true;
			} else {
				double d0 = movementcontroller.getX() - this.parentEntity.posX;
				double d1 = movementcontroller.getY() - this.parentEntity.posY;
				double d2 = movementcontroller.getZ() - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			Random random = this.parentEntity.getRNG();
			double d0 = this.parentEntity.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d1 = this.parentEntity.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d2 = this.parentEntity.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
		}
	}
}
