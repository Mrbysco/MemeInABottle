package com.mrbysco.miab.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class MemeFoods {
	public static final FoodProperties WAFFLE = (new FoodProperties.Builder()).nutrition(3).saturationModifier(0.3F).build();
	public static final FoodProperties POPTART = (new FoodProperties.Builder()).nutrition(3).saturationModifier(0.3F).build();
	public static final FoodProperties PINEAPPLE = (new FoodProperties.Builder()).nutrition(3).saturationModifier(0.4F).build();
	public static final FoodProperties APPLE = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.4F).build();
	public static final FoodProperties ONION = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.4F).build();
	public static final FoodProperties BURGER = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).build();
	public static final FoodProperties PILLS = (new FoodProperties.Builder()).nutrition(0).saturationModifier(0).build();
	public static final FoodProperties POD = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.4F).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.POISON, 12 * 20, 1), 1F).build();
}
