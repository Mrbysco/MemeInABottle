package com.Mrbysco.MIAB.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMeme extends EntityThrowable{
	    public EntityMeme(World worldIn)
	    {
	        super(worldIn);
	    }

	    public EntityMeme(World worldIn, EntityLivingBase throwerIn)
	    {
	        super(worldIn, throwerIn);
	    }

	    public EntityMeme(World worldIn, double x, double y, double z)
	    {
	        super(worldIn, x, y, z);
	    }

	    /**
	     * Called when this EntityThrowable hits a block or entity.
	     */
	    protected void onImpact(MovingObjectPosition p_70184_1_)
	    {
	        if (p_70184_1_.entityHit != null)
	        {
	            int i = 0;

	            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
	        }

	        for (int j = 0; j < 8; ++j)
	        {
	            this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
	        }

	        if (!this.worldObj.isRemote)
	        {
	        	this.playSound("miab:meme.sound", 10, 1);
	        	this.playSound("MIAB:meme.sound", 10, 1);
	            this.setDead();
	        }
	    }
	}