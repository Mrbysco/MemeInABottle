package com.Mrbysco.miab.entities.AI;

import net.minecraft.entity.EntityLiving;

public class EntityAIAvoidAttacker extends EntityAIFlyingBase {

	private final float distance;
	private final float flightHealth;
	
	public EntityAIAvoidAttacker(EntityLiving entity, float speed,
			int flightTime, int walkTime, int targetFlightHeight,
			float distance, float flightHealth) {
		super(entity, speed, flightTime, walkTime, targetFlightHeight);
		this.distance = distance;
		this.flightHealth = flightHealth;
	}

	@Override
	public boolean shouldExecute() {
		
		if(entity.getRevengeTimer() > 0 && entity.getAttackTarget() != null
				&& entity.getHealth() < flightHealth) {
			if(entity.getDistanceSq(entity.getAttackTarget()) < distance) {
			flightCounter = 1;
			}
		}
		return super.shouldExecute();
	}
}