package com.mrbysco.miab.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractMeme extends CreatureEntity {
	protected int summonSoundTime = 100;

	public AbstractMeme(EntityType<? extends AbstractMeme> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2F)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23000000)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D)
				.createMutableAttribute(Attributes.ARMOR, 2.0D);
	}

	@Override
	protected void registerData() {
		super.registerData();
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("summonSoundTime", this.summonSoundTime);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.summonSoundTime = compound.getInt("summonSoundTime");
	}

	@Override
	public void livingTick() {
		super.livingTick();
		if (!this.world.isRemote) {
			int i = this.summonSoundTime;

			if (i > 0) {
				--i;
				summonSoundTime = i;
			}
		}
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable CompoundNBT dataTag) {
		livingData = super.onInitialSpawn(worldIn, difficultyIn, reason, livingData, dataTag);
		float f = difficultyIn.getClampedAdditionalDifficulty();
		if(canPickupItems()) {
			this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		}

		this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).applyNonPersistentModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.5D, AttributeModifier.Operation.ADDITION));

		double d0 = this.rand.nextDouble() * 1.5D * (double)f;
		if (d0 > 1.0D) {
			this.getAttribute(Attributes.FOLLOW_RANGE).applyNonPersistentModifier(new AttributeModifier("Random meme-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}

		return livingData;
	}

	public boolean canPickupItems() { 
		return false;
	}

	public PlayerEntity getNearestPlayer(int range) {
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(getPosX(), getPosY(), getPosZ(), getPosX() + 1, getPosY() + 1, getPosZ() + 1)).grow(range);
		List<PlayerEntity> list = world.getEntitiesWithinAABB(PlayerEntity.class, axisalignedbb);
		return !list.isEmpty() ? list.get(0) : null;
	}

	public boolean isPlayerNearby(int range) {
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(getPosX(), getPosY(), getPosZ(), getPosX() + 1, getPosY() + 1, getPosZ() + 1)).grow(range);
		List<PlayerEntity> list = world.getEntitiesWithinAABB(PlayerEntity.class, axisalignedbb);
		return !list.isEmpty();
	}

	@Override
	public void playAmbientSound() {
		if(this.summonSoundTime <= 0) {
			super.playAmbientSound();
		}
	}
}
