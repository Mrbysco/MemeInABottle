package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeLoot;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EntityShrek extends AbstractMeme{

	private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (p_213697_0_) -> {
		return p_213697_0_ == Difficulty.HARD;
	};
	private final BreakDoorGoal breakDoorAI = new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE);
	private boolean isBreakDoorsTaskSet;

	public EntityShrek(EntityType<? extends EntityShrek> entityType, World worldIn) {
		super(entityType, worldIn);
		//TODO: super.setSize(0.6F, 2.2F);
	}

	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.registerGoals();
	}

	private void registerTargetGoals() {
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(EntityShrek.class));
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.6D);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	}
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.shrek_passive.get();
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return MemeSounds.shrek_hit.get();
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.shrek_death.get();
    }
	
	@Override
	public boolean canPickupItems() {
		return true;
	}

	@Override
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.SHREK_LOOT;
	}

	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if(!world.isRemote)
		{
			DonkeyEntity donkey = EntityType.DONKEY.create(world);
			donkey.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0);
			donkey.setCustomName(new StringTextComponent("Donkey"));
			world.addEntity(donkey);
		}
	}

	//Breaking doors
	public boolean isBreakDoorsTaskSet()
	{
		return this.isBreakDoorsTaskSet;
	}
	protected boolean canBreakDoors() {
		return true;
	}

	public void setBreakDoorsAItask(boolean enabled)
	{
		if (this.canBreakDoors()) {
			if (this.isBreakDoorsTaskSet != enabled) {
				this.isBreakDoorsTaskSet = enabled;
				((GroundPathNavigator)this.getNavigator()).setBreakDoors(enabled);
				if (enabled) {
					this.goalSelector.addGoal(1, this.breakDoorAI);
				} else {
					this.goalSelector.removeGoal(this.breakDoorAI);
				}
			}
		} else if (this.isBreakDoorsTaskSet) {
			this.goalSelector.removeGoal(this.breakDoorAI);
			this.isBreakDoorsTaskSet = false;
		}
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setBreakDoorsAItask(compound.getBoolean("CanBreakDoors"));
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable CompoundNBT tag) {
		float f = difficultyIn.getClampedAdditionalDifficulty();
		this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
		this.setEquipmentBasedOnDifficulty(difficultyIn);
		this.setEnchantmentBasedOnDifficulty(difficultyIn);

		if (this.rand.nextFloat() < f * 0.05F)
		{
			this.setBreakDoorsAItask(true);
		}

		return super.onInitialSpawn(worldIn, difficultyIn, reason, livingData, tag);
	}
}
