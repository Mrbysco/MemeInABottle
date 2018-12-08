package com.Mrbysco.miab.items.base;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemCustomWeapon extends ItemSword{

	private final float attackDamage;
    private final Item.ToolMaterial material;
    
	public ItemCustomWeapon(Item.ToolMaterial material, String registry) {
		super(material);
		this.material = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.attackDamage = 3.0F + material.getAttackDamage();
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
	}
}
