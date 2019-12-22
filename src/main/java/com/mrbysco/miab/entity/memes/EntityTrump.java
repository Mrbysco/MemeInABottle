package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class EntityTrump extends AbstractMeme{

	protected int placedBlocks;
	protected int maxWallBlocks;

	public EntityTrump(EntityType<? extends EntityTrump> entityType, World worldIn) {
		super(entityType, worldIn);
		this.maxWallBlocks = rand.nextInt(10) + 5;
		this.placedBlocks = 0;
	}
	
	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(10, new EntityTrump.AIPlaceBlock(this));
		this.registerTargetGoals();
	}
	
	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(EntityTrump.class));
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		return MemeSounds.trump_sound;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source)
	{
		return MemeSounds.trump_hit;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return MemeSounds.trump_death;
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("PlacedBlocks", this.placedBlocks);
		compound.putInt("MaxWallBlocks", this.maxWallBlocks);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.placedBlocks = compound.getInt("PlacedBlocks");
		this.maxWallBlocks = compound.getInt("MaxWallBlocks");
	}

	public void addPlacedBlock() {
		this.placedBlocks++;
	}

	public void setPlacedBlocks(int amount)
	{
		this.placedBlocks = amount;
	}

	static class AIPlaceBlock extends Goal
	{
		private final EntityTrump trump;

		public AIPlaceBlock(EntityTrump p_i45843_1_)
		{
			this.trump = p_i45843_1_;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute()
		{
			if (this.trump.placedBlocks >= this.trump.maxWallBlocks)
			{
				return false;
			}
			else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.trump.world, this.trump))
			{
				return false;
			}
			else
			{
				return this.trump.getRNG().nextInt(2000) == 0;
			}
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask()
		{
			Random random = this.trump.getRNG();
			World iworld = this.trump.world;
			int i = MathHelper.floor(this.trump.posX - 1.0D + random.nextDouble() * 2.0D);
			int j = MathHelper.floor(this.trump.posY + random.nextDouble() * 2.0D);
			int k = MathHelper.floor(this.trump.posZ - 1.0D + random.nextDouble() * 2.0D);
			BlockPos blockpos = new BlockPos(i, j, k);
			BlockState blockstate = iworld.getBlockState(blockpos);
			BlockPos blockpos1 = blockpos.down();
			BlockState blockstate1 = iworld.getBlockState(blockpos1);
			BlockState blockstate2 = Blocks.BRICKS.getDefaultState();

			if (blockstate2 != null && this.canPlaceBlock(iworld, blockpos, blockstate2, blockstate, blockstate1, blockpos1)  && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(trump, new net.minecraftforge.common.util.BlockSnapshot(iworld, blockpos, blockstate1), net.minecraft.util.Direction.UP)) {
				iworld.setBlockState(blockpos, blockstate2, 3);
				this.trump.addPlacedBlock();
			}
		}

		private boolean canPlaceBlock(IWorldReader p_220836_1_, BlockPos p_220836_2_, BlockState p_220836_3_, BlockState p_220836_4_, BlockState p_220836_5_, BlockPos p_220836_6_) {
			return p_220836_4_.isAir(p_220836_1_, p_220836_2_) && !p_220836_5_.isAir(p_220836_1_, p_220836_6_) && p_220836_5_.func_224756_o(p_220836_1_, p_220836_6_) && p_220836_3_.isValidPosition(p_220836_1_, p_220836_2_);
		}
	}
}
