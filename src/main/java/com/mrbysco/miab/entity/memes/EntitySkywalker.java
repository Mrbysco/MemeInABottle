package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeLoot;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.block.SandBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntitySkywalker extends AbstractMeme {
	public EntitySkywalker(EntityType<? extends EntitySkywalker> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.registerTargetGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(EntitySkywalker.class));
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(22.0D);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.4D);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}

	@Override
	public void livingTick()
	{
		BlockPos position = this.getPosition().add(0,-1,0);

		if((this.moveForward != 0 || this.moveStrafing != 0) && this.onGround && (world.getBlockState(position).getBlock() instanceof SandBlock))
		{
			if(!this.world.isRemote)
			{
				int random = rand.nextInt(1000);

				if (random < 1)
				{
					world.playSound((PlayerEntity)null, this.getPosition(), MemeSounds.meme_music2, SoundCategory.RECORDS, 0.75F, 1.0F);
				}
			}
		}

		if (this.isPassenger() && this.getAttackTarget() != null && this.getRidingEntity() instanceof ChickenEntity)
		{
			((ChickenEntity)this.getRidingEntity()).getNavigator().setPath(this.getNavigator().getPath(), 1.5D);
		}

		super.livingTick();
	}
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.skywalker_sand;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return MemeSounds.skywalker_sand;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.skywalker_sand;
    }
	
	@Override
	public boolean canPickupItems() {
		return true;
	}

	@Override
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.SKYWALKER_LOOT;
	}
}
