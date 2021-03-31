package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.entity.ai.CallForKnucklesGoal;
import com.mrbysco.miab.init.MemeEntities;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class KnucklesQueenEntity extends AbstractMeme implements IRangedAttackMob {

	public KnucklesQueenEntity(EntityType<? extends KnucklesQueenEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 15, 10.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(1, new CallForKnucklesGoal(this, true, new Class[0]));
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(KnucklesQueenEntity.class));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AbstractMeme.registerAttributes()
			.createMutableAttribute(Attributes.MAX_HEALTH, 22.0D)
			.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23D)
			.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.4D)
			.createMutableAttribute(Attributes.FOLLOW_RANGE, 30.0D)
			.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {

	}

	@Override
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.knuckles_passive.get();
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return MemeSounds.knuckles_hurt.get();
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.knuckles_passive.get();
    }
	
	@Override
	public boolean canPickupItems() {
		return false;
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable CompoundNBT dataTag) {
		livingData = super.onInitialSpawn(worldIn, difficultyIn, reason, livingData, dataTag);
		if(!world.isRemote) {
			int knucklesAmount = rand.nextInt(9);
			for(int i = 0; i < knucklesAmount; i++) {
				KnucklesEntity knuckles = MemeEntities.KNUCKLES.get().create(world);
				knuckles.setKnucklesType(rand.nextInt(7));
				knuckles.setPositionAndUpdate(getPosX(), getPosY(), getPosZ());

				world.addEntity(knuckles);
			}
		}

		return livingData;
	}
}
