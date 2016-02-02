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

public class EntityBill extends EntityZombie
{
public static String NAME = "BillCipher";
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityBill(World world) {
	    super(world);
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
		
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
	};
	
	    @Override
	    protected String getLivingSound() {
	      return "miab:bill.sound";
	    }

	    @Override
	    protected String getHurtSound() {
	      return "miab:bill.hit";
	    }

	    @Override
	    protected String getDeathSound() {
	      return "miab:bill.death";
	    }
	    
	    @Override
	    protected void dropFewItems(boolean hitByPlayer, int lootingLevel) {
	        if(rand.nextBoolean()) {
	          dropItem(Items.emerald, 1);
	        }
	    }
}