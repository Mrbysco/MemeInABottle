package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.entity.ai.EntityAIFollowPlayer;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityChocolateGuy extends AbstractMeme{
	private static final DataParameter<Boolean> FOLLOWING_PLAYER = EntityDataManager.<Boolean>createKey(EntityChocolateGuy.class, DataSerializers.BOOLEAN);

	public EntityChocolateGuy(World worldIn) {
		super(worldIn);
		super.setSize(0.6F, 2.7F);
	}
	
	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityChocolateGuy.AIFollowPlayerCocoa(this, 1.6D, 10.0F, 2.0F, 16));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.applyEntityAI();
	}

	private void applyEntityAI() {
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
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


	static class AIFollowPlayerCocoa extends EntityAIFollowPlayer {
		public AIFollowPlayerCocoa(EntityChocolateGuy memeIn, double followSpeedIn, float minDistIn, float maxDistIn, int findRange) {
			super(memeIn, followSpeedIn, minDistIn, maxDistIn, findRange);
		}

		@Override
		public boolean shouldExecute() {
			EntityChocolateGuy tom = (EntityChocolateGuy)this.meme;
			EntityPlayer nearestPlayer = this.meme.getNearestPlayer(this.range);
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
		public void updateTask() {
			super.updateTask();
		}

		private boolean shouldFollowPlayer(EntityPlayer player)
		{
			EntityChocolateGuy tom = (EntityChocolateGuy)this.meme;
			ItemStack heldStack = player.getHeldItemMainhand();
			boolean flag = heldStack.getItem() == Items.DYE && heldStack.getMetadata() == 3;
			if(tom.isFollowingPlayer() != flag) {
				tom.setFollowingPlayer(flag);
			}
			return flag;
		}
	}
}
