package com.Mrbysco.MIAB.entity;

import com.Mrbysco.MIAB.entity.monsters.EntityCena;

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
	            this.worldObj.spawnParticle(EnumParticleTypes.NOTE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
	        }

	        if (!this.worldObj.isRemote)
	        {
	        	if (rand.nextInt(100) <2) { EntityCena cena = new EntityCena(worldObj); cena.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); worldObj.spawnEntityInWorld(cena);}
	        	this.worldObj.playSoundAtEntity(this, "miab:meme.sound", 1F, 1F);
	        	this.setDead();

	    }
	}
}