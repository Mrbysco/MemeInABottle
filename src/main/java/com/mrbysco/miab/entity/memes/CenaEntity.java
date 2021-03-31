package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeRegister;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class CenaEntity extends AbstractMeme{

	public CenaEntity(EntityType<? extends CenaEntity> entityType, World worldIn) {
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
		this.targetSelector.addGoal(1, new CenaEntity.AIFindTarget(this));
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(CenaEntity.class));
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AbstractMeme.registerAttributes()
			.createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
			.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23D)
			.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.4D)
			.createMutableAttribute(Attributes.FOLLOW_RANGE, 30.0D)
			.createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D);
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
	public void livingTick() {
		if (isPlayerNearby(6)) {
			if (isPotionActive(Effects.INVISIBILITY)) {
				removePotionEffect(Effects.INVISIBILITY);
			}
		} else {
			if (!isPotionActive(Effects.INVISIBILITY)) {
				addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 480 * 20, 0));
			}
		}
		super.livingTick();
	}

	private boolean shouldAttackPlayer(PlayerEntity player) {
        ItemStack itemstack = player.getItemStackFromSlot(EquipmentSlotType.LEGS);

        if (itemstack.getItem() != MemeRegister.WRESTLING_BELT.get())
            return true;
        else
        	return false;
    }
	
	class AIFindTarget extends NearestAttackableTargetGoal<PlayerEntity> {
		private final CenaEntity meme;

        public AIFindTarget(CenaEntity meme) {
            super(meme, PlayerEntity.class, false);
            this.meme = meme;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute() {
            return super.shouldExecute() && (this.target != null && this.meme.shouldAttackPlayer((PlayerEntity)this.target));
        }
    }
}
