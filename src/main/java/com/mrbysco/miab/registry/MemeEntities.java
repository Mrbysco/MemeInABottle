package com.mrbysco.miab.registry;

import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.AttachedGirlfriendEntity;
import com.mrbysco.miab.entity.memes.BongoCatEntity;
import com.mrbysco.miab.entity.memes.CenaEntity;
import com.mrbysco.miab.entity.memes.ChocolateGuyEntity;
import com.mrbysco.miab.entity.memes.ClippyEntity;
import com.mrbysco.miab.entity.memes.DankeyEntity;
import com.mrbysco.miab.entity.memes.DatBoiEntity;
import com.mrbysco.miab.entity.memes.DogeEntity;
import com.mrbysco.miab.entity.memes.FAEntity;
import com.mrbysco.miab.entity.memes.GnomeEntity;
import com.mrbysco.miab.entity.memes.GrandDadEntity;
import com.mrbysco.miab.entity.memes.GrumpyEntity;
import com.mrbysco.miab.entity.memes.HeManEntity;
import com.mrbysco.miab.entity.memes.HotDogEntity;
import com.mrbysco.miab.entity.memes.KnucklesEntity;
import com.mrbysco.miab.entity.memes.KnucklesQueenEntity;
import com.mrbysco.miab.entity.memes.NigelEntity;
import com.mrbysco.miab.entity.memes.NyanCatEntity;
import com.mrbysco.miab.entity.memes.PPAPEntity;
import com.mrbysco.miab.entity.memes.PepeEntity;
import com.mrbysco.miab.entity.memes.PhilSwiftEntity;
import com.mrbysco.miab.entity.memes.PinguEntity;
import com.mrbysco.miab.entity.memes.RoadmanShaqEntity;
import com.mrbysco.miab.entity.memes.RobbieEntity;
import com.mrbysco.miab.entity.memes.RoflCopterEntity;
import com.mrbysco.miab.entity.memes.SanicEntity;
import com.mrbysco.miab.entity.memes.SansEntity;
import com.mrbysco.miab.entity.memes.ShrekEntity;
import com.mrbysco.miab.entity.memes.SkywalkerEntity;
import com.mrbysco.miab.entity.memes.TacNyanEntity;
import com.mrbysco.miab.entity.memes.TrololoEntity;
import com.mrbysco.miab.entity.memes.TrumpEntity;
import com.mrbysco.miab.entity.projectile.KnucklesSpitEntity;
import com.mrbysco.miab.entity.projectile.SplashMemeEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MemeEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Reference.MOD_ID);

	public static final RegistryObject<EntityType<SplashMemeEntity>> SPLASH_MEME = ENTITIES.register("splash_meme", () ->
			registerProjectile("splash_meme", EntityType.Builder.<SplashMemeEntity>of(SplashMemeEntity::new, MobCategory.MISC)
					.sized(0.25F, 0.25F)
					.setCustomClientFactory(SplashMemeEntity::new)));
	public static final RegistryObject<EntityType<KnucklesSpitEntity>> KNUCKLES_SPIT = ENTITIES.register("knuckles_spit", () ->
			registerProjectile("knuckles_spit", EntityType.Builder.<KnucklesSpitEntity>of(KnucklesSpitEntity::new, MobCategory.MISC)
					.sized(0.25F, 0.25F)
					.setCustomClientFactory(KnucklesSpitEntity::new)));

	public static final RegistryObject<EntityType<CenaEntity>> JOHN_CENA = ENTITIES.register("john_cena", () -> register("john_cena", EntityType.Builder.<CenaEntity>of(CenaEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<TrumpEntity>> DONALD_TRUMP = ENTITIES.register("donald_trump", () -> register("donald_trump", EntityType.Builder.<TrumpEntity>of(TrumpEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<DogeEntity>> DOGE = ENTITIES.register("doge", () -> register("doge", EntityType.Builder.<DogeEntity>of(DogeEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<GrumpyEntity>> GRUMPY_CAT = ENTITIES.register("grumpy_cat", () -> register("grumpy_cat", EntityType.Builder.<GrumpyEntity>of(GrumpyEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<AttachedGirlfriendEntity>> ATTACHED_GIRLFRIEND = ENTITIES.register("attached_girlfriend", () -> register("attached_girlfriend", EntityType.Builder.<AttachedGirlfriendEntity>of(AttachedGirlfriendEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<TrololoEntity>> EDUARD_KHIL = ENTITIES.register("eduard_khil", () -> register("eduard_khil", EntityType.Builder.<TrololoEntity>of(TrololoEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<PPAPEntity>> PPAP = ENTITIES.register("ppap", () -> register("ppap", EntityType.Builder.<PPAPEntity>of(PPAPEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<RobbieEntity>> ROBBIE_ROTTEN = ENTITIES.register("robbie_rotten", () -> register("robbie_rotten", EntityType.Builder.<RobbieEntity>of(RobbieEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<GrandDadEntity>> GRAND_DAD = ENTITIES.register("grand_dad", () -> register("grand_dad", EntityType.Builder.<GrandDadEntity>of(GrandDadEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<HeManEntity>> HE_MAN = ENTITIES.register("he_man", () -> register("he_man", EntityType.Builder.<HeManEntity>of(HeManEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<SkywalkerEntity>> SKYWALKER = ENTITIES.register("anakin_skywalker", () -> register("anakin_skywalker", EntityType.Builder.<SkywalkerEntity>of(SkywalkerEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<RoadmanShaqEntity>> ROADMAN_SHAQ = ENTITIES.register("roadman_shaq", () -> register("roadman_shaq", EntityType.Builder.<RoadmanShaqEntity>of(RoadmanShaqEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<PhilSwiftEntity>> PHIL_SWIFT = ENTITIES.register("phil_swift", () -> register("phil_swift", EntityType.Builder.<PhilSwiftEntity>of(PhilSwiftEntity::new, MobCategory.MONSTER)));

	public static final RegistryObject<EntityType<DankeyEntity>> DANKEY_KANG = ENTITIES.register("dankey_kang", () -> register("dankey_kang", EntityType.Builder.<DankeyEntity>of(DankeyEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<ShrekEntity>> SHREK = ENTITIES.register("shrek", () -> register("shrek", EntityType.Builder.<ShrekEntity>of(ShrekEntity::new, MobCategory.MONSTER).sized(0.6F, 2.2F)));
	public static final RegistryObject<EntityType<DatBoiEntity>> DAT_BOI = ENTITIES.register("dat_boi", () -> register("dat_boi", EntityType.Builder.<DatBoiEntity>of(DatBoiEntity::new, MobCategory.MONSTER).sized(0.6F, 2.7F)));
	public static final RegistryObject<EntityType<SanicEntity>> SANIC = ENTITIES.register("sanic", () -> register("sanic", EntityType.Builder.<SanicEntity>of(SanicEntity::new, MobCategory.MONSTER).sized(1.0F, 1.0F)));
	public static final RegistryObject<EntityType<PepeEntity>> PEPE = ENTITIES.register("pepe", () -> register("pepe", EntityType.Builder.<PepeEntity>of(PepeEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<FAEntity>> FOREVER_ALONE = ENTITIES.register("forever_alone", () -> register("forever_alone", EntityType.Builder.<FAEntity>of(FAEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<NyanCatEntity>> NYAN_CAT = ENTITIES.register("nyan_cat", () -> register("nyan_cat", EntityType.Builder.<NyanCatEntity>of(NyanCatEntity::new, MobCategory.MONSTER).sized(0.6F, 0.7F)));
	public static final RegistryObject<EntityType<TacNyanEntity>> TAC_NAYN = ENTITIES.register("tac_nayn", () -> register("tac_nayn", EntityType.Builder.<TacNyanEntity>of(TacNyanEntity::new, MobCategory.MONSTER).sized(0.6F, 0.7F)));
	public static final RegistryObject<EntityType<NigelEntity>> NIGEL_THORNBERRY = ENTITIES.register("nigel_thornberry", () -> register("nigel_thornberry", EntityType.Builder.<NigelEntity>of(NigelEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<HotDogEntity>> DANCING_HOTDOG = ENTITIES.register("dancing_hotdog", () -> register("dancing_hotdog", EntityType.Builder.<HotDogEntity>of(HotDogEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<BongoCatEntity>> BONGO_CAT = ENTITIES.register("bongo_cat", () -> register("bongo_cat", EntityType.Builder.<BongoCatEntity>of(BongoCatEntity::new, MobCategory.MONSTER).sized(0.6F, 1.5F)));
	public static final RegistryObject<EntityType<RoflCopterEntity>> ROFL_COPTER = ENTITIES.register("roflcopter", () -> register("roflcopter", EntityType.Builder.<RoflCopterEntity>of(RoflCopterEntity::new, MobCategory.MONSTER).sized(1F, 1.4F)));
	public static final RegistryObject<EntityType<GnomeEntity>> GNOME = ENTITIES.register("gnome", () -> register("gnome", EntityType.Builder.<GnomeEntity>of(GnomeEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<ClippyEntity>> CLIPPY = ENTITIES.register("clippy", () -> register("clippy", EntityType.Builder.<ClippyEntity>of(ClippyEntity::new, MobCategory.MONSTER).sized(0.7F, 1.95F)));
	public static final RegistryObject<EntityType<KnucklesEntity>> KNUCKLES = ENTITIES.register("knuckles", () -> register("knuckles", EntityType.Builder.<KnucklesEntity>of(KnucklesEntity::new, MobCategory.MONSTER).sized(0.9F, 0.9F)));
	public static final RegistryObject<EntityType<KnucklesQueenEntity>> KNUCKLES_QUEEN = ENTITIES.register("knuckles_queen", () -> register("knuckles_queen", EntityType.Builder.<KnucklesQueenEntity>of(KnucklesQueenEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<SansEntity>> SANS = ENTITIES.register("sans", () -> register("sans", EntityType.Builder.<SansEntity>of(SansEntity::new, MobCategory.MONSTER)));
	public static final RegistryObject<EntityType<PinguEntity>> PINGU = ENTITIES.register("pingu", () -> register("pingu", EntityType.Builder.<PinguEntity>of(PinguEntity::new, MobCategory.MONSTER).sized(0.4F, 0.6F)));
	public static final RegistryObject<EntityType<ChocolateGuyEntity>> TOM = ENTITIES.register("tom", () -> register("tom", EntityType.Builder.<ChocolateGuyEntity>of(ChocolateGuyEntity::new, MobCategory.MONSTER).sized(0.6F, 1.7F)));

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

	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(JOHN_CENA.get(), CenaEntity.registerAttributes().build());
		event.put(DONALD_TRUMP.get(), TrumpEntity.registerAttributes().build());
		event.put(DOGE.get(), DogeEntity.registerAttributes().build());
		event.put(GRUMPY_CAT.get(), GrumpyEntity.registerAttributes().build());
		event.put(ATTACHED_GIRLFRIEND.get(), AttachedGirlfriendEntity.registerAttributes().build());
		event.put(EDUARD_KHIL.get(), TrololoEntity.registerAttributes().build());
		event.put(PPAP.get(), PPAPEntity.registerAttributes().build());
		event.put(ROBBIE_ROTTEN.get(), RobbieEntity.registerAttributes().build());
		event.put(GRAND_DAD.get(), GrandDadEntity.registerAttributes().build());
		event.put(HE_MAN.get(), HeManEntity.registerAttributes().build());
		event.put(SKYWALKER.get(), SkywalkerEntity.registerAttributes().build());
		event.put(ROADMAN_SHAQ.get(), RoadmanShaqEntity.registerAttributes().build());
		event.put(PHIL_SWIFT.get(), PhilSwiftEntity.registerAttributes().build());

		event.put(DANKEY_KANG.get(), DankeyEntity.registerAttributes().build());
		event.put(SHREK.get(), ShrekEntity.registerAttributes().build());
		event.put(DAT_BOI.get(), DatBoiEntity.registerAttributes().build());
		event.put(SANIC.get(), SanicEntity.registerAttributes().build());
		event.put(PEPE.get(), PepeEntity.registerAttributes().build());
		event.put(FOREVER_ALONE.get(), FAEntity.registerAttributes().build());
		event.put(NYAN_CAT.get(), NyanCatEntity.registerAttributes().build());
		event.put(TAC_NAYN.get(), TacNyanEntity.registerAttributes().build());
		event.put(NIGEL_THORNBERRY.get(), NigelEntity.registerAttributes().build());
		event.put(DANCING_HOTDOG.get(), HotDogEntity.registerAttributes().build());
		event.put(BONGO_CAT.get(), BongoCatEntity.registerAttributes().build());
		event.put(ROFL_COPTER.get(), RoflCopterEntity.registerAttributes().build());
		event.put(GNOME.get(), GnomeEntity.registerAttributes().build());
		event.put(CLIPPY.get(), ClippyEntity.registerAttributes().build());
		event.put(KNUCKLES.get(), KnucklesEntity.registerAttributes().build());
		event.put(KNUCKLES_QUEEN.get(), KnucklesQueenEntity.registerAttributes().build());
		event.put(SANS.get(), SansEntity.registerAttributes().build());
		event.put(PINGU.get(), PinguEntity.registerAttributes().build());
		event.put(TOM.get(), ChocolateGuyEntity.registerAttributes().build());
	}
}
