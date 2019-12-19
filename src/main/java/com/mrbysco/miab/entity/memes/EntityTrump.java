package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityTrump extends AbstractMeme{

	protected int placedBlocks;
	protected int maxWallBlocks;

	public EntityTrump(World worldIn) {
		super(worldIn);
		this.maxWallBlocks = rand.nextInt(10) + 5;
		this.placedBlocks = 0;
	}
	
	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(10, new EntityTrump.AIPlaceBlock(this));
		this.applyEntityAI();
	}
	
	private void applyEntityAI() {
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
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
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("PlacedBlocks", this.placedBlocks);
		compound.setInteger("MaxWallBlocks", this.maxWallBlocks);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.placedBlocks = compound.getInteger("PlacedBlocks");
		this.maxWallBlocks = compound.getInteger("MaxWallBlocks");
	}

	public void addPlacedBlock() {
		this.placedBlocks++;
	}

	public void setPlacedBlocks(int amount)
	{
		this.placedBlocks = amount;
	}

	static class AIPlaceBlock extends EntityAIBase
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
			World world = this.trump.world;
			int i = MathHelper.floor(this.trump.posX - 1.0D + random.nextDouble() * 2.0D);
			int j = MathHelper.floor(this.trump.posY + random.nextDouble() * 2.0D);
			int k = MathHelper.floor(this.trump.posZ - 1.0D + random.nextDouble() * 2.0D);
			BlockPos blockpos = new BlockPos(i, j, k);
			IBlockState iblockstate = world.getBlockState(blockpos);
			IBlockState iblockstate1 = world.getBlockState(blockpos.down());
			IBlockState iblockstate2 = Blocks.BRICK_BLOCK.getDefaultState();

			if (iblockstate2 != null && this.canPlaceBlock(world, blockpos, iblockstate2.getBlock(), iblockstate, iblockstate1))
			{
				world.setBlockState(blockpos, iblockstate2, 3);
				this.trump.addPlacedBlock();
			}
		}

		private boolean canPlaceBlock(World p_188518_1_, BlockPos p_188518_2_, Block p_188518_3_, IBlockState p_188518_4_, IBlockState p_188518_5_)
		{
			if (!p_188518_3_.canPlaceBlockAt(p_188518_1_, p_188518_2_))
			{
				return false;
			}
			else if (p_188518_4_.getMaterial() != Material.AIR)
			{
				return false;
			}
			else if (p_188518_5_.getMaterial() == Material.AIR)
			{
				return false;
			}
			else
			{
				return p_188518_5_.isFullCube();
			}
		}
	}
}
