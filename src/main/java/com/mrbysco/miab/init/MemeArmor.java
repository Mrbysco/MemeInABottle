package com.mrbysco.miab.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum MemeArmor implements IArmorMaterial {
    TRUMPHAIR("trumphair", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.trump_sound, 0.0F, 0.0F, () -> null),
    BELT("belt", 7, new int[]{1, 3, 2, 1}, 15, () -> SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> null),
    LEATHERBELT("leatherbelt", 7, new int[]{1, 3, 2, 1}, 15, MemeSounds.leather_belt, 0.0F, 0.0F, () -> null),
    TROLLMASK("trollmask", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.trololo, 0.0F, 0.0F, () -> null),
    RIPOFFHAT("rippoffhat", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.dad_summon, 2.0F, 0.0F, () -> null),
    GLASSES("sunglasses", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.thuglife, 0.0F, 0.0F, () -> null);

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final Supplier<SoundEvent> soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    private MemeArmor(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, Supplier<SoundEvent> equipSoundIn, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
    }

    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent.get();
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}