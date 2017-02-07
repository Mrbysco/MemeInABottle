package com.Mrbysco.MIAB.entity.monsters;

import com.Mrbysco.MIAB.entity.monsters.entityBase.EntityMemeBase;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRobbie extends EntityMemeBase 
{

	ItemStack itemstack = this.getHeldItemMainhand();
	
	public static String NAME = "Rotten Robbie";
	boolean holdingSax = false;
	
	private boolean isMounted = false;
	
	public EntityRobbie(World world) {
	    super(world);
	    }
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.245D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	};
	
		@Override
	    protected SoundEvent getAmbientSound()
	    {
		
		//Check if he's holding the item
		if (this.worldObj != null && !this.worldObj.isRemote)
		{
			if (itemstack != null && itemstack.getItem() == Items.APPLE)
	        {
				holdingSax = true;
	        }
	    }
		
		//if the item is held sound changes
		if (holdingSax == true)
		{
		return MiabSoundEvents.robbie_sax;
		}
		else
		return MiabSoundEvents.robbie_passive;
	    }
		
		@Override
	    protected SoundEvent getHurtSound()
	    {
	        return MiabSoundEvents.robbie_hit;
	    }
		
		@Override
	    protected SoundEvent getDeathSound()
	    {
	        return MiabSoundEvents.robbie_death;
	    }

}