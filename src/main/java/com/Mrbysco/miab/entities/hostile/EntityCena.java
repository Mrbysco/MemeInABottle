package com.Mrbysco.miab.entities.hostile;

import java.util.List;

import com.Mrbysco.miab.entities.base.EntityMemeBase;
import com.Mrbysco.miab.init.MemeLoot;
import com.Mrbysco.miab.init.MemeSounds;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityCena extends EntityMemeBase 
{
	public static String NAME = "John Cena";
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityCena(World world) {
	    super(world);
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	};
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.cena_sound;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return MemeSounds.cena_sound;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.cena_sound;
    }

	@Override
    protected ResourceLocation getLootTable()
    {
    	return MemeLoot.CENA_LOOT;
    }
	
	@Override
	public void onLivingUpdate() {
		if (playerDetection(10)) 
		{
			if (isPotionActive(MobEffects.INVISIBILITY)) {
				removePotionEffect(MobEffects.INVISIBILITY);
			}
		} 
		else 
		{
			if (!isPotionActive(MobEffects.INVISIBILITY)) {
				addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 480 * 20, 0));
			}
		}
		super.onLivingUpdate();
	}
	
	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection(int range) {
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(range);
		List<EntityPlayer> list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		return !list.isEmpty();
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {		
		this.playSound(MemeSounds.cena_spawn, 1F, 1F);
		if (rand.nextInt(2) < 1) 
		{
			setCustomNameTag(NAME);
		}
		return super.onInitialSpawn(difficulty, livingdata);
	}
}