package com.mrbysco.miab.items.bottle;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.projectile.EntitySplashMeme;
import com.mrbysco.miab.items.ItemMemeBase;
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

public class ItemSplashMemeBottle extends ItemMemeBase {

	public ItemSplashMemeBottle(Item.Properties builder) {
		super(builder.maxStackSize(16));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		ItemStack stack1 = playerIn.abilities.isCreativeMode ? itemstack.copy() : itemstack.split(1);
		worldIn.playSound((PlayerEntity) null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_LINGERING_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote) {
			EntitySplashMeme entitymeme = new EntitySplashMeme(worldIn, playerIn, stack1);
			entitymeme.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.5F, 1.0F);
			worldIn.addEntity(entitymeme);
		}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(Screen.hasShiftDown()){
			tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "splashbottle.text1").applyTextStyle(TextFormatting.YELLOW));
			tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "splashbottle.text2").applyTextStyle(TextFormatting.YELLOW));
		}
		else
			tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "shift.info").applyTextStyle(TextFormatting.UNDERLINE));
	}
}
