package com.mrbysco.miab.registry;

import com.mrbysco.miab.Reference;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterial.Layer;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class MemeArmor {
	public static final Holder<ArmorMaterial> TRUMPHAIR = register("trumphair", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, MemeSounds.trump_sound, 0.0F, 0.0F, () -> null);
	public static final Holder<ArmorMaterial> BELT = register("belt", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> null);
	public static final Holder<ArmorMaterial> LEATHERBELT = register("leatherbelt", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, MemeSounds.leather_belt, 0.0F, 0.0F, () -> null);
	public static final Holder<ArmorMaterial> TROLLMASK = register("trollmask", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, MemeSounds.trololo, 0.0F, 0.0F, () -> null);
	public static final Holder<ArmorMaterial> RIPOFFHAT = register("rippoffhat", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, MemeSounds.dad_summon, 2.0F, 0.0F, () -> null);
	public static final Holder<ArmorMaterial> GLASSES = register("sunglasses", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 2);
		map.put(ArmorItem.Type.HELMET, 1);
	}), 15, MemeSounds.thuglife, 0.0F, 0.0F, () -> null);

	private static Holder<ArmorMaterial> register(
			String pName,
			EnumMap<ArmorItem.Type, Integer> pDefense,
			int pEnchantmentValue,
			Holder<SoundEvent> pEquipSound,
			float pToughness,
			float pKnockbackResistance,
			Supplier<Ingredient> pRepairIngredient
	) {
		List<Layer> list = List.of(new ArmorMaterial.Layer(Reference.modLoc(pName)));
		return register(pName, pDefense, pEnchantmentValue, pEquipSound, pToughness, pKnockbackResistance, pRepairIngredient, list);
	}

	private static Holder<ArmorMaterial> register(
			String pName,
			EnumMap<ArmorItem.Type, Integer> pDefense,
			int pEnchantmentValue,
			Holder<SoundEvent> pEquipSound,
			float pToughness,
			float pKnockbackResistance,
			Supplier<Ingredient> pRepairIngridient,
			List<ArmorMaterial.Layer> pLayers
	) {
		EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);

		for (ArmorItem.Type armoritem$type : ArmorItem.Type.values()) {
			enummap.put(armoritem$type, pDefense.get(armoritem$type));
		}

		return Registry.registerForHolder(
				BuiltInRegistries.ARMOR_MATERIAL,
				Reference.modLoc(pName),
				new ArmorMaterial(enummap, pEnchantmentValue, pEquipSound, pRepairIngridient, pLayers, pToughness, pKnockbackResistance)
		);
	}
}