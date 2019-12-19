package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityPingu extends AbstractMeme
{
	public EntityPingu(World worldIn) {
		super(worldIn);
        this.setSize(0.4F, 0.6F);
	}
	
	@Override
	protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
    	this.tasks.addTask(5, new EntityAIWander(this, 1.0));
    	this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(8, new EntityPingu.AIPinguAttack(this, 1.0F, false));

        this.tasks.addTask(10, new EntityAIWanderAvoidWater(this, 0.8D, 1.0000001E-5F));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
	}
	
	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
    }

	@Override
	@Nullable
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.noot;
    }

	@Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return MemeSounds.noot;
    }

	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.noot;
    }
	
	/**
     * Returns the volume for the sounds this mob makes.
     */
	@Override
    protected float getSoundVolume()
    {
        return 0.6F;
    }

	@Override
	public boolean canPickupItems() {
		return false;
	}

	class AIPinguAttack extends EntityAIAttackMelee {
		private final EntityPingu pingu;
		private int raiseArmTicks;

		public AIPinguAttack(EntityPingu pingu, double speedIn, boolean useLongMemory) {
			super(pingu, speedIn, useLongMemory);
			this.pingu = pingu;
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by another one
		 */
		public void resetTask()
		{
			super.resetTask();
			this.pingu.setArmsRaised(false);
		}
		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting()
		{
			super.startExecuting();
			this.raiseArmTicks = 0;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask()
		{
			super.updateTask();
			++this.raiseArmTicks;

			if (this.raiseArmTicks >= 5 && this.attackTick < 10)
			{
				this.pingu.setArmsRaised(true);
			}
			else
			{
				this.pingu.setArmsRaised(false);
			}
		}
	}
}