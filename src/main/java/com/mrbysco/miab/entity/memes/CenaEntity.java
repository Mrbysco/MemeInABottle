package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.registry.MemeRegistry;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CenaEntity extends AbstractMeme {

	public CenaEntity(EntityType<? extends CenaEntity> entityType, Level level) {
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
		this.targetSelector.addGoal(1, new AIFindTarget(this));
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(CenaEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AbstractMeme.registerAttributes()
				.add(Attributes.MAX_HEALTH, 30.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.23D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.4D)
				.add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.ATTACK_DAMAGE, 5.0D);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return MemeSounds.cena_sound.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return MemeSounds.cena_sound.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return MemeSounds.cena_sound.get();
	}

	@Override
	public boolean canPickupItems() {
		return true;
	}

	@Override
	public void aiStep() {
		if (isPlayerNearby(6)) {
			if (hasEffect(MobEffects.INVISIBILITY)) {
				removeEffect(MobEffects.INVISIBILITY);
			}
		} else {
			if (!hasEffect(MobEffects.INVISIBILITY)) {
				addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 480 * 20, 0));
			}
		}
		super.aiStep();
	}

	private boolean shouldAttackPlayer(Player player) {
		ItemStack itemstack = player.getItemBySlot(EquipmentSlot.LEGS);

		if (itemstack.getItem() != MemeRegistry.WRESTLING_BELT.get())
			return true;
		else
			return false;
	}

	static class AIFindTarget extends NearestAttackableTargetGoal<Player> {
		private final CenaEntity meme;

		public AIFindTarget(CenaEntity meme) {
			super(meme, Player.class, false);
			this.meme = meme;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean canUse() {
			return super.canUse() && (this.targetMob != null && this.meme.shouldAttackPlayer((Player) this.targetMob));
		}
	}
}
