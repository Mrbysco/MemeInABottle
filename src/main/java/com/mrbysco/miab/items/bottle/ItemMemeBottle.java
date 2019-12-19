package com.mrbysco.miab.items.bottle;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.items.ItemMemeBase;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemMemeBottle extends ItemMemeBase {

	public ItemMemeBottle(String registry) {
		super(registry);
		setMaxStackSize(16);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) 
	{
		EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;

        if (entityplayer instanceof EntityPlayerMP)
        {
            CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
        }
        
        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
        {
            stack.shrink(1);
        }

		if(!worldIn.isRemote) {
			MemeRegistry.INSTANCE.triggerRandomMeme(worldIn, entityLiving.getPosition(), entityplayer);
		}

        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
        {
            if (stack.isEmpty())
            {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (entityplayer != null)
            {
                entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        return stack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
	    return 32;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(GuiScreen.isShiftKeyDown()){
			tooltip.add(TextFormatting.YELLOW + I18n.format(Reference.MOD_PREFIX + "bottle.text1"));
			tooltip.add(TextFormatting.YELLOW + I18n.format(Reference.MOD_PREFIX + "bottle.text2"));
		}
		else 
			tooltip.add(TextFormatting.UNDERLINE + I18n.format(Reference.MOD_PREFIX + "shift.info"));
	}
	
}
