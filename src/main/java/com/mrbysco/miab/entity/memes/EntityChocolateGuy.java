package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.entity.ai.FollowPlayerGoal;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
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

public class EntityChocolateGuy extends AbstractMeme{
	private static final DataParameter<Boolean> FOLLOWING_PLAYER = EntityDataManager.<Boolean>createKey(EntityChocolateGuy.class, DataSerializers.BOOLEAN);

	public EntityChocolateGuy(EntityType<? extends EntityChocolateGuy> entityType, World worldIn) {
		super(entityType, worldIn);
		//TODO: super.setSize(0.6F, 2.7F);
	}
	
	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new AIFollowPlayerGoalCocoa(this, 1.6D, 10.0F, 2.0F, 16));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(EntityChocolateGuy.class));
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(FOLLOWING_PLAYER, Boolean.valueOf(false));
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		return this.isFollowingPlayer() ? MemeSounds.tom_sound : super.getAmbientSound();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return MemeSounds.tom_sound;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return MemeSounds.tom_sound;
	}

	public void setFollowingPlayer(boolean armsRaised)
	{
		this.getDataManager().set(FOLLOWING_PLAYER, Boolean.valueOf(armsRaised));
	}

	public boolean isFollowingPlayer()
	{
		return ((Boolean)this.getDataManager().get(FOLLOWING_PLAYER)).booleanValue();
	}


	static class AIFollowPlayerGoalCocoa extends FollowPlayerGoal {
		public AIFollowPlayerGoalCocoa(EntityChocolateGuy memeIn, double followSpeedIn, float minDistIn, float maxDistIn, int findRange) {
			super(memeIn, followSpeedIn, minDistIn, maxDistIn, findRange);
		}

		@Override
		public boolean shouldExecute() {
			EntityChocolateGuy tom = (EntityChocolateGuy)this.meme;
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

		private boolean shouldFollowPlayer(PlayerEntity player)
		{
			EntityChocolateGuy tom = (EntityChocolateGuy)this.meme;
			ItemStack heldStack = player.getHeldItemMainhand();
			boolean flag = heldStack.getItem() == Items.COCOA_BEANS;
			if(tom.isFollowingPlayer() != flag) {
				tom.setFollowingPlayer(flag);
			}
			return flag;
		}
	}
}
