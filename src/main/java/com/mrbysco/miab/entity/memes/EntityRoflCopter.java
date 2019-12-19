package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.ai.EntityAIAvoidAttacker;
import com.mrbysco.miab.init.MemeLoot;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWanderAvoidWaterFlying;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityRoflCopter extends EntityCreature {
	private static final DataParameter<Byte> LANDED = EntityDataManager.<Byte>createKey(EntityRoflCopter.class, DataSerializers.BYTE);

	/** Coordinates of where the rofl spawned. */
	private BlockPos spawnPosition;

	public EntityRoflCopter(World worldIn)
	{
		super(worldIn);
		this.setSize(1F, 1.4F);
		this.setIsCopterLanded(true);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(LANDED, Byte.valueOf((byte)0));
	}

	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(2, new EntityAIAvoidAttacker(this, 1.3f, 500, 400, 85, 20, getMaxHealth() / 2));
		this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.5F));
		this.tasks.addTask(2, new EntityAIWanderAvoidWaterFlying(this, 1.0D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(8, new EntityAIAttackMelee(this, 1.0F, false));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
	}

	@Override
	public boolean canBeLeashedTo(EntityPlayer player) {
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
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
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
	public void onUpdate()
	{
		super.onUpdate();

		if (this.getIsCopterLanded())
		{
			this.motionX = 0.0D;
			this.motionY = 0.0D;
			this.motionZ = 0.0D;
			this.posY = (double)MathHelper.floor(this.posY) + 1.0D - (double)this.height;
		}
		else
		{
			this.motionY *= 0.6000000238418579D;
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
			if (this.world.getBlockState(blockpos1).isNormalCube())
			{
				if (this.rand.nextInt(200) == 0)
				{
					this.rotationYawHead = (float)this.rand.nextInt(360);
				}

				if (this.world.getNearestPlayerNotCreative(this, 4.0D) != null)
				{
					this.setIsCopterLanded(false);
					this.world.playEvent((EntityPlayer)null, 1025, blockpos, 0);
				}
			}
			else
			{
				this.setIsCopterLanded(false);
				this.world.playEvent((EntityPlayer) null, 1025, blockpos, 0);
			}
		}
		else
		{
			if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1))
			{
				this.spawnPosition = null;
			}

			if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((double)((int)this.posX), (double)((int)this.posY), (double)((int)this.posZ)) < 4.0D)
			{
				this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
			}

			double d0 = (double)this.spawnPosition.getX() + 0.5D - this.posX;
			double d1 = (double)this.spawnPosition.getY() + 0.1D - this.posY;
			double d2 = (double)this.spawnPosition.getZ() + 0.5D - this.posZ;
			this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
			this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
			this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
			float f = (float)(MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
			float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
			this.moveForward = 0.5F;
			this.rotationYaw += f1;

			if (this.rand.nextInt(100) == 0 && this.world.getBlockState(blockpos1).isNormalCube())
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
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
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
		if (this.isEntityInvulnerable(source))
		{
			return false;
		}
		else
		{
			if (!this.world.isRemote && this.getIsCopterLanded())
			{
				this.setIsCopterLanded(false);
			}

			return super.attackEntityFrom(source, amount);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.dataManager.set(LANDED, Byte.valueOf(compound.getByte("CopterFlags")));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setByte("CopterFlags", ((Byte)this.dataManager.get(LANDED)).byteValue());
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	@Override
	public boolean getCanSpawnHere()
	{
		BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

		if (blockpos.getY() >= this.world.getSeaLevel())
		{
			return false;
		}
		else
		{
			int i = this.world.getLightFromNeighbors(blockpos);

			return i > this.rand.nextInt(4) ? false : super.getCanSpawnHere();
		}
	}

	@Override
	public float getEyeHeight()
	{
		return this.height / 1.5F;
	}

	@Nullable
	@Override
	protected ResourceLocation getLootTable() {
		return MemeLoot.ROFL_LOOT;
	}
}
