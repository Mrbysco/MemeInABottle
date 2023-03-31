package com.mrbysco.miab.entity.memes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.OcelotAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class NyanCatEntity extends Cat {

	public NyanCatEntity(EntityType<? extends Cat> entityType, Level level) {
		super(entityType, level);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(3, new AvoidEntityGoal(this, TacNyanEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(7, new LeapAtTargetGoal(this, 0.3F));
		this.goalSelector.addGoal(8, new OcelotAttackGoal(this));
		this.goalSelector.addGoal(10, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers(NyanCatEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Cat.createAttributes()
				.add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
