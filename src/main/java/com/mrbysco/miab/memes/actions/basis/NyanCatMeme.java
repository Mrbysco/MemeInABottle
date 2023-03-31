package com.mrbysco.miab.memes.actions.basis;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.NyanCatEntity;
import com.mrbysco.miab.entity.memes.TacNyanEntity;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import com.mrbysco.miab.registry.MemeEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class NyanCatMeme extends BasicFunny {

	public NyanCatMeme() {
		super(Reference.MOD_PREFIX + "nyan_cat", 5);
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			NyanCatEntity cat = MemeEntities.NYAN_CAT.get().create(world);
			if (cat != null) {
				cat.tame(player);
				spawnEntity(world, cat, pos);
			}
			if (world.random.nextBoolean()) {
				TacNyanEntity tac = MemeEntities.TAC_NAYN.get().create(world);
				if (tac != null) {
					tac.tame(player);
					spawnEntity(world, tac, pos);
				}
			}
		}
	}
}
