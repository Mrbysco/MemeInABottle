package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeItems;
import com.mrbysco.miab.init.MemeLoot;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityTrololo extends AbstractMeme{

	public EntityTrololo(World worldIn) {
		super(worldIn);
	}

	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.applyEntityAI();
	}

	private void applyEntityAI() {
		this.targetTasks.addTask(1, new EntityTrololo.AIFindTarget(this));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.4D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.khil_sound;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return MemeSounds.khil_sound;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.khil_death;
    }
	
	@Override
	public boolean canPickupItems() {
		return true;
	}

	@Override
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.TROLO_LOOT;
	}

	private boolean shouldAttackPlayer(EntityPlayer player)
    {
        ItemStack itemstack = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

        if (itemstack.getItem() != MemeItems.troll_mask)
            return true;
        else
        	return false;
    }

	class AIFindTarget extends EntityAINearestAttackableTarget<EntityPlayer>
    {
		private final EntityTrololo meme;
        /** The player */
        private EntityPlayer player;

        public AIFindTarget(EntityTrololo meme)
        {
            super(meme, EntityPlayer.class, false);
            this.meme = meme;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return super.shouldExecute() && (this.targetEntity != null && this.meme.shouldAttackPlayer(this.targetEntity));
        }

    }
}
