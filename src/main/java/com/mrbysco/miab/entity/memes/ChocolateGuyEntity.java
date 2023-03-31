package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.entity.ai.FollowPlayerGoal;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class ChocolateGuyEntity extends AbstractMeme {
	private static final EntityDataAccessor<Boolean> FOLLOWING_PLAYER = SynchedEntityData.<Boolean>defineId(ChocolateGuyEntity.class, EntityDataSerializers.BOOLEAN);

	public ChocolateGuyEntity(EntityType<? extends ChocolateGuyEntity> entityType, Level level) {
		super(entityType, level);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new AIFollowPlayerGoalCocoa(this, 1.6D, 10.0F, 2.0F, 16));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(ChocolateGuyEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AbstractMeme.registerAttributes()
				.add(Attributes.MAX_HEALTH, 16.0D)
				.add(Attributes.FOLLOW_RANGE, 20.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(FOLLOWING_PLAYER, Boolean.valueOf(false));
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return this.isFollowingPlayer() ? MemeSounds.tom_sound.get() : super.getAmbientSound();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return MemeSounds.tom_sound.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return MemeSounds.tom_sound.get();
	}

	public void setFollowingPlayer(boolean armsRaised) {
		this.getEntityData().set(FOLLOWING_PLAYER, Boolean.valueOf(armsRaised));
	}

	public boolean isFollowingPlayer() {
		return ((Boolean) this.getEntityData().get(FOLLOWING_PLAYER)).booleanValue();
	}

	static class AIFollowPlayerGoalCocoa extends FollowPlayerGoal {
		public AIFollowPlayerGoalCocoa(ChocolateGuyEntity memeIn, double followSpeedIn, float minDistIn, float maxDistIn, int findRange) {
			super(memeIn, followSpeedIn, minDistIn, maxDistIn, findRange);
		}

		@Override
		public boolean canUse() {
			ChocolateGuyEntity tom = (ChocolateGuyEntity) this.meme;
			Player nearestPlayer = this.meme.getNearestPlayer(this.range);
			if (nearestPlayer == null) {
				if (tom.isFollowingPlayer()) {
					tom.setFollowingPlayer(false);
				}
				return false;
			} else if (nearestPlayer.isSpectator()) {
				if (tom.isFollowingPlayer()) {
					tom.setFollowingPlayer(false);
				}
				return false;
			} else {
				this.player = nearestPlayer;
				return this.shouldFollowPlayer(this.player);
			}
		}

		@Override
		public void tick() {
			super.tick();
		}

		private boolean shouldFollowPlayer(Player player) {
			ChocolateGuyEntity tom = (ChocolateGuyEntity) this.meme;
			ItemStack heldStack = player.getMainHandItem();
			boolean flag = heldStack.getItem() == Items.COCOA_BEANS;
			if (tom.isFollowingPlayer() != flag) {
				tom.setFollowingPlayer(flag);
			}
			return flag;
		}
	}
}
