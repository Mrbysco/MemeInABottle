package com.mrbysco.miab.entity.ai;

import com.mrbysco.miab.entity.memes.KnucklesEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.AABB;

import java.util.EnumSet;

public class CallForKnucklesGoal extends TargetGoal {
	private final boolean entityCallsForHelp;
	/**
	 * Store the previous revengeTimer value
	 */
	private int revengeTimerOld;
	private final Class<?>[] excludedReinforcementTypes;

	public CallForKnucklesGoal(PathfinderMob creatureIn, boolean entityCallsForHelpIn, Class<?>... excludedReinforcementTypes) {
		super(creatureIn, true);
		this.entityCallsForHelp = entityCallsForHelpIn;
		this.excludedReinforcementTypes = excludedReinforcementTypes;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean canUse() {
		int i = this.mob.getLastHurtByMobTimestamp();
		LivingEntity entitylivingbase = this.mob.getLastHurtByMob();
		return i != this.revengeTimerOld && entitylivingbase != null && this.canAttack(entitylivingbase, TargetingConditions.DEFAULT);
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void start() {
		this.mob.setTarget(this.mob.getLastHurtByMob());
		this.targetMob = this.mob.getTarget();
		this.revengeTimerOld = this.mob.getLastHurtByMobTimestamp();
		this.unseenMemoryTicks = 300;

		if (this.entityCallsForHelp) {
			this.alertOthers();
		}

		super.start();
	}

	protected void alertOthers() {
		double d0 = this.getFollowDistance();

		for (Mob entitymob : this.mob.level.getEntitiesOfClass(this.mob.getClass(),
				(new AABB(this.mob.getX(), this.mob.getY(), this.mob.getZ(),
						this.mob.getX() + 1.0D, this.mob.getY() + 1.0D, this.mob.getZ() + 1.0D)).inflate(d0, 10.0D, d0))) {
			//if (this.goalOwner != entitycreature && entitycreature.getAttackTarget() == null && (!(this.goalOwner instanceof EntityTameable)
			//		|| ((EntityTameable)this.goalOwner).getOwner() == ((EntityTameable)entitycreature).getOwner())
			//		&& !entitycreature.isOnSameTeam(this.goalOwner.getRevengeTarget()))
			if (this.mob != entitymob && entitymob instanceof KnucklesEntity) {
				boolean flag = false;

				for (Class<?> oclass : this.excludedReinforcementTypes) {
					if (entitymob.getClass() == oclass) {
						flag = true;
						break;
					}
				}

				if (!flag) {
					this.setEntityAttackTarget(entitymob, this.mob.getLastHurtByMob());
				}
			}
		}
	}

	protected void setEntityAttackTarget(Mob creatureIn, LivingEntity entityLivingBaseIn) {
		creatureIn.setTarget(entityLivingBaseIn);
	}
}