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
	      return "miab:cena.sound";
	    }

	    @Override
	    protected String getHurtSound() {
	      return "miab:cena.sound";
	    }

	    @Override
	    protected String getDeathSound() {
	      return "miab:cena.sound";
	    }
	    
	    @Override
	    protected void dropFewItems(boolean hitByPlayer, int lootingLevel) {
	        if(rand.nextBoolean()) {
	          dropItem(MIABItems.MCW_Belt, 1);
	        }
	      }
	    }