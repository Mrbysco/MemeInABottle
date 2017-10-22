package com.Mrbysco.miab.items;

import java.util.List;

import javax.annotation.Nullable;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.config.MemeConfigGen;
import com.Mrbysco.miab.items.base.ItemCustomItem;
import com.Mrbysco.miab.memes.MemeHelper;
import com.Mrbysco.miab.memes.MemeLists;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.GuiScreen;
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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMemeBottle extends ItemCustomItem{

	public ItemMemeBottle(String unlocalized, String registry) {
		super(unlocalized, registry);
		setMaxStackSize(16);
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;

        if (entityplayer instanceof EntityPlayerMP)
        {
            CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
        }
        
        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
        {
            stack.shrink(1);
        }

        doTheThing(worldIn, entityplayer);
        
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
	public int getMaxItemUseDuration(ItemStack stack)
    {
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
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		if(GuiScreen.isShiftKeyDown()){
		tooltip.add(TextFormatting.YELLOW + I18n.translateToLocal("bottle.text1"));
		tooltip.add(TextFormatting.YELLOW + I18n.translateToLocal("bottle.text2"));
		}
		else 
		tooltip.add(TextFormatting.UNDERLINE + "Press Shift For More Info");
    }
	
	public static void doTheThing(World worldIn, EntityPlayer entityplayer) {
		int random = worldIn.rand.nextInt(100);
        if(random < 30)
    	{
        	if(worldIn.isRemote)
        	{
        		doTheClientThing(worldIn);
        	}
    	}
        else
        {
        if (!worldIn.isRemote)
	        {
	        	BlockPos pos = entityplayer.getPosition();
        		if(MemeConfigGen.general.MatureSounds == true)
        		{
        			worldIn.playSound(null, pos, MemeLists.getRandomMatureSound(), SoundCategory.NEUTRAL, 1f, 1f);
        		}
        		else
        		{
        			worldIn.playSound(null, pos, MemeLists.getRandomSafeSound(), SoundCategory.NEUTRAL, 1f, 1f);
        		}
	        }
        }
	}
	
	@SideOnly(Side.CLIENT)
	public static void doTheClientThing(World worldIn)
	{
		MemeInABottle.proxy.displayMemeGui(MemeHelper.RandomMemeLocation());
	}
}
