package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeItems;
import com.mrbysco.miab.init.MemeLoot;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityTrololo extends AbstractMeme{

	public EntityTrololo(EntityType<? extends EntityTrololo> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(1, new EntityTrololo.AIFindTarget(this));
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(EntityTrololo.class));
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0D);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.4D);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
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

	private boolean shouldAttackPlayer(PlayerEntity player)
    {
        ItemStack itemstack = player.getItemStackFromSlot(EquipmentSlotType.HEAD);

        if (itemstack.getItem() != MemeItems.troll_mask)
            return true;
        else
        	return false;
    }

	class AIFindTarget extends NearestAttackableTargetGoal<PlayerEntity>
    {
		private final EntityTrololo meme;
        /** The player */
        private PlayerEntity player;

        public AIFindTarget(EntityTrololo meme)
        {
            super(meme, PlayerEntity.class, false);
            this.meme = meme;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return super.shouldExecute() && (this.target != null && this.meme.shouldAttackPlayer((PlayerEntity)this.target));
        }
    }
}
