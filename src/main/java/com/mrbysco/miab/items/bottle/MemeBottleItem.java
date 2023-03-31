package com.mrbysco.miab.items.bottle;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.items.MemeBaseItem;
import com.mrbysco.miab.memes.FunnyRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.List;

public class MemeBottleItem extends MemeBaseItem {

	public MemeBottleItem(Item.Properties builder) {
		super(builder.stacksTo(16));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
		Player entityplayer = entityLiving instanceof Player ? (Player) entityLiving : null;

		if (entityplayer instanceof ServerPlayer) {
			CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) entityplayer, stack);
		}

		if (entityplayer != null || !entityplayer.getAbilities().instabuild) {
			stack.shrink(1);
		}

		if (!level.isClientSide) {
			FunnyRegistry.instance().triggerRandomMeme(level, entityLiving.blockPosition(), entityplayer);
		}

		if (entityplayer != null || !entityplayer.getAbilities().instabuild) {
			if (stack.isEmpty()) {
				return new ItemStack(Items.GLASS_BOTTLE);
			}

			entityplayer.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
		}

		return stack;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack p_77661_1_) {
		return UseAnim.DRINK;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		playerIn.startUsingItem(handIn);
		return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, playerIn.getItemInHand(handIn));
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, level, tooltip, flagIn);
		if (Screen.hasShiftDown()) {
			tooltip.add(Component.translatable(Reference.MOD_PREFIX + "bottle.text1").withStyle(ChatFormatting.YELLOW));
			tooltip.add(Component.translatable(Reference.MOD_PREFIX + "bottle.text2").withStyle(ChatFormatting.YELLOW));
		} else {
			tooltip.add(Component.translatable(Reference.MOD_PREFIX + "shift.info").withStyle(ChatFormatting.GRAY));
		}
	}

}
