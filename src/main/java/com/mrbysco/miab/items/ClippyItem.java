package com.mrbysco.miab.items;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.ClippyEntity;
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

import javax.annotation.Nullable;
import java.util.List;

public class ClippyItem extends MemeBaseItem {
	public ClippyItem(Item.Properties builder) {
		super(builder);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		HitResult raytraceresult = getPlayerPOVHitResult(level, playerIn, Fluid.NONE);
		InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, level, itemstack, raytraceresult);
		if (ret != null) return ret;

		if (raytraceresult == null) {
			return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
		} else if (raytraceresult.getType() != Type.BLOCK) {
			return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
		} else {
			BlockHitResult traceResult = (BlockHitResult) raytraceresult;
			BlockPos blockpos = traceResult.getBlockPos();
			ClippyEntity clippy = MemeEntities.CLIPPY.get().create(level);
			if (clippy != null) {
				clippy.teleportTo(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
				level.addFreshEntity(clippy);
			}

			if (!playerIn.isCreative()) {
				itemstack.shrink(1);
			}
			return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, level, tooltip, flagIn);
		tooltip.add(Component.translatable(Reference.MOD_PREFIX + "clippy.info").withStyle(ChatFormatting.YELLOW));
	}
}
