package com.mrbysco.miab.items.food;

import com.mrbysco.miab.items.MemeBaseItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class FoodWithSoundItem extends MemeBaseItem {
	private Supplier<SoundEvent> sound;
	private int cooldown;

	public FoodWithSoundItem(Item.Properties builder, Supplier<SoundEvent> soundIn, int cooldownIn) {
		super(builder);
		this.sound = soundIn;
		this.cooldown = cooldownIn;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), this.sound.get(), SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);

		if(this.cooldown != 0) {
			playerIn.getCooldownTracker().setCooldown(this, this.cooldown);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
