package com.mrbysco.miab.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MemeFoods {
    public static final Food WAFFLE = (new Food.Builder()).hunger(3).saturation(0.3F).build();
    public static final Food POPTART = (new Food.Builder()).hunger(3).saturation(0.3F).build();
    public static final Food PINEAPPLE = (new Food.Builder()).hunger(3).saturation(0.4F).build();
    public static final Food APPLE = (new Food.Builder()).hunger(2).saturation(0.4F).build();
    public static final Food ONION = (new Food.Builder()).hunger(2).saturation(0.4F).build();
    public static final Food BURGER = (new Food.Builder()).hunger(4).saturation(0.4F).build();
    public static final Food PILLS = (new Food.Builder()).hunger(0).saturation(0).build();
    public static final Food POD = (new Food.Builder()).hunger(1).saturation(0.4F).setAlwaysEdible().effect(new EffectInstance(Effects.POISON, 12*20, 1), 1F).build();
}
