package com.Mrbysco.MIAB.items;

import javax.annotation.Nullable;

import com.Mrbysco.MIAB.MIAB;
import com.mojang.realmsclient.dto.PlayerInfo;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFidget extends Item{
	public ItemFidget(String UnlocalisedName, String RegistryName) {
		setMaxStackSize(1);
		setUnlocalizedName(UnlocalisedName);
		setRegistryName(RegistryName);
		setCreativeTab(MIAB.tabMIAB);
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
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1200;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack heldItem = playerIn.getHeldItem(handIn);
		
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, heldItem);
	}
}
