package com.mrbysco.miab.memes.actions.basis;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class InceptionMeme extends BasicFunny {

	public InceptionMeme() {
		super(Reference.MOD_PREFIX + "inception", 5);
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		if(!world.isRemote) {
			world.playSound((PlayerEntity)null, pos, MemeSounds.inception, SoundCategory.RECORDS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			world.setBlockState(pos, Blocks.CHEST.getDefaultState());
			ChestTileEntity chest = (ChestTileEntity) world.getTileEntity(pos);
			chest.setInventorySlotContents(0, new ItemStack(Blocks.CHEST));
			chest.setCustomName(new StringTextComponent("Chestception"));
		}
	}
}
