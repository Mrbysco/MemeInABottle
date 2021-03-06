package com.mrbysco.miab.items;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.RoflCopterEntity;
import com.mrbysco.miab.init.MemeEntities;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class RoflCopterItem extends MemeBaseItem {
	public RoflCopterItem(Item.Properties builder)
	{
		super(builder);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);
		if (ret != null) return ret;

		if (raytraceresult == null) {
			return new ActionResult<>(ActionResultType.PASS, itemstack);
		} else if (raytraceresult.getType() != Type.BLOCK) {
			return new ActionResult<>(ActionResultType.PASS, itemstack);
		} else {
			BlockRayTraceResult traceResult = (BlockRayTraceResult)raytraceresult;
			BlockPos blockpos = traceResult.getPos();
			RoflCopterEntity roflCopter = MemeEntities.ROFL_COPTER.get().create(worldIn);
			if(roflCopter != null) {
				roflCopter.setPositionAndUpdate(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
				worldIn.addEntity(roflCopter);
			}


			if (!playerIn.isCreative()) {
				itemstack.shrink(1);
			}
			return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
		}
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "roflcopter.info").mergeStyle(TextFormatting.YELLOW));
	}
}
