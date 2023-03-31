package com.mrbysco.miab.registry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum MemeArmor implements ArmorMaterial {
	TRUMPHAIR("trumphair", 5, new int[]{1, 3, 2, 1}, 15, MemeSounds.trump_sound, 0.0F, 0.0F, () -> null),
	BELT("belt", 7, new int[]{1, 3, 2, 1}, 15, () -> SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> null),
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
	private final LazyLoadedValue<Ingredient> repairMaterial;

	MemeArmor(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, Supplier<SoundEvent> equipSoundIn, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterialSupplier) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountsIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = equipSoundIn;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairMaterial = new LazyLoadedValue<>(repairMaterialSupplier);
	}

	public int getDurabilityForSlot(EquipmentSlot slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	public int getDefenseForSlot(EquipmentSlot slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantability;
	}

	public SoundEvent getEquipSound() {
		return this.soundEvent.get();
	}

	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
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
		return this.knockbackResistance;
	}
}