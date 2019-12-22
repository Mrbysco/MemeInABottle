package com.mrbysco.miab.init;

import com.google.common.base.Preconditions;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.items.ItemClippy;
import com.mrbysco.miab.items.ItemFidget;
import com.mrbysco.miab.items.ItemKnife;
import com.mrbysco.miab.items.ItemMemeBase;
import com.mrbysco.miab.items.ItemMemeSpawnEgg;
import com.mrbysco.miab.items.ItemRoflCopter;
import com.mrbysco.miab.items.armor.ItemCustomArmor;
import com.mrbysco.miab.items.armor.ItemGnomeHat;
import com.mrbysco.miab.items.armor.ItemLeatherBelt;
import com.mrbysco.miab.items.armor.ItemSunglasses;
import com.mrbysco.miab.items.bottle.ItemLingeringMemeBottle;
import com.mrbysco.miab.items.bottle.ItemMemeBottle;
import com.mrbysco.miab.items.bottle.ItemSplashMemeBottle;
import com.mrbysco.miab.items.food.ItemFoodWithSound;
import com.mrbysco.miab.items.food.ItemPills;
import com.mrbysco.miab.items.music.ItemInstrument;
import com.mrbysco.miab.items.music.ItemMemeRecord;
import com.mrbysco.miab.items.music.ItemMusical;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = Bus.MOD)
public class MemeItems {
	public static Item meme_in_a_bottle;
	public static Item splash_meme_in_a_bottle;
	public static Item lingering_meme_in_a_bottle;

	public static SwordItem knife;
	public static SwordItem hot_knife;

	public static Item pen;
	public static Item penpineapple;
	public static Item applepen;
	public static Item ppap;
	
	public static Item sax;
	public static Item fidget_spinner;
	public static Item trumpet;
	public static Item flex_tape;

	public static Item clippy;
	public static Item roflcopter;
	
	public static Item waffle;
	public static Item poptart;
	public static Item pineapple;
	public static Item apple;
	public static Item onion;
	public static Item burger;
	public static Item pills_here;
	public static Item pod;

	public static Item gnome_hat;
	public static ArmorItem wrestling_belt;
	public static ArmorItem leather_belt;
	public static ArmorItem trump_hair;
	public static ArmorItem troll_mask;
	public static ArmorItem ripoff_hat;
	public static ArmorItem sunglasses;

	public static MusicDiscItem meme_record1;
	public static MusicDiscItem meme_record2;
	public static MusicDiscItem meme_record3;
	public static MusicDiscItem meme_record4;

	public static Item john_cena_spawn_egg;
	public static Item donald_trump_spawn_egg;
	public static Item doge_spawn_egg;
	public static Item grumpy_cat_spawn_egg;
	public static Item attached_girlfriend_spawn_egg;
	public static Item eduard_khil_spawn_egg;
	public static Item ppap_spawn_egg;
	public static Item robbie_rotten_spawn_egg;
	public static Item grand_dad_spawn_egg;
	public static Item he_man_spawn_egg;
	public static Item anakin_skywalker_spawn_egg;
	public static Item roadman_shaq_spawn_egg;
	public static Item phil_swift_spawn_egg;
	public static Item dankey_kang_spawn_egg;
	public static Item shrek_spawn_egg;
	public static Item dat_boi_spawn_egg;
	public static Item sanic_spawn_egg;
	public static Item pepe_spawn_egg;
	public static Item forever_alone_spawn_egg;
	public static Item nyan_cat_spawn_egg;
	public static Item tac_nayn_spawn_egg;
	public static Item nigel_thornberry_spawn_egg;
	public static Item dancing_hotdog_spawn_egg;
	public static Item bongo_cat_spawn_egg;
	public static Item roflcopter_spawn_egg;
	public static Item gnome_spawn_egg;
	public static Item knuckles_spawn_egg;
	public static Item knuckles_queen_spawn_egg;
	public static Item sans_spawn_egg;
	public static Item pingu_spawn_egg;
	public static Item tom_spawn_egg;

	public static ArrayList<Item> ITEMS = new ArrayList<>();

	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        meme_in_a_bottle = registerItem(new ItemMemeBottle(itemBuilder()),"meme_in_a_bottle");
        splash_meme_in_a_bottle = registerItem(new ItemSplashMemeBottle(itemBuilder()),"splash_meme_in_a_bottle");
        lingering_meme_in_a_bottle = registerItem(new ItemLingeringMemeBottle(itemBuilder()),"lingering_meme_in_a_bottle");

		knife = registerItem(new ItemKnife(itemBuilder(), false),"knife");
		hot_knife = registerItem(new ItemKnife(itemBuilder(), true),"hot_knife");

		pen = registerItem(new ItemMusical(itemBuilder(), MemeSounds.ppap_havepen, null, 5, null), "pen");
		penpineapple = registerItem(new ItemMusical(itemBuilder(), MemeSounds.ppap_ahpineapplepen, MemeSounds.ppap_pineapplepen, 5, Reference.MOD_PREFIX + "instrument.info"), "pineapple_pen");
		applepen = registerItem(new ItemMusical(itemBuilder(), MemeSounds.ppap_ahapplepen, MemeSounds.ppap_applepen, 5, Reference.MOD_PREFIX + "instrument.info"), "apple_pen");
		ppap = registerItem(new ItemMusical(itemBuilder(), MemeSounds.ppap_ppap, null, 5, null), "pen_pineapple_apple_pen");

		sax = registerItem(new ItemInstrument(itemBuilder(), MemeSounds.robbie_sax, MemeSounds.robbie_sax2, 20, Reference.MOD_PREFIX + "instrument.info"), "sax");
		trumpet = registerItem(new ItemInstrument(itemBuilder(), MemeSounds.doot, null, 5, Reference.MOD_PREFIX + "trumpet.info"), "trumpet");
		flex_tape = registerItem(new ItemMemeBase(itemBuilder()), "flex_tape");
		fidget_spinner = registerItem(new ItemFidget(itemBuilder()), "fidget_spinner");

		clippy = registerItem(new ItemClippy(itemBuilder()), "clippy");
		roflcopter = registerItem(new ItemRoflCopter(itemBuilder()), "roflcopter");

		waffle = registerItem(new ItemMemeBase(itemBuilder().food(MemeFoods.WAFFLE)), "waffle");
		poptart = registerItem(new ItemMemeBase(itemBuilder().food(MemeFoods.POPTART)), "poptart");
		pineapple = registerItem(new ItemFoodWithSound(itemBuilder().food(MemeFoods.PINEAPPLE), MemeSounds.ppap_havepineapple, 5), "pineapple");
		apple = registerItem(new ItemFoodWithSound(itemBuilder().food(MemeFoods.APPLE), MemeSounds.ppap_haveapple, 5), "apple");
		onion = registerItem(new ItemFoodWithSound(itemBuilder().food(MemeFoods.ONION), MemeSounds.shrek_onion, 5), "onion");
		burger = registerItem(new ItemMemeBase(itemBuilder().food(MemeFoods.BURGER)), "mineburger");
		pills_here = registerItem(new ItemPills(itemBuilder().food(MemeFoods.PILLS), MemeSounds.pills), "pills");
		pod = registerItem(new ItemMemeBase(itemBuilder().food(MemeFoods.POD)), "pod");

		trump_hair = registerItem(new ItemCustomArmor(MemeArmor.TRUMPHAIR, EquipmentSlotType.HEAD, itemBuilder()), "trump_hair");
		gnome_hat = registerItem(new ItemGnomeHat(itemBuilder()),"gnome_hat");
		wrestling_belt = registerItem(new ItemCustomArmor(MemeArmor.BELT, EquipmentSlotType.LEGS, itemBuilder()), "wrestling_belt");
		leather_belt = registerItem(new ItemLeatherBelt(MemeArmor.LEATHERBELT, EquipmentSlotType.CHEST, itemBuilder()), "leather_belt");
		troll_mask = registerItem(new ItemCustomArmor(MemeArmor.TROLLMASK, EquipmentSlotType.HEAD, itemBuilder()), "troll_mask");
		ripoff_hat = registerItem(new ItemCustomArmor(MemeArmor.RIPOFFHAT, EquipmentSlotType.HEAD, itemBuilder()), "ripoff_hat");
		sunglasses = registerItem(new ItemSunglasses(MemeArmor.GLASSES, EquipmentSlotType.HEAD, itemBuilder()), "sunglasses");

		meme_record1 = registerItem(new ItemMemeRecord(0, MemeSounds.meme_music, itemBuilder()), "meme_record_1");
		meme_record2 = registerItem(new ItemMemeRecord(0, MemeSounds.meme_music2, itemBuilder()), "meme_record_2");
		meme_record3 = registerItem(new ItemMemeRecord(0, MemeSounds.meme_music3, itemBuilder()), "meme_record_3");
		meme_record4 = registerItem(new ItemMemeRecord(0, MemeSounds.meme_music4, itemBuilder()), "meme_record_4");

		john_cena_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.JOHN_CENA, 16032864, 9199159, itemBuilder()), "john_cena_spawn_egg");
		donald_trump_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.DONALD_TRUMP, 16753920, 16766720, itemBuilder()), "donald_trump_spawn_egg");
		doge_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.DOGE, 14196256, 15719341, itemBuilder()), "doge_spawn_egg");
		grumpy_cat_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.GRUMPY_CAT, 14406346, 3354149, itemBuilder()), "grumpy_cat_spawn_egg");
		attached_girlfriend_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.ATTACHED_GIRLFRIEND, 16240814, 5187607, itemBuilder()), "attached_girlfriend_spawn_egg");
		eduard_khil_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.EDUARD_KHIL, 16765091, 4204057, itemBuilder()), "eduard_khil_spawn_egg");
		ppap_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.PPAP, 16768915, 2170639, itemBuilder()), "ppap_spawn_egg");
		robbie_rotten_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.ROBBIE_ROTTEN, 16765357, 2370625, itemBuilder()), "robbie_rotten_spawn_egg");
		grand_dad_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.GRAND_DAD, 16777215, 1333964, itemBuilder()), "grand_dad_spawn_egg");
		he_man_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.HE_MAN, 13408394, 14595118, itemBuilder()), "he_man_spawn_egg");
		anakin_skywalker_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.SKYWALKER, 16631181, 7950634, itemBuilder()), "anakin_skywalker_spawn_egg");
		roadman_shaq_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.ROADMAN_SHAQ, 6375218, 1973790, itemBuilder()), "roadman_shaq_spawn_egg");
		phil_swift_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.PHIL_SWIFT, 16768437, 4013373, itemBuilder()), "phil_swift_spawn_egg");
		dankey_kang_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.DANKEY_KANG, 1917560, 14668958, itemBuilder()), "dankey_kang_spawn_egg");
		shrek_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.SHREK, 6994007, 1401603, itemBuilder()), "shrek_spawn_egg");
		dat_boi_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.DAT_BOI, 307716, 4276545, itemBuilder()), "dat_boi_spawn_egg");
		sanic_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.SANIC, 4147404, 2764941, itemBuilder()), "sanic_spawn_egg");
		pepe_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.PEPE, 5934398, 2642377, itemBuilder()), "pepe_spawn_egg");
		forever_alone_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.FOREVER_ALONE, 14869218, 4031140, itemBuilder()), "forever_alone_spawn_egg");
		nyan_cat_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.NYAN_CAT, 15118949, 15684762, itemBuilder()), "nyan_cat_spawn_egg");
		tac_nayn_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.TAC_NAYN, 2829099, 11688484, itemBuilder()), "tac_nayn_spawn_egg");
		nigel_thornberry_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.NIGEL_THORNBERRY, 15044481, 11155745, itemBuilder()), "nigel_thornberry_spawn_egg");
		dancing_hotdog_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.DANCING_HOTDOG, 11887182, 14456412, itemBuilder()), "dancing_hotdog_spawn_egg");
		bongo_cat_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.BONGO_CAT, 16777215, 1644825, itemBuilder()), "bongo_cat_spawn_egg");
		roflcopter_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.ROFL_COPTER, 16777215, 1644825, itemBuilder()), "roflcopter_spawn_egg");
		gnome_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.GNOME, 1189750, 13442571, itemBuilder()), "gnome_spawn_egg");
		knuckles_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.KNUCKLES, 16729165, 16777215, itemBuilder()), "knuckles_spawn_egg");
		knuckles_queen_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.KNUCKLES_QUEEN, 16729165, 16777215, itemBuilder()), "knuckles_queen_spawn_egg");
		sans_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.SANS, 6579836, 2610142, itemBuilder()), "sans_spawn_egg");
		pingu_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.PINGU, 1975859, 15855854, itemBuilder()), "pingu_spawn_egg");
		tom_spawn_egg = registerItem(new ItemMemeSpawnEgg(MemeEntities.TOM, 9405003, 8747679, itemBuilder()), "tom_spawn_egg");

		registry.registerAll(ITEMS.toArray(new Item[0]));
	}
	
	public static <T extends Item> T registerItem(T item, String name) {
		item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		Preconditions.checkNotNull(item, "registryName");
		ITEMS.add(item);
		return item;
    }

	private static Item.Properties itemBuilder()
	{
		return new Item.Properties();
	}
}
