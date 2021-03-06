package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class PinguEntity extends AbstractMeme {
	public PinguEntity(EntityType<? extends PinguEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}
	
	@Override
	protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
    	this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0));
    	this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new LeapAtTargetGoal(this, 0.3F));
        this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1.0F, false));
        this.goalSelector.addGoal(11, new LookAtGoal(this, PlayerEntity.class, 10.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(PinguEntity.class));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AbstractMeme.registerAttributes()
			.createMutableAttribute(Attributes.MAX_HEALTH, 8.0D)
			.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.30000001192092896D);
    }

	@Override
	@Nullable
    protected SoundEvent getAmbientSound() {
        return MemeSounds.noot.get();
    }

	@Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return MemeSounds.noot.get();
    }

	@Override
    protected SoundEvent getDeathSound() {
        return MemeSounds.noot.get();
    }
	
	/**
     * Returns the volume for the sounds this mob makes.
     */
	@Override
    protected float getSoundVolume() {
        return 0.6F;
    }

	@Override
	public boolean canPickupItems() {
		return false;
	}
}