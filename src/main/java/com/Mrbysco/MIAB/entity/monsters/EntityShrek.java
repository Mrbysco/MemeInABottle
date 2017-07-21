package com.Mrbysco.MIAB.entity.monsters;

import com.Mrbysco.MIAB.entity.entitybases.EntityMemeBase;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityShrek extends EntityMemeBase 
{
	public static String NAME = "Shrek";
	
	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean canBreakDoors = true;
	
	private boolean isMounted = false;
	
	public EntityShrek(World world) {
	    super(world);
	    super.setSize(0.6F, 2.2F);
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
        return MiabSoundEvents.shrek_passive;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return MiabSoundEvents.shrek_hit;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MiabSoundEvents.shrek_death;
    }
	
	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if(!this.world.isRemote)
		{
			Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_DONKEY_AMBIENT, 1F, 1F);
			EntityDonkey donkey = new EntityDonkey(world);
			donkey.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0);
			world.spawnEntity(donkey);
			donkey.setCustomNameTag("Donkey");
		}
	}
	
	@Override
	protected ResourceLocation getLootTable()
	{
		return new ResourceLocation("miab:entity/shrek");
	}

}