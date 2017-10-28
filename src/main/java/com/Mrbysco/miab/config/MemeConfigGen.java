package com.Mrbysco.miab.config;

import com.Mrbysco.miab.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
@Config.LangKey("memeinabottle.config.title")
public class MemeConfigGen {
	
	@Config.Comment({"General settings"})
	public static General general = new General();
	
	public static class General{
		
		@Config.Comment("When true meme bottles can be found on beaches. (Default: true)")
		public boolean MemesOnTheBeach = true;
		
		@Config.Comment("Setting to true allows for some of the questionable memes (Default: false)")
		public boolean MatureSounds = false;
		
		@Config.Comment("Use Minecraft's narrator to pronounce some copypasta memes (Default: false)")
		public boolean UseNarator = false;
		
		@Config.Comment("The higher this number is the bigger the chance of a special meme summon, the number being X out of 100,"+ 
		"100 = 100% chance of special meme summons (Default: 40)")
		public int SpecialMemeChance = 40;
		
		@Config.Comment("Setting this to true allows a small amount of the meme creatures to spawn naturally where they fit (Default: false)")
		public boolean NaturalSpawning = false;
	}

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