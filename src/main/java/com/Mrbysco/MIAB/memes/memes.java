package com.Mrbysco.MIAB.memes;

import java.util.Random;

import com.Mrbysco.MIAB.MemeText;
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
import com.Mrbysco.MIAB.init.MIABVillagers;
import com.Mrbysco.MIAB.init.MiabSoundEvents;
import com.mojang.text2speech.Narrator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class memes {
	
    public static void doMemeStuff(double posX, double posY, double posZ, World world, EntityPlayer player, Entity entity, int RandomValue, boolean canSummon)
    {	
    	Random random;
    	if (canSummon == true)
    	{
	    	if (RandomValue <1 ) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.cena_spawn, 1F, 1F);
	    		EntityCena cena = new EntityCena(world); 
	    		cena.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(cena);
	    		if (RandomValue <50) 
	    		{
	    			cena.setCustomNameTag("John Cena");
	    		}
	    		if(MIABConfig.UseNarator)
	    		{
	    		Narrator.getNarrator().say("And his name is! JOHN CENA");
	    		}
	    		else
	    		{
	        		player.sendMessage(new TextComponentTranslation("cena.itscena"));	
	    		}
	    	}
	
	    	else if (RandomValue <2) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.bill_spawn, 1F, 1F);
	    		EntityBill bill = new EntityBill(world); 
	    		bill.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(bill);
	    		
	    		if (RandomValue <50) 
	    		{
	    			bill.setCustomNameTag("Bill Cipher");
	    		}
	    	}
	    	
	    	else if (RandomValue <3) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.trump_spawn, 1F, 1F);
	    		EntityTrump trump = new EntityTrump(world); 
	    		trump.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(trump);
	    		
	    		if (RandomValue <50) 
	    		{
	    			trump.setCustomNameTag("Donald Drumpf");
	    		}
	    	}
	    	
	    	else if (RandomValue <4) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.khil_spawn, 1F, 1F);
	    		EntityKhil khil = new EntityKhil(world); 
	    		khil.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(khil);
	    		if (RandomValue <50) 
	    		{
	    			khil.setCustomNameTag("Eduard Khil");
	    		}
	    	}
	
	    	else if (RandomValue <5) 
	    	{ 
	    		entity.playSound(SoundEvents.ENTITY_WOLF_HOWL, 1F, 1F);
	    		EntityDoge Doge = new EntityDoge(world); 
	    		Doge.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(Doge);
	    		
	    		if (RandomValue <50) 
	    		{
	    			Doge.setCustomNameTag("Doge");
	    		}
	    	}
	
	    	else if (RandomValue <6)  
	    	{ 
	    		entity.playSound(SoundEvents.ENTITY_CAT_PURR, 1F, 1F);
	    		EntityGrumpy Grumpy = new EntityGrumpy(world); 
	    		Grumpy.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(Grumpy);
	    		
	    		if (RandomValue <50) 
	    		{
	    			Grumpy.setCustomNameTag("Grumpy");
	    		}
	    	}
	    	
	    	else if (RandomValue <7) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.ception_spawn, 1F, 1F);
	    		world.setBlockState(new BlockPos(posX,  posY, posZ), Blocks.CHEST.getDefaultState()); 
	    		TileEntityChest chest = (TileEntityChest) world.getTileEntity(new BlockPos(posX, posY, posZ));
	    		chest.setInventorySlotContents(0, new ItemStack(Blocks.CHEST));
	    		chest.setCustomName("Chestception");
			}
	    	
	    	else if (RandomValue <8) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.ppap_spawn, 1F, 1F);
	    		EntityPpap ppap = new EntityPpap(world); 
	    		ppap.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(ppap);
	    		if (RandomValue <50) 
				{
	    			ppap.setCustomNameTag("Kosaka Daimaou");
				}
			}
	    	
	 		
	 		//Disabled till I figure out how to summon a modded villager
	    	else if (RandomValue <9) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.keyboard_mechanical, 1F, 1F);
	    		EntityVillager villagememe = new EntityVillager(world); 
	    		villagememe.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		villagememe.setProfession(MIABVillagers.toby);
	    		world.spawnEntity(villagememe);
	    		villagememe.setProfession(MIABVillagers.toby);
	    		if (RandomValue <10) 
	    		{
	    			villagememe.setCustomNameTag("Toby");
	    		}
	    	}
	    	
	    	else if (RandomValue <11) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.moonman_summon, 1F, 1F);
	    		EntityMoonman moonman = new EntityMoonman(world); 
	    		moonman.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(moonman);
	    		if (RandomValue <50) 
	    		{
	    			moonman.setCustomNameTag("Moon Man");
	    		}
	    	}
	    	
	    	else if (RandomValue <12) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.boi_summon, 1F, 1F);
	    		EntityDatBoi datboi = new EntityDatBoi(world); 
	    		datboi.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(datboi);
	    		if (RandomValue <50) 
	    		{
	    			datboi.setCustomNameTag("Dat Boi");
	    		}
	    	}
	    	
	    	else if (RandomValue <13) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.shrek_summon, 1F, 1F);
	    		EntityShrek shrek = new EntityShrek(world); 
	    		shrek.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(shrek);
	    		if (RandomValue <50) 
	    		{
	    			shrek.setCustomNameTag("Shrek");
	    		}
	    	}
	    	
	    	else if (RandomValue <14)  
	    	{ 
	    		entity.playSound(MiabSoundEvents.robbie_summon, 1F, 1F);
	    		EntityRobbie rotten = new EntityRobbie(world); 
	    		rotten.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(rotten);
	    		if (RandomValue <50) 
	    		{
	    			rotten.setCustomNameTag("Robbie Rotten");
	    		}
	    	}
	    	
	    	else if (RandomValue <15)  
	    	{ 
	    		entity.playSound(MiabSoundEvents.dad_summon, 1F, 1F);
	    		EntityMario7 grand = new EntityMario7(world); 
	    		grand.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(grand);
	    		if (RandomValue <50) 
	    		{
	    			grand.setCustomNameTag("Grand Dad?!");
	    		}
	    	}
	    	
	    	else if (RandomValue <16) 
	    	{ 
	    		entity.playSound(SoundEvents.ENTITY_CAT_PURR, 1F, 1F);
	    		EntityNyanCat nyancat = new EntityNyanCat(world); 
	    		nyancat.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(nyancat);
	    		if (RandomValue <50) 
	    		{
	    			nyancat.setCustomNameTag("Nyan Cat");
	    		}
	    		EntityTacNyan tacnyan = new EntityTacNyan(world); 
	    		tacnyan.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(tacnyan);
	    		if (RandomValue <50) 
	    		{
	    			tacnyan.setCustomNameTag("Tac Nyan");
	    		}
	    	}
	    	
	    	else if (RandomValue <17) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.cry, 1F, 1F);
	    		EntityFA forever = new EntityFA(world); 
	    		forever.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(forever);
	    		if (RandomValue <50) 
	    		{
	    			forever.setCustomNameTag("Forever Alone");
	    		}
	    	}
	    	
	    	else if (RandomValue <18) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.sanic_slow, 1F, 1F);
	    		EntitySanic sanic = new EntitySanic(world); 
	    		sanic.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(sanic);
	    		if (RandomValue <50) 
	    		{
	    			sanic.setCustomNameTag("Sanic");
	    		}
	    	}
	    	
	    	else if (RandomValue <19) 
	    	{ 
	    		entity.playSound(MiabSoundEvents.leather_belt, 1F, 1F);
	    		world.spawnEntity(new EntityItem(world, posX + 0.5, posY, posZ, new ItemStack(MIABItems.leather_belt)));
	    	}
	    	else if (RandomValue <20) 
	    	{ 			
	    		entity.playSound(MiabSoundEvents.ception_spawn, 1F, 1F);
	    		world.spawnEntity(new EntityItem(world, posX + 0.5, posY, posZ, new ItemStack(MIABItems.splash_meme_in_a_bottle)));
	    	}
	 		
	    	else if (RandomValue <21) 
	    	{ 			
	    		entity.playSound(MiabSoundEvents.dankey_summon, 1F, 1F);
	    		EntityDankey dankey = new EntityDankey(world); 
	    		dankey.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(dankey);
	    		if (RandomValue <50) 
	    		{
	    			dankey.setCustomNameTag("Dankey Kang");
	    		}
	    	}
	 		
	    	else if (RandomValue <22) 
	    	{ 	
	    		entity.playSound(MiabSoundEvents.nigel_blagh, 1F, 1F);
	    		EntityNigel nigel = new EntityNigel(world); 
	    		nigel.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
	    		world.spawnEntity(nigel);
	    		if (RandomValue <50) 
	    		{
	    			nigel.setCustomNameTag("Nigel Thornberry");
	    		}
	    	}
    	}
    	else if (RandomValue <23) 
    	{
    		if(MIABConfig.UseNarator)
    		{
    			Narrator.getNarrator().say(MemeText.memebee_part);
    		}
    		else
    		{
    			player.sendMessage(new TextComponentTranslation("memebee.part1"));	
    	 		player.sendMessage(new TextComponentTranslation("memebee.part2"));	
    	 		player.sendMessage(new TextComponentTranslation("memebee.part3"));	
    	 		player.sendMessage(new TextComponentTranslation("memebee.part4"));	
    	 		player.sendMessage(new TextComponentTranslation("memebee.part5"));	
    	 		player.sendMessage(new TextComponentTranslation("memebee.part6"));
    		}
    		
    	}
	 	
    	else if (RandomValue <24) 
    	{
    		if(MIABConfig.UseNarator)
    		{
    			Narrator.getNarrator().say(MemeText.navy_part);
    		}
    		else
    		{
    			player.sendMessage(new TextComponentTranslation("navy.part1"));	
        		player.sendMessage(new TextComponentTranslation("navy.part2"));	
        		player.sendMessage(new TextComponentTranslation("navy.part3"));	
        		player.sendMessage(new TextComponentTranslation("navy.part4"));	
        		player.sendMessage(new TextComponentTranslation("navy.part5"));	
        		player.sendMessage(new TextComponentTranslation("navy.part6"));
    		}
    	}
		else if (RandomValue <25) 
		{
			if(MIABConfig.UseNarator)
			{
				Narrator.getNarrator().say(MemeText.lm_part);
			}
			else
			{
				player.sendMessage(new TextComponentTranslation("lm.part1"));	
				player.sendMessage(new TextComponentTranslation("lm.part2"));	
				player.sendMessage(new TextComponentTranslation("lm.part3"));	
				player.sendMessage(new TextComponentTranslation("lm.part4"));	
				player.sendMessage(new TextComponentTranslation("lm.part5"));	
			}
			
		}
		else if(MIABConfig.MatureSounds)
    	{
			entity.playSound(MiabSoundEvents.meme_soundMature ,1F,1F);
    	}
    	else
    	{
    		entity.playSound(MiabSoundEvents.meme_sound, 1F, 1F);
    	}
    }
}
