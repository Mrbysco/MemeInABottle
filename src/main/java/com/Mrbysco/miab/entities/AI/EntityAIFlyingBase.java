package com.Mrbysco.miab.entities.AI;

import com.Mrbysco.miab.entities.passive.EntityRoflCopter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityAIFlyingBase extends EntityAIBase {

	private final float DEG = (float) (Math.PI / 180);

	protected final EntityLiving entity;
	
	private final int flightTime;
	private final int walkTime;
	private final int targetFlightHeight;
	private final float speed;
	
	protected int flightCounter;
	private int turnCounter;
	
	private final double DESCEND_FACTOR = ((float) -2/(float) 3);
	
	public EntityAIFlyingBase(EntityLiving entity, float speed, int flightTime,
			int walkTime, int targetFlightHeight) {

		setMutexBits(4);
		
		this.entity = entity;
		this.speed = Math.max(0.0f, speed/10);
		this.flightTime = flightTime;
		this.walkTime = walkTime;
		this.targetFlightHeight = targetFlightHeight;
		
		flightCounter = -entity.getRNG().nextInt(walkTime);
	}

	@Override
	public boolean shouldExecute() {
		
		return flightCounter++ > 0	&& !entity.isInWater();
	}

	@Override
	public boolean isInterruptible() {
		if(!isOnGround(entity))
		{
			if(entity instanceof EntityRoflCopter)
			{
				EntityRoflCopter rofl = (EntityRoflCopter)entity;
				rofl.setIsCopterLanded(false);
			}
		}
		return isOnGround(entity) || entity.isInWater();
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		return shouldExecute() && !isOnGround(entity);
	}

	private void ascend() {
		
		entity.motionY = speed;
		entity.limbSwingAmount = 3;
	}
	
	private void descend() {

		entity.limbSwingAmount = 1;
		entity.motionY = speed * DESCEND_FACTOR;
	}
	
	private void align() {
		
		entity.motionX = -speed * MathHelper.sin(entity.rotationYaw * DEG);
		entity.motionZ = speed * MathHelper.cos(entity.rotationYaw * DEG);
		
		if(turnCounter-- == 0) {
			
			turnCounter = entity.getRNG().nextInt(flightCounter + flightTime);
			entity.rotationYaw += (entity.getRNG().nextGaussian() - 0.5f);
		}
	}
	
	@Override
	public void startExecuting() {

	}

	@Override
	public void resetTask() {

		flightCounter = -entity.getRNG().nextInt(walkTime);
	}

	@Override
	public void updateTask() {
		
		if(flightCounter >= flightTime) {
			descend();
		} else {
			if(flightCounter > 0) {
				if(entity.posY < targetFlightHeight) {
					ascend();
				} else {
					descend();
				}
			}
		}
		align();
	}
	
	public static int getHeightAboveGround(Entity entity, int limit) {
	
		int blockCounter = 0;
		
		World world = entity.world;
		
		BlockPos down = entity.getPosition().down();
		
		while(world.getBlockState(down).getBlock() == Blocks.AIR 
				&& limit >= blockCounter) {
			
			blockCounter++;
			down = down.down();
		}
		return blockCounter;
	}
	
	public static boolean isOnGround(Entity entity) {
		
		return entity.getEntityWorld().getBlockState(
				entity.getPosition().down()).getBlock() != Blocks.AIR;
	}
	
	public static boolean isNearGround(Entity entity, int limit) {
		
		return getHeightAboveGround(entity, limit) <= limit;
	}
}