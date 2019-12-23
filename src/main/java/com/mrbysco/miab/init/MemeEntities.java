package com.mrbysco.miab.init;

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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MemeEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Reference.MOD_ID);

	public static final RegistryObject<EntityType<EntitySplashMeme>> SPLASH_MEME = ENTITIES.register("splash_meme", () -> registerProjectile("splash_meme", EntityType.Builder.<EntitySplashMeme>create(EntitySplashMeme::new, EntityClassification.MONSTER).size(0.25F, 0.25F).setCustomClientFactory(EntitySplashMeme::new)));
	public static final RegistryObject<EntityType<EntityKnucklesSpit>> KNUCKLES_SPIT = ENTITIES.register("knuckles_spit", () -> registerProjectile("knuckles_spit", EntityType.Builder.<EntityKnucklesSpit>create(EntityKnucklesSpit::new, EntityClassification.MONSTER).size(0.25F, 0.25F).setCustomClientFactory(EntityKnucklesSpit::new)));

	public static final RegistryObject<EntityType<EntityCena>> JOHN_CENA = ENTITIES.register("john_cena", () -> register("john_cena", EntityType.Builder.<EntityCena>create(EntityCena::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityTrump>> DONALD_TRUMP = ENTITIES.register("donald_trump", () -> register("donald_trump", EntityType.Builder.<EntityTrump>create(EntityTrump::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityDoge>> DOGE = ENTITIES.register("doge", () -> register("doge", EntityType.Builder.<EntityDoge>create(EntityDoge::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityGrumpy>> GRUMPY_CAT = ENTITIES.register("grumpy_cat", () -> register("grumpy_cat", EntityType.Builder.<EntityGrumpy>create(EntityGrumpy::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityAttachedGirlfriend>> ATTACHED_GIRLFRIEND = ENTITIES.register("attached_girlfriend", () -> register("attached_girlfriend", EntityType.Builder.<EntityAttachedGirlfriend>create(EntityAttachedGirlfriend::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityTrololo>> EDUARD_KHIL = ENTITIES.register("eduard_khil", () -> register("eduard_khil", EntityType.Builder.<EntityTrololo>create(EntityTrololo::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityPPAP>> PPAP = ENTITIES.register("ppap", () -> register("ppap", EntityType.Builder.<EntityPPAP>create(EntityPPAP::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityRobbie>> ROBBIE_ROTTEN = ENTITIES.register("robbie_rotten", () -> register("robbie_rotten", EntityType.Builder.<EntityRobbie>create(EntityRobbie::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityMario7>> GRAND_DAD = ENTITIES.register("grand_dad", () -> register("grand_dad", EntityType.Builder.<EntityMario7>create(EntityMario7::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityHeMan>> HE_MAN = ENTITIES.register("he_man", () -> register("he_man", EntityType.Builder.<EntityHeMan>create(EntityHeMan::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntitySkywalker>> SKYWALKER = ENTITIES.register("anakin_skywalker", () -> register("anakin_skywalker", EntityType.Builder.<EntitySkywalker>create(EntitySkywalker::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityRoadmanShaq>> ROADMAN_SHAQ = ENTITIES.register("roadman_shaq", () -> register("roadman_shaq", EntityType.Builder.<EntityRoadmanShaq>create(EntityRoadmanShaq::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityPhilSwift>> PHIL_SWIFT = ENTITIES.register("phil_swift", () -> register("phil_swift", EntityType.Builder.<EntityPhilSwift>create(EntityPhilSwift::new, EntityClassification.MONSTER)));

	public static final RegistryObject<EntityType<EntityDankey>> DANKEY_KANG = ENTITIES.register("dankey_kang", () -> register("dankey_kang", EntityType.Builder.<EntityDankey>create(EntityDankey::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityShrek>> SHREK = ENTITIES.register("shrek", () -> register("shrek", EntityType.Builder.<EntityShrek>create(EntityShrek::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityDatBoi>> DAT_BOI = ENTITIES.register("dat_boi", () -> register("dat_boi", EntityType.Builder.<EntityDatBoi>create(EntityDatBoi::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntitySanic>> SANIC = ENTITIES.register("sanic", () -> register("sanic", EntityType.Builder.<EntitySanic>create(EntitySanic::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityPepe>> PEPE = ENTITIES.register("pepe", () -> register("pepe", EntityType.Builder.<EntityPepe>create(EntityPepe::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityFA>> FOREVER_ALONE = ENTITIES.register("forever_alone", () -> register("forever_alone", EntityType.Builder.<EntityFA>create(EntityFA::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityNyanCat>> NYAN_CAT = ENTITIES.register("nyan_cat", () -> register("nyan_cat", EntityType.Builder.<EntityNyanCat>create(EntityNyanCat::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityTacNayn>> TAC_NAYN = ENTITIES.register("tac_nayn", () -> register("tac_nayn", EntityType.Builder.<EntityTacNayn>create(EntityTacNayn::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityNigel>> NIGEL_THORNBERRY = ENTITIES.register("nigel_thornberry", () -> register("nigel_thornberry", EntityType.Builder.<EntityNigel>create(EntityNigel::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityHotDog>> DANCING_HOTDOG = ENTITIES.register("dancing_hotdog", () -> register("dancing_hotdog", EntityType.Builder.<EntityHotDog>create(EntityHotDog::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityBongoCat>> BONGO_CAT = ENTITIES.register("bongo_cat", () -> register("bongo_cat", EntityType.Builder.<EntityBongoCat>create(EntityBongoCat::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityRoflCopter>> ROFL_COPTER = ENTITIES.register("roflcopter", () -> register("roflcopter", EntityType.Builder.<EntityRoflCopter>create(EntityRoflCopter::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityGnome>> GNOME = ENTITIES.register("gnome", () -> register("gnome", EntityType.Builder.<EntityGnome>create(EntityGnome::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityClippy>> CLIPPY = ENTITIES.register("clippy", () -> register("clippy", EntityType.Builder.<EntityClippy>create(EntityClippy::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityKnuckles>> KNUCKLES = ENTITIES.register("knuckles", () -> register("knuckles", EntityType.Builder.<EntityKnuckles>create(EntityKnuckles::new, EntityClassification.MONSTER).size(0.9F, 0.9F)));
	public static final RegistryObject<EntityType<EntityKnucklesQueen>> KNUCKLES_QUEEN = ENTITIES.register("knuckles_queen", () -> register("knuckles_queen", EntityType.Builder.<EntityKnucklesQueen>create(EntityKnucklesQueen::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntitySans>> SANS = ENTITIES.register("sans", () -> register("sans", EntityType.Builder.<EntitySans>create(EntitySans::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityPingu>> PINGU = ENTITIES.register("pingu", () -> register("pingu", EntityType.Builder.<EntityPingu>create(EntityPingu::new, EntityClassification.MONSTER)));
	public static final RegistryObject<EntityType<EntityChocolateGuy>> TOM = ENTITIES.register("tom", () -> register("tom", EntityType.Builder.<EntityChocolateGuy>create(EntityChocolateGuy::new, EntityClassification.MONSTER)));

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder, boolean sendVelocityUpdates) {
		EntityType<T> entityType = builder.setTrackingRange(64).setUpdateInterval(3).setShouldReceiveVelocityUpdates(sendVelocityUpdates).build(id);

		return entityType;
	}

	public static <T extends Entity> EntityType<T> registerProjectile(String id, EntityType.Builder<T> builder) {
		EntityType<T> entityType = builder.setTrackingRange(4).setUpdateInterval(10).build(id);

		return entityType;
	}

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
		return register(id, builder, true);
	}
}
