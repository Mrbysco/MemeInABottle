package com.mrbysco.miab.init;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.blocks.BlockOscar;
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
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MemeRegister {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Reference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Reference.MOD_ID);

	//BLOCKS
	public static final RegistryObject<BlockOscar> OSCAR = BLOCKS.register("oscar", () -> new BlockOscar(Block.Properties.create(Material.IRON)));

	//ITEMS
	public static final RegistryObject<Item> meme_in_a_bottle = ITEMS.register("meme_in_a_bottle", () -> new ItemMemeBottle(itemBuilder()));
	public static final RegistryObject<Item> splash_meme_in_a_bottle = ITEMS.register("splash_meme_in_a_bottle", () -> new ItemSplashMemeBottle(itemBuilder()));
	public static final RegistryObject<Item> lingering_meme_in_a_bottle = ITEMS.register("lingering_meme_in_a_bottle", () -> new ItemLingeringMemeBottle(itemBuilder()));

	public static final RegistryObject<SwordItem> knife = ITEMS.register("knife", () -> new ItemKnife(itemBuilder(), false));
	public static final RegistryObject<SwordItem> hot_knife = ITEMS.register("hot_knife", () -> new ItemKnife(itemBuilder(), true));

	public static final RegistryObject<Item> pen = ITEMS.register("pen", () -> new ItemMusical(itemBuilder(), MemeSounds.ppap_havepen.get(), null, 5, null));
	public static final RegistryObject<Item> penpineapple = ITEMS.register("pineapple_pen", () -> new ItemMusical(itemBuilder(), MemeSounds.ppap_ahpineapplepen.get(), MemeSounds.ppap_pineapplepen.get(), 5, Reference.MOD_PREFIX + "instrument.info"));
	public static final RegistryObject<Item> applepen = ITEMS.register("apple_pen", () -> new ItemMusical(itemBuilder(), MemeSounds.ppap_ahapplepen.get(), MemeSounds.ppap_applepen.get(), 5, Reference.MOD_PREFIX + "instrument.info"));
	public static final RegistryObject<Item> ppap = ITEMS.register("pen_pineapple_apple_pen", () -> new ItemMusical(itemBuilder(), MemeSounds.ppap_ppap.get(), null, 5, null));

	public static final RegistryObject<Item> sax = ITEMS.register("sax", () -> new ItemInstrument(itemBuilder(), MemeSounds.robbie_sax.get(), MemeSounds.robbie_sax2.get(), 20, Reference.MOD_PREFIX + "instrument.info"));
	public static final RegistryObject<Item> trumpet = ITEMS.register("trumpet", () -> new ItemInstrument(itemBuilder(), MemeSounds.doot.get(), null, 5, Reference.MOD_PREFIX + "trumpet.info"));
	public static final RegistryObject<Item> flex_tape = ITEMS.register("flex_tape", () -> new ItemFidget(itemBuilder()));
	public static final RegistryObject<Item> fidget_spinner = ITEMS.register("fidget_spinner", () -> new ItemMemeBase(itemBuilder()));

	public static final RegistryObject<Item> clippy = ITEMS.register("clippy", () -> new ItemClippy(itemBuilder()));
	public static final RegistryObject<Item> roflcopter = ITEMS.register("roflcopter", () -> new ItemRoflCopter(itemBuilder()));

	public static final RegistryObject<Item> waffle = ITEMS.register("waffle", () -> new ItemMemeBase(itemBuilder().food(MemeFoods.WAFFLE)));
	public static final RegistryObject<Item> poptart = ITEMS.register("poptart", () -> new ItemMemeBase(itemBuilder().food(MemeFoods.POPTART)));
	public static final RegistryObject<Item> pineapple = ITEMS.register("pineapple", () -> new ItemFoodWithSound(itemBuilder().food(MemeFoods.PINEAPPLE), MemeSounds.ppap_havepineapple.get(), 5));
	public static final RegistryObject<Item> apple = ITEMS.register("apple", () -> new ItemFoodWithSound(itemBuilder().food(MemeFoods.APPLE), MemeSounds.ppap_haveapple.get(), 5));
	public static final RegistryObject<Item> onion = ITEMS.register("onion", () -> new ItemFoodWithSound(itemBuilder().food(MemeFoods.ONION), MemeSounds.shrek_onion.get(), 5));
	public static final RegistryObject<Item> burger = ITEMS.register("mineburger", () -> new ItemMemeBase(itemBuilder().food(MemeFoods.BURGER)));
	public static final RegistryObject<Item> pills = ITEMS.register("pills", () -> new ItemPills(itemBuilder().food(MemeFoods.PILLS), MemeSounds.pills.get()));
	public static final RegistryObject<Item> pod = ITEMS.register("pod", () -> new ItemMemeBase(itemBuilder().food(MemeFoods.POD)));

	public static final RegistryObject<Item> gnome_hat = ITEMS.register("gnome_hat", () -> new ItemGnomeHat(itemBuilder()));
	public static final RegistryObject<ArmorItem> wrestling_belt = ITEMS.register("wrestling_belt", () -> new ItemCustomArmor(MemeArmor.BELT, EquipmentSlotType.LEGS, itemBuilder()));
	public static final RegistryObject<ArmorItem> leather_belt = ITEMS.register("leather_belt", () -> new ItemLeatherBelt(MemeArmor.LEATHERBELT, EquipmentSlotType.CHEST, itemBuilder()));
	public static final RegistryObject<ArmorItem> trump_hair = ITEMS.register("trump_hair", () -> new ItemCustomArmor(MemeArmor.TRUMPHAIR, EquipmentSlotType.HEAD, itemBuilder()));
	public static final RegistryObject<ArmorItem> troll_mask = ITEMS.register("troll_mask", () -> new ItemCustomArmor(MemeArmor.TROLLMASK, EquipmentSlotType.HEAD, itemBuilder()));
	public static final RegistryObject<ArmorItem> ripoff_hat = ITEMS.register("ripoff_hat", () -> new ItemCustomArmor(MemeArmor.RIPOFFHAT, EquipmentSlotType.HEAD, itemBuilder()));
	public static final RegistryObject<ArmorItem> sunglasses = ITEMS.register("sunglasses", () -> new ItemSunglasses(MemeArmor.GLASSES, EquipmentSlotType.HEAD, itemBuilder()));

	public static final RegistryObject<MusicDiscItem> meme_record1 = ITEMS.register("meme_record_1" , () -> new ItemMemeRecord(0, MemeSounds.meme_music.get(), itemBuilder()));
	public static final RegistryObject<MusicDiscItem> meme_record2 = ITEMS.register("meme_record_2" , () -> new ItemMemeRecord(0, MemeSounds.meme_music2.get(), itemBuilder()));
	public static final RegistryObject<MusicDiscItem> meme_record3 = ITEMS.register("meme_record_3" , () -> new ItemMemeRecord(0, MemeSounds.meme_music3.get(), itemBuilder()));
	public static final RegistryObject<MusicDiscItem> meme_record4 = ITEMS.register("meme_record_4" , () -> new ItemMemeRecord(0, MemeSounds.meme_music4.get(), itemBuilder()));

	public static final RegistryObject<Item> john_cena_spawn_egg = ITEMS.register("john_cena_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.JOHN_CENA.get(), 16032864, 9199159, itemBuilder()));
	public static final RegistryObject<Item> donald_trump_spawn_egg = ITEMS.register("donald_trump_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.DONALD_TRUMP.get(), 16753920, 16766720, itemBuilder()));
	public static final RegistryObject<Item> doge_spawn_egg = ITEMS.register("doge_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.DOGE.get(), 14196256, 15719341, itemBuilder()));
	public static final RegistryObject<Item> grumpy_cat_spawn_egg = ITEMS.register("grumpy_cat_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.GRUMPY_CAT.get(), 14406346, 3354149, itemBuilder()));
	public static final RegistryObject<Item> attached_girlfriend_spawn_egg = ITEMS.register("attached_girlfriend_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.ATTACHED_GIRLFRIEND.get(), 16240814, 5187607, itemBuilder()));
	public static final RegistryObject<Item> eduard_khil_spawn_egg = ITEMS.register("eduard_khil_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.EDUARD_KHIL.get(), 16765091, 4204057, itemBuilder()));
	public static final RegistryObject<Item> ppap_spawn_egg = ITEMS.register("ppap_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.PPAP.get(), 16768915, 2170639, itemBuilder()));
	public static final RegistryObject<Item> robbie_rotten_spawn_egg = ITEMS.register("robbie_rotten_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.ROBBIE_ROTTEN.get(), 16765357, 2370625, itemBuilder()));
	public static final RegistryObject<Item> grand_dad_spawn_egg = ITEMS.register("grand_dad_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.GRAND_DAD.get(), 16777215, 1333964, itemBuilder()));
	public static final RegistryObject<Item> he_man_spawn_egg = ITEMS.register("he_man_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.HE_MAN.get(), 13408394, 14595118, itemBuilder()));
	public static final RegistryObject<Item> anakin_skywalker_spawn_egg = ITEMS.register("anakin_skywalker_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.SKYWALKER.get(), 16631181, 7950634, itemBuilder()));
	public static final RegistryObject<Item> roadman_shaq_spawn_egg = ITEMS.register("roadman_shaq_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.ROADMAN_SHAQ.get(), 6375218, 1973790, itemBuilder()));
	public static final RegistryObject<Item> phil_swift_spawn_egg = ITEMS.register("phil_swift_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.PHIL_SWIFT.get(), 16768437, 4013373, itemBuilder()));
	public static final RegistryObject<Item> dankey_kang_spawn_egg = ITEMS.register("dankey_kang_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.DANKEY_KANG.get(), 1917560, 14668958, itemBuilder()));
	public static final RegistryObject<Item> shrek_spawn_egg = ITEMS.register("shrek_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.SHREK.get(), 6994007, 1401603, itemBuilder()));
	public static final RegistryObject<Item> dat_boi_spawn_egg = ITEMS.register("dat_boi_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.DAT_BOI.get(), 307716, 4276545, itemBuilder()));
	public static final RegistryObject<Item> sanic_spawn_egg = ITEMS.register("sanic_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.SANIC.get(), 4147404, 2764941, itemBuilder()));
	public static final RegistryObject<Item> pepe_spawn_egg = ITEMS.register("pepe_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.PEPE.get(), 5934398, 2642377, itemBuilder()));
	public static final RegistryObject<Item> forever_alone_spawn_egg = ITEMS.register("forever_alone_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.FOREVER_ALONE.get(), 14869218, 4031140, itemBuilder()));
	public static final RegistryObject<Item> nyan_cat_spawn_egg = ITEMS.register("nyan_cat_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.NYAN_CAT.get(), 15118949, 15684762, itemBuilder()));
	public static final RegistryObject<Item> tac_nayn_spawn_egg = ITEMS.register("tac_nayn_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.TAC_NAYN.get(), 2829099, 11688484, itemBuilder()));
	public static final RegistryObject<Item> nigel_thornberry_spawn_egg = ITEMS.register("nigel_thornberry_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.NIGEL_THORNBERRY.get(), 15044481, 11155745, itemBuilder()));
	public static final RegistryObject<Item> dancing_hotdog_spawn_egg = ITEMS.register("dancing_hotdog_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.DANCING_HOTDOG.get(), 11887182, 14456412, itemBuilder()));
	public static final RegistryObject<Item> bongo_cat_spawn_egg = ITEMS.register("bongo_cat_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.BONGO_CAT.get(), 16777215, 1644825, itemBuilder()));
	public static final RegistryObject<Item> roflcopter_spawn_egg = ITEMS.register("roflcopter_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.ROFL_COPTER.get(), 16777215, 1644825, itemBuilder()));
	public static final RegistryObject<Item> gnome_spawn_egg = ITEMS.register("gnome_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.GNOME.get(), 1189750, 13442571, itemBuilder()));
	public static final RegistryObject<Item> knuckles_spawn_egg = ITEMS.register("knuckles_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.KNUCKLES.get(), 16729165, 16777215, itemBuilder()));
	public static final RegistryObject<Item> knuckles_queen_spawn_egg = ITEMS.register("knuckles_queen_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.KNUCKLES_QUEEN.get(), 16729165, 16777215, itemBuilder()));
	public static final RegistryObject<Item> sans_spawn_egg = ITEMS.register("sans_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.SANS.get(), 6579836, 2610142, itemBuilder()));
	public static final RegistryObject<Item> pingu_spawn_egg = ITEMS.register("pingu_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.PINGU.get(), 1975859, 15855854, itemBuilder()));
	public static final RegistryObject<Item> tom_spawn_egg = ITEMS.register("tom_spawn_egg" , () -> new ItemMemeSpawnEgg(MemeEntities.TOM.get(), 9405003, 8747679, itemBuilder()));

	static {
		ITEMS.register("oscar", () -> new BlockItem(OSCAR.get(), new Item.Properties().group(MemeTab.MEME_TAB)));
	}

	private static Item.Properties itemBuilder()
	{
		return new Item.Properties();
	}
}
