package com.Mrbysco.MIAB.entity.monsters;

import com.Mrbysco.MIAB.init.MIABItems;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityPpap extends EntityZombie 
{
	public static String NAME = "KosakaDaimaou";
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityPpap(World world) {
	    super(world);
	    targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false));
		}
	
	@Override
	public void onLivingUpdate()
    {
		if (this.isRiding() && this.getAttackTarget() != null && this.getRidingEntity() instanceof EntityChicken)
        {
            ((EntityLiving)this.getRidingEntity()).getNavigator().setPath(this.getNavigator().getPath(), 1.5D);
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
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	};
	
		@Override
	    protected SoundEvent getAmbientSound()
	    {
	        return MiabSoundEvents.ppap_sound;
	    }
		
		@Override
	    protected SoundEvent getHurtSound()
	    {
	        return MiabSoundEvents.ppap_sound;
	    }
		
		@Override
	    protected SoundEvent getDeathSound()
	    {
	        return MiabSoundEvents.ppap_death;
	    }
	    
	    @Override
	    protected void dropFewItems(boolean hitByPlayer, int lootingLevel) {
	        if(rand.nextBoolean()) {
	        	//Placeholder
	          dropItem(Items.APPLE, 1);
	        }
	        
	    }
}