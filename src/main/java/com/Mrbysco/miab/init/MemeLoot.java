package com.mrbysco.miab.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class MemeLoot {
	public static final ResourceLocation MEME_BASE_LOOT = new ResourceLocation("memeinabottle:entity/memebase");
	public static final ResourceLocation CLIPPY_LOOT = new ResourceLocation("memeinabottle:entity/clippy");
	public static final ResourceLocation NYAN_LOOT = new ResourceLocation("memeinabottle:entity/nyancat");
	public static final ResourceLocation NAYN_LOOT = new ResourceLocation("memeinabottle:entity/tacnyan");
	public static final ResourceLocation CENA_LOOT = new ResourceLocation("memeinabottle:entity/cena");
	public static final ResourceLocation DAT_BOI_LOOT = new ResourceLocation("memeinabottle:entity/datboi");
	public static final ResourceLocation HE_MAN_LOOT = new ResourceLocation("memeinabottle:entity/heman");
	public static final ResourceLocation TROLO_LOOT = new ResourceLocation("memeinabottle:entity/eduardkhil");
	public static final ResourceLocation GRAND_LOOT = new ResourceLocation("memeinabottle:entity/mario");
	public static final ResourceLocation MOON_LOOT = new ResourceLocation("memeinabottle:entity/moonman");
	public static final ResourceLocation PPAP_LOOT = new ResourceLocation("memeinabottle:entity/ppap");
	public static final ResourceLocation ROBBIE_LOOT = new ResourceLocation("memeinabottle:entity/robbierotten");
	public static final ResourceLocation SHREK_LOOT = new ResourceLocation("memeinabottle:entity/shrek");
	public static final ResourceLocation SKYWALKER_LOOT = new ResourceLocation("memeinabottle:entity/skywalker");
	public static final ResourceLocation TRUMP_LOOT = new ResourceLocation("memeinabottle:entity/trump");
	public static final ResourceLocation BONGO_LOOT = new ResourceLocation("memeinabottle:entity/bongocat");
	public static final ResourceLocation ROFL_LOOT = new ResourceLocation("memeinabottle:entity/roflcopter");
	public static final ResourceLocation GNOME_LOOT = new ResourceLocation("memeinabottle:entity/gnome");
	public static final ResourceLocation FLEX_LOOT = new ResourceLocation("memeinabottle:entity/philswift");
	public static final ResourceLocation SANS_LOOT = new ResourceLocation("memeinabottle:entity/sans");
	
	public static void registerLootTables()
	{
		LootTableList.register(MEME_BASE_LOOT);
		
		LootTableList.register(CLIPPY_LOOT);
		LootTableList.register(NYAN_LOOT);
		LootTableList.register(NAYN_LOOT);
		LootTableList.register(CENA_LOOT);
		LootTableList.register(DAT_BOI_LOOT);
		LootTableList.register(HE_MAN_LOOT);
		LootTableList.register(TROLO_LOOT);
		LootTableList.register(GRAND_LOOT);
		LootTableList.register(MOON_LOOT);
		LootTableList.register(PPAP_LOOT);
		LootTableList.register(ROBBIE_LOOT);
		LootTableList.register(SHREK_LOOT);
		LootTableList.register(SKYWALKER_LOOT);
		LootTableList.register(TRUMP_LOOT);
		LootTableList.register(BONGO_LOOT);
		LootTableList.register(ROFL_LOOT);
		LootTableList.register(GNOME_LOOT);
		LootTableList.register(FLEX_LOOT);
		LootTableList.register(SANS_LOOT);
	}
}
