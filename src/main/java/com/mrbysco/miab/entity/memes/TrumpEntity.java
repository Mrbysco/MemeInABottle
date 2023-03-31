package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class TrumpEntity extends AbstractMeme {

	protected int placedBlocks;
	protected int maxWallBlocks;

	public TrumpEntity(EntityType<? extends TrumpEntity> entityType, Level level) {
		super(entityType, level);
		this.maxWallBlocks = random.nextInt(10) + 5;
		this.placedBlocks = 0;
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(10, new TrumpEntity.AIPlaceBlock(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(TrumpEntity.class));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AbstractMeme.registerAttributes()
				.add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return MemeSounds.trump_sound.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return MemeSounds.trump_hit.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return MemeSounds.trump_death.get();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("PlacedBlocks", this.placedBlocks);
		compound.putInt("MaxWallBlocks", this.maxWallBlocks);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.placedBlocks = compound.getInt("PlacedBlocks");
		this.maxWallBlocks = compound.getInt("MaxWallBlocks");
	}

	public void addPlacedBlock() {
		this.placedBlocks++;
	}

	public void setPlacedBlocks(int amount) {
		this.placedBlocks = amount;
	}

	static class AIPlaceBlock extends Goal {
		private final TrumpEntity trump;

		public AIPlaceBlock(TrumpEntity p_i45843_1_) {
			this.trump = p_i45843_1_;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean canUse() {
			if (this.trump.placedBlocks >= this.trump.maxWallBlocks) {
				return false;
			} else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.trump.level, this.trump)) {
				return false;
			} else {
				return this.trump.getRandom().nextInt(2000) == 0;
			}
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			RandomSource random = this.trump.getRandom();
			Level level = this.trump.level;
			int i = Mth.floor(this.trump.getX() - 1.0D + random.nextDouble() * 2.0D);
			int j = Mth.floor(this.trump.getY() + random.nextDouble() * 2.0D);
			int k = Mth.floor(this.trump.getZ() - 1.0D + random.nextDouble() * 2.0D);
			BlockPos blockpos = new BlockPos(i, j, k);
			BlockState blockstate = level.getBlockState(blockpos);
			BlockPos blockpos1 = blockpos.below();
			BlockState blockstate1 = level.getBlockState(blockpos1);
			BlockState blockstate2 = Blocks.BRICKS.defaultBlockState();

			if (blockstate2 != null && this.canPlaceBlock(level, blockpos, blockstate2, blockstate, blockstate1, blockpos1) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(trump, net.minecraftforge.common.util.BlockSnapshot.create(level.dimension(), level, blockpos), net.minecraft.core.Direction.UP)) {
				level.setBlock(blockpos, blockstate2, 3);
				this.trump.addPlacedBlock();
			}
		}

		private boolean canPlaceBlock(LevelReader reader, BlockPos pos, BlockState state, BlockState state1, BlockState state2, BlockPos pos1) {
			return state1.isAir() && !state2.isAir() && !state2.is(Blocks.BEDROCK) && state.canSurvive(reader, pos);
		}
	}
}
