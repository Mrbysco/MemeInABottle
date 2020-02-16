package com.mrbysco.miab.items.music;

import com.mrbysco.miab.items.ItemMemeBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ItemMusical extends ItemMemeBase {
	private Supplier<? extends SoundEvent> sound;
	private Supplier<? extends SoundEvent> sound2;
	private int cooldown;
	private String info;

	public ItemMusical(Item.Properties builder, Supplier<? extends SoundEvent> soundIn, @Nullable Supplier<? extends SoundEvent> soundin2, int cooldownNumber, String textLocal)
	{
		super(builder);
		this.sound = soundIn;
		this.sound2 = soundin2;
		this.cooldown = cooldownNumber;
		this.info = textLocal;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if(playerIn.isSneaking() && this.sound2.get() != null)
		{
			playerIn.playSound(this.sound2.get(), 1F, 1F);
		}
		else
		{
			playerIn.playSound(this.sound.get(), 1F, 1F);
		}

		if(this.sound2 == null)
		{
			playerIn.playSound(this.sound.get(), 1F, 1F);
		}

		if(this.cooldown != 0)
		{
			playerIn.getCooldownTracker().setCooldown(this, this.cooldown);
		}

		return new ActionResult<ItemStack>(ActionResultType.SUCCESS, itemstack);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(this.info != null && !this.info.isEmpty()) {
			tooltip.add(new TranslationTextComponent(this.info).applyTextStyle(TextFormatting.YELLOW));
		}
	}
}
