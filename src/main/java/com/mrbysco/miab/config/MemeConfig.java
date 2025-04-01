package com.mrbysco.miab.config;

import com.mrbysco.miab.MemeInABottle;
import com.mrbysco.miab.memes.FunnyRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;
import net.neoforged.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class MemeConfig {

	public static class Server {
		public final BooleanValue memesOnBeach;
		public final BooleanValue matureSounds;
		public final BooleanValue useNarator;
		public final BooleanValue logTriggers;
		public final ConfigValue<List<? extends String>> disabledMemes;

		Server(ModConfigSpec.Builder builder) {
			builder.comment("General settings")
					.push("general");

			memesOnBeach = builder
					.comment("When enabled allows you to dig up memes in beaches. (Default: true)")
					.define("memesOnBeach", true);

			matureSounds = builder
					.comment("Setting to true allows for some of the questionable memes (Default: false)")
					.define("matureSounds", false);

			useNarator = builder
					.comment("Use Minecraft's narrator to pronounce some copypasta memes (Default: false)")
					.define("useNarator", false);

			logTriggers = builder
					.comment("When enabled will log the memes executed. (Default: false)")
					.define("logTriggers", false);

			builder.pop();
			builder.comment("Meme Settings")
					.push("meme");

			disabledMemes = builder
					.comment("Any meme id's added here will be removed from the possible meme list")
					.defineListAllowEmpty("disabled_memes", List::of, String::new, entry -> entry instanceof String);

			builder.pop();
		}
	}

	public static final ModConfigSpec serverSpec;
	public static final Server SERVER;

	static {
		final Pair<Server, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Server::new);
		serverSpec = specPair.getRight();
		SERVER = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {
		MemeInABottle.logger.debug("Loaded Meme In A Bottle's config file {}", configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
		MemeInABottle.logger.debug("Meme In A Bottle's config just got changed on the file system!");
		FunnyRegistry.instance().checkDisabled();
	}
}
