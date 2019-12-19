package com.mrbysco.miab.entity;

import com.mrbysco.miab.init.MemeLoot;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractMeme extends EntityMob {
    private static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.<Boolean>createKey(AbstractMeme.class, DataSerializers.BOOLEAN);
	protected int summonSoundTime = 100;

	public AbstractMeme(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
        this.getDataManager().register(ARMS_RAISED, Boolean.valueOf(false));
	}
	
	public void setArmsRaised(boolean armsRaised)
    {
        this.getDataManager().set(ARMS_RAISED, Boolean.valueOf(armsRaised));
    }

    public boolean isArmsRaised()
    {
        return ((Boolean)this.getDataManager().get(ARMS_RAISED)).booleanValue();
    }

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("PlacedBlocks", this.summonSoundTime);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.summonSoundTime = compound.getInteger("PlacedBlocks");
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (!this.world.isRemote)
		{
			int i = this.summonSoundTime;

			if (i > 0)
			{
				--i;
				summonSoundTime = i;
			}
		}
	}

	@Nullable
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.MEME_BASE_LOOT;
	}
	
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		float f = difficulty.getClampedAdditionalDifficulty();
		if(canPickupItems()) {
		    this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		}
		
	    this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
		
	    double d0 = this.rand.nextDouble() * 1.5D * (double)f;
		if (d0 > 1.0D)
		{
		   this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random meme-spawn bonus", d0, 2));
		}
	    
		return livingdata;
	}
	
	public boolean canPickupItems() { 
		return false;
	}
	
	public EntityPlayer getNearestPlayer(int range) {
        AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(range);
        List<EntityPlayer> list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
        return !list.isEmpty() ? list.get(0) : null;
    }

	@Override
	public void playLivingSound() {
		if(this.summonSoundTime <= 0) {
			super.playLivingSound();
		}
	}
}
