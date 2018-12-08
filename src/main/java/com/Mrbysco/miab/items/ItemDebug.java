package com.Mrbysco.miab.items;

import java.util.List;

import javax.annotation.Nullable;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.config.MemeConfigGen;
import com.Mrbysco.miab.memes.MemeLists;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDebug extends Item
{
	public ItemDebug(String registry)
	{
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		if (playerIn.isSneaking())
		{
			if(!worldIn.isRemote)
			{
				BlockPos pos = playerIn.getPosition();
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
		else
		{
			playerIn.openGui(MemeInABottle.instance, 0, worldIn, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		if(GuiScreen.isShiftKeyDown()){
		tooltip.add(TextFormatting.YELLOW + I18n.format(Reference.MOD_PREFIX + "debug.text1"));
		tooltip.add(TextFormatting.RED + I18n.format(Reference.MOD_PREFIX + "debug.text2"));
		tooltip.add(TextFormatting.GREEN + I18n.format(Reference.MOD_PREFIX + "debug.text3"));
		}
		else 
		tooltip.add(TextFormatting.UNDERLINE + I18n.format(Reference.MOD_PREFIX + "shift.info"));
    }
}
