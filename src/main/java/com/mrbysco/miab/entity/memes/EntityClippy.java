package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.init.MemeLoot;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import javax.annotation.Nullable;

public class EntityClippy extends EntityMob {

	public float jumpAmount;
	public float jumpFactor;
	public float prevJumpFactor;
	private boolean wasOnGround;
	public EntityClippy(World worldIn) {
		super(worldIn);
		this.setSize(0.7F, 1.95F);
		this.moveHelper = new EntityClippy.ClippyMoverHelper(this);
	}

	protected void initEntityAI()
	{
		super.initEntityAI();
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityClippy.AIHop(this));
		this.tasks.addTask(2, new EntityClippy.AIClippyAttack(this));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));

		this.applyEntityAI();
	}

	private void applyEntityAI() {
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		Biome biome = this.world.getBiome(this.getPosition());
		SoundEvent sound = SoundEvents.ENTITY_SLIME_HURT;
		if(!this.isDead)
		{
			if(this.world.isDaytime() == false)
			{
				sound = MemeSounds.clippy_night;
			}
			if(BiomeDictionary.hasType(biome, Type.FOREST))
			{
				if(playerNearby() && getPlayerHealth() < 6)
				{
					sound = MemeSounds.clippy_health;
				}
				if(this.posY < 60)
				{
					sound = MemeSounds.clippy_cave;
				}
				sound = MemeSounds.clippy_forest;
			}
			else if(playerNearby() && getPlayerHealth() < 6)
			{
				sound = MemeSounds.clippy_health;
			}
			else if(this.posY < 60)
			{
				sound = MemeSounds.clippy_cave;
			}
			else if(this.world.findNearestStructure("Mineshaft", this.getPosition(), true) == this.getPosition())
			{
				sound = MemeSounds.clippy_mineshaft;
			}
			else
			{
				sound = MemeSounds.clippy_passive;
			}
		}
		return sound;
	}

	private boolean playerNearby()
	{
		EntityPlayer player = this.world.getClosestPlayerToEntity(this, 20);

		return player != null;
	}

	private float getPlayerHealth()
	{
		float health = this.world.getClosestPlayerToEntity(this, 20).getHealth();

		return health;
	}
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return MemeSounds.clippy_hurt;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.clippy_death;
    }

	@Nullable
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.CLIPPY_LOOT;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityIn) {
		if (this.canDamagePlayer() && !this.isDead)
		{
			this.dealDamage(entityIn);
		}
	}

	protected boolean canDamagePlayer()
	{
		return this.getAttackTarget() instanceof EntityPlayer;
	}

	protected void dealDamage(EntityLivingBase entityIn)
	{
		int i = 2;

		if (this.canEntityBeSeen(entityIn) && this.getDistanceSq(entityIn) < 0.6D * (double)i * 0.6D * (double)i && entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)2))
		{
			this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.applyEnchantments(this, entityIn);
		}
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("wasOnGround", this.wasOnGround);
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.wasOnGround = compound.getBoolean("wasOnGround");
	}

	public void onUpdate()
	{
		this.jumpFactor += (this.jumpAmount - this.jumpFactor) * 0.5F;
		this.prevJumpFactor = this.jumpFactor;
		super.onUpdate();

		if (this.onGround && !this.wasOnGround)
		{
			int i = 2;
			for (int j = 0; j < i * 8; ++j)
			{
				float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
				float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
				float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
				float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
				World world = this.world;
				EnumParticleTypes enumparticletypes = EnumParticleTypes.FIREWORKS_SPARK;
				double d0 = this.posX + (double)f2;
				double d1 = this.posZ + (double)f3;
				world.spawnParticle(enumparticletypes, d0, this.getEntityBoundingBox().minY, d1, 0.0D, 0.0D, 0.0D);
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

	protected void alterJumpAmount()
	{
		this.jumpAmount *= 0.6F;
	}

	protected void jump()
	{
		this.motionY = 0.41999998688697815D;
		this.isAirBorne = true;
	}

	/**
	 * Gets the amount of time the clippy needs to wait between jumps.
	 */
	protected int getJumpDelay()
	{
		return this.rand.nextInt(20) + 10;
	}

	protected SoundEvent getJumpSound()
	{
		return MemeSounds.boing;
	}

	static class AIHop extends EntityAIBase
	{
		private final EntityClippy clippy;

		public AIHop(EntityClippy clippyIn)
		{
			this.clippy = clippyIn;
			this.setMutexBits(5);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute()
		{
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask()
		{
			((EntityClippy.ClippyMoverHelper)this.clippy.getMoveHelper()).setSpeed(1.0D);
		}
	}

	static class ClippyMoverHelper extends EntityMoveHelper
	{
		private float yRot;
		private int jumpDelay;
		private final EntityClippy clippy;
		private boolean isAggressive;

		public ClippyMoverHelper(EntityClippy clippyIn)
		{
			super(clippyIn);
			this.clippy = clippyIn;
			this.yRot = 180.0F * clippyIn.rotationYaw / (float)Math.PI;
		}

		public void setDirection(float p_179920_1_, boolean p_179920_2_)
		{
			this.yRot = p_179920_1_;
			this.isAggressive = p_179920_2_;
		}

		public void setSpeed(double speedIn)
		{
			this.speed = speedIn;
			this.action = EntityMoveHelper.Action.MOVE_TO;
		}

		public void onUpdateMoveHelper()
		{
			this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, this.yRot, 90.0F);
			this.entity.rotationYawHead = this.entity.rotationYaw;
			this.entity.renderYawOffset = this.entity.rotationYaw;

			if (this.action != EntityMoveHelper.Action.MOVE_TO)
			{
				this.entity.setMoveForward(0.0F);
			}
			else
			{
				this.action = EntityMoveHelper.Action.WAIT;

				if (this.entity.onGround)
				{
					this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

					if (this.jumpDelay-- <= 0)
					{
						this.jumpDelay = this.clippy.getJumpDelay();

						if (this.isAggressive)
						{
							this.jumpDelay /= 3;
						}

						this.clippy.getJumpHelper().setJumping();

						this.clippy.playSound(this.clippy.getJumpSound(), this.clippy.getSoundVolume(), ((this.clippy.getRNG().nextFloat() - this.clippy.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
					}
					else
					{
						this.clippy.moveStrafing = 0.0F;
						this.clippy.moveForward = 0.0F;
						this.entity.setAIMoveSpeed(0.0F);
					}
				}
				else
				{
					this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
				}
			}
		}
	}

	static class AIClippyAttack extends EntityAIBase
	{
		private final EntityClippy clippy;
		private int growTieredTimer;

		public AIClippyAttack(EntityClippy clippyIn)
		{
			this.clippy = clippyIn;
			this.setMutexBits(2);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute()
		{
			EntityLivingBase entitylivingbase = this.clippy.getAttackTarget();

			if (entitylivingbase == null)
			{
				return false;
			}
			else if (!entitylivingbase.isEntityAlive())
			{
				return false;
			}
			else
			{
				return !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer)entitylivingbase).capabilities.disableDamage;
			}
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting()
		{
			this.growTieredTimer = 300;
			super.startExecuting();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting()
		{
			EntityLivingBase entitylivingbase = this.clippy.getAttackTarget();

			if (entitylivingbase == null)
			{
				return false;
			}
			else if (!entitylivingbase.isEntityAlive())
			{
				return false;
			}
			else if (entitylivingbase instanceof EntityPlayer && ((EntityPlayer)entitylivingbase).capabilities.disableDamage)
			{
				return false;
			}
			else
			{
				return --this.growTieredTimer > 0;
			}
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask()
		{
			this.clippy.faceEntity(this.clippy.getAttackTarget(), 10.0F, 10.0F);
			((EntityClippy.ClippyMoverHelper)this.clippy.getMoveHelper()).setDirection(this.clippy.rotationYaw, true);
		}
	}
}
