package com.mrbysco.miab.config;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID, category = "", name = "MemeInABottle")
@Config.LangKey("memeinabottle.config.title")
public class MemeConfig {
	@Config.Comment({"General settings"})
	public static General general = new General();
	
	@Config.Comment({"Meme Settings"})
	public static Memes memes = new Memes();
	
	public static class General{
		@Config.Comment("When enabled allows you to dig up memes in beaches. (Default: true)")
		public boolean MemesOnBeach = true;
		
		@Config.Comment("Setting to true allows for some of the questionable memes (Default: false)")
		@Config.RequiresMcRestart
		public boolean MatureSounds = false;
		
		@Config.Comment("Use Minecraft's narrator to pronounce some copypasta memes (Default: false)")
		public boolean UseNarator = false;
	}
	
	public static class Memes{
		@Config.Comment("Any meme id's added here will be removed from the possible meme list")
		public String[] disabled_memes = new String[] { };
	}
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	private static class EventHandler {

		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MOD_ID)) {
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
				MemeRegistry.INSTANCE.checkDisabled();
			}
		}
	}
}
