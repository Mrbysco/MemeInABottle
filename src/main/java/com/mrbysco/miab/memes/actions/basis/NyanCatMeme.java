package com.mrbysco.miab.memes.actions.basis;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.EntityNyanCat;
import com.mrbysco.miab.entity.memes.EntityTacNayn;
import com.mrbysco.miab.init.MemeEntities;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NyanCatMeme extends BasicFunny {

	public NyanCatMeme() {
		super(Reference.MOD_PREFIX + "nyan_cat", 5);
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		if(!world.isRemote) {
			EntityNyanCat cat = MemeEntities.NYAN_CAT.create(world);
			cat.setTamedBy(player);
			spawnEntity(world, cat, pos);
			if(world.rand.nextBoolean()) {
				EntityTacNayn tac = MemeEntities.TAC_NAYN.create(world);
				cat.setTamedBy(player);
				spawnEntity(world, tac, pos);
			}
		}
	}
}
