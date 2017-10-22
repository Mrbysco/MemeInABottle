package com.Mrbysco.miab.handlers;

import java.util.Random;

import org.apache.logging.log4j.Logger;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.entities.hostile.EntityShrek;
import com.Mrbysco.miab.entities.passive.EntityClippy;
import com.Mrbysco.miab.init.MemeItems;
import com.Mrbysco.miab.init.MemeSounds;
import com.Mrbysco.miab.memes.MemeHelper;
import com.Mrbysco.miab.memes.MemeLists;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;

public class MemeEventHandlers {

	private static final Logger logger = MemeInABottle.logger;
	
	@SubscribeEvent
	public void OnBlockInteraction(PlayerInteractEvent.RightClickBlock event) {
		ItemStack itemStack = event.getItemStack();
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		EntityPlayer player = event.getEntityPlayer();
		Block block = world.getBlockState(pos).getBlock();
		
		if(!world.isRemote)
		{
			if (world.getBiome(pos) == Biomes.BEACH)
			{
				if(block == Blocks.SAND)
				{
					if(itemStack == ItemStack.EMPTY)
					{
						int random = world.rand.nextInt(1000);
	
						if(random < 10)
						{
							world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), MemeLists.getRandomMemeBottle()));
						}
					}
					if(itemStack.getItem() instanceof ItemSpade)
					{
						ItemTool item = (ItemTool)itemStack.getItem();
						int itemDamage = itemStack.getItemDamage();
						
						int random = world.rand.nextInt(1000);
	
						if(random < 30) {
							world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), MemeLists.getRandomMemeBottle()));
							itemStack.setItemDamage(itemDamage + 1);
						}
					}
				}
			}
			
			if(itemStack.getItem() == MemeItems.clippy)
			{
				EntityClippy clippy = new EntityClippy(world);
				clippy.setPositionAndUpdate(pos.getX(), pos.getY() + 1, pos.getZ());
				world.spawnEntity(clippy);
				
				if (!player.isCreative())
				{
					itemStack.shrink(1);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onTrumpetInteraction(EntityInteract event)
	{
		EntityPlayer player = event.getEntityPlayer();
		ItemStack itemstack = event.getItemStack();
		Entity entity = event.getTarget();
		
		if(entity instanceof EntitySkeleton && itemstack.getItem() == MemeItems.trumpet)
		{
			EntitySkeleton hitSkeleton = (EntitySkeleton)entity; 
			ItemStack skeletonItem = hitSkeleton.getHeldItem(EnumHand.MAIN_HAND);
			
			if(skeletonItem.getItem() == Items.BOW && player.getHeldItem(EnumHand.MAIN_HAND).getItem() == MemeItems.trumpet)
			{
				hitSkeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(MemeItems.trumpet));
				hitSkeleton.setDropChance(EntityEquipmentSlot.MAINHAND, 1F);
				
				if(!player.isCreative())
				{
					player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onSkeletonSpawn(LivingSpawnEvent event)
	{
		Entity entity = event.getEntity();
		World world = event.getWorld();
		
		if(entity instanceof EntitySkeleton)
		{
			EntitySkeleton skeleton = (EntitySkeleton)entity;
			int random = world.rand.nextInt(100);
			if (random == 1)
			{
				skeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(MemeItems.trumpet));
				skeleton.playSound(MemeSounds.doot, 1F, 1F);
			}
		}
	}
	
	@SubscribeEvent
	public void onLootTableLoad(LootTableLoadEvent event)
	{
		if(event.getName().equals(LootTableList.ENTITIES_SKELETON))
		{
			final LootPool trumpet = event.getTable().getPool("trumpet");
			 
	        if (trumpet != null)
	        	trumpet.addEntry(new LootEntryItem(MemeItems.trumpet, 1, 0, new LootFunction[0], new LootCondition[0], "memeinabottle:trumpet"));
		}
	}
	
	@SubscribeEvent
	public void onTick(TickEvent.WorldTickEvent event)
	{
		if(event.phase == Phase.END && event.side == Side.SERVER) {
			for(Entity entity : event.world.getEntities(Entity.class, EntitySelectors.IS_ALIVE)) {
				if(entity instanceof EntityAreaEffectCloud && entity.getCustomNameTag() == "dankcloud") {
					World world = event.world;
					EntityPlayer player = world.getClosestPlayerToEntity(entity, 20);

					int random = world.rand.nextInt(1000);

					if(random < 8) 
					{
						EntityAreaEffectCloud cloud = (EntityAreaEffectCloud)entity;
						BlockPos pos = entity.getPosition();
						Random rand = new Random();
						int radius = (int) cloud.getRadius();
						
						pos.add(-radius + rand.nextInt((radius * 2) + 1), 0, -radius + rand.nextInt((radius * 2) + 1));
						MemeHelper.SpawnRandomMeme(world, pos, player, entity);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event)
	{
		Entity entity = event.getEntity();
		World world = entity.getEntityWorld();
		BlockPos pos = entity.getPosition();
		
		if(entity instanceof EntityShrek)
		{
			EntityDonkey donkey = new EntityDonkey(world);
			
			donkey.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
			world.spawnEntity(donkey);
		}
	}
}
