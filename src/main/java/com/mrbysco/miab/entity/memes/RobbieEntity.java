package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeRegister;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class RobbieEntity extends AbstractMeme{

	public RobbieEntity(EntityType<? extends RobbieEntity> entityType, World worldIn) {
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
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(RobbieEntity.class));
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
    protected SoundEvent getAmbientSound() {
		if (!isHoldingSax()) {
			return MemeSounds.robbie_passive.get();
		} else {
			return MemeSounds.robbie_sax.get();
		}
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return MemeSounds.robbie_hit.get();
    }
	
	@Override
    protected SoundEvent getDeathSound() {
        return MemeSounds.robbie_death.get();
    }

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable CompoundNBT dataTag) {
		livingData = super.onInitialSpawn(worldIn, difficultyIn, reason, livingData, dataTag);
		if (rand.nextInt(10) < 3) {
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(MemeRegister.SAX.get()));
		}
		return livingData;
	}

	public boolean isHoldingSax() {
		return this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem() == MemeRegister.SAX.get();
	}

	@Override
	public boolean canPickupItems() {
		return true;
	}
}
