package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.handler.DispenseHandler;
import com.Mrbysco.MIAB.items.ItemApple;
import com.Mrbysco.MIAB.items.ItemApplePen;
import com.Mrbysco.MIAB.items.ItemCustomRecord;
import com.Mrbysco.MIAB.items.ItemFidget;
import com.Mrbysco.MIAB.items.ItemHot_Knife;
import com.Mrbysco.MIAB.items.ItemKnife;
import com.Mrbysco.MIAB.items.ItemLeather_belt;
import com.Mrbysco.MIAB.items.ItemLingeringMeme_in_a_bottle;
import com.Mrbysco.MIAB.items.ItemMineBurger;
import com.Mrbysco.MIAB.items.ItemOnion;
import com.Mrbysco.MIAB.items.ItemPPAP;
import com.Mrbysco.MIAB.items.ItemPen;
import com.Mrbysco.MIAB.items.ItemPills;
import com.Mrbysco.MIAB.items.ItemPineapple;
import com.Mrbysco.MIAB.items.ItemPineapplePen;
import com.Mrbysco.MIAB.items.ItemPoptart;
import com.Mrbysco.MIAB.items.ItemSax;
import com.Mrbysco.MIAB.items.ItemWaffle;
import com.Mrbysco.MIAB.items.Itemcustom_armor;
import com.Mrbysco.MIAB.items.Itemmeme_in_a_bottle;
import com.Mrbysco.MIAB.items.Itemsplash_meme_in_a_bottle;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class MIABItems {
	
	public static Item meme_in_a_bottle;
	public static Item splash_meme_in_a_bottle;
	public static Item lingering_meme_in_a_bottle;
	public static Item mcw_belt;
	public static Item leather_belt;
	public static Item trump_hair;
	public static Item troll_mask;
	public static Item ripoff_hat;
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
	public static ItemSword knife;
	public static ItemSword hot_knife;
	public static Item fidget;
	public static ItemFood pills;
	
	public static final ArmorMaterial trumphair = EnumHelper.addArmorMaterial("trumphair", "miab:trumphair", 5 , new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial belt = EnumHelper.addArmorMaterial("belt", "miab:belt", 7, new int[]{2, 5, 3, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0F);
	public static final ArmorMaterial leatherbelt = EnumHelper.addArmorMaterial("leatherbelt", "miab:leatherbelt", 7, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial trollmask = EnumHelper.addArmorMaterial("trollmask", "miab:trollmask", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial ripoffhat = EnumHelper.addArmorMaterial("rippoffhat", "miab:rippoffhat", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	
	public static void init(){
		meme_in_a_bottle = new Itemmeme_in_a_bottle("memeinabottle", "itemmemeinabottle");
		splash_meme_in_a_bottle = new Itemsplash_meme_in_a_bottle("splashmemeinabottle", "itemsplashmemeinabottle");
		lingering_meme_in_a_bottle = new ItemLingeringMeme_in_a_bottle("lingeringmemeinabottle", "itemlingeringmemeinabottle");
		trump_hair = new Itemcustom_armor("trump_hair", trumphair, 1, EntityEquipmentSlot.HEAD, "trumphair", "itemtrumphair");
		mcw_belt = new Itemcustom_armor("mcw_belt", belt, 2, EntityEquipmentSlot.LEGS,"mcwbelt", "itemmcwbelt");
		leather_belt = new ItemLeather_belt("leather_belt", leatherbelt, 1, EntityEquipmentSlot.CHEST, "leatherbelt", "itemleatherbelt");
		troll_mask = new Itemcustom_armor("troll_mask", trollmask, 1, EntityEquipmentSlot.HEAD, "trollmask", "itemtrollmask");
		ripoff_hat = new Itemcustom_armor("ripoff_hat", ripoffhat, 1, EntityEquipmentSlot.HEAD, "rippoffhat", "itemripoffhat");
		pineapple = new ItemPineapple(3, 4, false, "pineapple", "itempineapple");
		apple = new ItemApple(2, 4, false, "apple", "itemapple");
		onion = new ItemOnion(2, 4, false, "onion", "itemonion");
		burger = new ItemMineBurger(4, 4, false, "mineburger", "itemmineburger");
		waffle = new ItemWaffle(3, 3, false, "waffle", "itemwaffle");
		poptart = new ItemPoptart(3, 3, false, "poptart", "itempoptart");
		pen = new ItemPen("pen", "itempen");
		pills = new ItemPills(0, 0, false, "pills", "itempills");
		penpineapple = new ItemPineapplePen("pineapplepen", "itempineapplepen");
		applepen = new ItemApplePen("applepen", "itemapplepen");
		ppap = new ItemPPAP("ppap", "itemppap");
		sax = new ItemSax("sax", "itemsax");
		meme_record1 = new ItemCustomRecord("memesong1", MiabSoundEvents.meme_music, "itemmemerecord1", "memerecord1");
		meme_record2 = new ItemCustomRecord("memesong2", MiabSoundEvents.meme_music2, "itemmemerecord2", "memerecord2");
		meme_record3 = new ItemCustomRecord("memesong3", MiabSoundEvents.meme_music3, "itemmemerecord3", "memerecord3");
		knife = new ItemKnife(Item.ToolMaterial.IRON, "knife", "itemknife");
		hot_knife = new ItemHot_Knife(Item.ToolMaterial.IRON, "hotknife", "itemhotknife");
		fidget = new ItemFidget("fidget", "itemfidget");
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
		ForgeRegistries.ITEMS.register(ppap);
		ForgeRegistries.ITEMS.register(onion);
		ForgeRegistries.ITEMS.register(burger);
		ForgeRegistries.ITEMS.register(waffle);
		ForgeRegistries.ITEMS.register(poptart);
		ForgeRegistries.ITEMS.register(sax);
		ForgeRegistries.ITEMS.register(meme_record1);
		ForgeRegistries.ITEMS.register(meme_record2);
		ForgeRegistries.ITEMS.register(meme_record3);
		ForgeRegistries.ITEMS.register(knife);
		ForgeRegistries.ITEMS.register(hot_knife);
		ForgeRegistries.ITEMS.register(fidget);
		
    	BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(MIABItems.splash_meme_in_a_bottle, new DispenseHandler());
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
		registerRender(ppap);
		registerRender(onion);
		registerRender(burger);
		registerRender(waffle);
		registerRender(poptart);
		registerRender(sax);
		registerRender(meme_record1);
		registerRender(meme_record2);
		registerRender(meme_record3);
		registerRender(knife);
		registerRender(hot_knife);
		registerRender(fidget);
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
