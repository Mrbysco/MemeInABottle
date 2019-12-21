package com.mrbysco.miab.items;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.EntityRoflCopter;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemRoflCopter extends ItemMemeBase{
	public ItemRoflCopter(String registry )
	{
		super(registry);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, false);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);
		if (ret != null) return ret;

		if (raytraceresult == null) {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
		} else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK) {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
		} else {
			BlockPos blockpos = raytraceresult.getBlockPos();
			EntityRoflCopter roflCopter = new EntityRoflCopter(worldIn);
			roflCopter.setPositionAndUpdate(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
			worldIn.spawnEntity(roflCopter);

			if (!playerIn.isCreative())
			{
				itemstack.shrink(1);
			}
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		}
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		tooltip.add(TextFormatting.YELLOW + I18n.format(Reference.MOD_PREFIX + "roflcopter.info"));
	}
}
