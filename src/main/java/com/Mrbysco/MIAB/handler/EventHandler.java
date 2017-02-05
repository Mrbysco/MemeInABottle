package com.Mrbysco.MIAB.handler;

import com.Mrbysco.MIAB.entity.monsters.EntityBill;
import com.Mrbysco.MIAB.entity.monsters.EntityCena;
import com.Mrbysco.MIAB.entity.monsters.EntityDatBoi;
import com.Mrbysco.MIAB.entity.monsters.EntityKhil;
import com.Mrbysco.MIAB.entity.monsters.EntityMoonman;
import com.Mrbysco.MIAB.entity.monsters.EntityPpap;
import com.Mrbysco.MIAB.entity.monsters.EntityShrek;
import com.Mrbysco.MIAB.entity.monsters.EntityTrump;
import com.Mrbysco.MIAB.init.MIABConfig;
import com.Mrbysco.MIAB.init.MIABItems;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	public static double random_drop;
	public static double random_chance;
    public static int dropped;
	
	@SubscribeEvent
	public void onLivingDrop(LivingDropsEvent event) {
		if (event.getEntity() instanceof EntityCena) {
			random_drop = Math.random();
            if ( random_drop < MIABConfig.DropChance )
            {
            	ItemStack itemStackToDrop = new ItemStack(MIABItems.mcw_belt, 1);
            	event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
            			
            		event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
            }
		}
		if (event.getEntity() instanceof EntityBill) {
			random_drop = Math.random();
            if ( random_drop < MIABConfig.DropChance )
            {
            	ItemStack itemStackToDrop = new ItemStack(Items.GOLD_INGOT, 1);
            	event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
            			
            		event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
            }
		}
		if (event.getEntity() instanceof EntityKhil) {
			random_drop = Math.random();
            if ( random_drop < MIABConfig.DropChance )
            {
            	ItemStack itemStackToDrop = new ItemStack(MIABItems.troll_mask, 1);
            	event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
            			
            		event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
            }
		}
		
		//PPAP
		if (event.getEntity() instanceof EntityPpap) {
			random_chance = Math.random();
            if ( random_chance < 0.6)
            {
            	ItemStack itemStackToDrop = new ItemStack(MIABItems.pen, 1);
            	event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
            			
            		event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
            }

            if (random_chance < 0.7)
            {
            	ItemStack itemStackToDrop = new ItemStack(MIABItems.pen, 1);
            	event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
            			
            			event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
            }
            if (random_chance < 0.5)
            {
            	ItemStack itemStackToDrop = new ItemStack(MIABItems.pen, 1);
            	event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
            			
            			event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
            }
         }
		
        if (event.getEntity() instanceof EntityTrump) {
			random_drop = Math.random();
            if ( random_drop < MIABConfig.DropChance )
            {
            	ItemStack itemStackToDrop = new ItemStack(MIABItems.trump_hair, 1);
            	event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
            			
            		event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
            }
        }
        
        if (event.getEntity() instanceof EntityDatBoi) {
        	random_drop = Math.random();
        	if ( random_drop < MIABConfig.DropChance )
        	{
        		ItemStack itemStackToDrop = new ItemStack(Items.SLIME_BALL, 1);
        		event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
        				
        				event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
        	}
        }
        
        /*
        if (event.getEntity() instanceof EntityShrek) {
        	random_drop = Math.random();
        	if ( random_drop < MIABConfig.DropChance )
        	{
        		ItemStack itemStackToDrop = new ItemStack(MIABItems.onion, 1);
        		event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
        				
        				event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
        	}
        }
        
        if (event.getEntity() instanceof EntityMoonman) {
        	random_drop = Math.random();
        	if ( random_drop < MIABConfig.DropChance )
        	{
        		ItemStack itemStackToDrop = new ItemStack(MIABItems.mineburger, 1);
        		event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
        				
        				event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
        	}
        }
        
        */
        
	}
}