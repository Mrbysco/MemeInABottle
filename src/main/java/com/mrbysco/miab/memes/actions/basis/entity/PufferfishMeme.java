package com.mrbysco.miab.memes.actions.basis.entity;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.memes.actions.base.BasicEntityMeme;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class PufferfishMeme extends BasicEntityMeme {

	public PufferfishMeme() {
		super(Reference.MOD_PREFIX + "pufferfish", 5, EntityType.PUFFERFISH, MemeSounds.pufferfish);
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		super.trigger(world, pos, player);
		if(!world.isRemote) {
			spawnEntityItem(world, new ItemStack(Items.CARROT, 1), pos);
			if(MemeConfig.SERVER.useNarator.get()) {
				Narrator.getNarrator().say("You know what to do!", false);
			} else {
				player.sendMessage(new TranslationTextComponent(Reference.MOD_PREFIX + "message.ykwtd"), Util.DUMMY_UUID);
			}
		}
	}
}
