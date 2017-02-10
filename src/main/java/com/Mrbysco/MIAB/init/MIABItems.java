package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.handler.DispenseHandler;
import com.Mrbysco.MIAB.items.ItemApple;
import com.Mrbysco.MIAB.items.ItemMineBurger;
import com.Mrbysco.MIAB.items.ItemOnion;
import com.Mrbysco.MIAB.items.ItemPen;
import com.Mrbysco.MIAB.items.ItemPineapple;
import com.Mrbysco.MIAB.items.ItemSax;
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
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MIABItems {
	
	public static Item meme_in_a_bottle;
	public static Item splash_meme_in_a_bottle;
	public static Item mcw_belt;
	public static Item trump_hair;
	public static Item troll_mask;
	public static Item ripoff_hat;
	public static ItemFood pineapple;
	public static ItemFood apple;
	public static Item pen;
	public static ItemFood onion;
	public static ItemFood burger;
	public static Item sax;
	
	public static final ArmorMaterial trumphair = EnumHelper.addArmorMaterial("trumphair", "miab:trumphair", 5 , new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial belt = EnumHelper.addArmorMaterial("belt", "miab:belt", 7, new int[]{2, 5, 3, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0F);
	public static final ArmorMaterial trollmask = EnumHelper.addArmorMaterial("trollmask", "miab:trollmask", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static final ArmorMaterial ripoffhat = EnumHelper.addArmorMaterial("rippoffhat", "miab:rippoffhat", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	
	public static void init(){
		meme_in_a_bottle = new Itemmeme_in_a_bottle();
		splash_meme_in_a_bottle = new Itemsplash_meme_in_a_bottle();
		trump_hair = new Itemcustom_armor("trump_hair", trumphair, 2, EntityEquipmentSlot.HEAD).setRegistryName(Reference.MIABItems.TRUMPHAIR.getRegistryName()).setUnlocalizedName(Reference.MIABItems.TRUMPHAIR.getUnlocalisedName()).setCreativeTab(MIAB.tabMIAB);
		mcw_belt = new Itemcustom_armor("mcw_belt", belt, 2, EntityEquipmentSlot.LEGS).setRegistryName(Reference.MIABItems.MCWBELT.getRegistryName()).setUnlocalizedName(Reference.MIABItems.MCWBELT.getUnlocalisedName()).setCreativeTab(MIAB.tabMIAB);
		troll_mask = new Itemcustom_armor("troll_mask", trollmask, 2, EntityEquipmentSlot.HEAD).setRegistryName(Reference.MIABItems.TROLLMASK.getRegistryName()).setUnlocalizedName(Reference.MIABItems.TROLLMASK.getUnlocalisedName()).setCreativeTab(MIAB.tabMIAB);
		ripoff_hat = new Itemcustom_armor("ripoff_hat", ripoffhat, 2, EntityEquipmentSlot.HEAD).setRegistryName(Reference.MIABItems.RIPOFFHAT.getRegistryName()).setUnlocalizedName(Reference.MIABItems.RIPOFFHAT.getUnlocalisedName()).setCreativeTab(MIAB.tabMIAB);
		pineapple = new ItemPineapple(3, 4, false);
		apple = new ItemApple(2, 4, false);
		onion = new ItemOnion(2, 4, false);
		burger = new ItemMineBurger(4, 4, false);
		pen = new ItemPen();
		sax = new ItemSax();
		}
	
	public static void register()
	{
		GameRegistry.register(meme_in_a_bottle);
		GameRegistry.register(splash_meme_in_a_bottle);
		GameRegistry.register(trump_hair);
		GameRegistry.register(mcw_belt);
		GameRegistry.register(troll_mask);
		GameRegistry.register(ripoff_hat);
		GameRegistry.register(pineapple);
		GameRegistry.register(apple);
		GameRegistry.register(pen);
		GameRegistry.register(onion);
		GameRegistry.register(burger);
		GameRegistry.register(sax);
		
    	BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(splash_meme_in_a_bottle, new DispenseHandler());
	}
	
	public static void registerRenders()
	{
		registerRender(meme_in_a_bottle);
		registerRender(splash_meme_in_a_bottle);
		registerRender(trump_hair);
		registerRender(mcw_belt);
		registerRender(troll_mask);
		registerRender(ripoff_hat);
		registerRender(pineapple);
		registerRender(apple);
		registerRender(pen);
		registerRender(onion);
		registerRender(burger);
		registerRender(sax);
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
