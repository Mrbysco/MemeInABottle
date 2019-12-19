package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.entity.AbstractMeme;
import com.mrbysco.miab.init.MemeLoot;
import com.mrbysco.miab.init.MemeSounds;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityShrek extends AbstractMeme{

	private final EntityAIBreakDoor breakDoorAI = new EntityAIBreakDoor(this);
	private boolean isBreakDoorsTaskSet;

	public EntityShrek(World worldIn) {
		super(worldIn);
		super.setSize(0.6F, 2.2F);
	}

	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
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
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.6D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	}
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MemeSounds.shrek_passive;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return MemeSounds.shrek_hit;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MemeSounds.shrek_death;
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
			EntityDonkey donkey = new EntityDonkey(world);
			donkey.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0);
			donkey.setCustomNameTag("Donkey");
			world.spawnEntity(donkey);
		}
	}

	//Breaking doors
	public boolean isBreakDoorsTaskSet()
	{
		return this.isBreakDoorsTaskSet;
	}

	public void setBreakDoorsAItask(boolean enabled)
	{
		if (this.isBreakDoorsTaskSet != enabled)
		{
			this.isBreakDoorsTaskSet = enabled;
			((PathNavigateGround)this.getNavigator()).setBreakDoors(enabled);

			if (enabled)
			{
				this.tasks.addTask(1, this.breakDoorAI);
			}
			else
			{
				this.tasks.removeTask(this.breakDoorAI);
			}
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setBreakDoorsAItask(compound.getBoolean("CanBreakDoors"));
	}

	@Nullable
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		float f = difficulty.getClampedAdditionalDifficulty();
		this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
		this.setEquipmentBasedOnDifficulty(difficulty);
		this.setEnchantmentBasedOnDifficulty(difficulty);

		if (this.rand.nextFloat() < f * 0.05F)
		{
			this.setBreakDoorsAItask(true);
		}

		return super.onInitialSpawn(difficulty, livingdata);
	}
}
