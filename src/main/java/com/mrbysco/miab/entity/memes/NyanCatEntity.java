package com.mrbysco.miab.entity.memes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.OcelotAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class NyanCatEntity extends CatEntity {

	public NyanCatEntity(EntityType<? extends CatEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(3, new AvoidEntityGoal(this, TacNyanEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(7, new LeapAtTargetGoal(this, 0.3F));
		this.goalSelector.addGoal(8, new OcelotAttackGoal(this));
		this.goalSelector.addGoal(10, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp(NyanCatEntity.class));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return CatEntity.func_234184_eY_()
			.createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
