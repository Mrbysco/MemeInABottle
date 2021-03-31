package com.mrbysco.miab.items.bottle;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.projectile.SplashMemeEntity;
import com.mrbysco.miab.items.MemeBaseItem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class LingeringMemeBottleItem extends MemeBaseItem {

	public LingeringMemeBottleItem(Item.Properties builder) {
		super(builder.maxStackSize(8));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_LINGERING_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote) {
			SplashMemeEntity memeEntity = new SplashMemeEntity(worldIn, playerIn);
			memeEntity.setItem(itemstack);
			memeEntity.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.5F, 1.0F);
			worldIn.addEntity(memeEntity);
		}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		if (!playerIn.abilities.isCreativeMode) {
			itemstack.shrink(1);
		}

		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(Screen.hasShiftDown())
			tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "lingeringbottle.text1").mergeStyle(TextFormatting.YELLOW));
		else
			tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "shift.info").mergeStyle(TextFormatting.GRAY));
	}
	
}
