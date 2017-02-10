package com.Mrbysco.MIAB.entity;

import com.Mrbysco.MIAB.entity.monsters.EntityBill;
import com.Mrbysco.MIAB.entity.monsters.EntityCena;
import com.Mrbysco.MIAB.entity.monsters.EntityDatBoi;
import com.Mrbysco.MIAB.entity.monsters.EntityFA;
import com.Mrbysco.MIAB.entity.monsters.EntityKhil;
import com.Mrbysco.MIAB.entity.monsters.EntityMario7;
import com.Mrbysco.MIAB.entity.monsters.EntityMoonman;
import com.Mrbysco.MIAB.entity.monsters.EntityPpap;
import com.Mrbysco.MIAB.entity.monsters.EntityRobbie;
import com.Mrbysco.MIAB.entity.monsters.EntitySanic;
import com.Mrbysco.MIAB.entity.monsters.EntityShrek;
import com.Mrbysco.MIAB.entity.monsters.EntityTacNyan;
import com.Mrbysco.MIAB.entity.monsters.EntityTrump;
import com.Mrbysco.MIAB.entity.passive.EntityDoge;
import com.Mrbysco.MIAB.entity.passive.EntityGrumpy;
import com.Mrbysco.MIAB.entity.passive.EntityNyanCat;
import com.Mrbysco.MIAB.init.MIABConfig;
import com.Mrbysco.MIAB.init.MIABItems;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityMeme extends EntityThrowable{

 		int c = MIABConfig.MemeSpawnPercentage;
 	
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

	    public static void registerFixesMeme(DataFixer fixer)
	    {
	        EntityThrowable.registerFixesThrowable(fixer, "memeSplash");
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
	        	if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.cena_spawn, 1F, 1F);
	        		EntityCena cena = new EntityCena(worldObj); 
	        		cena.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(cena);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			cena.setCustomNameTag("John Cena");
	        		}
	        	}

	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.bill_spawn, 1F, 1F);
	        		EntityBill bill = new EntityBill(worldObj); 
	        		bill.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(bill);
	        		
	        		if (rand.nextInt(100) <50) 
	        		{
	        			bill.setCustomNameTag("Bill Cipher");
	        		}
	        	}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.trump_spawn, 1F, 1F);
	        		EntityTrump trump = new EntityTrump(worldObj); 
	        		trump.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(trump);
	        		
	        		if (rand.nextInt(100) <50) 
	        		{
	        			trump.setCustomNameTag("Donald Drumpf");
	        		}
	        	}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.khil_spawn, 1F, 1F);
	        		EntityKhil khil = new EntityKhil(worldObj); 
	        		khil.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(khil);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			khil.setCustomNameTag("Eduard Khil");
	        		}
	        	}

	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(SoundEvents.ENTITY_WOLF_GROWL, 1F, 1F);
	        		EntityDoge Doge = new EntityDoge(worldObj); 
	        		Doge.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(Doge);
	        		
	        		if (rand.nextInt(100) <50) 
	        		{
	        			Doge.setCustomNameTag("Doge");
	        		}
	        	}

	        	else if (rand.nextInt(c) == 0) 
	        	{ 
	        		this.playSound(SoundEvents.ENTITY_CAT_PURR, 1F, 1F);
	        		EntityGrumpy Grumpy = new EntityGrumpy(worldObj); 
	        		Grumpy.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(Grumpy);
	        		
	        		if (rand.nextInt(100) <50) 
	        		{
	        			Grumpy.setCustomNameTag("Grumpy");
	        		}
	        	}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.ception_spawn, 1F, 1F);
	        		worldObj.setBlockState(new BlockPos(posX,  posY, posZ), Blocks.CHEST.getDefaultState()); 
	        		TileEntityChest chest = (TileEntityChest) worldObj.getTileEntity(new BlockPos(posX, posY, posZ));
	        		chest.setInventorySlotContents(0, new ItemStack(Blocks.CHEST));
	        		chest.setCustomName("Chestception");
	    		}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.ppap_spawn, 1F, 1F);
	        		EntityPpap ppap = new EntityPpap(worldObj); 
	        		ppap.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(ppap);
	        		if (rand.nextInt(100) <50) 
					{
	        			ppap.setCustomNameTag("Kosaka Daimaou");
					}
	    		}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.keyboard_mechanical, 1F, 1F);
	        		EntityVillager villagememe = new EntityVillager(worldObj); 
	        		villagememe.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(villagememe);
	        		//villagememe.set
	        		if (rand.nextInt(100) <50) 
	        		{
	        			villagememe.setCustomNameTag("Toby");
	        		}
	        	}
	        		
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.moonman_summon, 1F, 1F);
	        		EntityMoonman moonman = new EntityMoonman(worldObj); 
	        		moonman.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(moonman);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			moonman.setCustomNameTag("Moon Man");
	        		}
	        	}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.boi_summon, 1F, 1F);
	        		EntityDatBoi datboi = new EntityDatBoi(worldObj); 
	        		datboi.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(datboi);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			datboi.setCustomNameTag("Dat Boi");
	        		}
	        	}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(MiabSoundEvents.shrek_summon, 1F, 1F);
	        		EntityShrek shrek = new EntityShrek(worldObj); 
	        		shrek.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(shrek);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			shrek.setCustomNameTag("Shrek");
	        		}
	        	}
	        	
	        	else if (rand.nextInt(c) == 0) 
	        	{ 
	        		this.playSound(MiabSoundEvents.robbie_summon, 1F, 1F);
	        		EntityRobbie rotten = new EntityRobbie(worldObj); 
	        		rotten.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(rotten);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			rotten.setCustomNameTag("Robbie Rotten");
	        		}
	        	}
	        	
	        	else if (rand.nextInt(c) == 0) 
	        	{ 
	        		this.playSound(MiabSoundEvents.dad_summon, 1F, 1F);
	        		EntityMario7 grand = new EntityMario7(worldObj); 
	        		grand.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(grand);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			grand.setCustomNameTag("Grand Dad?!");
	        		}
	        	}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(SoundEvents.ENTITY_CAT_PURR, 1F, 1F);
	        		EntityNyanCat nyancat = new EntityNyanCat(worldObj); 
	        		nyancat.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(nyancat);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			nyancat.setCustomNameTag("Nyan Cat");
	        		}
	        		EntityTacNyan tacnyan = new EntityTacNyan(worldObj); 
	        		tacnyan.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(tacnyan);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			tacnyan.setCustomNameTag("Tac Nyan");
	        		}
	        		
	        	}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(SoundEvents.ENTITY_GHAST_SCREAM, 1F, 1F);
	        		EntityFA forever = new EntityFA(worldObj); 
	        		forever.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(forever);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			forever.setCustomNameTag("Forever Alone");
	        		}
	        		
	        	}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	        		this.playSound(SoundEvents.ENTITY_GHAST_SCREAM, 1F, 1F);
	        		EntitySanic sanic = new EntitySanic(worldObj); 
	        		sanic.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	        		worldObj.spawnEntityInWorld(sanic);
	        		if (rand.nextInt(100) <50) 
	        		{
	        			sanic.setCustomNameTag("Sanic");
	        		}
	        		
	        	}
	        	
	        	else if (rand.nextInt(c) == 0)
	        	{ 
	             	ItemStack itemStackToDrop = new ItemStack(MIABItems.splash_meme_in_a_bottle, 1);
	        	}
	        	
	        	else if(MIABConfig.MatureSounds)
	        	{
	        		this.playSound(MiabSoundEvents.meme_soundMature ,1F,1F);
	        	}
	        	else
	        	{
	        		this.playSound(MiabSoundEvents.meme_sound, 1F, 1F);
	        	}
	        	this.setDead();

	    }
	}
}