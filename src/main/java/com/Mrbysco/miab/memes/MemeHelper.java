package com.Mrbysco.miab.memes;

import java.util.Random;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.config.MemeConfigGen;
import com.Mrbysco.miab.entities.boss.EntityMemeBigBoss;
import com.Mrbysco.miab.entities.hostile.EntityBill;
import com.Mrbysco.miab.entities.hostile.EntityCena;
import com.Mrbysco.miab.entities.hostile.EntityDankey;
import com.Mrbysco.miab.entities.hostile.EntityDatBoi;
import com.Mrbysco.miab.entities.hostile.EntityFA;
import com.Mrbysco.miab.entities.hostile.EntityHeMan;
import com.Mrbysco.miab.entities.hostile.EntityHotDog;
import com.Mrbysco.miab.entities.hostile.EntityKhil;
import com.Mrbysco.miab.entities.hostile.EntityMario7;
import com.Mrbysco.miab.entities.hostile.EntityMoonman;
import com.Mrbysco.miab.entities.hostile.EntityNigel;
import com.Mrbysco.miab.entities.hostile.EntityPpap;
import com.Mrbysco.miab.entities.hostile.EntityRoadmanShaq;
import com.Mrbysco.miab.entities.hostile.EntityRobbie;
import com.Mrbysco.miab.entities.hostile.EntitySanic;
import com.Mrbysco.miab.entities.hostile.EntityShrek;
import com.Mrbysco.miab.entities.hostile.EntitySkywalker;
import com.Mrbysco.miab.entities.hostile.EntityTacNyan;
import com.Mrbysco.miab.entities.hostile.EntityTrump;
import com.Mrbysco.miab.entities.passive.EntityClippy;
import com.Mrbysco.miab.entities.passive.EntityDoge;
import com.Mrbysco.miab.entities.passive.EntityGrumpy;
import com.Mrbysco.miab.entities.passive.EntityNyanCat;
import com.Mrbysco.miab.gui.GuiFakeOver;
import com.Mrbysco.miab.gui.MemeGui;
import com.Mrbysco.miab.init.MemeItems;
import com.Mrbysco.miab.init.MemeSounds;
import com.Mrbysco.miab.init.MemeVillagers;
import com.mojang.text2speech.Narrator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class MemeHelper {
	
	public static void SpawnRandomMeme(World world, BlockPos pos, EntityPlayer player, Entity entity) {
		int randomValue = new Random().nextInt(47);
		if (!world.isRemote)
	    {
			switch(randomValue)
			{
			    case 0:
			    	spawnEntity(world, new EntityCena(world), pos, MemeSounds.cena_spawn);
				        if(MemeConfigGen.general.UseNarator)
			    		{
				        	Narrator.getNarrator().say("And his name is! JOHN CENA");
			    		}
			    		else
			    		{
			        		player.sendMessage(new TextComponentTranslation("cena.itscena"));	
			    		}
			        break;
			    case 1:
			    	spawnEntity(world, new EntityBill(world), pos, MemeSounds.bill_spawn);
			        break;
			    case 2:
			    	spawnEntity(world, new EntityTrump(world), pos, MemeSounds.trump_spawn);
			        break;
			    case 3:
			    	spawnEntity(world, new EntityKhil(world), pos, MemeSounds.khil_spawn);
			    	break;
			    case 4:
			    	spawnEntity(world, new EntityDoge(world), pos, SoundEvents.ENTITY_WOLF_GROWL);
			    	break;
			    case 5:
			    	spawnEntity(world, new EntityGrumpy(world), pos, SoundEvents.ENTITY_CAT_PURR);
			    	break;
			    case 6:
			    	entity.playSound(MemeSounds.ception_spawn, 1F, 1F);
		    		world.setBlockState(pos, Blocks.CHEST.getDefaultState()); 
		    		TileEntityChest chest = (TileEntityChest) world.getTileEntity(pos);
		    		chest.setInventorySlotContents(0, new ItemStack(Blocks.CHEST));
		    		chest.setCustomName("Chestception");
			    	break;
			    case 7:
			    	spawnEntity(world, new EntityPpap(world), pos, MemeSounds.ppap_spawn);
			    	break;
			    case 8:
			    	entity.playSound(MemeSounds.keyboard_mechanical, 1F, 1F);
		    		EntityVillager villagememe = new EntityVillager(world); 
		    		villagememe.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0,0); 
		    		villagememe.setProfession(MemeVillagers.toby);
		    		world.spawnEntity(villagememe);
		    		villagememe.setProfession(MemeVillagers.toby);
		    		villagememe.setCustomNameTag("Toby");
			    	break;
			    case 9:
			    	spawnEntity(world, new EntityMoonman(world), pos, MemeSounds.moonman_summon);
			    	break;
			    case 10:
			    	spawnEntity(world, new EntityDatBoi(world), pos, MemeSounds.boi_summon);
			    	break;
			    case 12:
			    	spawnEntity(world, new EntityShrek(world), pos, MemeSounds.shrek_summon);
			    	break;
			    case 13:
			    	spawnEntity(world, new EntityRobbie(world), pos, MemeSounds.robbie_summon);
			    	break;
			    case 14:
			    	spawnEntity(world, new EntityMario7(world), pos, MemeSounds.dad_summon);
			    	break;
			    case 15:
			    	spawnEntity(world, new EntityNyanCat(world), pos, SoundEvents.ENTITY_CAT_AMBIENT);
			    	spawnEntity(world, new EntityTacNyan(world), pos, SoundEvents.ENTITY_CAT_HISS);
			    	break;
			    case 16:
			    	spawnEntity(world, new EntityFA(world), pos);
			    	break;
			    case 17:
			    	spawnEntity(world, new EntitySanic(world), pos, MemeSounds.sanic_slow);
			    	break;
			    case 18:
			    	entity.playSound(MemeSounds.leather_belt, 1F, 1F);
		    		world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(MemeItems.leather_belt)));
			    	break;
			    case 19:
			    	entity.playSound(MemeSounds.ception_spawn, 1F, 1F);
		    		world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(MemeItems.splash_meme_in_a_bottle)));
			    	break;
			    case 20:
			    	spawnEntity(world, new EntityDankey(world), pos, MemeSounds.dankey_summon);
			    	break;
			    case 21:
			    	spawnEntity(world, new EntityNigel(world), pos, MemeSounds.nigel_blagh);
			    	break;
			    case 22:
			    	spawnEntity(world, new EntitySkywalker(world), pos, MemeSounds.skywalker_sand);
			    	break;
			    case 23:
			    	if(MemeConfigGen.general.UseNarator == true)
		    		{
		    			Narrator.getNarrator().say(MemeNarratorTexts.dangerous);
		    		}
		    		else
		    		{
		    			player.sendMessage(new TextComponentTranslation("dangerous"));	
		    		}
			    	ItemStack sword = new ItemStack(Items.WOODEN_SWORD);
			    	world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), sword));
		    		sword.setStackDisplayName("Zelda Sword");
		    		break;
			    case 24:
			    	entity.playSound(MemeSounds.pills, 1F, 1F);
			    	world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(MemeItems.pills_here)));
			    	break;
			    case 25:
			    	if(MemeConfigGen.general.UseNarator == true)
		    		{
		    			Narrator.getNarrator().say(MemeNarratorTexts.ykwtd);
		    		}
		    		else
		    		{
		    			player.sendMessage(new TextComponentTranslation("message.ykwtd"));	
		    		}
			    	world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(MemeItems.fidget)));
			    	break;
			    case 26:
			    	if(MemeConfigGen.general.UseNarator == true)
		    		{
		    			Narrator.getNarrator().say(MemeNarratorTexts.ykwtd);
		    		}
		    		else
		    		{
		    			player.sendMessage(new TextComponentTranslation("message.ykwtd"));	
		    		}
			    	world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(MemeItems.knife)));
			    	break;
			    case 27:
			    	if(MemeConfigGen.general.UseNarator == true)
		    		{
		    			Narrator.getNarrator().say(MemeNarratorTexts.memebee_part);
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
			    	break;
			    case 28:
			    	if(MemeConfigGen.general.UseNarator == true)
		    		{
		    			Narrator.getNarrator().say(MemeNarratorTexts.navy_part);
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
			    	break;
			    case 29:
			    	if(MemeConfigGen.general.UseNarator == true)
					{
						Narrator.getNarrator().say(MemeNarratorTexts.lm_part);
					}
					else
					{
						player.sendMessage(new TextComponentTranslation("lm.part1"));	
						player.sendMessage(new TextComponentTranslation("lm.part2"));	
						player.sendMessage(new TextComponentTranslation("lm.part3"));	
						player.sendMessage(new TextComponentTranslation("lm.part4"));	
						player.sendMessage(new TextComponentTranslation("lm.part5"));	
					}
			    	break;
			    case 30:
			    	spawnEntity(world, new EntityRoadmanShaq(world), pos, MemeSounds.shaq_summon);
			    	break;
			    case 31:
			    	world.playSound(null, pos, MemeSounds.wasted, SoundCategory.NEUTRAL, 1f, 1f);
			    	if ((player instanceof EntityPlayerMP))
	    	        {
	    	          SPacketTitle packet = new SPacketTitle(SPacketTitle.Type.TITLE, new TextComponentString("WASTED").setStyle(new Style().setColor(TextFormatting.RED).setBold(true)), 5, 60, 20);
	    	          ((EntityPlayerMP)player).connection.sendPacket(packet);
	    	        }
			    	break;
			    case 32:
			    	world.playSound(null, pos, MemeSounds.wasted, SoundCategory.NEUTRAL, 1f, 1f);
			    	break;
			    case 33:
			    	world.playSound(null, pos, MemeSounds.doot, SoundCategory.NEUTRAL, 1f, 1f);
			    	world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(MemeItems.trumpet)));
			    	break;
			    case 45:
			    	spawnEntity(world, new EntityMemeBigBoss(world), pos, MemeSounds.big_boi);
			    	break;
			    case 46:
			    	spawnEntity(world, new EntityHotDog(world), pos, MemeSounds.hotdog_full);
			    	break;
			    case 47:
			    	spawnEntity(world, new EntityHeMan(world), pos, MemeSounds.heman_spawn);
			    	break;
			    case 48:
			    	spawnEntity(world, new EntityClippy(world), pos);
			    	break;
			    	
			    default:
	                break;
			}
	    }
		else
	    {
			ResourceLocation meme = new ResourceLocation("memeinabottle:textures/items/splash_meme_in_a_bottle.png");
			
	        switch(randomValue)
	        {
	        case 32:
	        	MemeInABottle.proxy.displayClientGui(new GuiFakeOver(new TextComponentTranslation("death.attack.generic", new Object[] {"You"})));
	        	break;
	        case 34:
				meme = new ResourceLocation("memeinabottle:textures/meme/allthethings.png");
				MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
				break;
		    case 35:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/gentleman.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    case 36:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/kidmeme.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    case 37:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/lelenny.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    case 38:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/megusta.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    case 39:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/bp.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    case 40:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/skeleton.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    case 41:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/sponge.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    case 42:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/trollface.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    case 43:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/needram.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    case 44:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/dawge.png");
		    	MemeInABottle.proxy.displayClientGui(new MemeGui(meme));
		    	break;
		    	
	            default:
	                break;
	        }
	    }
	}
	
	private static void spawnEntity(World world, Entity entity, BlockPos pos, SoundEvent sound) {
		
		world.playSound(null, pos, sound, SoundCategory.NEUTRAL, 1f, 1f);
		
		entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
		world.spawnEntity(entity);
	}
	
	private static void spawnEntity(World world, Entity entity, BlockPos pos) {
		entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
		world.spawnEntity(entity);
	}
	
	public static ResourceLocation RandomMemeLocation() {
		ResourceLocation meme = new ResourceLocation("memeinabottle:textures/items/splash_meme_in_a_bottle.png");
		int randomValue = new Random().nextInt(10);
		switch(randomValue)
		{
			case 0:
				meme = new ResourceLocation("memeinabottle:textures/meme/allthethings.png");
				break;
		    case 1:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/gentleman.png");
		    	break;
		    case 2:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/kidmeme.png");
		    	break;
		    case 3:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/lelenny.png");
		    	break;
		    case 4:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/megusta.png");
		    	break;
		    case 5:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/bp.png");
		    	break;
		    case 6:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/skeleton.png");
		    	break;
		    case 7:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/sponge.png");
		    	break;
		    case 8:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/trollface.png");
		    	break;
		    case 9:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/needram.png");
		    	break;
		    case 10:
		    	meme = new ResourceLocation("memeinabottle:textures/meme/dawge.png");
		    	break;
		}
		return meme;
	}
}
