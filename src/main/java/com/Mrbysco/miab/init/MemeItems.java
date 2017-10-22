package com.Mrbysco.miab.init;

import com.Mrbysco.miab.handlers.DispenseHandler;
import com.Mrbysco.miab.items.ItemDebug;
import com.Mrbysco.miab.items.ItemFidget;
import com.Mrbysco.miab.items.ItemInstrument;
import com.Mrbysco.miab.items.ItemKnife;
import com.Mrbysco.miab.items.ItemLeatherBelt;
import com.Mrbysco.miab.items.ItemLingeringMemeBottle;
import com.Mrbysco.miab.items.ItemMemeBottle;
import com.Mrbysco.miab.items.ItemSplashMemeBottle;
import com.Mrbysco.miab.items.ItemSunglasses;
import com.Mrbysco.miab.items.base.ItemCustomArmor;
import com.Mrbysco.miab.items.base.ItemCustomFood;
import com.Mrbysco.miab.items.base.ItemCustomItemInfo;
import com.Mrbysco.miab.items.base.ItemCustomRecord;
import com.Mrbysco.miab.items.base.ItemMusical;
import com.Mrbysco.miab.items.food.ItemFoodWithSound;
import com.Mrbysco.miab.items.food.ItemPills;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class MemeItems {
	
	public static Item meme_in_a_bottle;
	public static Item splash_meme_in_a_bottle;
	public static Item lingering_meme_in_a_bottle;
	public static ItemArmor mcw_belt;
	public static ItemArmor leather_belt;
	public static ItemArmor trump_hair;
	public static ItemArmor troll_mask;
	public static ItemArmor ripoff_hat;
	public static ItemFood pineapple;
	public static ItemFood apple;
	public static Item penpineapple;
	public static Item applepen;
	public static Item pen;
	public static Item ppap;
	public static ItemFood onion;
	public static ItemFood burger;
	public static Item sax;
	public static Item waffle;
	public static Item poptart;
	public static ItemRecord meme_record1;
	public static ItemRecord meme_record2;
	public static ItemRecord meme_record3;
	public static ItemRecord meme_record4;
	public static ItemSword knife;
	public static ItemSword hot_knife;
	public static Item fidget;
	public static ItemFood pills_here;
	public static Item trumpet;
	public static ItemArmor sunglasses;
	public static Item clippy;
	public static Item debug;
	
	public static final ArmorMaterial trumphair = EnumHelper.addArmorMaterial("trumphair", "memeinabottle:trumphair", 5 , new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial belt = EnumHelper.addArmorMaterial("belt", "memeinabottle:belt", 7, new int[]{2, 5, 3, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0F);
	public static final ArmorMaterial leatherbelt = EnumHelper.addArmorMaterial("leatherbelt", "memeinabottle:leatherbelt", 7, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial trollmask = EnumHelper.addArmorMaterial("trollmask", "memeinabottle:trollmask", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial ripoffhat = EnumHelper.addArmorMaterial("rippoffhat", "memeinabottle:rippoffhat", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial glasses = EnumHelper.addArmorMaterial("sunglasses", "memeinabottle:sunglasses", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.thuglife, 0F);
	
	public static void init(){
		meme_in_a_bottle = new ItemMemeBottle("memeinabottle", "meme_in_a_bottle");
		splash_meme_in_a_bottle = new ItemSplashMemeBottle("splashmemeinabottle", "splash_meme_in_a_bottle");
		lingering_meme_in_a_bottle = new ItemLingeringMemeBottle("lingeringmemeinabottle", "lingering_meme_in_a_bottle");
		trump_hair = new ItemCustomArmor(trumphair, 1, EntityEquipmentSlot.HEAD, "trumphair", "trump_hair");
		mcw_belt = new ItemCustomArmor(belt, 2, EntityEquipmentSlot.LEGS,"mcwbelt", "mcw_belt");
		leather_belt = new ItemLeatherBelt(leatherbelt, 1, EntityEquipmentSlot.CHEST, "leatherbelt", "leather_belt");
		troll_mask = new ItemCustomArmor(trollmask, 1, EntityEquipmentSlot.HEAD, "trollmask", "troll_mask");
		ripoff_hat = new ItemCustomArmor(ripoffhat, 1, EntityEquipmentSlot.HEAD, "rippoffhat", "ripoff_hat");
		pineapple = new ItemFoodWithSound(3, 4, false, "pineapple", "pineapple", MemeSounds.ppap_havepineapple, 5);
		apple = new ItemFoodWithSound(2, 4, false, "apple", "apple", MemeSounds.ppap_haveapple, 5);
		onion = new ItemFoodWithSound(2, 4, false, "onion", "onion", MemeSounds.shrek_onion, 5);
		burger = new ItemCustomFood(4, 4, false, "mineburger", "mineburger");
		waffle = new ItemCustomFood(3, 3, false, "waffle", "waffle");
		poptart = new ItemCustomFood(3, 3, false, "poptart", "poptart");
		pen = new ItemMusical("pen", "pen", MemeSounds.ppap_havepen, null, 5, null);
		pills_here = new ItemPills(0, 0, false, "pills", "pills", MemeSounds.pills);
		penpineapple = new ItemMusical("pineapplepen", "pineapple_pen", MemeSounds.ppap_ahpineapplepen, MemeSounds.ppap_pineapplepen, 5, "instrument.info");
		applepen = new ItemMusical("applepen", "apple_pen", MemeSounds.ppap_ahapplepen, MemeSounds.ppap_applepen, 5, "instrument.info");
		ppap = new ItemMusical("ppap", "pen_pineapple_apple_pen", MemeSounds.ppap_ppap, null, 5, null);
		sax = new ItemInstrument("sax", "sax", MemeSounds.robbie_sax, MemeSounds.robbie_sax2, 20, "instrument.info");
		meme_record1 = new ItemCustomRecord("memesong1", MemeSounds.meme_music, "memerecord1", "meme_record_1");
		meme_record2 = new ItemCustomRecord("memesong2", MemeSounds.meme_music2, "memerecord2", "meme_record_2");
		meme_record3 = new ItemCustomRecord("memesong3", MemeSounds.meme_music3, "memerecord3", "meme_record_3");
		meme_record4 = new ItemCustomRecord("memesong4", MemeSounds.meme_music4, "memerecord4", "meme_record_4");
		knife = new ItemKnife(Item.ToolMaterial.IRON, "knife", "knife", false);
		hot_knife = new ItemKnife(Item.ToolMaterial.IRON, "hotknife", "hot_knife", true);
		fidget = new ItemFidget("fidget", "fidget");
		trumpet = new ItemInstrument("trumpet", "trumpet", MemeSounds.doot, null, 5, "trumpet.info");
		sunglasses = new ItemSunglasses(glasses, 1, EntityEquipmentSlot.HEAD, "sunglasses", "sunglasses");
		clippy = new ItemCustomItemInfo("clippy", "clippy", "clippy.info");
		debug = new ItemDebug("debugitem", "debug_item");
		}
	
	public static void register()
	{
		ForgeRegistries.ITEMS.register(meme_in_a_bottle);
		ForgeRegistries.ITEMS.register(splash_meme_in_a_bottle);
		ForgeRegistries.ITEMS.register(lingering_meme_in_a_bottle);
		ForgeRegistries.ITEMS.register(trump_hair);
		ForgeRegistries.ITEMS.register(mcw_belt);
		ForgeRegistries.ITEMS.register(leather_belt);
		ForgeRegistries.ITEMS.register(troll_mask);
		ForgeRegistries.ITEMS.register(ripoff_hat);
		ForgeRegistries.ITEMS.register(pineapple);
		ForgeRegistries.ITEMS.register(apple);
		ForgeRegistries.ITEMS.register(penpineapple);
		ForgeRegistries.ITEMS.register(applepen);
		ForgeRegistries.ITEMS.register(pen);
		ForgeRegistries.ITEMS.register(pills_here);
		ForgeRegistries.ITEMS.register(ppap);
		ForgeRegistries.ITEMS.register(onion);
		ForgeRegistries.ITEMS.register(burger);
		ForgeRegistries.ITEMS.register(waffle);
		ForgeRegistries.ITEMS.register(poptart);
		ForgeRegistries.ITEMS.register(sax);
		ForgeRegistries.ITEMS.register(meme_record1);
		ForgeRegistries.ITEMS.register(meme_record2);
		ForgeRegistries.ITEMS.register(meme_record3);
		ForgeRegistries.ITEMS.register(meme_record4);
		ForgeRegistries.ITEMS.register(knife);
		ForgeRegistries.ITEMS.register(hot_knife);
		ForgeRegistries.ITEMS.register(fidget);
		ForgeRegistries.ITEMS.register(trumpet);
		ForgeRegistries.ITEMS.register(sunglasses);
		ForgeRegistries.ITEMS.register(clippy);
		ForgeRegistries.ITEMS.register(debug);
		
    	BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(MemeItems.splash_meme_in_a_bottle, new DispenseHandler());
	}
	
	public static void registerRenders()
	{
		registerRender(meme_in_a_bottle);
		registerRender(splash_meme_in_a_bottle);
		registerRender(lingering_meme_in_a_bottle);
		registerRender(trump_hair);
		registerRender(mcw_belt);
		registerRender(leather_belt);
		registerRender(troll_mask);
		registerRender(ripoff_hat);
		registerRender(pineapple);
		registerRender(apple);
		registerRender(penpineapple);
		registerRender(applepen);
		registerRender(pen);
		registerRender(pills_here);
		registerRender(ppap);
		registerRender(onion);
		registerRender(burger);
		registerRender(waffle);
		registerRender(poptart);
		registerRender(sax);
		registerRender(meme_record1);
		registerRender(meme_record2);
		registerRender(meme_record3);
		registerRender(meme_record4);
		registerRender(knife);
		registerRender(hot_knife);
		registerRender(fidget);
		registerRender(trumpet);
		registerRender(sunglasses);
		registerRender(clippy);
		registerRender(debug);
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}