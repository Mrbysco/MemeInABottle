package com.mrbysco.miab.memes.actions.basis.item;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class DangerousToGoAloneMeme extends BasicFunny {

	public DangerousToGoAloneMeme() {
		super(Reference.MOD_PREFIX + "dangerous", 10);
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		super.trigger(world, pos, player);
		if(!world.isRemote) {
			ItemStack sword = new ItemStack(Items.WOODEN_SWORD);
			sword.setDisplayName(new StringTextComponent("Zelda Sword"));
			spawnEntityItem(world, sword, pos);

			if(MemeConfig.SERVER.UseNarator.get())
    		{
	        	Narrator.getNarrator().say("It's dangerous to go alone, take this", false);
    		}
    		else
    		{
    			player.sendMessage(new TranslationTextComponent(Reference.MOD_PREFIX + "dangerous"));
    		}
		}
	}
}
