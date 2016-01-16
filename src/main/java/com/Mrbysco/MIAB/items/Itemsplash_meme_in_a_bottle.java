package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.entity.EntityMeme;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class Itemsplash_meme_in_a_bottle extends Item {

	public Itemsplash_meme_in_a_bottle()
    {
        this.maxStackSize = 8;
    }
	    /**
	     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	     */
	    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {
	        if (!playerIn.capabilities.isCreativeMode)
	        {
	            --itemStackIn.stackSize;
	        }

	        worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	        if (!worldIn.isRemote)
	        {
	            worldIn.spawnEntityInWorld(new EntityMeme(worldIn, playerIn));
	        }

	        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
	        return itemStackIn;
	    }
	}