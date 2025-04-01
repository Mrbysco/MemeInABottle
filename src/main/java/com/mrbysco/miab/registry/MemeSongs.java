package com.mrbysco.miab.registry;

import com.mrbysco.miab.Reference;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;

public class MemeSongs {
	public static final ResourceKey<JukeboxSong> MEME_MUSIC_1 = create("meme_music_1");
	public static final ResourceKey<JukeboxSong> MEME_MUSIC_2 = create("meme_music_2");

	private static ResourceKey<JukeboxSong> create(String path) {
		return ResourceKey.create(Registries.JUKEBOX_SONG, Reference.modLoc(path));
	}

	public static void bootstrap(BootstrapContext<JukeboxSong> context) {
		registerPlaceholder(context, MEME_MUSIC_1, MemeSounds.meme_music1.getDelegate(), 4820);
		registerPlaceholder(context, MEME_MUSIC_2, MemeSounds.meme_music2.getDelegate(), 3140);
	}

	private static void registerPlaceholder(
			BootstrapContext<JukeboxSong> context,
			ResourceKey<JukeboxSong> song,
			Holder<SoundEvent> soundEvent,
			float length
	) {
		context.register(
				song,
				new JukeboxSong(soundEvent,
						Component.translatable(Util.makeDescriptionId("jukebox_song", song.location())),
						length, 0)
		);
	}
}
