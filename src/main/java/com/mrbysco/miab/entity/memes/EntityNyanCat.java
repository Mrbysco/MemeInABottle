package com.mrbysco.miab.entity.memes;

import com.mrbysco.miab.init.MemeLoot;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIOcelotAttack;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityNyanCat extends EntityOcelot {

	public EntityNyanCat(World worldIn)
	{
		super(worldIn);
		this.setSize(0.6F, 0.7F);
	}

	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity<>(this, EntityTacNayn.class, 6.0F, 1.0D, 1.2D));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3F));
		this.tasks.addTask(8, new EntityAIOcelotAttack(this));
		this.tasks.addTask(10, new EntityAIWander(this, 0.8D));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false, new Class[0]));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}

	@Nullable
	protected ResourceLocation getLootTable()
	{
		return MemeLoot.NYAN_LOOT;
	}
}
