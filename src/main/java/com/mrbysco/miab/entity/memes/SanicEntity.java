package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class SanicEntity extends AbstractMeme{

	public SanicEntity(EntityType<? extends SanicEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(SanicEntity.class));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AbstractMeme.registerAttributes()
			.createMutableAttribute(Attributes.MAX_HEALTH, 14.0D)
			.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.235D)
			.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.4D)
			.createMutableAttribute(Attributes.FOLLOW_RANGE, 30.0D)
			.createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
	}
	
	@Override
    protected SoundEvent getAmbientSound() {
        return MemeSounds.sanic_slow.get();
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return MemeSounds.sanic_slow.get();
    }
	
	@Override
    protected SoundEvent getDeathSound() {
        return MemeSounds.sanic_slow.get();
    }
	
	@Override
	public boolean canPickupItems() {
		return false;
	}
}
