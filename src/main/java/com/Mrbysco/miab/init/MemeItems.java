package com.Mrbysco.miab.init;

import java.util.ArrayList;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.handlers.DispenseHandler;
import com.Mrbysco.miab.items.ItemDebug;
import com.Mrbysco.miab.items.ItemFidget;
import com.Mrbysco.miab.items.ItemGnomeHat;
import com.Mrbysco.miab.items.ItemInstrument;
import com.Mrbysco.miab.items.ItemKnife;
import com.Mrbysco.miab.items.ItemLeatherBelt;
import com.Mrbysco.miab.items.ItemLingeringMemeBottle;
import com.Mrbysco.miab.items.ItemMemeBottle;
import com.Mrbysco.miab.items.ItemPills;
import com.Mrbysco.miab.items.ItemSplashMemeBottle;
import com.Mrbysco.miab.items.ItemSunglasses;
import com.Mrbysco.miab.items.base.ItemCustomArmor;
import com.Mrbysco.miab.items.base.ItemCustomFood;
import com.Mrbysco.miab.items.base.ItemCustomItem;
import com.Mrbysco.miab.items.base.ItemCustomItemInfo;
import com.Mrbysco.miab.items.base.ItemCustomRecord;
import com.Mrbysco.miab.items.base.ItemMusical;
import com.Mrbysco.miab.items.food.ItemFoodWithSound;

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

@EventBusSubscriber
public class MemeItems {
	
	public static Item meme_in_a_bottle;
	public static Item splash_meme_in_a_bottle;
	public static Item lingering_meme_in_a_bottle;
	public static ItemArmor mcw_belt;
	public static ItemArmor leather_belt;
	public static ItemArmor trump_hair;
	public static Item gnome_hat;
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
	public static Item roflcopter;
	public static Item flextape;
	public static Item debug;
	public static ItemFood pod;
	
	public static ArrayList<Item> ITEMS = new ArrayList<>();

	public static final ArmorMaterial trumphair = EnumHelper.addArmorMaterial("trumphair", "memeinabottle:trumphair", 5 , new int[]{1, 3, 2, 1}, 15, MemeSounds.trump_sound, 0F);
	public static final ArmorMaterial belt = EnumHelper.addArmorMaterial("belt", "memeinabottle:belt", 7, new int[]{2, 5, 3, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial leatherbelt = EnumHelper.addArmorMaterial("leatherbelt", "memeinabottle:leatherbelt", 7, new int[]{1, 3, 2, 1}, 15, MemeSounds.leather_belt, 0F);
	public static final ArmorMaterial trollmask = EnumHelper.addArmorMaterial("trollmask", "memeinabottle:trollmask", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.trololo, 0F);
	public static final ArmorMaterial ripoffhat = EnumHelper.addArmorMaterial("rippoffhat", "memeinabottle:rippoffhat", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.dad_summon, 0F);
	public static final ArmorMaterial glasses = EnumHelper.addArmorMaterial("sunglasses", "memeinabottle:sunglasses", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.thuglife, 0F);
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
		
        IForgeRegistry<Item> registry = event.getRegistry();

        meme_in_a_bottle = registerItem(new ItemMemeBottle("meme_in_a_bottle"));
		splash_meme_in_a_bottle = registerItem(new ItemSplashMemeBottle("splash_meme_in_a_bottle"));
		lingering_meme_in_a_bottle = registerItem(new ItemLingeringMemeBottle("lingering_meme_in_a_bottle"));
		trump_hair = registerItem(new ItemCustomArmor(trumphair, 1, EntityEquipmentSlot.HEAD, "trump_hair"));
		gnome_hat = registerItem(new ItemGnomeHat("gnome_hat"));
		mcw_belt = registerItem(new ItemCustomArmor(belt, 2, EntityEquipmentSlot.LEGS, "mcw_belt"));
		leather_belt = registerItem(new ItemLeatherBelt(leatherbelt, 1, EntityEquipmentSlot.CHEST, "leather_belt"));
		troll_mask = registerItem(new ItemCustomArmor(trollmask, 1, EntityEquipmentSlot.HEAD, "troll_mask"));
		ripoff_hat = registerItem(new ItemCustomArmor(ripoffhat, 1, EntityEquipmentSlot.HEAD, "ripoff_hat"));
		pineapple = registerItem(new ItemFoodWithSound(3, 4, false, "pineapple", MemeSounds.ppap_havepineapple, 5));
		apple = registerItem(new ItemFoodWithSound(2, 4, false, "apple", MemeSounds.ppap_haveapple, 5));
		onion = registerItem(new ItemFoodWithSound(2, 4, false, "onion", MemeSounds.shrek_onion, 5));
		burger = registerItem(new ItemCustomFood(4, 4, false, "mineburger"));
		waffle = registerItem(new ItemCustomFood(3, 3, false, "waffle"));
		poptart = registerItem(new ItemCustomFood(3, 3, false, "poptart"));
		pen = registerItem(new ItemMusical("pen", MemeSounds.ppap_havepen, null, 5, null));
		pills_here = registerItem(new ItemPills(0, 0, false, "pills", MemeSounds.pills));
		penpineapple = registerItem(new ItemMusical("pineapple_pen", MemeSounds.ppap_ahpineapplepen, MemeSounds.ppap_pineapplepen, 5, Reference.MOD_PREFIX + "instrument.info"));
		applepen = registerItem(new ItemMusical("apple_pen", MemeSounds.ppap_ahapplepen, MemeSounds.ppap_applepen, 5, Reference.MOD_PREFIX + "instrument.info"));
		ppap = registerItem(new ItemMusical("pen_pineapple_apple_pen", MemeSounds.ppap_ppap, null, 5, null));
		sax = registerItem(new ItemInstrument("sax", MemeSounds.robbie_sax, MemeSounds.robbie_sax2, 20, Reference.MOD_PREFIX + "instrument.info"));
		meme_record1 = registerItem(new ItemCustomRecord("memesong1", MemeSounds.meme_music, "meme_record_1"));
		meme_record2 = registerItem(new ItemCustomRecord("memesong2", MemeSounds.meme_music2, "meme_record_2"));
		meme_record3 = registerItem(new ItemCustomRecord("memesong3", MemeSounds.meme_music3, "meme_record_3"));
		meme_record4 = registerItem(new ItemCustomRecord("memesong4", MemeSounds.meme_music4, "meme_record_4"));
		knife = registerItem(new ItemKnife(Item.ToolMaterial.IRON, "knife", false));
		hot_knife = registerItem(new ItemKnife(Item.ToolMaterial.IRON, "hot_knife", true));
		fidget = registerItem(new ItemFidget("fidget"));
		trumpet = registerItem(new ItemInstrument("trumpet", MemeSounds.doot, null, 5, Reference.MOD_PREFIX + "trumpet.info"));
		sunglasses = registerItem(new ItemSunglasses(glasses, 1, EntityEquipmentSlot.HEAD, "sunglasses"));
		clippy = registerItem(new ItemCustomItemInfo("clippy", Reference.MOD_PREFIX + "clippy.info"));
		roflcopter = registerItem(new ItemCustomItemInfo("roflcopter", Reference.MOD_PREFIX + "roflcopter.info"));
		flextape = registerItem(new ItemCustomItem("flex_tape"));
		debug = registerItem(new ItemDebug("debug_item"));
		pod = registerItem(new ItemCustomFood(1, 0.4F, false, "pod").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.POISON, 12*20, 1), 1F));
		
		registry.registerAll(ITEMS.toArray(new Item[0]));
		
    	BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(MemeItems.splash_meme_in_a_bottle, new DispenseHandler());
	}
	
	public static <T extends Item> T registerItem(T item)
    {
        ITEMS.add(item);
        return item;
    }
}