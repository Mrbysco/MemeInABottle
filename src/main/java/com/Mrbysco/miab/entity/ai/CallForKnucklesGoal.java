package com.mrbysco.miab.entity.ai;

import com.mrbysco.miab.entity.memes.EntityKnuckles;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.EnumSet;

public class CallForKnucklesGoal extends TargetGoal
{
	private final boolean entityCallsForHelp;
	/** Store the previous revengeTimer value */
	private int revengeTimerOld;
	private final Class<?>[] excludedReinforcementTypes;

	public CallForKnucklesGoal(CreatureEntity creatureIn, boolean entityCallsForHelpIn, Class<?>... excludedReinforcementTypes)
	{
		super(creatureIn, true);
		this.entityCallsForHelp = entityCallsForHelpIn;
		this.excludedReinforcementTypes = excludedReinforcementTypes;
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		int i = this.goalOwner.getRevengeTimer();
		LivingEntity entitylivingbase = this.goalOwner.getRevengeTarget();
		return i != this.revengeTimerOld && entitylivingbase != null && this.isSuitableTarget(entitylivingbase, EntityPredicate.DEFAULT);
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		this.goalOwner.setAttackTarget(this.goalOwner.getRevengeTarget());
		this.target = this.goalOwner.getAttackTarget();
		this.revengeTimerOld = this.goalOwner.getRevengeTimer();
		this.unseenMemoryTicks = 300;

		if (this.entityCallsForHelp)
		{
			this.alertOthers();
		}

		super.startExecuting();
	}

	protected void alertOthers()
	{
		double d0 = this.getTargetDistance();

		for (MobEntity entitymob : this.goalOwner.world.getEntitiesWithinAABB(this.goalOwner.getClass(), (new AxisAlignedBB(this.goalOwner.posX, this.goalOwner.posY, this.goalOwner.posZ, this.goalOwner.posX + 1.0D, this.goalOwner.posY + 1.0D, this.goalOwner.posZ + 1.0D)).grow(d0, 10.0D, d0)))
		{
			//if (this.goalOwner != entitycreature && entitycreature.getAttackTarget() == null && (!(this.goalOwner instanceof EntityTameable)
			//		|| ((EntityTameable)this.goalOwner).getOwner() == ((EntityTameable)entitycreature).getOwner())
			//		&& !entitycreature.isOnSameTeam(this.goalOwner.getRevengeTarget()))
			if (this.goalOwner != entitymob && entitymob instanceof EntityKnuckles)
			{
				boolean flag = false;

				for (Class<?> oclass : this.excludedReinforcementTypes)
				{
					if (entitymob.getClass() == oclass)
					{
						flag = true;
						break;
					}
				}

				if (!flag)
				{
					this.setEntityAttackTarget(entitymob, this.goalOwner.getRevengeTarget());
				}
			}
		}
	}

	protected void setEntityAttackTarget(MobEntity creatureIn, LivingEntity entityLivingBaseIn)
	{
		creatureIn.setAttackTarget(entityLivingBaseIn);
	}
}