package com.mrbysco.miab.entity;

import com.mrbysco.miab.init.MemeLoot;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractMeme extends CreatureEntity {
	protected int summonSoundTime = 100;

	public AbstractMeme(EntityType<? extends AbstractMeme> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
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
		if (!this.world.isRemote)
		{
			int i = this.summonSoundTime;

			if (i > 0)
			{
				--i;
				summonSoundTime = i;
			}
		}
	}

	@Nullable
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.MEME_BASE_LOOT;
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable CompoundNBT tag) {
		livingData = super.onInitialSpawn(worldIn, difficultyIn, reason, livingData, tag);
		float f = difficultyIn.getClampedAdditionalDifficulty();
		if(canPickupItems()) {
			this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		}

		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.5D, AttributeModifier.Operation.ADDITION));

		double d0 = this.rand.nextDouble() * 1.5D * (double)f;
		if (d0 > 1.0D)
		{
			this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random meme-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}

		return livingData;
	}

	public boolean canPickupItems() { 
		return false;
	}
	
	public PlayerEntity getNearestPlayer(int range) {
        AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(range);
        List<PlayerEntity> list = world.getEntitiesWithinAABB(PlayerEntity.class, axisalignedbb);
        return !list.isEmpty() ? list.get(0) : null;
    }

	@Override
	public void playAmbientSound() {
		if(this.summonSoundTime <= 0) {
			super.playAmbientSound();
		}
	}
}
