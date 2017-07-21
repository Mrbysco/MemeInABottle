package com.Mrbysco.MIAB.config;

import com.Mrbysco.MIAB.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
@Config.LangKey("miab.config.title")
public class MIABConfigGen {
	@Config.Comment("Generation of bottles on sand near water (default: true)")
	public static boolean GenerateBottles = true;
	
	@Config.Comment("Censors out some of the questionable memes (default: false)")
	public static boolean MatureSounds = false;
	
	@Config.Comment("Use Minecrafts narrator to speak out some copypasta memes (default: false)")
	public static boolean UseNarator = false;
	
	@Config.Comment("Meme Random Value, the less the value the more chance of meme summons. (default: 100)")
	public static int MemeRandomness = 100;

	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	private static class EventHandler {

		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MOD_ID)) {
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}
}