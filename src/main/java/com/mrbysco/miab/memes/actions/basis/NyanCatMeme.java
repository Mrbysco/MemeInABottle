package com.mrbysco.miab.memes.actions.basis;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.EntityNyanCat;
import com.mrbysco.miab.entity.memes.EntityTacNayn;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NyanCatMeme extends BasicFunny {

	public NyanCatMeme() {
		super(Reference.MOD_PREFIX + "nyan_cat", 5);
	}

	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote) {
			EntityNyanCat cat = new EntityNyanCat(world);
			cat.setTamedBy(player);
			spawnEntity(world, cat, pos);
			if(world.rand.nextBoolean()) {
				EntityTacNayn tac = new EntityTacNayn(world);
				cat.setTamedBy(player);
				spawnEntity(world, tac, pos);
			}
		}
	}
}
