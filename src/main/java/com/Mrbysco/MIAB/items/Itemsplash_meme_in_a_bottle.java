package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.entity.EntityMeme;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class Itemsplash_meme_in_a_bottle extends Item {

	public Itemsplash_meme_in_a_bottle()
    {
        this.maxStackSize = 8;
        setUnlocalizedName(Reference.MIABItems.SPLASHMEMEINABOTTLE.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.SPLASHMEMEINABOTTLE.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
    }

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
        	EntityMeme entitymeme = new EntityMeme(worldIn, playerIn);
        	entitymeme.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.5F, 1.0F);
            worldIn.spawnEntity(entitymeme);
        }

        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
}