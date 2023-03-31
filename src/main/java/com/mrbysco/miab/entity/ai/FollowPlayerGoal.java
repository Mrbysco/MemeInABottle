package com.mrbysco.miab.entity.ai;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import java.util.EnumSet;

public class FollowPlayerGoal extends Goal {
	public final AbstractMeme meme;
	public Player player;
	public final Level world;
	public final double followSpeed;
	public final PathNavigation navigator;
	public int timeToRecalcPath;
	float maxDist;
	float minDist;
	public float oldWaterCost;
	public int range;

	public FollowPlayerGoal(AbstractMeme memeIn, double followSpeedIn, float minDistIn, float maxDistIn, int findRange) {
		this.meme = memeIn;
		this.world = memeIn.level;
		this.followSpeed = followSpeedIn;
		this.navigator = memeIn.getNavigation();
		this.minDist = minDistIn;
		this.maxDist = maxDistIn;
		this.range = findRange;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		if (!(meme.getNavigation() instanceof GroundPathNavigation) && !(meme.getNavigation() instanceof FlyingPathNavigation)) {
			throw new IllegalArgumentException("Unsupported mob type for FollowPlayerGoal");
		}
	}

	@Override
	public boolean canUse() {
		Player nearestPlayer = this.meme.getNearestPlayer(this.range);
		if (nearestPlayer == null) {
			return false;
		} else if (nearestPlayer.isSpectator()) {
			return false;
		} else {
			this.player = nearestPlayer;
			return true;
		}
	}

	public boolean canContinueToUse() {
		return !this.navigator.isDone() && this.meme.distanceToSqr(this.player) > (double) (this.maxDist * this.maxDist);
	}

	public void start() {
		this.timeToRecalcPath = 0;
		this.oldWaterCost = this.meme.getPathfindingMalus(BlockPathTypes.WATER);
		this.meme.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
	}

	public void stop() {
		this.player = null;
		this.navigator.stop();
		this.meme.setPathfindingMalus(BlockPathTypes.WATER, this.oldWaterCost);
	}

	public void tick() {
		this.meme.getLookControl().setLookAt(this.player, 10.0F, (float) this.meme.getMaxHeadXRot());
		if (--this.timeToRecalcPath <= 0) {
			this.timeToRecalcPath = 10;
			if (!this.navigator.moveTo(this.player, this.followSpeed)) {
				if (!this.meme.isLeashed() && !this.meme.isPassenger()) {
					if (!(this.meme.distanceToSqr(this.player) < 144.0D)) {
						int i = Mth.floor(this.player.getX()) - 2;
						int j = Mth.floor(this.player.getZ()) - 2;
						int k = Mth.floor(this.player.getBoundingBox().minY);

						for (int l = 0; l <= 4; ++l) {
							for (int i1 = 0; i1 <= 4; ++i1) {
								if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.canTeleportToBlock(new BlockPos(i + l, k - 1, j + i1))) {
									this.meme.moveTo((double) ((float) (i + l) + 0.5F), (double) k, (double) ((float) (j + i1) + 0.5F),
											this.meme.getYRot(), this.meme.getXRot());
									this.navigator.stop();
									return;
								}
							}
						}

					}
				}
			}
		}
	}

	protected boolean canTeleportToBlock(BlockPos pos) {
		BlockState blockstate = this.world.getBlockState(pos);
		return blockstate.isValidSpawn(this.world, pos, this.meme.getType()) && this.world.isEmptyBlock(pos.above()) && this.world.isEmptyBlock(pos.above(2));
	}
}
