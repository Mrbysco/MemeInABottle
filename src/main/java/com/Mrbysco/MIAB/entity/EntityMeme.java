package com.Mrbysco.MIAB.entity;

import com.Mrbysco.MIAB.entity.monsters.EntityBill;
import com.Mrbysco.MIAB.entity.monsters.EntityCena;
import com.Mrbysco.MIAB.entity.monsters.EntityKhil;
import com.Mrbysco.MIAB.entity.monsters.EntityPpap;
import com.Mrbysco.MIAB.entity.monsters.EntityTrump;
import com.Mrbysco.MIAB.entity.passive.EntityDoge;
import com.Mrbysco.MIAB.entity.passive.EntityGrumpy;
import com.Mrbysco.MIAB.init.MIABConfig;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
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
	    protected void onImpact(RayTraceResult result)
	    {
	    	if (result.entityHit != null)
	        {
	            int i = 0;
	
	            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
	        }
	        
	    	 for (int j = 0; j < 8; ++j)
	         {
	             this.worldObj.spawnParticle(EnumParticleTypes.NOTE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
	         }

	    	if (!this.worldObj.isRemote)
	        {
	        	if (rand.nextInt(100) <2) 
	        	{ 
	        		//this.worldObj.playSoundAtEntity(this, "miab:cena.spawn", 1F, 1F); 
	        		this.playSound(MiabSoundEvents.cena_spawn, 1F, 1F);
	        		EntityCena cena = new EntityCena(worldObj); 
	        		cena.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(cena);
	        	}

	        	if (rand.nextInt(100) <4) 
	        	{ 
	        		//this.worldObj.playSoundAtEntity(this, "miab:bill.spawn", 1F, 1F); 
	        		this.playSound(MiabSoundEvents.bill_spawn, 1F, 1F);
	        		EntityBill bill = new EntityBill(worldObj); 
	        		bill.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(bill);
	        	}
	        	
	        	if (rand.nextInt(100) <5) 
	        	{ 
	        		//this.worldObj.playSoundAtEntity(this, "miab:trump.spawn", 1F, 1F); 
	        		this.playSound(MiabSoundEvents.trump_spawn, 1F, 1F);
	        		EntityTrump trump = new EntityTrump(worldObj); 
	        		trump.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(trump);
	        	}
	        	
	        	if (rand.nextInt(100) <10) 
	        	{ 
	        		//this.worldObj.playSoundAtEntity(this, "miab:khil.spawn", 1F, 1F); 
	        		this.playSound(MiabSoundEvents.khil_spawn, 1F, 1F);
	        		EntityKhil khil = new EntityKhil(worldObj); 
	        		khil.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(khil);
	        	}

	        	if (rand.nextInt(100) <6) 
	        	{ 
	        		//this.worldObj.playSoundAtEntity(this, "miab:Doge.spawn", 1F, 1F); 
	        		this.playSound(SoundEvents.ENTITY_WOLF_GROWL, 1F, 1F);
	        		EntityDoge Doge = new EntityDoge(worldObj); 
	        		Doge.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(Doge);
	        	}

	        	if (rand.nextInt(100) <6) 
	        	{ 
	        		//this.worldObj.playSoundAtEntity(this, "miab:Grumpy.spawn", 1F, 1F); 
	        		this.playSound(SoundEvents.ENTITY_CAT_PURR, 1F, 1F);
	        		EntityGrumpy Grumpy = new EntityGrumpy(worldObj); 
	        		Grumpy.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(Grumpy);
	        	}
	        	
	        	if (rand.nextInt(100) <2) 
	        	{ 
	        		//this.worldObj.playSoundAtEntity(this, "miab:ception.spawn", 1F, 1F); 
	        		this.playSound(MiabSoundEvents.ception_spawn, 1F, 1F);
	        		worldObj.setBlockState(new BlockPos(posX,  posY, posZ), Blocks.CHEST.getDefaultState()); 
	        		TileEntityChest chest = (TileEntityChest) worldObj.getTileEntity(new BlockPos(posX, posY, posZ));
	        		chest.setInventorySlotContents(0, new ItemStack(Blocks.CHEST));
	        		chest.setCustomName("Chestception");
	    		}
	        	
	        	if (rand.nextInt(100) <5) 
	        	{ 
	        		//this.worldObj.playSoundAtEntity(this, "miab:ception.spawn", 1F, 1F); 
	        		this.playSound(MiabSoundEvents.ppap_spawn, 1F, 1F);
	        		worldObj.setBlockState(new BlockPos(posX,  posY, posZ), Blocks.CHEST.getDefaultState()); 
	        		EntityPpap Ppap = new EntityPpap(worldObj); 
	        		Ppap.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(Ppap);
	        		if (rand.nextInt(100) <50) 
					{
	        			Ppap.setCustomNameTag("Kosaka Daimaou");
					}
	    		}
	        	
	        	if(MIABConfig.MatureSounds)
	        	{
	        		//this.worldObj.playSoundAtEntity(this, "miab:meme.soundMature", 1F, 1F);
	        		this.playSound(MiabSoundEvents.meme_soundMature ,1F,1F);
	        	}
	        	else
	        	{
	        		//this.worldObj.playSoundAtEntity(this, "miab:meme.sound", 1F, 1F);
	        		//this.worldObj.playSound(this, getPosition(), MiabSoundEvents.meme_soundMature, SoundCategory.HOSTILE, 1F, 1F);
	        		this.playSound(MiabSoundEvents.meme_sound, 1F, 1F);
	        	}
	        	this.setDead();

	    }
	}
}