package com.mrbysco.miab.items;

import com.mrbysco.miab.init.MemeTab;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class ItemMemeSpawnEgg extends SpawnEggItem {
    public ItemMemeSpawnEgg(EntityType<?> typeIn, int primaryColorIn, int secondaryColorIn, Item.Properties builder) {
        super(typeIn, primaryColorIn, secondaryColorIn, builder.group(MemeTab.MEME_TAB));
    }
}
