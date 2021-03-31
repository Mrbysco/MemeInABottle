package com.mrbysco.miab.entity.ai;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.EnumSet;

public class FollowPlayerGoal extends Goal {
    public final AbstractMeme meme;
    public PlayerEntity player;
    public final World world;
    public final double followSpeed;
    public final PathNavigator navigator;
    public int timeToRecalcPath;
    float maxDist;
    float minDist;
    public float oldWaterCost;
    public int range;
    
	public FollowPlayerGoal(AbstractMeme memeIn, double followSpeedIn, float minDistIn, float maxDistIn, int findRange) {
        this.meme = memeIn;
        this.world = memeIn.world;
        this.followSpeed = followSpeedIn;
        this.navigator = memeIn.getNavigator();
        this.minDist = minDistIn;
        this.maxDist = maxDistIn;
        this.range = findRange;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        if (!(meme.getNavigator() instanceof GroundPathNavigator) && !(meme.getNavigator() instanceof FlyingPathNavigator)) {
            throw new IllegalArgumentException("Unsupported mob type for FollowPlayerGoal");
        }
    }
	
	@Override
	public boolean shouldExecute() {
		PlayerEntity nearestPlayer = this.meme.getNearestPlayer(this.range);
        if (nearestPlayer == null) {
            return false;
        } else if (nearestPlayer.isSpectator()) {
            return false;
        } else {
            this.player = nearestPlayer;
            return true;
        }
	}

	public boolean shouldContinueExecuting() {
        return !this.navigator.noPath() && this.meme.getDistanceSq(this.player) > (double)(this.maxDist * this.maxDist);
    }
	
	public void startExecuting() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.meme.getPathPriority(PathNodeType.WATER);
        this.meme.setPathPriority(PathNodeType.WATER, 0.0F);
    }
	
	public void resetTask() {
        this.player = null;
        this.navigator.clearPath();
        this.meme.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
    }

    public void tick() {
        this.meme.getLookController().setLookPositionWithEntity(this.player, 10.0F, (float)this.meme.getVerticalFaceSpeed());
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = 10;
            if (!this.navigator.tryMoveToEntityLiving(this.player, this.followSpeed)) {
                if (!this.meme.getLeashed() && !this.meme.isPassenger()) {
                    if (!(this.meme.getDistanceSq(this.player) < 144.0D)) {
                        int i = MathHelper.floor(this.player.getPosX()) - 2;
                        int j = MathHelper.floor(this.player.getPosZ()) - 2;
                        int k = MathHelper.floor(this.player.getBoundingBox().minY);

                        for(int l = 0; l <= 4; ++l) {
                            for(int i1 = 0; i1 <= 4; ++i1) {
                                if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.canTeleportToBlock(new BlockPos(i + l, k - 1, j + i1))) {
                                    this.meme.setLocationAndAngles((double)((float)(i + l) + 0.5F), (double)k, (double)((float)(j + i1) + 0.5F), this.meme.rotationYaw, this.meme.rotationPitch);
                                    this.navigator.clearPath();
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
        return blockstate.canEntitySpawn(this.world, pos, this.meme.getType()) && this.world.isAirBlock(pos.up()) && this.world.isAirBlock(pos.up(2));
    }
}
