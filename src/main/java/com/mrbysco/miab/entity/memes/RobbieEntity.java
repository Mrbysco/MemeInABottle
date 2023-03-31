package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.registry.MemeRegistry;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class RobbieEntity extends AbstractMeme {

	public RobbieEntity(EntityType<? extends RobbieEntity> entityType, Level level) {
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
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(RobbieEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AbstractMeme.registerAttributes()
				.add(Attributes.MAX_HEALTH, 22.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.23D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.4D)
				.add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.ATTACK_DAMAGE, 3.0D);
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
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData livingData, @Nullable CompoundTag dataTag) {
		livingData = super.finalizeSpawn(level, difficultyIn, reason, livingData, dataTag);
		if (random.nextInt(10) < 3) {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MemeRegistry.SAX.get()));
		}
		return livingData;
	}

	public boolean isHoldingSax() {
		return this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == MemeRegistry.SAX.get();
	}

	@Override
	public boolean canPickupItems() {
		return true;
	}
}
