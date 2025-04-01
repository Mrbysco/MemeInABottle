package com.mrbysco.miab.registry;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.blocks.OscarBlock;
import com.mrbysco.miab.items.ClippyItem;
import com.mrbysco.miab.items.FidgetItem;
import com.mrbysco.miab.items.KnifeItem;
import com.mrbysco.miab.items.MemeBaseItem;
import com.mrbysco.miab.items.RoflCopterItem;
import com.mrbysco.miab.items.armor.CustomArmorItem;
import com.mrbysco.miab.items.armor.GnomeHatItem;
import com.mrbysco.miab.items.armor.LeatherBeltItem;
import com.mrbysco.miab.items.armor.SunglassesItem;
import com.mrbysco.miab.items.bottle.LingeringMemeBottleItem;
import com.mrbysco.miab.items.bottle.MemeBottleItem;
import com.mrbysco.miab.items.bottle.SplashMemeBottleItem;
import com.mrbysco.miab.items.food.FoodWithSoundItem;
import com.mrbysco.miab.items.food.PillsItem;
import com.mrbysco.miab.items.music.InstrumentItem;
import com.mrbysco.miab.items.music.MusicalItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MemeRegistry {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Reference.MOD_ID);

	//BLOCKS
	public static final DeferredBlock<OscarBlock> OSCAR = BLOCKS.register("oscar", () -> new OscarBlock(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

	//ITEMS
	public static final DeferredItem<MemeBottleItem> MEME_IN_A_BOTTLE = ITEMS.register("meme_in_a_bottle", () -> new MemeBottleItem(itemBuilder()));
	public static final DeferredItem<SplashMemeBottleItem> SPLASH_MEME_IN_A_BOTTLE = ITEMS.register("splash_meme_in_a_bottle", () -> new SplashMemeBottleItem(itemBuilder()));
	public static final DeferredItem<LingeringMemeBottleItem> LINGERING_MEME_IN_A_BOTTLE = ITEMS.register("lingering_meme_in_a_bottle", () -> new LingeringMemeBottleItem(itemBuilder()));

	public static final DeferredItem<SwordItem> KNIFE = ITEMS.register("knife", () -> new KnifeItem(itemBuilder(), false));
	public static final DeferredItem<SwordItem> HOT_KNIFE = ITEMS.register("hot_knife", () -> new KnifeItem(itemBuilder(), true));

	public static final DeferredItem<Item> PEN = ITEMS.register("pen", () -> new MusicalItem(itemBuilder(), MemeSounds.ppap_havepen, null, 5, null));
	public static final DeferredItem<Item> PENPINEAPPLE = ITEMS.register("pineapple_pen", () -> new MusicalItem(itemBuilder(), MemeSounds.ppap_ahpineapplepen, MemeSounds.ppap_pineapplepen, 5, Reference.MOD_PREFIX + "instrument.info"));
	public static final DeferredItem<Item> APPLEPEN = ITEMS.register("apple_pen", () -> new MusicalItem(itemBuilder(), MemeSounds.ppap_ahapplepen, MemeSounds.ppap_applepen, 5, Reference.MOD_PREFIX + "instrument.info"));
	public static final DeferredItem<Item> PPAP = ITEMS.register("pen_pineapple_apple_pen", () -> new MusicalItem(itemBuilder(), MemeSounds.ppap_ppap, null, 5, null));

	public static final DeferredItem<Item> SAX = ITEMS.register("sax", () -> new InstrumentItem(itemBuilder(), MemeSounds.robbie_sax, MemeSounds.robbie_sax2, 20, Reference.MOD_PREFIX + "instrument.info"));
	public static final DeferredItem<Item> TRUMPET = ITEMS.register("trumpet", () -> new InstrumentItem(itemBuilder(), MemeSounds.doot, null, 5, Reference.MOD_PREFIX + "trumpet.info"));
	public static final DeferredItem<Item> FLEX_TAPE = ITEMS.register("flex_tape", () -> new FidgetItem(itemBuilder()));
	public static final DeferredItem<Item> FIDGET_SPINNER = ITEMS.register("fidget_spinner", () -> new MemeBaseItem(itemBuilder()));

	public static final DeferredItem<Item> CLIPPY = ITEMS.register("clippy", () -> new ClippyItem(itemBuilder()));
	public static final DeferredItem<Item> ROFLCOPTER = ITEMS.register("roflcopter", () -> new RoflCopterItem(itemBuilder()));

	public static final DeferredItem<Item> WAFFLE = ITEMS.register("waffle", () -> new MemeBaseItem(itemBuilder().food(MemeFoods.WAFFLE)));
	public static final DeferredItem<Item> POPTART = ITEMS.register("poptart", () -> new MemeBaseItem(itemBuilder().food(MemeFoods.POPTART)));
	public static final DeferredItem<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new FoodWithSoundItem(itemBuilder().food(MemeFoods.PINEAPPLE), MemeSounds.ppap_havepineapple, 5));
	public static final DeferredItem<Item> APPLE = ITEMS.register("apple", () -> new FoodWithSoundItem(itemBuilder().food(MemeFoods.APPLE), MemeSounds.ppap_haveapple, 5));
	public static final DeferredItem<Item> ONION = ITEMS.register("onion", () -> new FoodWithSoundItem(itemBuilder().food(MemeFoods.ONION), MemeSounds.shrek_onion, 5));
	public static final DeferredItem<Item> BURGER = ITEMS.register("mineburger", () -> new MemeBaseItem(itemBuilder().food(MemeFoods.BURGER)));
	public static final DeferredItem<Item> PILLS = ITEMS.register("pills", () -> new PillsItem(itemBuilder().food(MemeFoods.PILLS), MemeSounds.pills));
	public static final DeferredItem<Item> POD = ITEMS.register("pod", () -> new MemeBaseItem(itemBuilder().food(MemeFoods.POD)));

	public static final DeferredItem<Item> GNOME_HAT = ITEMS.register("gnome_hat", () -> new GnomeHatItem(itemBuilder()));
	public static final DeferredItem<ArmorItem> WRESTLING_BELT = ITEMS.register("wrestling_belt", () -> new CustomArmorItem(MemeArmor.BELT, Type.LEGGINGS, itemBuilder()));
	public static final DeferredItem<ArmorItem> LEATHER_BELT = ITEMS.register("leather_belt", () -> new LeatherBeltItem(MemeArmor.LEATHERBELT, Type.CHESTPLATE, itemBuilder()));
	public static final DeferredItem<ArmorItem> TRUMP_HAIR = ITEMS.register("trump_hair", () -> new CustomArmorItem(MemeArmor.TRUMPHAIR, Type.HELMET, itemBuilder()));
	public static final DeferredItem<ArmorItem> TROLL_MASK = ITEMS.register("troll_mask", () -> new CustomArmorItem(MemeArmor.TROLLMASK, Type.HELMET, itemBuilder()));
	public static final DeferredItem<ArmorItem> RIPOFF_HAT = ITEMS.register("ripoff_hat", () -> new CustomArmorItem(MemeArmor.RIPOFFHAT, Type.HELMET, itemBuilder()));
	public static final DeferredItem<ArmorItem> SUNGLASSES = ITEMS.register("sunglasses", () -> new SunglassesItem(MemeArmor.GLASSES, Type.HELMET, itemBuilder()));

	public static final DeferredItem<Item> MEME_RECORD1 = ITEMS.registerSimpleItem("meme_record_1", new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable( MemeSongs.MEME_MUSIC_1));
	public static final DeferredItem<Item> MEME_RECORD2 = ITEMS.registerSimpleItem("meme_record_2", new Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(MemeSongs.MEME_MUSIC_2));

	public static final DeferredItem<Item> JOHN_CENA_SPAWN_EGG = ITEMS.register("john_cena_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.JOHN_CENA, 16032864, 9199159, itemBuilder()));
	public static final DeferredItem<Item> DONALD_TRUMP_SPAWN_EGG = ITEMS.register("donald_trump_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.DONALD_TRUMP, 16753920, 16766720, itemBuilder()));
	public static final DeferredItem<Item> DOGE_SPAWN_EGG = ITEMS.register("doge_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.DOGE, 14196256, 15719341, itemBuilder()));
	public static final DeferredItem<Item> GRUMPY_CAT_SPAWN_EGG = ITEMS.register("grumpy_cat_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.GRUMPY_CAT, 14406346, 3354149, itemBuilder()));
	public static final DeferredItem<Item> ATTACHED_GIRLFRIEND_SPAWN_EGG = ITEMS.register("attached_girlfriend_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.ATTACHED_GIRLFRIEND, 16240814, 5187607, itemBuilder()));
	public static final DeferredItem<Item> EDUARD_KHIL_SPAWN_EGG = ITEMS.register("eduard_khil_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.EDUARD_KHIL, 16765091, 4204057, itemBuilder()));
	public static final DeferredItem<Item> PPAP_SPAWN_EGG = ITEMS.register("ppap_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.PPAP, 16768915, 2170639, itemBuilder()));
	public static final DeferredItem<Item> ROBBIE_ROTTEN_SPAWN_EGG = ITEMS.register("robbie_rotten_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.ROBBIE_ROTTEN, 16765357, 2370625, itemBuilder()));
	public static final DeferredItem<Item> GRAND_DAD_SPAWN_EGG = ITEMS.register("grand_dad_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.GRAND_DAD, 16777215, 1333964, itemBuilder()));
	public static final DeferredItem<Item> HE_MAN_SPAWN_EGG = ITEMS.register("he_man_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.HE_MAN, 13408394, 14595118, itemBuilder()));
	public static final DeferredItem<Item> ANAKIN_SKYWALKER_SPAWN_EGG = ITEMS.register("anakin_skywalker_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.SKYWALKER, 16631181, 7950634, itemBuilder()));
	public static final DeferredItem<Item> ROADMAN_SHAQ_SPAWN_EGG = ITEMS.register("roadman_shaq_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.ROADMAN_SHAQ, 6375218, 1973790, itemBuilder()));
	public static final DeferredItem<Item> PHIL_SWIFT_SPAWN_EGG = ITEMS.register("phil_swift_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.PHIL_SWIFT, 16768437, 4013373, itemBuilder()));
	public static final DeferredItem<Item> DANKEY_KANG_SPAWN_EGG = ITEMS.register("dankey_kang_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.DANKEY_KANG, 1917560, 14668958, itemBuilder()));
	public static final DeferredItem<Item> SHREK_SPAWN_EGG = ITEMS.register("shrek_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.SHREK, 6994007, 1401603, itemBuilder()));
	public static final DeferredItem<Item> DAT_BOI_SPAWN_EGG = ITEMS.register("dat_boi_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.DAT_BOI, 307716, 4276545, itemBuilder()));
	public static final DeferredItem<Item> SANIC_SPAWN_EGG = ITEMS.register("sanic_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.SANIC, 4147404, 2764941, itemBuilder()));
	public static final DeferredItem<Item> PEPE_SPAWN_EGG = ITEMS.register("pepe_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.PEPE, 5934398, 2642377, itemBuilder()));
	public static final DeferredItem<Item> FOREVER_ALONE_SPAWN_EGG = ITEMS.register("forever_alone_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.FOREVER_ALONE, 14869218, 4031140, itemBuilder()));
	public static final DeferredItem<Item> NYAN_CAT_SPAWN_EGG = ITEMS.register("nyan_cat_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.NYAN_CAT, 15118949, 15684762, itemBuilder()));
	public static final DeferredItem<Item> TAC_NAYN_SPAWN_EGG = ITEMS.register("tac_nayn_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.TAC_NAYN, 2829099, 11688484, itemBuilder()));
	public static final DeferredItem<Item> NIGEL_THORNBERRY_SPAWN_EGG = ITEMS.register("nigel_thornberry_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.NIGEL_THORNBERRY, 15044481, 11155745, itemBuilder()));
	public static final DeferredItem<Item> DANCING_HOTDOG_SPAWN_EGG = ITEMS.register("dancing_hotdog_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.DANCING_HOTDOG, 11887182, 14456412, itemBuilder()));
	public static final DeferredItem<Item> BONGO_CAT_SPAWN_EGG = ITEMS.register("bongo_cat_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.BONGO_CAT, 16777215, 1644825, itemBuilder()));
	public static final DeferredItem<Item> ROFLCOPTER_SPAWN_EGG = ITEMS.register("roflcopter_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.ROFL_COPTER, 16777215, 1644825, itemBuilder()));
	public static final DeferredItem<Item> GNOME_SPAWN_EGG = ITEMS.register("gnome_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.GNOME, 1189750, 13442571, itemBuilder()));
	public static final DeferredItem<Item> KNUCKLES_SPAWN_EGG = ITEMS.register("knuckles_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.KNUCKLES, 16729165, 16777215, itemBuilder()));
	public static final DeferredItem<Item> KNUCKLES_QUEEN_SPAWN_EGG = ITEMS.register("knuckles_queen_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.KNUCKLES_QUEEN, 16729165, 16777215, itemBuilder()));
	public static final DeferredItem<Item> SANS_SPAWN_EGG = ITEMS.register("sans_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.SANS, 6579836, 2610142, itemBuilder()));
	public static final DeferredItem<Item> PINGU_SPAWN_EGG = ITEMS.register("pingu_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.PINGU, 1975859, 15855854, itemBuilder()));
	public static final DeferredItem<Item> TOM_SPAWN_EGG = ITEMS.register("tom_spawn_egg", () -> new DeferredSpawnEggItem(MemeEntities.TOM, 9405003, 8747679, itemBuilder()));

	//Block items
	public static final DeferredItem<Item> OSCAR_ITEM = ITEMS.register("oscar", () -> new BlockItem(OSCAR.get(), new Item.Properties()));

	private static Item.Properties itemBuilder() {
		return new Item.Properties();
	}
}
