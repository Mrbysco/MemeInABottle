package com.mrbysco.miab.init;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.items.ItemClippy;
import com.mrbysco.miab.items.ItemFidget;
import com.mrbysco.miab.items.ItemKnife;
import com.mrbysco.miab.items.ItemMemeBase;
import com.mrbysco.miab.items.ItemRoflCopter;
import com.mrbysco.miab.items.armor.ItemCustomArmor;
import com.mrbysco.miab.items.armor.ItemGnomeHat;
import com.mrbysco.miab.items.armor.ItemLeatherBelt;
import com.mrbysco.miab.items.armor.ItemSunglasses;
import com.mrbysco.miab.items.bottle.DispenseHandler;
import com.mrbysco.miab.items.bottle.ItemLingeringMemeBottle;
import com.mrbysco.miab.items.bottle.ItemMemeBottle;
import com.mrbysco.miab.items.bottle.ItemSplashMemeBottle;
import com.mrbysco.miab.items.food.ItemCustomFood;
import com.mrbysco.miab.items.food.ItemFoodWithSound;
import com.mrbysco.miab.items.food.ItemPills;
import com.mrbysco.miab.items.music.ItemInstrument;
import com.mrbysco.miab.items.music.ItemMemeRecord;
import com.mrbysco.miab.items.music.ItemMusical;
import net.minecraft.block.BlockDispenser;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@EventBusSubscriber
public class MemeItems {
	public static Item meme_in_a_bottle;
	public static Item splash_meme_in_a_bottle;
	public static Item lingering_meme_in_a_bottle;

	public static ItemSword knife;
	public static ItemSword hot_knife;

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
	
	public static ItemFood waffle;
	public static ItemFood poptart;
	public static ItemFood pineapple;
	public static ItemFood apple;
	public static ItemFood onion;
	public static ItemFood burger;
	public static ItemFood pills_here;
	public static ItemFood pod;

	public static Item gnome_hat;
	public static ItemArmor wrestling_belt;
	public static ItemArmor leather_belt;
	public static ItemArmor trump_hair;
	public static ItemArmor troll_mask;
	public static ItemArmor ripoff_hat;
	public static ItemArmor sunglasses;

	public static ItemRecord meme_record1;
	public static ItemRecord meme_record2;
	public static ItemRecord meme_record3;
	public static ItemRecord meme_record4;
	
	public static ArrayList<Item> ITEMS = new ArrayList<>();

	public static final ArmorMaterial trumphair = EnumHelper.addArmorMaterial("trumphair", "memeinabottle:trumphair", 5 , new int[]{1, 3, 2, 1}, 15, MemeSounds.trump_sound, 0F);
	public static final ArmorMaterial belt = EnumHelper.addArmorMaterial("belt", "memeinabottle:belt", 7, new int[]{2, 5, 3, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial leatherbelt = EnumHelper.addArmorMaterial("leatherbelt", "memeinabottle:leatherbelt", 7, new int[]{1, 3, 2, 1}, 15, MemeSounds.leather_belt, 0F);
	public static final ArmorMaterial trollmask = EnumHelper.addArmorMaterial("trollmask", "memeinabottle:trollmask", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.trololo, 0F);
	public static final ArmorMaterial ripoffhat = EnumHelper.addArmorMaterial("rippoffhat", "memeinabottle:rippoffhat", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.dad_summon, 0F);
	public static final ArmorMaterial glasses = EnumHelper.addArmorMaterial("sunglasses", "memeinabottle:sunglasses", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.thuglife, 0F);

	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        meme_in_a_bottle = registerItem(new ItemMemeBottle("meme_in_a_bottle"));
        splash_meme_in_a_bottle = registerItem(new ItemSplashMemeBottle("splash_meme_in_a_bottle"));
        lingering_meme_in_a_bottle = registerItem(new ItemLingeringMemeBottle("lingering_meme_in_a_bottle"));

		knife = registerItem(new ItemKnife(Item.ToolMaterial.IRON, "knife", false));
		hot_knife = registerItem(new ItemKnife(Item.ToolMaterial.IRON, "hot_knife", true));

		pen = registerItem(new ItemMusical("pen", MemeSounds.ppap_havepen, null, 5, null));
		penpineapple = registerItem(new ItemMusical("pineapple_pen", MemeSounds.ppap_ahpineapplepen, MemeSounds.ppap_pineapplepen, 5, Reference.MOD_PREFIX + "instrument.info"));
		applepen = registerItem(new ItemMusical("apple_pen", MemeSounds.ppap_ahapplepen, MemeSounds.ppap_applepen, 5, Reference.MOD_PREFIX + "instrument.info"));
		ppap = registerItem(new ItemMusical("pen_pineapple_apple_pen", MemeSounds.ppap_ppap, null, 5, null));

		sax = registerItem(new ItemInstrument("sax", MemeSounds.robbie_sax, MemeSounds.robbie_sax2, 20, Reference.MOD_PREFIX + "instrument.info"));
		trumpet = registerItem(new ItemInstrument("trumpet", MemeSounds.doot, null, 5, Reference.MOD_PREFIX + "trumpet.info"));
		flex_tape = registerItem(new ItemMemeBase("flex_tape"));
		fidget_spinner = registerItem(new ItemFidget("fidget_spinner"));

		clippy = registerItem(new ItemClippy("clippy"));
		roflcopter = registerItem(new ItemRoflCopter("roflcopter"));

		waffle = registerItem(new ItemCustomFood(3, 3, false, "waffle"));
		poptart = registerItem(new ItemCustomFood(3, 3, false, "poptart"));
		pineapple = registerItem(new ItemFoodWithSound(3, 4, false, "pineapple", MemeSounds.ppap_havepineapple, 5));
		apple = registerItem(new ItemFoodWithSound(2, 4, false, "apple", MemeSounds.ppap_haveapple, 5));
		onion = registerItem(new ItemFoodWithSound(2, 4, false, "onion", MemeSounds.shrek_onion, 5));
		burger = registerItem(new ItemCustomFood(4, 4, false, "mineburger"));
		pills_here = registerItem(new ItemPills(0, 0, false, "pills", MemeSounds.pills));
		pod = registerItem(new ItemCustomFood(1, 0.4F, false, "pod").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.POISON, 12*20, 1), 1F));

		trump_hair = registerItem(new ItemCustomArmor(trumphair, 1, EntityEquipmentSlot.HEAD, "trump_hair"));
		gnome_hat = registerItem(new ItemGnomeHat("gnome_hat"));
		wrestling_belt = registerItem(new ItemCustomArmor(belt, 2, EntityEquipmentSlot.LEGS, "wrestling_belt"));
		leather_belt = registerItem(new ItemLeatherBelt(leatherbelt, 1, EntityEquipmentSlot.CHEST, "leather_belt"));
		troll_mask = registerItem(new ItemCustomArmor(trollmask, 1, EntityEquipmentSlot.HEAD, "troll_mask"));
		ripoff_hat = registerItem(new ItemCustomArmor(ripoffhat, 1, EntityEquipmentSlot.HEAD, "ripoff_hat"));
		sunglasses = registerItem(new ItemSunglasses(glasses, 1, EntityEquipmentSlot.HEAD, "sunglasses"));

		meme_record1 = registerItem(new ItemMemeRecord("memesong1", MemeSounds.meme_music, "meme_record_1"));
		meme_record2 = registerItem(new ItemMemeRecord("memesong2", MemeSounds.meme_music2, "meme_record_2"));
		meme_record3 = registerItem(new ItemMemeRecord("memesong3", MemeSounds.meme_music3, "meme_record_3"));
		meme_record4 = registerItem(new ItemMemeRecord("memesong4", MemeSounds.meme_music4, "meme_record_4"));

		registry.registerAll(ITEMS.toArray(new Item[0]));
		registerDispenserBehavior();
	}
	
	public static void registerDispenserBehavior() {
    	BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(MemeItems.splash_meme_in_a_bottle, new DispenseHandler());
    	BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(MemeItems.lingering_meme_in_a_bottle, new DispenseHandler());
	}
	
	public static <T extends Item> T registerItem(T item) {
        ITEMS.add(item);
        return item;
    }
}
