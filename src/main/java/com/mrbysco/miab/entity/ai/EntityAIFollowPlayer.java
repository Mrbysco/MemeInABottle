package com.mrbysco.miab.entity.ai;

import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityAIFollowPlayer extends EntityAIBase {
    public final AbstractMeme meme;
    public EntityPlayer player;
    public final World world;
    public final double followSpeed;
    public final PathNavigate petPathfinder;
    public int timeToRecalcPath;
    float maxDist;
    float minDist;
    public float oldWaterCost;
    public int range;
    
	public EntityAIFollowPlayer(AbstractMeme memeIn, double followSpeedIn, float minDistIn, float maxDistIn, int findRange) {
        this.meme = memeIn;
        this.world = memeIn.world;
        this.followSpeed = followSpeedIn;
        this.petPathfinder = memeIn.getNavigator();
        this.minDist = minDistIn;
        this.maxDist = maxDistIn;
        this.range = findRange;
        this.setMutexBits(3);

        if (!(memeIn.getNavigator() instanceof PathNavigateGround) && !(memeIn.getNavigator() instanceof PathNavigateFlying))
        {
            throw new IllegalArgumentException("Unsupported mob type for FollowPlayer");
        }
    }
	
	@Override
	public boolean shouldExecute() {
		EntityPlayer nearestPlayer = this.meme.getNearestPlayer(this.range);
        if (nearestPlayer == null) {
            return false;
        } else if (nearestPlayer.isSpectator()) {
            return false;
        } else {
            this.player = nearestPlayer;
            return true;
        }
	}

	public boolean shouldContinueExecuting()
    {
        return !this.petPathfinder.noPath() && this.meme.getDistanceSq(this.player) > (double)(this.maxDist * this.maxDist);
    }
	
	public void startExecuting()
    {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.meme.getPathPriority(PathNodeType.WATER);
        this.meme.setPathPriority(PathNodeType.WATER, 0.0F);
    }
	
	public void resetTask()
    {
        this.player = null;
        this.petPathfinder.clearPath();
        this.meme.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
    }

    public void updateTask()
    {
        this.meme.getLookHelper().setLookPositionWithEntity(this.player, 10.0F, (float)this.meme.getVerticalFaceSpeed());

        if (--this.timeToRecalcPath <= 0)
        {
            this.timeToRecalcPath = 10;

            if (!this.petPathfinder.tryMoveToEntityLiving(this.player, this.followSpeed))
            {
                if (!this.meme.getLeashed() && !this.meme.isRiding())
                {
                    if (this.meme.getDistanceSq(this.player) >= 144.0D)
                    {
                        int i = MathHelper.floor(this.player.posX) - 2;
                        int j = MathHelper.floor(this.player.posZ) - 2;
                        int k = MathHelper.floor(this.player.getEntityBoundingBox().minY);

                        for (int l = 0; l <= 4; ++l)
                        {
                            for (int i1 = 0; i1 <= 4; ++i1)
                            {
                                if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.isTeleportFriendlyBlock(i, j, k, l, i1))
                                {
                                    this.meme.setLocationAndAngles((double)((float)(i + l) + 0.5F), (double)k, (double)((float)(j + i1) + 0.5F), this.meme.rotationYaw, this.meme.rotationPitch);
                                    this.petPathfinder.clearPath();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
	protected boolean isTeleportFriendlyBlock(int x, int z, int y, int xOffset, int zOffset)
    {
        BlockPos blockpos = new BlockPos(x + xOffset, y - 1, z + zOffset);
        IBlockState iblockstate = this.world.getBlockState(blockpos);
        return iblockstate.getBlockFaceShape(this.world, blockpos, EnumFacing.DOWN) == BlockFaceShape.SOLID && iblockstate.canEntitySpawn(this.meme) && this.world.isAirBlock(blockpos.up()) && this.world.isAirBlock(blockpos.up(2));
    }
}
