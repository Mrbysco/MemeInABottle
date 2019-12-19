package com.mrbysco.miab.init;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.entity.memes.EntityAttachedGirlfriend;
import com.mrbysco.miab.entity.memes.EntityBongoCat;
import com.mrbysco.miab.entity.memes.EntityCena;
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
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

import java.util.List;

@EventBusSubscriber
public class MemeEntities {
	private static List<EntityEntry> ENTITIES_WITH_EGG = Lists.newArrayList();
	private static List<EntityEntry> ENTITIES = Lists.newArrayList();

	public static final EntityEntry SPLASH_MEME = createThrowable("splash_meme", EntitySplashMeme.class);
	public static final EntityEntry JOHN_CENA = createEntity("john_cena", EntityCena.class, 16032864, 9199159);
	public static final EntityEntry DONALD_TRUMP = createEntity("donald_trump", EntityTrump.class, 16753920, 16766720);
	public static final EntityEntry DOGE = createEntity("doge", EntityDoge.class, 14196256, 15719341);
	public static final EntityEntry GRUMPY_CAT = createEntity("grumpy_cat", EntityGrumpy.class, 14406346, 3354149);
	public static final EntityEntry ATTACHED_GIRLFRIEND = createEntity("attached_girlfriend", EntityAttachedGirlfriend.class, 16240814, 5187607);
	public static final EntityEntry EDUARD_KHIL = createEntity("eduard_khil", EntityTrololo.class, 16765091, 4204057);
	public static final EntityEntry PPAP = createEntity("ppap", EntityPPAP.class, 16768915, 2170639);
	public static final EntityEntry ROBBIE_ROTTEN = createEntity("robbie_rotten", EntityRobbie.class, 16765357, 2370625);
	public static final EntityEntry GRAND_DAD = createEntity("grand_dad", EntityMario7.class, 16777215, 1333964);
	public static final EntityEntry HE_MAN = createEntity("he-man", EntityHeMan.class, 13408394, 14595118);
	public static final EntityEntry SKYWALKER = createEntity("anakin_skywalker", EntitySkywalker.class, 16631181, 7950634);
	public static final EntityEntry ROADMAN_SHAQ = createEntity("roadman_shaq", EntityRoadmanShaq.class, 6375218, 1973790);
	public static final EntityEntry PHIL_SWIFT = createEntity("phil_swift", EntityPhilSwift.class, 16768437, 4013373);

	public static final EntityEntry DANKEY_KANG = createEntity("dankey_kang", EntityDankey.class, 1917560, 14668958);
	public static final EntityEntry SHREK = createEntity("shrek", EntityShrek.class, 6994007, 1401603);
	public static final EntityEntry DAT_BOI = createEntity("dat_boi", EntityDatBoi.class, 307716, 4276545);
	public static final EntityEntry SANIC = createEntity("sanic", EntitySanic.class, 4147404, 2764941);
	public static final EntityEntry PEPE = createEntity("pepe", EntityPepe.class, 5934398, 2642377);
	public static final EntityEntry FOREVER_ALONE = createEntity("forever_alone", EntityFA.class, 14869218, 4031140);
	public static final EntityEntry NYAN_CAT = createEntity("nyan_cat", EntityNyanCat.class, 15118949, 15684762);
	public static final EntityEntry TAC_NAYN = createEntity("tac_nayn", EntityTacNayn.class, 2829099, 11688484);
	public static final EntityEntry NIGEL_THORNBERRY = createEntity("nigel_thornberry", EntityNigel.class, 15044481, 11155745);
	public static final EntityEntry DANCING_HOTDOG = createEntity("dancing_hotdog", EntityHotDog.class, 11887182, 14456412);
	public static final EntityEntry BONGO_CAT = createEntity("bongo_cat", EntityBongoCat.class, 16777215, 1644825);
	public static final EntityEntry ROFL_COPTER = createEntity("roflcopter", EntityRoflCopter.class, 16777215, 1644825);
	public static final EntityEntry GNOME = createEntity("gnome", EntityGnome.class, 1189750, 13442571);
	public static final EntityEntry CLIPPY = createEntity("clippy", EntityClippy.class);
	public static final EntityEntry KNUCKLES = createEntity("knuckles", EntityKnuckles.class, 16729165, 16777215);
	public static final EntityEntry KNUCKLES_QUEEN = createEntity("knuckles_queen", EntityKnucklesQueen.class, 16729165, 16777215);
	public static final EntityEntry KNUCKLES_SPIT = createEntity("knuckles_spit", EntityKnucklesSpit.class);
	public static final EntityEntry SANS = createEntity("sans", EntitySans.class, 6579836, 2610142);
	public static final EntityEntry PINGU = createEntity("pingu", EntityPingu.class, 1975859, 15855854);

	static int ID = 0;

	private static EntityEntry createThrowable(String registryName, Class<? extends Entity> entityClass) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, registryName);
		EntityEntry entry = new EntityEntry(entityClass, Reference.MOD_PREFIX + registryName);
		entry.setRegistryName(location);

		return entry;
	}

	private static EntityEntry createEntity(String registryName, Class<? extends Entity> entityClass) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, registryName);
		EntityEntry entry = new EntityEntry(entityClass, Reference.MOD_PREFIX + registryName);
		entry.setRegistryName(location);
		ENTITIES.add(entry);

		return entry;
	}

	private static EntityEntry createEntity(String registryName, Class<? extends Entity> entityClass, int eggPrimary, int eggSecondary) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, registryName);
		EntityEntry entry = new EntityEntry(entityClass, Reference.MOD_PREFIX + registryName);
		entry.setRegistryName(location);
		entry.setEgg(new EntityList.EntityEggInfo(location, eggPrimary, eggSecondary));
		ENTITIES_WITH_EGG.add(entry);

		return entry;
	}

	public static void registerEntity(RegistryEvent.Register<EntityEntry> event, EntityEntry entry, int range, int update, boolean velocityUpdates) {
		Preconditions.checkNotNull(entry.getRegistryName(), "registryName");
		event.getRegistry().register(EntityEntryBuilder.create()
				.entity(entry.getEntityClass())
				.id(entry.getRegistryName(), ID)
				.name(entry.getName())
				.tracker(80, 3, true)
				.build());
		ID++;
	}

	public static void registerEggEntity(RegistryEvent.Register<EntityEntry> event, EntityEntry entry, int range, int update, boolean velocityUpdates) {
		Preconditions.checkNotNull(entry.getRegistryName(), "registryName");
		event.getRegistry().register(EntityEntryBuilder.create()
				.entity(entry.getEntityClass())
				.id(entry.getRegistryName(), ID)
				.name(entry.getName())
				.tracker(80, 3, true)
				.egg(entry.getEgg().primaryColor, entry.getEgg().secondaryColor)
				.build());
		ID++;
	}

	@SubscribeEvent
	public static void registerPenguins(RegistryEvent.Register<EntityEntry> event) {
		registerEntity(event, SPLASH_MEME, 64, 10, true);

		for (EntityEntry entry : ENTITIES) {
			registerEntity(event, entry, 80, 3, true);
			ID++;
		}
		for (EntityEntry entry : ENTITIES_WITH_EGG) {
			registerEggEntity(event, entry, 80, 3, true);
			ID++;
		}

	}
}
