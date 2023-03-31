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
import com.mrbysco.miab.items.music.MemeRecordItem;
import com.mrbysco.miab.items.music.MusicalItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MemeRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

	//BLOCKS
	public static final RegistryObject<OscarBlock> OSCAR = BLOCKS.register("oscar", () -> new OscarBlock(Block.Properties.of(Material.METAL)));

	//ITEMS
	public static final RegistryObject<Item> MEME_IN_A_BOTTLE = ITEMS.register("meme_in_a_bottle", () -> new MemeBottleItem(itemBuilder()));
	public static final RegistryObject<Item> SPLASH_MEME_IN_A_BOTTLE = ITEMS.register("splash_meme_in_a_bottle", () -> new SplashMemeBottleItem(itemBuilder()));
	public static final RegistryObject<Item> LINGERING_MEME_IN_A_BOTTLE = ITEMS.register("lingering_meme_in_a_bottle", () -> new LingeringMemeBottleItem(itemBuilder()));

	public static final RegistryObject<SwordItem> KNIFE = ITEMS.register("knife", () -> new KnifeItem(itemBuilder(), false));
	public static final RegistryObject<SwordItem> HOT_KNIFE = ITEMS.register("hot_knife", () -> new KnifeItem(itemBuilder(), true));

	public static final RegistryObject<Item> PEN = ITEMS.register("pen", () -> new MusicalItem(itemBuilder(), () -> MemeSounds.ppap_havepen.get(), null, 5, null));
	public static final RegistryObject<Item> PENPINEAPPLE = ITEMS.register("pineapple_pen", () -> new MusicalItem(itemBuilder(), () -> MemeSounds.ppap_ahpineapplepen.get(), () -> MemeSounds.ppap_pineapplepen.get(), 5, Reference.MOD_PREFIX + "instrument.info"));
	public static final RegistryObject<Item> APPLEPEN = ITEMS.register("apple_pen", () -> new MusicalItem(itemBuilder(), () -> MemeSounds.ppap_ahapplepen.get(), () -> MemeSounds.ppap_applepen.get(), 5, Reference.MOD_PREFIX + "instrument.info"));
	public static final RegistryObject<Item> PPAP = ITEMS.register("pen_pineapple_apple_pen", () -> new MusicalItem(itemBuilder(), () -> MemeSounds.ppap_ppap.get(), null, 5, null));

	public static final RegistryObject<Item> SAX = ITEMS.register("sax", () -> new InstrumentItem(itemBuilder(), () -> MemeSounds.robbie_sax.get(), () -> MemeSounds.robbie_sax2.get(), 20, Reference.MOD_PREFIX + "instrument.info"));
	public static final RegistryObject<Item> TRUMPET = ITEMS.register("trumpet", () -> new InstrumentItem(itemBuilder(), () -> MemeSounds.doot.get(), null, 5, Reference.MOD_PREFIX + "trumpet.info"));
	public static final RegistryObject<Item> FLEX_TAPE = ITEMS.register("flex_tape", () -> new FidgetItem(itemBuilder()));
	public static final RegistryObject<Item> FIDGET_SPINNER = ITEMS.register("fidget_spinner", () -> new MemeBaseItem(itemBuilder()));

	public static final RegistryObject<Item> CLIPPY = ITEMS.register("clippy", () -> new ClippyItem(itemBuilder()));
	public static final RegistryObject<Item> ROFLCOPTER = ITEMS.register("roflcopter", () -> new RoflCopterItem(itemBuilder()));

	public static final RegistryObject<Item> WAFFLE = ITEMS.register("waffle", () -> new MemeBaseItem(itemBuilder().food(MemeFoods.WAFFLE)));
	public static final RegistryObject<Item> POPTART = ITEMS.register("poptart", () -> new MemeBaseItem(itemBuilder().food(MemeFoods.POPTART)));
	public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new FoodWithSoundItem(itemBuilder().food(MemeFoods.PINEAPPLE), () -> MemeSounds.ppap_havepineapple.get(), 5));
	public static final RegistryObject<Item> APPLE = ITEMS.register("apple", () -> new FoodWithSoundItem(itemBuilder().food(MemeFoods.APPLE), () -> MemeSounds.ppap_haveapple.get(), 5));
	public static final RegistryObject<Item> ONION = ITEMS.register("onion", () -> new FoodWithSoundItem(itemBuilder().food(MemeFoods.ONION), () -> MemeSounds.shrek_onion.get(), 5));
	public static final RegistryObject<Item> BURGER = ITEMS.register("mineburger", () -> new MemeBaseItem(itemBuilder().food(MemeFoods.BURGER)));
	public static final RegistryObject<Item> PILLS = ITEMS.register("pills", () -> new PillsItem(itemBuilder().food(MemeFoods.PILLS), () -> MemeSounds.pills.get()));
	public static final RegistryObject<Item> POD = ITEMS.register("pod", () -> new MemeBaseItem(itemBuilder().food(MemeFoods.POD)));

	public static final RegistryObject<Item> GNOME_HAT = ITEMS.register("gnome_hat", () -> new GnomeHatItem(itemBuilder()));
	public static final RegistryObject<ArmorItem> WRESTLING_BELT = ITEMS.register("wrestling_belt", () -> new CustomArmorItem(MemeArmor.BELT, EquipmentSlot.LEGS, itemBuilder()));
	public static final RegistryObject<ArmorItem> LEATHER_BELT = ITEMS.register("leather_belt", () -> new LeatherBeltItem(MemeArmor.LEATHERBELT, EquipmentSlot.CHEST, itemBuilder()));
	public static final RegistryObject<ArmorItem> TRUMP_HAIR = ITEMS.register("trump_hair", () -> new CustomArmorItem(MemeArmor.TRUMPHAIR, EquipmentSlot.HEAD, itemBuilder()));
	public static final RegistryObject<ArmorItem> TROLL_MASK = ITEMS.register("troll_mask", () -> new CustomArmorItem(MemeArmor.TROLLMASK, EquipmentSlot.HEAD, itemBuilder()));
	public static final RegistryObject<ArmorItem> RIPOFF_HAT = ITEMS.register("ripoff_hat", () -> new CustomArmorItem(MemeArmor.RIPOFFHAT, EquipmentSlot.HEAD, itemBuilder()));
	public static final RegistryObject<ArmorItem> SUNGLASSES = ITEMS.register("sunglasses", () -> new SunglassesItem(MemeArmor.GLASSES, EquipmentSlot.HEAD, itemBuilder()));

	public static final RegistryObject<RecordItem> MEME_RECORD1 = ITEMS.register("meme_record_1", () -> new MemeRecordItem(0, () -> MemeSounds.meme_music1.get(), 4820, itemBuilder()));
	public static final RegistryObject<RecordItem> MEME_RECORD2 = ITEMS.register("meme_record_2", () -> new MemeRecordItem(0, () -> MemeSounds.meme_music2.get(), 3140, itemBuilder()));

	public static final RegistryObject<Item> JOHN_CENA_SPAWN_EGG = ITEMS.register("john_cena_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.JOHN_CENA.get(), 16032864, 9199159, itemBuilder()));
	public static final RegistryObject<Item> DONALD_TRUMP_SPAWN_EGG = ITEMS.register("donald_trump_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.DONALD_TRUMP.get(), 16753920, 16766720, itemBuilder()));
	public static final RegistryObject<Item> DOGE_SPAWN_EGG = ITEMS.register("doge_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.DOGE.get(), 14196256, 15719341, itemBuilder()));
	public static final RegistryObject<Item> GRUMPY_CAT_SPAWN_EGG = ITEMS.register("grumpy_cat_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.GRUMPY_CAT.get(), 14406346, 3354149, itemBuilder()));
	public static final RegistryObject<Item> ATTACHED_GIRLFRIEND_SPAWN_EGG = ITEMS.register("attached_girlfriend_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.ATTACHED_GIRLFRIEND.get(), 16240814, 5187607, itemBuilder()));
	public static final RegistryObject<Item> EDUARD_KHIL_SPAWN_EGG = ITEMS.register("eduard_khil_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.EDUARD_KHIL.get(), 16765091, 4204057, itemBuilder()));
	public static final RegistryObject<Item> PPAP_SPAWN_EGG = ITEMS.register("ppap_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.PPAP.get(), 16768915, 2170639, itemBuilder()));
	public static final RegistryObject<Item> ROBBIE_ROTTEN_SPAWN_EGG = ITEMS.register("robbie_rotten_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.ROBBIE_ROTTEN.get(), 16765357, 2370625, itemBuilder()));
	public static final RegistryObject<Item> GRAND_DAD_SPAWN_EGG = ITEMS.register("grand_dad_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.GRAND_DAD.get(), 16777215, 1333964, itemBuilder()));
	public static final RegistryObject<Item> HE_MAN_SPAWN_EGG = ITEMS.register("he_man_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.HE_MAN.get(), 13408394, 14595118, itemBuilder()));
	public static final RegistryObject<Item> ANAKIN_SKYWALKER_SPAWN_EGG = ITEMS.register("anakin_skywalker_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.SKYWALKER.get(), 16631181, 7950634, itemBuilder()));
	public static final RegistryObject<Item> ROADMAN_SHAQ_SPAWN_EGG = ITEMS.register("roadman_shaq_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.ROADMAN_SHAQ.get(), 6375218, 1973790, itemBuilder()));
	public static final RegistryObject<Item> PHIL_SWIFT_SPAWN_EGG = ITEMS.register("phil_swift_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.PHIL_SWIFT.get(), 16768437, 4013373, itemBuilder()));
	public static final RegistryObject<Item> DANKEY_KANG_SPAWN_EGG = ITEMS.register("dankey_kang_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.DANKEY_KANG.get(), 1917560, 14668958, itemBuilder()));
	public static final RegistryObject<Item> SHREK_SPAWN_EGG = ITEMS.register("shrek_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.SHREK.get(), 6994007, 1401603, itemBuilder()));
	public static final RegistryObject<Item> DAT_BOI_SPAWN_EGG = ITEMS.register("dat_boi_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.DAT_BOI.get(), 307716, 4276545, itemBuilder()));
	public static final RegistryObject<Item> SANIC_SPAWN_EGG = ITEMS.register("sanic_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.SANIC.get(), 4147404, 2764941, itemBuilder()));
	public static final RegistryObject<Item> PEPE_SPAWN_EGG = ITEMS.register("pepe_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.PEPE.get(), 5934398, 2642377, itemBuilder()));
	public static final RegistryObject<Item> FOREVER_ALONE_SPAWN_EGG = ITEMS.register("forever_alone_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.FOREVER_ALONE.get(), 14869218, 4031140, itemBuilder()));
	public static final RegistryObject<Item> NYAN_CAT_SPAWN_EGG = ITEMS.register("nyan_cat_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.NYAN_CAT.get(), 15118949, 15684762, itemBuilder()));
	public static final RegistryObject<Item> TAC_NAYN_SPAWN_EGG = ITEMS.register("tac_nayn_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.TAC_NAYN.get(), 2829099, 11688484, itemBuilder()));
	public static final RegistryObject<Item> NIGEL_THORNBERRY_SPAWN_EGG = ITEMS.register("nigel_thornberry_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.NIGEL_THORNBERRY.get(), 15044481, 11155745, itemBuilder()));
	public static final RegistryObject<Item> DANCING_HOTDOG_SPAWN_EGG = ITEMS.register("dancing_hotdog_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.DANCING_HOTDOG.get(), 11887182, 14456412, itemBuilder()));
	public static final RegistryObject<Item> BONGO_CAT_SPAWN_EGG = ITEMS.register("bongo_cat_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.BONGO_CAT.get(), 16777215, 1644825, itemBuilder()));
	public static final RegistryObject<Item> ROFLCOPTER_SPAWN_EGG = ITEMS.register("roflcopter_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.ROFL_COPTER.get(), 16777215, 1644825, itemBuilder()));
	public static final RegistryObject<Item> GNOME_SPAWN_EGG = ITEMS.register("gnome_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.GNOME.get(), 1189750, 13442571, itemBuilder()));
	public static final RegistryObject<Item> KNUCKLES_SPAWN_EGG = ITEMS.register("knuckles_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.KNUCKLES.get(), 16729165, 16777215, itemBuilder()));
	public static final RegistryObject<Item> KNUCKLES_QUEEN_SPAWN_EGG = ITEMS.register("knuckles_queen_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.KNUCKLES_QUEEN.get(), 16729165, 16777215, itemBuilder()));
	public static final RegistryObject<Item> SANS_SPAWN_EGG = ITEMS.register("sans_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.SANS.get(), 6579836, 2610142, itemBuilder()));
	public static final RegistryObject<Item> PINGU_SPAWN_EGG = ITEMS.register("pingu_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.PINGU.get(), 1975859, 15855854, itemBuilder()));
	public static final RegistryObject<Item> TOM_SPAWN_EGG = ITEMS.register("tom_spawn_egg", () -> new ForgeSpawnEggItem(() -> MemeEntities.TOM.get(), 9405003, 8747679, itemBuilder()));

	//Block items
	public static final RegistryObject<Item> OSCAR_ITEM = ITEMS.register("oscar", () -> new BlockItem(OSCAR.get(), new Item.Properties()));

	private static Item.Properties itemBuilder() {
		return new Item.Properties().tab(MemeTab.MEME_TAB);
	}
}
