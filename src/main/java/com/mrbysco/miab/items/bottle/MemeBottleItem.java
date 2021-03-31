package com.mrbysco.miab.items.bottle;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.items.MemeBaseItem;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class MemeBottleItem extends MemeBaseItem {

	public MemeBottleItem(Item.Properties builder) {
		super(builder.maxStackSize(16));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		PlayerEntity entityplayer = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

        if (entityplayer instanceof ServerPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)entityplayer, stack);
        }

        if (entityplayer != null || !entityplayer.abilities.isCreativeMode) {
            stack.shrink(1);
        }

		if(!worldIn.isRemote) {
			MemeRegistry.instance().triggerRandomMeme(worldIn, entityLiving.getPosition(), entityplayer);
		}

        if (entityplayer != null || !entityplayer.abilities.isCreativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

			entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
        }

        return stack;
	}
	
	@Override
	public int getUseDuration(ItemStack stack) {
	    return 32;
	}

	@Override
	public UseAction getUseAction(ItemStack p_77661_1_) {
		return UseAction.DRINK;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(Screen.hasShiftDown()){
			tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "bottle.text1").mergeStyle(TextFormatting.YELLOW));
			tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "bottle.text2").mergeStyle(TextFormatting.YELLOW));
		} else {
			tooltip.add(new TranslationTextComponent(Reference.MOD_PREFIX + "shift.info").mergeStyle(TextFormatting.GRAY));
		}
	}
	
}
