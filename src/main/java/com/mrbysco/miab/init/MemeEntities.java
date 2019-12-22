package com.mrbysco.miab.init;

import com.google.common.base.Preconditions;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.EntityAttachedGirlfriend;
import com.mrbysco.miab.entity.memes.EntityBongoCat;
import com.mrbysco.miab.entity.memes.EntityCena;
import com.mrbysco.miab.entity.memes.EntityChocolateGuy;
import com.mrbysco.miab.entity.memes.EntityClippy;
import com.mrbysco.miab.entity.memes.EntityDankey;
import com.mrbysco.miab.entity.memes.EntityDatBoi;
import com.mrbysco.miab.entity.memes.EntityDoge;
import com.mrbysco.miab.entity.memes.EntityFA;
import com.mrbysco.miab.entity.memes.EntityGnome;
import com.mrbysco.miab.entity.memes.EntityGrumpy;
import com.mrbysco.miab.entity.memes.EntityHeMan;
import com.mrbysco.miab.entity.memes.EntityHotDog;
import com.mrbysco.miab.entity.memes.EntityKnuckles;
import com.mrbysco.miab.entity.memes.EntityKnucklesQueen;
import com.mrbysco.miab.entity.memes.EntityMario7;
import com.mrbysco.miab.entity.memes.EntityNigel;
import com.mrbysco.miab.entity.memes.EntityNyanCat;
import com.mrbysco.miab.entity.memes.EntityPPAP;
import com.mrbysco.miab.entity.memes.EntityPepe;
import com.mrbysco.miab.entity.memes.EntityPhilSwift;
import com.mrbysco.miab.entity.memes.EntityPingu;
import com.mrbysco.miab.entity.memes.EntityRoadmanShaq;
import com.mrbysco.miab.entity.memes.EntityRobbie;
import com.mrbysco.miab.entity.memes.EntityRoflCopter;
import com.mrbysco.miab.entity.memes.EntitySanic;
import com.mrbysco.miab.entity.memes.EntitySans;
import com.mrbysco.miab.entity.memes.EntityShrek;
import com.mrbysco.miab.entity.memes.EntitySkywalker;
import com.mrbysco.miab.entity.memes.EntityTacNayn;
import com.mrbysco.miab.entity.memes.EntityTrololo;
import com.mrbysco.miab.entity.memes.EntityTrump;
import com.mrbysco.miab.entity.projectile.EntityKnucklesSpit;
import com.mrbysco.miab.entity.projectile.EntitySplashMeme;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class MemeEntities {
	public static final EntityType<EntitySplashMeme> SPLASH_MEME = register("splash_meme", EntityType.Builder.<EntitySplashMeme>create(EntitySplashMeme::new, EntityClassification.MISC)
			.size(0.25F, 0.25F)
			.setCustomClientFactory(EntitySplashMeme::new));

	public static final EntityType<EntityKnucklesSpit> KNUCKLES_SPIT = register("knuckles_spit", EntityType.Builder.<EntityKnucklesSpit>create(EntityKnucklesSpit::new, EntityClassification.MISC)
			.size(0.25F, 0.25F)
			.setCustomClientFactory(EntityKnucklesSpit::new));

	public static final EntityType<EntityCena> JOHN_CENA = register("john_cena", EntityType.Builder.<EntityCena>create(EntityCena::new, EntityClassification.MONSTER));
	public static final EntityType<EntityTrump> DONALD_TRUMP = register("donald_trump", EntityType.Builder.<EntityTrump>create(EntityTrump::new, EntityClassification.MONSTER));
	public static final EntityType<EntityDoge> DOGE = register("doge", EntityType.Builder.<EntityDoge>create(EntityDoge::new, EntityClassification.MONSTER));
	public static final EntityType<EntityGrumpy> GRUMPY_CAT = register("grumpy_cat", EntityType.Builder.<EntityGrumpy>create(EntityGrumpy::new, EntityClassification.MONSTER));
	public static final EntityType<EntityAttachedGirlfriend> ATTACHED_GIRLFRIEND = register("attached_girlfriend", EntityType.Builder.<EntityAttachedGirlfriend>create(EntityAttachedGirlfriend::new, EntityClassification.MONSTER));
	public static final EntityType<EntityTrololo> EDUARD_KHIL = register("eduard_khil", EntityType.Builder.<EntityTrololo>create(EntityTrololo::new, EntityClassification.MONSTER));
	public static final EntityType<EntityPPAP> PPAP = register("ppap", EntityType.Builder.<EntityPPAP>create(EntityPPAP::new, EntityClassification.MONSTER));
	public static final EntityType<EntityRobbie> ROBBIE_ROTTEN = register("robbie_rotten", EntityType.Builder.<EntityRobbie>create(EntityRobbie::new, EntityClassification.MONSTER));
	public static final EntityType<EntityMario7> GRAND_DAD = register("grand_dad", EntityType.Builder.<EntityMario7>create(EntityMario7::new, EntityClassification.MONSTER));
	public static final EntityType<EntityHeMan> HE_MAN = register("he-man", EntityType.Builder.<EntityHeMan>create(EntityHeMan::new, EntityClassification.MONSTER));
	public static final EntityType<EntitySkywalker> SKYWALKER = register("anakin_skywalker", EntityType.Builder.<EntitySkywalker>create(EntitySkywalker::new, EntityClassification.MONSTER));
	public static final EntityType<EntityRoadmanShaq> ROADMAN_SHAQ = register("roadman_shaq", EntityType.Builder.<EntityRoadmanShaq>create(EntityRoadmanShaq::new, EntityClassification.MONSTER));
	public static final EntityType<EntityPhilSwift> PHIL_SWIFT = register("phil_swift", EntityType.Builder.<EntityPhilSwift>create(EntityPhilSwift::new, EntityClassification.MONSTER));

	public static final EntityType<EntityDankey> DANKEY_KANG = register("dankey_kang", EntityType.Builder.<EntityDankey>create(EntityDankey::new, EntityClassification.MONSTER));
	public static final EntityType<EntityShrek> SHREK = register("shrek", EntityType.Builder.<EntityShrek>create(EntityShrek::new, EntityClassification.MONSTER));
	public static final EntityType<EntityDatBoi> DAT_BOI = register("dat_boi", EntityType.Builder.<EntityDatBoi>create(EntityDatBoi::new, EntityClassification.MONSTER));
	public static final EntityType<EntitySanic> SANIC = register("sanic", EntityType.Builder.<EntitySanic>create(EntitySanic::new, EntityClassification.MONSTER));
	public static final EntityType<EntityPepe> PEPE = register("pepe", EntityType.Builder.<EntityPepe>create(EntityPepe::new, EntityClassification.MONSTER));
	public static final EntityType<EntityFA> FOREVER_ALONE = register("forever_alone", EntityType.Builder.<EntityFA>create(EntityFA::new, EntityClassification.MONSTER));
	public static final EntityType<EntityNyanCat> NYAN_CAT = register("nyan_cat", EntityType.Builder.<EntityNyanCat>create(EntityNyanCat::new, EntityClassification.MONSTER));
	public static final EntityType<EntityTacNayn> TAC_NAYN = register("tac_nayn", EntityType.Builder.<EntityTacNayn>create(EntityTacNayn::new, EntityClassification.MONSTER));
	public static final EntityType<EntityNigel> NIGEL_THORNBERRY = register("nigel_thornberry", EntityType.Builder.<EntityNigel>create(EntityNigel::new, EntityClassification.MONSTER));
	public static final EntityType<EntityHotDog> DANCING_HOTDOG = register("dancing_hotdog", EntityType.Builder.<EntityHotDog>create(EntityHotDog::new, EntityClassification.MONSTER));
	public static final EntityType<EntityBongoCat> BONGO_CAT = register("bongo_cat", EntityType.Builder.<EntityBongoCat>create(EntityBongoCat::new, EntityClassification.MONSTER));
	public static final EntityType<EntityRoflCopter> ROFL_COPTER = register("roflcopter", EntityType.Builder.<EntityRoflCopter>create(EntityRoflCopter::new, EntityClassification.MONSTER));
	public static final EntityType<EntityGnome> GNOME = register("gnome", EntityType.Builder.<EntityGnome>create(EntityGnome::new, EntityClassification.MONSTER));
	public static final EntityType<EntityClippy> CLIPPY = register("clippy", EntityType.Builder.<EntityClippy>create(EntityClippy::new, EntityClassification.MONSTER));
	public static final EntityType<EntityKnuckles> KNUCKLES = register("knuckles", EntityType.Builder.<EntityKnuckles>create(EntityKnuckles::new, EntityClassification.MONSTER)
			.size(0.9F, 0.9F));
	public static final EntityType<EntityKnucklesQueen> KNUCKLES_QUEEN = register("knuckles_queen", EntityType.Builder.<EntityKnucklesQueen>create(EntityKnucklesQueen::new, EntityClassification.MONSTER));
	public static final EntityType<EntitySans> SANS = register("sans", EntityType.Builder.<EntitySans>create(EntitySans::new, EntityClassification.MONSTER));
	public static final EntityType<EntityPingu> PINGU = register("pingu", EntityType.Builder.<EntityPingu>create(EntityPingu::new, EntityClassification.MONSTER));
	public static final EntityType<EntityChocolateGuy> TOM = register("tom", EntityType.Builder.<EntityChocolateGuy>create(EntityChocolateGuy::new, EntityClassification.MONSTER));

	static int ID = 0;

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder, boolean sendVelocityUpdates) {
		EntityType<T> entityType = builder.setTrackingRange(64).setUpdateInterval(3).setShouldReceiveVelocityUpdates(sendVelocityUpdates).build("");
		ResourceLocation name = new ResourceLocation(Reference.MOD_ID, id);
		entityType.setRegistryName(name);

		return entityType;
	}
	public static <T extends Entity> EntityType<T> registerProjectile(String id, EntityType.Builder<T> builder) {
		EntityType<T> entityType = builder.setTrackingRange(4).setUpdateInterval(10).build("");
		ResourceLocation name = new ResourceLocation(Reference.MOD_ID, id);
		entityType.setRegistryName(name);

		return entityType;
	}

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
		return register(id, builder, true);
	}

	public static void register(EntityType<?> entityType, RegistryEvent.Register<EntityType<?>> event) {
		Preconditions.checkNotNull(entityType, "registryName");
		event.getRegistry().register(entityType);
	}

	@SubscribeEvent
	public static void registerPenguins(RegistryEvent.Register<EntityType<?>> event) {
		register(JOHN_CENA, event);
		register(DONALD_TRUMP, event);
		register(DOGE, event);
		register(GRUMPY_CAT, event);
		register(ATTACHED_GIRLFRIEND, event);
		register(EDUARD_KHIL, event);
		register(PPAP, event);
		register(ROBBIE_ROTTEN, event);
		register(GRAND_DAD, event);
		register(HE_MAN, event);
		register(SKYWALKER, event);
		register(ROADMAN_SHAQ, event);
		register(PHIL_SWIFT, event);
		register(DANKEY_KANG, event);
		register(SHREK, event);
		register(DAT_BOI, event);
		register(SANIC, event);
		register(PEPE, event);
		register(FOREVER_ALONE, event);
		register(NYAN_CAT, event);
		register(TAC_NAYN, event);
		register(NIGEL_THORNBERRY, event);
		register(DANCING_HOTDOG, event);
		register(BONGO_CAT, event);
		register(ROFL_COPTER, event);
		register(GNOME, event);
		register(CLIPPY, event);
		register(KNUCKLES, event);
		register(KNUCKLES_QUEEN, event);
		register(SANS, event);
		register(PINGU, event);
		register(TOM, event);
	}
}
