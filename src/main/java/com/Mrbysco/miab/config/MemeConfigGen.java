package com.Mrbysco.miab.config;

import com.Mrbysco.miab.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
@Config.LangKey("memeinabottle.config.title")
public class MemeConfigGen 
{
	
	@Config.Comment({"General settings"})
	@Config.Name("General Settings")
	public static General general = new General();
	
	@Config.Comment({"Spawn settings"})
	@Config.Name("Spawn Settings")
	public static Spawning spawning = new Spawning();
	
	public static class General
	{
		@Config.Comment("When true meme bottles can be found on beaches. (Default: true)")
		public boolean MemesOnTheBeach = true;
		
		@Config.Comment("Setting to true allows for some of the questionable memes (Default: false)")
		@Config.RequiresMcRestart
		public boolean MatureSounds = false;
		
		@Config.Comment("Use Minecraft's narrator to pronounce some copypasta memes (Default: false)")
		public boolean UseNarator = false;
		
		@Config.Comment("The higher this number is the bigger the chance of a special meme summon, the number being X out of 100,"+ 
		" 100 = 100% chance of special meme summons (Default: 40)")
		@Config.RangeInt(min = 1, max = 100)
		public int SpecialMemeChance = 40;
	}
	
	public static class Spawning
	{
		@Config.Comment({"Skywalker settings"})
		@Config.Name("Skywalker Settings")
		public SkyWalker skywalker = new SkyWalker();
		public class SkyWalker {
			@Config.Comment("Setting this to true lets Skywalker spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean SkywalkerSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 10)")
			@Config.RangeInt(min = 1)
			public int SkywalkerWeigth = 10;
		}

		@Config.Comment({"Attached Girlfriend settings"})
		@Config.Name("Attached Girlfriend settings")
		public AttachedGirlfriend attachedgirlfriend = new AttachedGirlfriend();
		public class AttachedGirlfriend {
			@Config.Comment("Setting this to true lets Overly Attached Girlfriend spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean AttachedGirlfriendSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int AttachedGirlfriendWeigth = 5;
		}
		
		@Config.Comment({"Bill Cipher settings"})
		@Config.Name("Bill Cipher settings")
		public Bill billcipher = new Bill();
		public class Bill {
			@Config.Comment("Setting this to true lets Bill Cipher spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean BillSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 6)")
			@Config.RangeInt(min = 1)
			public int BillWeigth = 6;
		}
		
		@Config.Comment({"John Cena settings"})
		@Config.Name("John Cena settings")
		public Cena cena = new Cena();
		public class Cena {
			@Config.Comment("Setting this to true lets John Cena spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean CenaSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int CenaWeigth = 5;
		}

		
		@Config.Comment({"Dankey Kang settings"})
		@Config.Name("Dankey Kang settings")
		public Dankey dankey = new Dankey();
		public class Dankey {
			@Config.Comment("Setting this to true lets Dankey Kang spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean DankeySpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int DankeyWeigth = 5;
		}
		
		@Config.Comment({"Dat Boi settings"})
		@Config.Name("Dat Boi settings")
		public DatBoi datboi = new DatBoi();
		public class DatBoi {
			@Config.Comment("Setting this to true lets Dat Boi spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean DatBoiSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int DatBoiWeigth = 5;
		}
		
		@Config.Comment({"Doge settings"})
		@Config.Name("Doge settings")
		public Doge doge = new Doge();
		public class Doge {
			@Config.Comment("Setting this to true lets Doge spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean DogeSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int DogeWeigth = 5;
		}

		
		@Config.Comment({"Forever Alone settings"})
		@Config.Name("Forever Alone settings")
		public ForeverAlone foreveralone = new ForeverAlone();
		public class ForeverAlone {
			@Config.Comment("Setting this to true lets Forever Alone Guy spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean ForeverAloneSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int ForeverAloneWeigth = 5;
		}
		
		@Config.Comment({"Grumpy cat settings"})
		@Config.Name("Grumpy cat settings")
		public Grumpy grumpy = new Grumpy();
		public class Grumpy {
			@Config.Comment("Setting this to true lets Grumpy Cat spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean GrumpySpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int GrumpyWeigth = 5;
		}
		
		@Config.Comment({"Trololo Guy settings"})
		@Config.Name("Trololo Guy settings")
		public Trololo trololo = new Trololo();
		public class Trololo {
			@Config.Comment("Setting this to true lets Eduard Khil [Trololo guy] spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean TrololoSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int TrololoWeigth = 5;
		}
		
		@Config.Comment({"Grand Dad settings"})
		@Config.Name("Grand Dad settings")
		public GrandDad granddad = new GrandDad();
		public class GrandDad {
			@Config.Comment("Setting this to true lets 7 Grand Dad spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean GrandDadSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int GrandDadWeigth = 5;
		}
		
		@Config.Comment({"Moonman settings"})
		@Config.Name("Moonman settings")
		public Moonman moonman = new Moonman();
		public class Moonman {
			@Config.Comment("Setting this to true lets Moonman spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean MoonmanSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 2)")
			@Config.RangeInt(min = 1)
			public int MoonmanWeigth = 2;
		}
		
		@Config.Comment({"Nigel Thornberry settings"})
		@Config.Name("Nigel Thornberry settings")
		public NigelThornberry nigel = new NigelThornberry();
		public class NigelThornberry {
			@Config.Comment("Setting this to true lets Nigel Thornberry spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean NigelSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 9)")
			@Config.RangeInt(min = 1)
			public int NigelWeigth = 9;
		}
		
		@Config.Comment({"Nyan Cat settings"})
		@Config.Name("Nyan Cat settings")
		public NyanCat nyancat = new NyanCat();
		public class NyanCat {
			@Config.Comment("Setting this to true lets Nyan Cat spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean NyanCatSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int NyanCatWeigth = 5;
		}
		
		@Config.Comment({"Pepe settings"})
		@Config.Name("Pepe settings")
		public Pepe pepe = new Pepe();
		public class Pepe {
			@Config.Comment("Setting this to true lets the rarest of Pepe's spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean PepeSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int PepeWeigth = 5;
		}
		
		@Config.Comment({"PPAP settings"})
		@Config.Name("PPAP settings")
		public PPAP ppap = new PPAP();
		public class PPAP {
			@Config.Comment("Setting this to true lets the PPAP guy spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean PpapSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int PpapWeigth = 5;
		}
		
		@Config.Comment({"Robbie Rotten settings"})
		@Config.Name("Robbie Rotten settings")
		public RobbieRotten robbierotten = new RobbieRotten();
		public class RobbieRotten {
			@Config.Comment("Setting this to true lets Robbie Rotten spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean RobbieRottenSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 14)")
			@Config.RangeInt(min = 1)
			public int RobbieRottenWeigth = 14;
		}
		
		@Config.Comment({"Sanic settings"})
		@Config.Name("Sanic settings")
		public Sanic sanic = new Sanic();
		public class Sanic {
			@Config.Comment("Setting this to true lets Sanic spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean SanicSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int SanicWeigth = 5;
		}
		
		@Config.Comment({"Shrek settings"})
		@Config.Name("Shrek settings")
		public Shrek shrek = new Shrek();
		public class Shrek {
			@Config.Comment("Setting this to true lets Shrek spawn in your swamp (Default: false)")
			@Config.RequiresMcRestart
			public boolean ShrekSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 6)")
			@Config.RangeInt(min = 1)
			public int ShrekWeigth = 6;
		}
		
		@Config.Comment({"taC nayN settings"})
		@Config.Name("taC nayN settings")
		public taCnayN tacnayn = new taCnayN();
		public class taCnayN {
			@Config.Comment("Setting this to true lets taC nayN spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean TacNaynSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int TacNaynWeigth = 5;
		}
		
		@Config.Comment({"Trump settings"})
		@Config.Name("Trump settings")
		public Trump trump = new Trump();
		public class Trump {
			@Config.Comment("Setting this to true lets the Donald spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean TrumpSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int TrumpWeigth= 5;
		}
		
		@Config.Comment({"Roadman Shaq settings"})
		@Config.Name("Roadman Shaq settings")
		public RoadmanShaq roadmanshaq = new RoadmanShaq();
		public class RoadmanShaq {
			@Config.Comment("Setting this to true lets Roadman Shaq spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean RoadmanShaqSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int RoadmanShaqWeigth= 5;
		}
		
		@Config.Comment({"Phil Swift settings"})
		@Config.Name("Phil Swift settings")
		public PhilSwift philswift = new PhilSwift();
		public class PhilSwift {
			@Config.Comment("Setting this to true lets Phil Swift spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean PhilSwiftSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int PhilSwiftWeigth= 5;
		}
		
		@Config.Comment({"Dancing Hotdog settings"})
		@Config.Name("Dancing Hotdog settings")
		public DancingHotdog dancinghotdog = new DancingHotdog();
		public class DancingHotdog {
			@Config.Comment("Setting this to true lets the Dancing Hotdog spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean HotDogSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int HotDogWeigth= 5;
		}
		
		@Config.Comment({"He-man settings"})
		@Config.Name("He-man settings")
		public HeMan heman = new HeMan();
		public class HeMan {
			@Config.Comment("Setting this to true lets He-Man spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean HeManSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int HeManWeigth= 5;
		}
		
		@Config.Comment({"Clippy settings"})
		@Config.Name("Clippy settings")
		public Clippy clippy = new Clippy();
		public class Clippy {
			@Config.Comment("Setting this to true lets Clippy spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean ClippySpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 6)")
			@Config.RangeInt(min = 1)
			public int ClippyWeigth= 6;
		}
		
		@Config.Comment({"Knuckles Queen settings"})
		@Config.Name("Knuckles Queen settings")
		public KnucklesQueen knucklesqueen = new KnucklesQueen();
		public class KnucklesQueen {
			@Config.Comment("Setting this to true lets the Queen and her Ugandan Knuckes spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean KnucklesQueenSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int KnucklesQueenWeigth = 5;
		}
		
		@Config.Comment({"Bongo Cat settings"})
		@Config.Name("Bongo Cat settings")
		public BongoCat bongocat = new BongoCat();
		public class BongoCat {
			@Config.Comment("Setting this to true lets Bongo Cat tap it's bongo in your world (Default: false)")
			@Config.RequiresMcRestart
			public boolean BongoCatSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int BongoCatWeigth = 5;
		}
		
		@Config.Comment({"RoflCopter settings"})
		@Config.Name("RoflCopter settings")
		public RoflCopter roflcopter = new RoflCopter();
		public class RoflCopter {
			@Config.Comment("Setting this to true lets RoflCopter spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean RoflCopterSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int RoflCopterWeigth = 5;
		}
		
		@Config.Comment({"Gnome settings"})
		@Config.Name("Gnome settings")
		public Gnome gnome = new Gnome();
		public class Gnome {
			@Config.Comment("Setting this to true lets RoflCopter spawn in the world (Default: false)")
			@Config.RequiresMcRestart
			public boolean GnomeSpawning = false;
			@Config.Comment("Sets the weigth, higher means it has a bigger spawns chance (Default: 5)")
			@Config.RangeInt(min = 1)
			public int GnomeWeigth = 5;
		}
	}

	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	private static class EventHandler 
	{
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) 
		{
			if (event.getModID().equals(Reference.MOD_ID)) 
			{
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}
}