package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class ShrekEntity extends AbstractMeme {

	private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (p_213697_0_) -> {
		return p_213697_0_ == Difficulty.HARD;
	};
	private final BreakDoorGoal breakDoorAI = new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE);
	private boolean isBreakDoorsTaskSet;

	public ShrekEntity(EntityType<? extends ShrekEntity> entityType, Level level) {
		super(entityType, level);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(ShrekEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AbstractMeme.registerAttributes()
				.add(Attributes.MAX_HEALTH, 30.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.23D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.6D)
				.add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.ATTACK_DAMAGE, 6.0D);
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
	public void die(DamageSource cause) {
		super.die(cause);
		if (!level.isClientSide) {
			Donkey donkey = EntityType.DONKEY.create(level);
			donkey.moveTo(getX() + 0.5, getY(), getZ() + 0.5, 0, 0);
			donkey.setCustomName(Component.literal("Donkey"));
			level.addFreshEntity(donkey);
		}
	}

	//Breaking doors
	public boolean isBreakDoorsTaskSet() {
		return this.isBreakDoorsTaskSet;
	}

	protected boolean canBreakDoors() {
		return true;
	}

	public void setBreakDoorsAItask(boolean enabled) {
		if (this.canBreakDoors()) {
			if (this.isBreakDoorsTaskSet != enabled) {
				this.isBreakDoorsTaskSet = enabled;
				((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(enabled);
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
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setBreakDoorsAItask(compound.getBoolean("CanBreakDoors"));
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData livingData, @Nullable CompoundTag dataTag) {
		livingData = super.finalizeSpawn(level, difficultyIn, reason, livingData, dataTag);
		float f = difficultyIn.getSpecialMultiplier();
		this.setBreakDoorsAItask(this.random.nextFloat() < f * 0.1F);
		this.populateDefaultEquipmentSlots(random, difficultyIn);
		this.populateDefaultEquipmentEnchantments(random, difficultyIn);

		if (this.random.nextFloat() < f * 0.05F) {
			this.setBreakDoorsAItask(true);
		}

		return livingData;
	}
}
