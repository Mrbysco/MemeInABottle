package com.mrbysco.miab.items.food;

import com.mrbysco.miab.items.ItemMemeBase;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ItemPills extends ItemMemeBase {
	private SoundEvent sound;

	public ItemPills(Item.Properties builder, SoundEvent soundIn)
	{
		super(builder);
		this.sound = soundIn;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
	{
		entityLiving.playSound(this.sound, 1F, 1F);
		entityLiving.heal(4);
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		playerIn.playSound(this.sound, 1F, 1F);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
