package com.mrbysco.miab.memes.actions.basis;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.STitlePacket;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class WastedMeme extends BasicFunny {

	public WastedMeme() {
		super(Reference.MOD_PREFIX + "wasted", 20);
	}	

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		if(!world.isRemote) {
			world.playSound((PlayerEntity)null, pos, MemeSounds.wasted, SoundCategory.NEUTRAL, 1f, 1f);
			if ((player instanceof ServerPlayerEntity))
			{
				STitlePacket packet = new STitlePacket(STitlePacket.Type.TITLE, new StringTextComponent("WASTED").setStyle(new Style().setColor(TextFormatting.RED).setBold(true)), 5, 60, 20);
				((ServerPlayerEntity)player).connection.sendPacket(packet);
			}
		}
	}
}
