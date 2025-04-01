package com.mrbysco.miab.items;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.RoflCopterEntity;
import com.mrbysco.miab.registry.MemeEntities;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;

import java.util.List;

public class RoflCopterItem extends MemeBaseItem {
	public RoflCopterItem(Item.Properties builder) {
		super(builder);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		HitResult raytraceresult = getPlayerPOVHitResult(level, playerIn, Fluid.NONE);

		if (raytraceresult == null) {
			return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
		} else if (raytraceresult.getType() != Type.BLOCK) {
			return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
		} else {
			BlockHitResult traceResult = (BlockHitResult) raytraceresult;
			BlockPos blockpos = traceResult.getBlockPos();
			RoflCopterEntity roflCopter = MemeEntities.ROFL_COPTER.get().create(level);
			if (roflCopter != null) {
				roflCopter.teleportTo(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
				level.addFreshEntity(roflCopter);
			}


			if (!playerIn.isCreative()) {
				itemstack.shrink(1);
			}
			return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltip, tooltipFlag);
		tooltip.add(Component.translatable(Reference.MOD_PREFIX + "roflcopter.info").withStyle(ChatFormatting.YELLOW));
	}
}
