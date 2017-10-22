package com.Mrbysco.miab.entities.hostile;

import com.Mrbysco.miab.entities.base.EntityMemeBase;
import com.Mrbysco.miab.init.MemeItems;
import com.Mrbysco.miab.init.MemeSounds;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityRobbie extends EntityMemeBase 
{

	ItemStack itemstack = this.getHeldItemMainhand();
	
	public static String NAME = "Robbie Rotten";
	boolean holdingSax;
	
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
		if (holdingSax != true)
		{
			return MemeSounds.robbie_passive;
		}
		else
		{
			return MemeSounds.robbie_sax;
		}
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return MemeSounds.robbie_hit;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.robbie_death;
    }
	
	@Override
	protected ResourceLocation getLootTable()
	{
		return new ResourceLocation("memeinabottle:entity/robbierotten");
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.playSound(MemeSounds.robbie_summon, 1F, 1F);
		
		if (rand.nextInt(10) < 3)
		{
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(MemeItems.sax));
			this.holdingSax = true;
		}
		
		if (rand.nextInt(2) < 1) 
		{
			setCustomNameTag(NAME);
		}
		return super.onInitialSpawn(difficulty, livingdata);
	}

}