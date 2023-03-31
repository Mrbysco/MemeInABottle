package com.mrbysco.miab.memes.actions.basis;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class WastedMeme extends BasicFunny {

	public WastedMeme() {
		super(Reference.MOD_PREFIX + "wasted", 20);
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			world.playSound((Player) null, pos, MemeSounds.wasted.get(), SoundSource.NEUTRAL, 1f, 1f);
			if (player instanceof ServerPlayer serverPlayer) {
				ClientboundSetTitleTextPacket packet = new ClientboundSetTitleTextPacket(
						Component.literal("WASTED").withStyle(ChatFormatting.RED).withStyle(Style.EMPTY.withBold(true)));
				serverPlayer.connection.send(packet);
				ClientboundSetTitlesAnimationPacket packet2 = new ClientboundSetTitlesAnimationPacket(5, 60, 20);
				serverPlayer.connection.send(packet2);
			}
		}
	}
}
