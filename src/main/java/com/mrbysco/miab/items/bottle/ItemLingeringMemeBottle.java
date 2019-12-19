package com.mrbysco.miab.items.bottle;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.projectile.EntitySplashMeme;
import com.mrbysco.miab.items.ItemMemeBase;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemLingeringMemeBottle extends ItemMemeBase {

	public ItemLingeringMemeBottle(String registry) {
		super(registry);
		setMaxStackSize(8);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
        ItemStack stack1 = playerIn.capabilities.isCreativeMode ? itemstack.copy() : itemstack.splitStack(1);
        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_LINGERINGPOTION_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));        
        
        if (!worldIn.isRemote) {
        	EntitySplashMeme entitymeme = new EntitySplashMeme(worldIn, playerIn, stack1);
        	entitymeme.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.5F, 1.0F);
            worldIn.spawnEntity(entitymeme);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(GuiScreen.isShiftKeyDown()){
			tooltip.add(TextFormatting.YELLOW + I18n.format(Reference.MOD_PREFIX + "lingeringbottle.text1"));
		}
		else 
			tooltip.add(TextFormatting.UNDERLINE + I18n.format(Reference.MOD_PREFIX + "shift.info"));
	}
	
}
