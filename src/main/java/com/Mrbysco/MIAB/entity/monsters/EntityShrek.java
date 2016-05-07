package com.Mrbysco.MIAB.entity.monsters;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityShrek extends EntityZombie{

public static String NAME = "Shrek";
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityShrek(World world) {
	    super(world);
	    this.setSize(0.7F, 2.2F);
	    targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false));
		}
	
	@Override
	public void onLivingUpdate()
    {
		if (this.isRiding() && this.getAttackTarget() != null && this.ridingEntity instanceof EntityChicken)
        {
            ((EntityLiving)this.ridingEntity).getNavigator().setPath(this.getNavigator().getPath(), 1.5D);
        }
		
		ignoreUndeadFire = true;
	       
        super.onLivingUpdate();
       
        ignoreUndeadFire = false;
    }
	
	private boolean ignoreUndeadFire = false;
	   
    @Override
    public float getBrightness(float partialTicks) {
        return ignoreUndeadFire ? 0f : super.getBrightness(partialTicks);
    }
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.27D);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(9.0D);
	};
	
	    @Override
	    protected String getLivingSound() {
	      return "miab:shrek.sound";
	    }

	    @Override
	    protected String getHurtSound() {
	      return "miab:shrek.hit";
	    }

	    @Override
	    protected String getDeathSound() {
	      return "miab:shrek.death";
	    }
	    
	    @Override
	    protected void dropFewItems(boolean hitByPlayer, int lootingLevel) {
	        if(rand.nextBoolean()) {
	          dropItem(Items.apple, 1);
	        }
	    }
}
