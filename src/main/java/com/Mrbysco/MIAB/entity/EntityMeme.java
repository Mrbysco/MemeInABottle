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
import com.Mrbysco.MIAB.init.MIABVillagers;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

    public static void registerFixesMeme(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "Meme");
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.NOTE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {	
        	
			if (rand.nextInt(100) <1) 
        	{ 
        		this.playSound(MiabSoundEvents.cena_spawn, 1F, 1F);
        		EntityCena cena = new EntityCena(world); 
        		cena.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(cena);
        		if (rand.nextInt(100) <50) 
        		{
        			cena.setCustomNameTag("John Cena");
        		}
        	}

        	else if (rand.nextInt(100) <2) 
        	{ 
        		this.playSound(MiabSoundEvents.bill_spawn, 1F, 1F);
        		EntityBill bill = new EntityBill(world); 
        		bill.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(bill);
        		
        		if (rand.nextInt(100) <50) 
        		{
        			bill.setCustomNameTag("Bill Cipher");
        		}
        	}
        	
        	else if (rand.nextInt(100) <3) 
        	{ 
        		this.playSound(MiabSoundEvents.trump_spawn, 1F, 1F);
        		EntityTrump trump = new EntityTrump(world); 
        		trump.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(trump);
        		
        		if (rand.nextInt(100) <50) 
        		{
        			trump.setCustomNameTag("Donald Drumpf");
        		}
        	}
        	
        	else if (rand.nextInt(100) <4) 
        	{ 
        		this.playSound(MiabSoundEvents.khil_spawn, 1F, 1F);
        		EntityKhil khil = new EntityKhil(world); 
        		khil.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(khil);
        		if (rand.nextInt(100) <50) 
        		{
        			khil.setCustomNameTag("Eduard Khil");
        		}
        	}

        	else if (rand.nextInt(100) <5) 
        	{ 
        		this.playSound(SoundEvents.ENTITY_WOLF_HOWL, 1F, 1F);
        		EntityDoge Doge = new EntityDoge(world); 
        		Doge.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(Doge);
        		
        		if (rand.nextInt(100) <50) 
        		{
        			Doge.setCustomNameTag("Doge");
        		}
        	}

        	else if (rand.nextInt(100) <6)  
        	{ 
        		this.playSound(SoundEvents.ENTITY_CAT_PURR, 1F, 1F);
        		EntityGrumpy Grumpy = new EntityGrumpy(world); 
        		Grumpy.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(Grumpy);
        		
        		if (rand.nextInt(100) <50) 
        		{
        			Grumpy.setCustomNameTag("Grumpy");
        		}
        	}
        	
        	else if (rand.nextInt(100) <7) 
        	{ 
        		this.playSound(MiabSoundEvents.ception_spawn, 1F, 1F);
        		world.setBlockState(new BlockPos(posX,  posY, posZ), Blocks.CHEST.getDefaultState()); 
        		TileEntityChest chest = (TileEntityChest) world.getTileEntity(new BlockPos(posX, posY, posZ));
        		chest.setInventorySlotContents(0, new ItemStack(Blocks.CHEST));
        		chest.setCustomName("Chestception");
    		}
        	
        	else if (rand.nextInt(100) <8) 
        	{ 
        		this.playSound(MiabSoundEvents.ppap_spawn, 1F, 1F);
        		EntityPpap ppap = new EntityPpap(world); 
        		ppap.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(ppap);
        		if (rand.nextInt(100) <50) 
				{
        			ppap.setCustomNameTag("Kosaka Daimaou");
				}
    		}
        	
	 		
	 		//Disabled till I figure out how to summon a modded villager
        	else if (rand.nextInt(100) <9) 
        	{ 
        		this.playSound(MiabSoundEvents.keyboard_mechanical, 1F, 1F);
        		EntityVillager villagememe = new EntityVillager(world); 
        		villagememe.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		villagememe.setProfession(MIABVillagers.toby);
        		world.spawnEntity(villagememe);
        		villagememe.setProfession(MIABVillagers.toby);
        		if (rand.nextInt(100) <10) 
        		{
        			villagememe.setCustomNameTag("Toby");
        		}
        	}
        	
        	else if (rand.nextInt(100) <11) 
        	{ 
        		this.playSound(MiabSoundEvents.moonman_summon, 1F, 1F);
        		EntityMoonman moonman = new EntityMoonman(world); 
        		moonman.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(moonman);
        		if (rand.nextInt(100) <50) 
        		{
        			moonman.setCustomNameTag("Moon Man");
        		}
        	}
        	
        	else if (rand.nextInt(100) <12) 
        	{ 
        		this.playSound(MiabSoundEvents.boi_summon, 1F, 1F);
        		EntityDatBoi datboi = new EntityDatBoi(world); 
        		datboi.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(datboi);
        		if (rand.nextInt(100) <50) 
        		{
        			datboi.setCustomNameTag("Dat Boi");
        		}
        	}
        	
        	else if (rand.nextInt(100) <13) 
        	{ 
        		this.playSound(MiabSoundEvents.shrek_summon, 1F, 1F);
        		EntityShrek shrek = new EntityShrek(world); 
        		shrek.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(shrek);
        		if (rand.nextInt(100) <50) 
        		{
        			shrek.setCustomNameTag("Shrek");
        		}
        	}
        	
        	else if (rand.nextInt(100) <14)  
        	{ 
        		this.playSound(MiabSoundEvents.robbie_summon, 1F, 1F);
        		EntityRobbie rotten = new EntityRobbie(world); 
        		rotten.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(rotten);
        		if (rand.nextInt(100) <50) 
        		{
        			rotten.setCustomNameTag("Robbie Rotten");
        		}
        	}
        	
        	else if (rand.nextInt(100) <15)  
        	{ 
        		this.playSound(MiabSoundEvents.dad_summon, 1F, 1F);
        		EntityMario7 grand = new EntityMario7(world); 
        		grand.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(grand);
        		if (rand.nextInt(100) <50) 
        		{
        			grand.setCustomNameTag("Grand Dad?!");
        		}
        	}
        	
        	else if (rand.nextInt(100) <16) 
        	{ 
        		this.playSound(SoundEvents.ENTITY_CAT_PURR, 1F, 1F);
        		EntityNyanCat nyancat = new EntityNyanCat(world); 
        		nyancat.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(nyancat);
        		if (rand.nextInt(100) <50) 
        		{
        			nyancat.setCustomNameTag("Nyan Cat");
        		}
        		EntityTacNyan tacnyan = new EntityTacNyan(world); 
        		tacnyan.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(tacnyan);
        		if (rand.nextInt(100) <50) 
        		{
        			tacnyan.setCustomNameTag("Tac Nyan");
        		}
        	}
        	
        	else if (rand.nextInt(100) <17) 
        	{ 
        		this.playSound(MiabSoundEvents.cry, 1F, 1F);
        		EntityFA forever = new EntityFA(world); 
        		forever.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(forever);
        		if (rand.nextInt(100) <50) 
        		{
        			forever.setCustomNameTag("Forever Alone");
        		}
        	}
        	
        	else if (rand.nextInt(100) <18) 
        	{ 
        		this.playSound(MiabSoundEvents.sanic_slow, 1F, 1F);
        		EntitySanic sanic = new EntitySanic(world); 
        		sanic.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(sanic);
        		if (rand.nextInt(100) <50) 
        		{
        			sanic.setCustomNameTag("Sanic");
        		}
        	}
        	
        	else if (rand.nextInt(100) <19) 
        	{ 
        		this.playSound(MiabSoundEvents.leather_belt, 1F, 1F);
        		world.spawnEntity(new EntityItem(world, posX + 0.5, posY, posZ, new ItemStack(MIABItems.leather_belt)));
        	}
        	else if (rand.nextInt(100) <20) 
        	{ 			
        		this.playSound(MiabSoundEvents.ception_spawn, 1F, 1F);
        		world.spawnEntity(new EntityItem(world, posX + 0.5, posY, posZ, new ItemStack(MIABItems.splash_meme_in_a_bottle)));
        	}
	 		
        	else if (rand.nextInt(100) <21) 
        	{ 			
        		this.playSound(MiabSoundEvents.dankey_summon, 1F, 1F);
        		EntityDankey dankey = new EntityDankey(world); 
        		dankey.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(dankey);
        		if (rand.nextInt(100) <50) 
        		{
        			dankey.setCustomNameTag("Dankey Kang");
        		}
        	}
	 		
        	else if (rand.nextInt(100) <22) 
        	{ 	
        		this.playSound(MiabSoundEvents.nigel_blagh, 1F, 1F);
        		EntityNigel nigel = new EntityNigel(world); 
        		nigel.setLocationAndAngles(posX + 0.5, posY, posZ + 0.5, 0,0); 
        		world.spawnEntity(nigel);
        		if (rand.nextInt(100) <50) 
        		{
        			nigel.setCustomNameTag("Nigel Thornberry");
        		}
        	}
			

    	 	else if(MIABConfig.MatureSounds)
        	{
        		this.playSound(MiabSoundEvents.meme_soundMature ,1F,1F);
        	}
        	else
        	{
        		this.playSound(MiabSoundEvents.meme_sound, 1F, 1F);
        	}
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }
}