package com.Mrbysco.miab.items;

import javax.annotation.Nullable;

import com.Mrbysco.miab.items.base.ItemCustomItem;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFidget extends ItemCustomItem
{
	
	public ItemFidget(String registry) 
	{
		super(registry);
		setMaxStackSize(1);
		addPropertyOverride(new ResourceLocation("spinning"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) 
	{
		return 1200;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		ItemStack heldItem = playerIn.getHeldItem(handIn);
		
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, heldItem);
	}
}
