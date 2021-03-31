package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class ShrekEntity extends AbstractMeme{

	private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (p_213697_0_) -> {
		return p_213697_0_ == Difficulty.HARD;
	};
	private final BreakDoorGoal breakDoorAI = new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE);
	private boolean isBreakDoorsTaskSet;

	public ShrekEntity(EntityType<? extends ShrekEntity> entityType, World worldIn) {
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
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(ShrekEntity.class));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AbstractMeme.registerAttributes()
			.createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
			.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23D)
			.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.6D)
			.createMutableAttribute(Attributes.FOLLOW_RANGE, 30.0D)
			.createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D);
	}
	
	@Override
    protected SoundEvent getAmbientSound() {
        return MemeSounds.shrek_passive.get();
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return MemeSounds.shrek_hit.get();
    }
	
	@Override
    protected SoundEvent getDeathSound() {
        return MemeSounds.shrek_death.get();
    }
	
	@Override
	public boolean canPickupItems() {
		return true;
	}

	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if(!world.isRemote) {
			DonkeyEntity donkey = EntityType.DONKEY.create(world);
			donkey.setLocationAndAngles(getPosX() + 0.5, getPosY(), getPosZ() + 0.5, 0,0);
			donkey.setCustomName(new StringTextComponent("Donkey"));
			world.addEntity(donkey);
		}
	}

	//Breaking doors
	public boolean isBreakDoorsTaskSet()
	{
		return this.isBreakDoorsTaskSet;
	}
	protected boolean canBreakDoors() {
		return true;
	}

	public void setBreakDoorsAItask(boolean enabled) {
		if (this.canBreakDoors()) {
			if (this.isBreakDoorsTaskSet != enabled) {
				this.isBreakDoorsTaskSet = enabled;
				((GroundPathNavigator)this.getNavigator()).setBreakDoors(enabled);
				if (enabled) {
					this.goalSelector.addGoal(1, this.breakDoorAI);
				} else {
					this.goalSelector.removeGoal(this.breakDoorAI);
				}
			}
		} else if (this.isBreakDoorsTaskSet) {
			this.goalSelector.removeGoal(this.breakDoorAI);
			this.isBreakDoorsTaskSet = false;
		}
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setBreakDoorsAItask(compound.getBoolean("CanBreakDoors"));
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable CompoundNBT dataTag) {
		livingData = super.onInitialSpawn(worldIn, difficultyIn, reason, livingData, dataTag);
		float f = difficultyIn.getClampedAdditionalDifficulty();
		this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
		this.setEquipmentBasedOnDifficulty(difficultyIn);
		this.setEnchantmentBasedOnDifficulty(difficultyIn);

		if (this.rand.nextFloat() < f * 0.05F)
		{
			this.setBreakDoorsAItask(true);
		}

		return livingData;
	}
}
