package com.mrbysco.miab.memes.actions.basis;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

public class InceptionMeme extends BasicFunny {

	public InceptionMeme() {
		super(Reference.MOD_PREFIX + "inception", 5);
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			world.playSound((Player) null, pos, MemeSounds.inception.get(), SoundSource.RECORDS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
			world.setBlockAndUpdate(pos, Blocks.CHEST.defaultBlockState());
			BlockEntity tile = world.getBlockEntity(pos);
			if (tile instanceof ChestBlockEntity chest) {
				chest.setItem(0, new ItemStack(Blocks.CHEST));
				chest.setCustomName(Component.literal("Chestception"));
			}
		}
	}
}
