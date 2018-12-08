package com.Mrbysco.miab.entities.hostile;

import com.Mrbysco.miab.entities.base.EntityMemeBase;
import com.Mrbysco.miab.init.MemeLoot;
import com.Mrbysco.miab.init.MemeSounds;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityKhil extends EntityMemeBase 
{
	public static String NAME = "Eduard Khil";
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityKhil(World world) {
	    super(world);
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
        return MemeSounds.khil_spawn;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return MemeSounds.khil_sound;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.khil_death;
    }

	@Override
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.TROLO_LOOT;
	}
		
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.playSound(MemeSounds.khil_spawn, 1F, 1F);
		if (rand.nextInt(2) < 1) 
		{
			setCustomNameTag(NAME);
		}
		return super.onInitialSpawn(difficulty, livingdata);
	}
}