package com.Mrbysco.MIAB.init;

import java.util.Locale;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;
import com.Mrbysco.MIAB.items.Itemcustom_armor;
import com.Mrbysco.MIAB.items.Itemmeme_in_a_bottle;
import com.Mrbysco.MIAB.items.Itemsplash_meme_in_a_bottle;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MIABItems {
	
	public static Item meme_in_a_bottle;
	public static Item splash_meme_in_a_bottle;
	public static Item mcw_belt;
	public static Item trump_hair;
	public static Item troll_mask;
	
	public static final ArmorMaterial trumphair = EnumHelper.addArmorMaterial("trumphair", "miab:trumphair", 5 , new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER);
	public static final ArmorMaterial belt = EnumHelper.addArmorMaterial("belt", "miab:belt", 7, new int[]{2, 5, 3, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD);
	public static final ArmorMaterial trollmask = EnumHelper.addArmorMaterial("trollmask", "miab:trollmask", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER);
	
	public static void init(){
		meme_in_a_bottle = new Itemmeme_in_a_bottle().setRegistryName("meme_in_a_bottle").setUnlocalizedName("meme_in_a_bottle").setCreativeTab(MIAB.tabMIAB);
		splash_meme_in_a_bottle = new Itemsplash_meme_in_a_bottle().setRegistryName("splash_meme_in_a_bottle").setUnlocalizedName("splash_meme_in_a_bottle").setCreativeTab(MIAB.tabMIAB);
		trump_hair = new Itemcustom_armor("trump_hair", trumphair, 2, EntityEquipmentSlot.HEAD).setRegistryName("trump_hair").setUnlocalizedName("trump_hair").setCreativeTab(MIAB.tabMIAB);
		mcw_belt = new Itemcustom_armor("MCW_Belt", belt, 2, EntityEquipmentSlot.LEGS).setRegistryName("MCW_Belt").setUnlocalizedName("MCW_Belt").setCreativeTab(MIAB.tabMIAB);
		troll_mask = new Itemcustom_armor("troll_mask", trollmask, 2, EntityEquipmentSlot.HEAD).setRegistryName("troll_mask").setUnlocalizedName("troll_mask").setCreativeTab(MIAB.tabMIAB);
		}
	
	public static void register()
	{
		GameRegistry.register(meme_in_a_bottle);
		GameRegistry.register(splash_meme_in_a_bottle);
		GameRegistry.register(trump_hair);
		GameRegistry.register(mcw_belt);
		GameRegistry.register(troll_mask);
	}
	
	public static void registerRenders()
	{
		registerRender(meme_in_a_bottle);
		registerRender(splash_meme_in_a_bottle);
		registerRender(trump_hair);
		registerRender(mcw_belt);
		registerRender(troll_mask);
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5).toLowerCase(Locale.US), "inventory"));
	}
	
}
