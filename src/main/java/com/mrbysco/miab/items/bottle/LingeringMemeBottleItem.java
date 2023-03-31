package com.mrbysco.miab.items.bottle;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.projectile.SplashMemeEntity;
import com.mrbysco.miab.items.MemeBaseItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class LingeringMemeBottleItem extends MemeBaseItem {

	public LingeringMemeBottleItem(Item.Properties builder) {
		super(builder.stacksTo(8));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		level.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.LINGERING_POTION_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (playerIn.getRandom().nextFloat() * 0.4F + 0.8F));

		if (!level.isClientSide) {
			SplashMemeEntity memeEntity = new SplashMemeEntity(level, playerIn);
			memeEntity.setItem(itemstack);
			memeEntity.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), -20.0F, 0.5F, 1.0F);
			level.addFreshEntity(memeEntity);
		}

		playerIn.awardStat(Stats.ITEM_USED.get(this));
		if (!playerIn.getAbilities().instabuild) {
			itemstack.shrink(1);
		}

		return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, level, tooltip, flagIn);
		if (Screen.hasShiftDown())
			tooltip.add(Component.translatable(Reference.MOD_PREFIX + "lingeringbottle.text1").withStyle(ChatFormatting.YELLOW));
		else
			tooltip.add(Component.translatable(Reference.MOD_PREFIX + "shift.info").withStyle(ChatFormatting.GRAY));
	}

}
