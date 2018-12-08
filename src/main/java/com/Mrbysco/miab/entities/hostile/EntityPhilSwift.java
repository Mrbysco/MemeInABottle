package com.Mrbysco.miab.entities.hostile;

import com.Mrbysco.miab.entities.base.EntityMemeBase;
import com.Mrbysco.miab.init.MemeItems;
import com.Mrbysco.miab.init.MemeLoot;
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

public class EntityPhilSwift extends EntityMemeBase 
{
	public static String NAME = "Phil Swift";
	
	private boolean isMounted = false;
	
	public EntityPhilSwift(World world) {
	    super(world);
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	};
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.phil_passive;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return MemeSounds.phil_hurt;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.phil_death;
    }

	@Override
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.FLEX_LOOT;
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.playSound(MemeSounds.phil_lottadamage, 1F, 1F);
		if (rand.nextInt(2) < 1) 
		{
			setCustomNameTag(NAME);
		}
		

		if (rand.nextInt(10) < 3)
		{
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(MemeItems.flextape));
		}
		return super.onInitialSpawn(difficulty, livingdata);
	}
}