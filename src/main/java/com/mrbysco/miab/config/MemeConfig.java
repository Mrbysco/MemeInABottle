package com.mrbysco.miab.config;

import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;

import java.util.Arrays;
import java.util.List;

import static net.minecraftforge.fml.Logging.CORE;
import static net.minecraftforge.fml.loading.LogMarkers.FORGEMOD;

public class MemeConfig {

	public static class Server {
		public final BooleanValue MemesOnBeach;
		public final BooleanValue MatureSounds;
		public final BooleanValue UseNarator;
		public final BooleanValue LogTriggers;
		public final ConfigValue<List<? extends String>> disabled_memes;

		Server(ForgeConfigSpec.Builder builder) {
			builder.comment("General settings")
					.push("general");

			MemesOnBeach = builder
					.comment("When enabled allows you to dig up memes in beaches. (Default: true)")
					.define("MemesOnBeach", true);

			MatureSounds = builder
					.comment("Setting to true allows for some of the questionable memes (Default: false)")
					.define("MatureSounds", false);

			UseNarator = builder
					.comment("Use Minecraft's narrator to pronounce some copypasta memes (Default: false)")
					.define("MemesOnBeach", false);

			LogTriggers = builder
					.comment("When enabled will log the memes executed. (Default: false)")
					.define("LogTriggers", false);

			builder.pop();
			builder.comment("Meme Settings")
					.push("meme");

			String[] messages = new String[]{ };
			disabled_memes = builder
					.comment("Any meme id's added here will be removed from the possible meme list")
					.defineList("disabled_memes", Arrays.asList(messages), entry -> entry instanceof String);

			builder.pop();
		}
	}

	public static final ForgeConfigSpec serverSpec;
	public static final MemeConfig.Server SERVER;
	static {
		final Pair<MemeConfig.Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(MemeConfig.Server::new);
		serverSpec = specPair.getRight();
		SERVER = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading configEvent) {
		LogManager.getLogger().debug(FORGEMOD, "Loaded forge config file {}", configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfig.ConfigReloading configEvent) {
		LogManager.getLogger().fatal(CORE, "Forge config just got changed on the file system!");
		MemeRegistry.INSTANCE.checkDisabled();
	}
}
