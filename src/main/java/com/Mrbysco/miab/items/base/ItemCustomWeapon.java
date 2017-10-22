package com.Mrbysco.miab.items.base;

import com.Mrbysco.miab.MemeInABottle;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemCustomWeapon extends ItemSword{

	private final float attackDamage;
    private final Item.ToolMaterial material;
    
	public ItemCustomWeapon(Item.ToolMaterial material, String unlocalized, String registry) {
		super(material);
		this.material = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.attackDamage = 3.0F + material.getDamageVsEntity();
		setUnlocalizedName(unlocalized);
		setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
	}
}
