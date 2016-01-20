package com.Mrbysco.MIAB.entity.monsters;

import com.Mrbysco.MIAB.init.MIABItems;

import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityCena extends EntityZombie {
	
	public static String NAME = "JohnCena";
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityCena(World world) {
	    super(world);
	    targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false));
		}
	
	    @Override
	    protected String getLivingSound() {
	      return "mob.zombie.say";
	    }

	    @Override
	    protected String getHurtSound() {
	      return "mob.zombie.hurt";
	    }

	    @Override
	    protected String getDeathSound() {
	      return "mob.zombie.death";
	    }
	    
	    @Override
	    protected void dropFewItems(boolean hitByPlayer, int lootingLevel) {
	      int numDrops = rand.nextInt(3 + lootingLevel);
	      for (int i = 0; i < numDrops; ++i) {
	        if(rand.nextBoolean()) {
	          dropItem(MIABItems.MCW_Belt, 1);
	        }
	      }
	    }

	  }
