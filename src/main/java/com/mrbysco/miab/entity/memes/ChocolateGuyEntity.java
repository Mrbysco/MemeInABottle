package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.entity.ai.FollowPlayerGoal;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ChocolateGuyEntity extends AbstractMeme{
	private static final DataParameter<Boolean> FOLLOWING_PLAYER = EntityDataManager.<Boolean>createKey(ChocolateGuyEntity.class, DataSerializers.BOOLEAN);

	public ChocolateGuyEntity(EntityType<? extends ChocolateGuyEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new AIFollowPlayerGoalCocoa(this, 1.6D, 10.0F, 2.0F, 16));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(ChocolateGuyEntity.class));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AbstractMeme.registerAttributes()
			.createMutableAttribute(Attributes.MAX_HEALTH, 16.0D)
			.createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D)
			.createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(FOLLOWING_PLAYER, Boolean.valueOf(false));
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
		this.getDataManager().set(FOLLOWING_PLAYER, Boolean.valueOf(armsRaised));
	}

	public boolean isFollowingPlayer() {
		return ((Boolean)this.getDataManager().get(FOLLOWING_PLAYER)).booleanValue();
	}

	static class AIFollowPlayerGoalCocoa extends FollowPlayerGoal {
		public AIFollowPlayerGoalCocoa(ChocolateGuyEntity memeIn, double followSpeedIn, float minDistIn, float maxDistIn, int findRange) {
			super(memeIn, followSpeedIn, minDistIn, maxDistIn, findRange);
		}

		@Override
		public boolean shouldExecute() {
			ChocolateGuyEntity tom = (ChocolateGuyEntity)this.meme;
			PlayerEntity nearestPlayer = this.meme.getNearestPlayer(this.range);
			if (nearestPlayer == null) {
				if(tom.isFollowingPlayer()) {
					tom.setFollowingPlayer(false);
				}
				return false;
			} else if (nearestPlayer.isSpectator()) {
				if(tom.isFollowingPlayer()) {
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

		private boolean shouldFollowPlayer(PlayerEntity player) {
			ChocolateGuyEntity tom = (ChocolateGuyEntity)this.meme;
			ItemStack heldStack = player.getHeldItemMainhand();
			boolean flag = heldStack.getItem() == Items.COCOA_BEANS;
			if(tom.isFollowingPlayer() != flag) {
				tom.setFollowingPlayer(flag);
			}
			return flag;
		}
	}
}
