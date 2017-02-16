package com.Mrbysco.MIAB.entity;

import com.Mrbysco.MIAB.entity.monsters.EntityBill;
import com.Mrbysco.MIAB.entity.monsters.EntityCena;
import com.Mrbysco.MIAB.entity.monsters.EntityDankey;
import com.Mrbysco.MIAB.entity.monsters.EntityDatBoi;
import com.Mrbysco.MIAB.entity.monsters.EntityFA;
import com.Mrbysco.MIAB.entity.monsters.EntityKhil;
import com.Mrbysco.MIAB.entity.monsters.EntityMario7;
import com.Mrbysco.MIAB.entity.monsters.EntityMoonman;
import com.Mrbysco.MIAB.entity.monsters.EntityNigel;
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
import com.Mrbysco.MIAB.memes.BasicSummoning;
import com.Mrbysco.MIAB.memes.LennyStructure;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class EntityMeme extends EntityThrowable{
	
		EntityPlayer player = this.worldObj.getClosestPlayerToEntity(this, 100.0);
	
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
	    	 for (int j = 0; j < 8; ++j)
	         {
	             this.worldObj.spawnParticle(EnumParticleTypes.NOTE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
	         }

	    	 	if (!this.worldObj.isRemote)
	    	 	{	    	 		
	    	 		if (rand.nextInt(100) <1) 
		        	{ 
		        		this.playSound(MiabSoundEvents.cena_spawn, 1F, 1F);
		        		EntityCena cena = new EntityCena(worldObj); 
		        		BasicSummoning.Summon(cena, worldObj, posX, posY, posZ);
		        		player.addChatMessage(new TextComponentTranslation("cena.itscena").setStyle(new Style().setColor(TextFormatting.YELLOW)));
		        		if (rand.nextInt(100) <50) 
		        		{
		        			cena.setCustomNameTag("John Cena");
		        		}
		        	}
	
		        	else if (rand.nextInt(100) <2) 
		        	{ 
		        		this.playSound(MiabSoundEvents.bill_spawn, 1F, 1F);
		        		EntityBill bill = new EntityBill(worldObj); 
		        		BasicSummoning.Summon(bill, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			bill.setCustomNameTag("Bill Cipher");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <3) 
		        	{ 
		        		this.playSound(MiabSoundEvents.trump_spawn, 1F, 1F);
		        		EntityTrump trump = new EntityTrump(worldObj); 
		        		BasicSummoning.Summon(trump, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			trump.setCustomNameTag("Donald Drumpf");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <4) 
		        	{ 
		        		this.playSound(MiabSoundEvents.khil_spawn, 1F, 1F);
		        		EntityKhil khil = new EntityKhil(worldObj); 
		        		BasicSummoning.Summon(khil, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			khil.setCustomNameTag("Eduard Khil");
		        		}
		        	}
	
		        	else if (rand.nextInt(100) <5) 
		        	{ 
		        		this.playSound(SoundEvents.ENTITY_WOLF_HOWL, 1F, 1F);
		        		EntityDoge Doge = new EntityDoge(worldObj); 
		        		BasicSummoning.Summon(Doge, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			Doge.setCustomNameTag("Doge");
		        		}
		        	}
	
		        	else if (rand.nextInt(100) <6)  
		        	{ 
		        		this.playSound(SoundEvents.ENTITY_CAT_PURR, 1F, 1F);
		        		EntityGrumpy Grumpy = new EntityGrumpy(worldObj); 
		        		BasicSummoning.Summon(Grumpy, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			Grumpy.setCustomNameTag("Grumpy");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <7) 
		        	{ 
		        		this.playSound(MiabSoundEvents.ception_spawn, 1F, 1F);
		        		worldObj.setBlockState(new BlockPos(posX,  posY, posZ), Blocks.CHEST.getDefaultState()); 
		        		TileEntityChest chest = (TileEntityChest) worldObj.getTileEntity(new BlockPos(posX, posY, posZ));
		        		chest.setInventorySlotContents(0, new ItemStack(Blocks.CHEST));
		        		chest.setCustomName("Chestception");
		    		}
		        	
		        	else if (rand.nextInt(100) <8) 
		        	{ 
		        		this.playSound(MiabSoundEvents.ppap_spawn, 1F, 1F);
		        		EntityPpap ppap = new EntityPpap(worldObj); 
		        		BasicSummoning.Summon(ppap, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
						{
		        			ppap.setCustomNameTag("Kosaka Daimaou");
						}
		    		}
		        	
	    	 		
	    	 		//Disabled till I figure out how to summon a modded villager
	    	 		/*
		        	else if (rand.nextInt(100) <9) 
		        	{ 
		        		this.playSound(MiabSoundEvents.keyboard_mechanical, 1F, 1F);
		        		EntityVillager villagememe = new EntityVillager(worldObj); 
		        		BasicSummoning.Summon(villagememe, worldObj, posX, posY, posZ);
		        		//villagememe.set
		        		if (rand.nextInt(100) <10) 
		        		{
		        			villagememe.setCustomNameTag("Toby");
		        		}
		        	}
		        	*/
		        		
		        	else if (rand.nextInt(100) <11) 
		        	{ 
		        		this.playSound(MiabSoundEvents.moonman_summon, 1F, 1F);
		        		EntityMoonman moonman = new EntityMoonman(worldObj); 
		        		BasicSummoning.Summon(moonman, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			moonman.setCustomNameTag("Moon Man");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <12) 
		        	{ 
		        		this.playSound(MiabSoundEvents.boi_summon, 1F, 1F);
		        		EntityDatBoi datboi = new EntityDatBoi(worldObj); 
		        		BasicSummoning.Summon(datboi, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			datboi.setCustomNameTag("Dat Boi");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <13) 
		        	{ 
		        		this.playSound(MiabSoundEvents.shrek_summon, 1F, 1F);
		        		EntityShrek shrek = new EntityShrek(worldObj); 
		        		BasicSummoning.Summon(shrek, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			shrek.setCustomNameTag("Shrek");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <14)  
		        	{ 
		        		this.playSound(MiabSoundEvents.robbie_summon, 1F, 1F);
		        		EntityRobbie rotten = new EntityRobbie(worldObj); 
		        		BasicSummoning.Summon(rotten, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			rotten.setCustomNameTag("Robbie Rotten");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <15)  
		        	{ 
		        		this.playSound(MiabSoundEvents.dad_summon, 1F, 1F);
		        		EntityMario7 grand = new EntityMario7(worldObj); 
		        		grand.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
		        		BasicSummoning.Summon(grand, worldObj, posX, posY, posZ);
		        		{
		        			grand.setCustomNameTag("Grand Dad?!");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <16) 
		        	{ 
		        		this.playSound(SoundEvents.ENTITY_CAT_PURR, 1F, 1F);
		        		EntityNyanCat nyancat = new EntityNyanCat(worldObj); 
		        		BasicSummoning.Summon(nyancat, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			nyancat.setCustomNameTag("Nyan Cat");
		        		}
		        		EntityTacNyan tacnyan = new EntityTacNyan(worldObj); 
		        		BasicSummoning.Summon(tacnyan, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			tacnyan.setCustomNameTag("Tac Nyan");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <17) 
		        	{ 
		        		this.playSound(MiabSoundEvents.cry, 1F, 1F);
		        		EntityFA forever = new EntityFA(worldObj); 
		        		BasicSummoning.Summon(forever, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			forever.setCustomNameTag("Forever Alone");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <18) 
		        	{ 
		        		this.playSound(MiabSoundEvents.sanic_slow, 1F, 1F);
		        		EntitySanic sanic = new EntitySanic(worldObj); 
		        		BasicSummoning.Summon(sanic, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			sanic.setCustomNameTag("Sanic");
		        		}
		        	}
		        	
		        	else if (rand.nextInt(100) <19) 
		        	{ 
		        		this.playSound(MiabSoundEvents.leather_belt, 1F, 1F);
		        		worldObj.spawnEntityInWorld(new EntityItem(worldObj, posX + 0.5, posY, posZ, new ItemStack(MIABItems.leather_belt)));
		        	}
		        	else if (rand.nextInt(100) <20) 
		        	{ 			
		        		this.playSound(MiabSoundEvents.ception_spawn, 1F, 1F);
		        		worldObj.spawnEntityInWorld(new EntityItem(worldObj, posX + 0.5, posY, posZ, new ItemStack(MIABItems.splash_meme_in_a_bottle)));
		        	}
	    	 		
		        	else if (rand.nextInt(100) <21) 
		        	{ 			
		        		this.playSound(MiabSoundEvents.dankey_summon, 1F, 1F);
		        		EntityDankey dankey = new EntityDankey(worldObj); 
		        		BasicSummoning.Summon(dankey, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			dankey.setCustomNameTag("Dankey Kang");
		        		}
		        	}
	    	 		
		        	else if (rand.nextInt(100) <22) 
		        	{ 	
		        		this.playSound(MiabSoundEvents.nigel_blagh, 1F, 1F);
		        		EntityNigel nigel = new EntityNigel(worldObj); 
		        		BasicSummoning.Summon(nigel, worldObj, posX, posY, posZ);
		        		if (rand.nextInt(100) <50) 
		        		{
		        			nigel.setCustomNameTag("Nigel Thornberry");
		        		}
		        	}
		    	 	
		        	else if (rand.nextInt(100) <23) 
		        	{ 			
		        		player.addChatMessage(new TextComponentTranslation("memebee.part1"));	
		    	 		player.addChatMessage(new TextComponentTranslation("memebee.part2"));	
		    	 		player.addChatMessage(new TextComponentTranslation("memebee.part3"));	
		    	 		player.addChatMessage(new TextComponentTranslation("memebee.part4"));	
		    	 		player.addChatMessage(new TextComponentTranslation("memebee.part5"));	
		    	 		player.addChatMessage(new TextComponentTranslation("memebee.part6"));
		        	}
		    	 	
		        	else if (rand.nextInt(100) <24) 
		        	{ 			
		        		player.addChatMessage(new TextComponentTranslation("navy.part1"));	
		        		player.addChatMessage(new TextComponentTranslation("navy.part2"));	
		        		player.addChatMessage(new TextComponentTranslation("navy.part3"));	
		        		player.addChatMessage(new TextComponentTranslation("navy.part4"));	
		        		player.addChatMessage(new TextComponentTranslation("navy.part5"));	
		        		player.addChatMessage(new TextComponentTranslation("navy.part6"));
		        	}
		    	 	
		        	else if (rand.nextInt(100) <25) 
		        	{ 			
		        		player.addChatMessage(new TextComponentTranslation("lm.part1"));	
		        		player.addChatMessage(new TextComponentTranslation("lm.part2"));	
		        		player.addChatMessage(new TextComponentTranslation("lm.part3"));	
		        		player.addChatMessage(new TextComponentTranslation("lm.part4"));	
		        		player.addChatMessage(new TextComponentTranslation("lm.part5"));	
		        	}
		    	 	
		        	else if (rand.nextInt(100) <26)
		        	{
		        		player.addChatMessage(new TextComponentTranslation(TextFormatting.DARK_GRAY + "Stormcloak Soldier" + TextFormatting.WHITE + ": I used to be an adventurer like you, then I took an arrow in the knee."));
		        	}
		    	 	
		        	else if(rand.nextInt(100) <27)
		        	{
		        		LennyStructure.buildLenny(worldObj, posX, posY, posZ);
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