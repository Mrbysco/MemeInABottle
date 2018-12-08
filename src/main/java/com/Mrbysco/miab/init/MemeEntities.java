package com.Mrbysco.miab.init;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.boss.EntityMemeBigBoss;
import com.Mrbysco.miab.entities.hostile.EntityAttachedGirlfriend;
import com.Mrbysco.miab.entities.hostile.EntityBill;
import com.Mrbysco.miab.entities.hostile.EntityCena;
import com.Mrbysco.miab.entities.hostile.EntityDankey;
import com.Mrbysco.miab.entities.hostile.EntityDatBoi;
import com.Mrbysco.miab.entities.hostile.EntityFA;
import com.Mrbysco.miab.entities.hostile.EntityHeMan;
import com.Mrbysco.miab.entities.hostile.EntityHotDog;
import com.Mrbysco.miab.entities.hostile.EntityKhil;
import com.Mrbysco.miab.entities.hostile.EntityMario7;
import com.Mrbysco.miab.entities.hostile.EntityMoonman;
import com.Mrbysco.miab.entities.hostile.EntityNigel;
import com.Mrbysco.miab.entities.hostile.EntityPepe;
import com.Mrbysco.miab.entities.hostile.EntityPhilSwift;
import com.Mrbysco.miab.entities.hostile.EntityPpap;
import com.Mrbysco.miab.entities.hostile.EntityRoadmanShaq;
import com.Mrbysco.miab.entities.hostile.EntityRobbie;
import com.Mrbysco.miab.entities.hostile.EntitySanic;
import com.Mrbysco.miab.entities.hostile.EntityShrek;
import com.Mrbysco.miab.entities.hostile.EntitySkywalker;
import com.Mrbysco.miab.entities.hostile.EntityTacNayn;
import com.Mrbysco.miab.entities.hostile.EntityTrump;
import com.Mrbysco.miab.entities.passive.EntityBongoCat;
import com.Mrbysco.miab.entities.passive.EntityClippy;
import com.Mrbysco.miab.entities.passive.EntityDoge;
import com.Mrbysco.miab.entities.passive.EntityGnome;
import com.Mrbysco.miab.entities.passive.EntityGrumpy;
import com.Mrbysco.miab.entities.passive.EntityKnuckles;
import com.Mrbysco.miab.entities.passive.EntityKnucklesQueen;
import com.Mrbysco.miab.entities.passive.EntityNyanCat;
import com.Mrbysco.miab.entities.passive.EntityRoflCopter;
import com.Mrbysco.miab.entities.projectiles.EntityKnucklesSpit;
import com.Mrbysco.miab.entities.projectiles.EntitySplashMeme;
import com.Mrbysco.miab.rendering.EntityMemeRenderer;
import com.Mrbysco.miab.rendering.KnucklesSpitRender;
import com.Mrbysco.miab.rendering.knuckles.RenderKnuckles;
import com.Mrbysco.miab.rendering.knuckles.RenderQueenKnuckles;
import com.Mrbysco.miab.rendering.monsters.RenderAttachedGirlfriend;
import com.Mrbysco.miab.rendering.monsters.RenderBigBoi;
import com.Mrbysco.miab.rendering.monsters.RenderBill;
import com.Mrbysco.miab.rendering.monsters.RenderCena;
import com.Mrbysco.miab.rendering.monsters.RenderDankey;
import com.Mrbysco.miab.rendering.monsters.RenderDatBoi;
import com.Mrbysco.miab.rendering.monsters.RenderFA;
import com.Mrbysco.miab.rendering.monsters.RenderHeMan;
import com.Mrbysco.miab.rendering.monsters.RenderHotDog;
import com.Mrbysco.miab.rendering.monsters.RenderKhil;
import com.Mrbysco.miab.rendering.monsters.RenderMario7;
import com.Mrbysco.miab.rendering.monsters.RenderMoonman;
import com.Mrbysco.miab.rendering.monsters.RenderNigel;
import com.Mrbysco.miab.rendering.monsters.RenderPepe;
import com.Mrbysco.miab.rendering.monsters.RenderPhilSwift;
import com.Mrbysco.miab.rendering.monsters.RenderPpap;
import com.Mrbysco.miab.rendering.monsters.RenderRoadmanShaq;
import com.Mrbysco.miab.rendering.monsters.RenderRobbie;
import com.Mrbysco.miab.rendering.monsters.RenderSanic;
import com.Mrbysco.miab.rendering.monsters.RenderShrek;
import com.Mrbysco.miab.rendering.monsters.RenderSkywalker;
import com.Mrbysco.miab.rendering.monsters.RenderTacNayn;
import com.Mrbysco.miab.rendering.monsters.RenderTrump;
import com.Mrbysco.miab.rendering.passive.RenderBongoCat;
import com.Mrbysco.miab.rendering.passive.RenderClippy;
import com.Mrbysco.miab.rendering.passive.RenderDoge;
import com.Mrbysco.miab.rendering.passive.RenderGnome;
import com.Mrbysco.miab.rendering.passive.RenderGrumpy;
import com.Mrbysco.miab.rendering.passive.RenderNyanCat;
import com.Mrbysco.miab.rendering.passive.RenderRoflCopter;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MemeEntities {

	static int ID = 0;
	
	public static void register() 
	{
		registerEntity("splash_meme", EntitySplashMeme.class, "SplashMeme", 80, 3, true);
		registerEntity("john_cena", EntityCena.class, "JohnCena", 80, 3, true, 16032864, 9199159);
		registerEntity("bill_cipher", EntityBill.class, "BillCipher", 80, 3, true, 16707402, 2171169);
		registerEntity("doge_wolf", EntityDoge.class, "DogeWolf", 80, 3, true, 14196256, 15719341);
		registerEntity("grumpy_cat", EntityGrumpy.class, "GrumpyCat", 80, 3, true, 14406346, 3354149);
		registerEntity("donald_trump", EntityTrump.class, "DonaldTrump", 80, 3, true, 16753920, 16766720);
		registerEntity("eduard_khil", EntityKhil.class, "EduardKhil", 80, 3, true, 16765091, 4204057);
		registerEntity("ppap_guy", EntityPpap.class, "PPAPGuy", 80, 3, true, 16768915, 2170639);
		registerEntity("shrek", EntityShrek.class, "Shrek", 80, 3, true, 6994007, 1401603);
		registerEntity("dat_boi", EntityDatBoi.class, "DatBoi", 80, 3, true, 307716, 4276545);
		registerEntity("moonman", EntityMoonman.class, "Moonman", 80, 3, true, 12895428, 7237230);
		registerEntity("rotten_robbie", EntityRobbie.class, "RottenRobbie", 80, 3, true, 16765357, 2370625);
		registerEntity("grand_dad", EntityMario7.class, "GrandDad", 80, 3, true, 16777215, 1333964);
		registerEntity("sanic", EntitySanic.class, "Sanic", 80, 3, true, 4147404, 2764941);
		registerEntity("pepe", EntityPepe.class, "Pepe", 80, 3, true, 5934398, 2642377);
		registerEntity("forever_alone", EntityFA.class, "ForeverAlone", 80, 3, true, 14869218, 4031140);
		registerEntity("nyan_cat", EntityNyanCat.class, "NyanCat", 80, 3, true, 15118949, 15684762);
		registerEntity("tac_nayn", EntityTacNayn.class, "taCnayN", 80, 3, true, 2829099, 11688484);
		registerEntity("dankey_kang", EntityDankey.class, "DankeyKang", 80, 3, true, 1917560, 14668958);
		registerEntity("nigel_thornberry", EntityNigel.class, "NigelThornberry", 80, 3, true, 15044481, 11155745);
		registerEntity("attached_girlfriend", EntityAttachedGirlfriend.class, "AttachedGirlfriend", 80, 3, true, 16240814, 5187607);
		registerEntity("anakin_skywalker", EntitySkywalker.class, "AnakinSkywalker", 80, 3, true, 16631181, 7950634);
		registerEntity("roadman_shaq", EntityRoadmanShaq.class, "RoadmanShaq", 80, 3, true, 6375218, 1973790);
		registerEntity("me_me_big_boi", EntityMemeBigBoss.class, "MemeBigBoi", 80, 3, true);
		registerEntity("dancing_hotdog", EntityHotDog.class, "DancingHotdog", 80, 3, true, 11887182, 14456412);
		registerEntity("he_man", EntityHeMan.class, "HeMan", 80, 3, true, 13408394, 14595118);
		registerEntity("clippy", EntityClippy.class, "Clippy", 80, 3, true);
		registerEntity("knuckles", EntityKnuckles.class, "Knuckles", 80, 3, true, 16729165, 16777215);
		registerEntity("knuckles_queen", EntityKnucklesQueen.class, "KnucklesQueen", 80, 3, true, 16729165, 16777215);
		registerEntity("knuckles_spit", EntityKnucklesSpit.class, "KnucklesSpit", 80, 3, true);
		registerEntity("bongo_cat", EntityBongoCat.class, "BongoCat", 80, 3, true, 16777215, 1644825);
		registerEntity("rofl_copter", EntityRoflCopter.class, "RoflCopter", 80, 3, true, 16777215, 1644825);
		registerEntity("gnome", EntityGnome.class, "Gnome", 80, 3, true, 1189750, 13442571);
		registerEntity("phil_swift", EntityPhilSwift.class, "PhilSwift", 80, 3, true, 16768437, 4013373);
	}
	
	public static void registerSpawn(Class <? extends EntityLiving > entityClass, int weigth, int minGroup, int maxGroup, Biome... biomes)
	{
		EntityRegistry.addSpawn(entityClass, weigth, minGroup, maxGroup, EnumCreatureType.MONSTER, biomes);
	}
	
	@SideOnly(Side.CLIENT)
	public static void RegisterEntityRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySplashMeme.class, renderManager -> new EntityMemeRenderer(renderManager, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkywalker.class, RenderSkywalker.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityAttachedGirlfriend.class, RenderAttachedGirlfriend.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityBill.class, RenderBill.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityCena.class, RenderCena.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityDankey.class, RenderDankey.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityDatBoi.class, RenderDatBoi.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityDoge.class, RenderDoge.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityFA.class, RenderFA.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityGrumpy.class, RenderGrumpy.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityKhil.class, RenderKhil.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityMario7.class, RenderMario7.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityMoonman.class, RenderMoonman.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityNigel.class, RenderNigel.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityNyanCat.class, RenderNyanCat.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityPepe.class, RenderPepe.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityPpap.class, RenderPpap.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityRobbie.class, RenderRobbie.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntitySanic.class, RenderSanic.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityShrek.class, RenderShrek.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityTacNayn.class, RenderTacNayn.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityTrump.class, RenderTrump.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityRoadmanShaq.class, RenderRoadmanShaq.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityMemeBigBoss.class, RenderBigBoi.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityHotDog.class, RenderHotDog.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityHeMan.class, RenderHeMan.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityClippy.class, RenderClippy.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityKnuckles.class, RenderKnuckles.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityKnucklesQueen.class, RenderQueenKnuckles.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityKnucklesSpit.class, renderManager -> new KnucklesSpitRender(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBongoCat.class, RenderBongoCat.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityRoflCopter.class, RenderRoflCopter.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityGnome.class, RenderGnome.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityPhilSwift.class, RenderPhilSwift.FACTORY);
	}
	
	public static void registerEntity(String registryName, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int eggPrimary, int eggSecondary) 
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, registryName), entityClass, Reference.MOD_PREFIX + entityName, ID, MemeInABottle.instance, trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
		ID++;
	}
	
	public static void registerEntity(String registryName, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) 
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, registryName), entityClass, Reference.MOD_PREFIX + entityName, ID, MemeInABottle.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		ID++;
	}
}
