package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SandBlock;

public class SkywalkerEntity extends AbstractMeme {
	public SkywalkerEntity(EntityType<? extends SkywalkerEntity> entityType, Level level) {
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
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(SkywalkerEntity.class));
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
	public void aiStep() {
		BlockPos position = this.blockPosition().offset(0, -1, 0);

		if ((this.zza != 0 || this.xxa != 0) && this.onGround && (level.getBlockState(position).getBlock() instanceof SandBlock)) {
			if (!this.level.isClientSide) {
				int random = this.random.nextInt(1000);

				if (random < 1) {
					level.playSound((Player) null, this.blockPosition(), MemeSounds.meme_music2.get(), SoundSource.RECORDS, 0.75F, 1.0F);
				}
			}
		}

		if (this.isPassenger() && this.getTarget() != null && this.getVehicle() instanceof Chicken) {
			((Chicken) this.getVehicle()).getNavigation().moveTo(this.getNavigation().getPath(), 1.5D);
		}

		super.aiStep();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return MemeSounds.skywalker_sand.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return MemeSounds.skywalker_sand.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return MemeSounds.skywalker_sand.get();
	}

	@Override
	public boolean canPickupItems() {
		return true;
	}
}
