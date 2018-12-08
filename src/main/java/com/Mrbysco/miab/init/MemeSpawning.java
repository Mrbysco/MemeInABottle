package com.Mrbysco.miab.init;

import com.Mrbysco.miab.config.MemeConfigGen;
import com.Mrbysco.miab.entities.hostile.EntityAttachedGirlfriend;
import com.Mrbysco.miab.entities.hostile.EntityBill;
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
import com.Mrbysco.miab.entities.hostile.EntityTacNayn;
import com.Mrbysco.miab.entities.hostile.EntityTrump;
import com.Mrbysco.miab.entities.passive.EntityBongoCat;
import com.Mrbysco.miab.entities.passive.EntityClippy;
import com.Mrbysco.miab.entities.passive.EntityDoge;
import com.Mrbysco.miab.entities.passive.EntityGrumpy;
import com.Mrbysco.miab.entities.passive.EntityKnucklesQueen;
import com.Mrbysco.miab.entities.passive.EntityNyanCat;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MemeSpawning {

	public static void registerSpawning() 
	{
		if(MemeConfigGen.spawning.skywalker.SkywalkerSpawning)
		{
			EntityRegistry.addSpawn(EntityDankey.class, MemeConfigGen.spawning.skywalker.SkywalkerWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.MUTATED_DESERT);
		}
		
		if(MemeConfigGen.spawning.attachedgirlfriend.AttachedGirlfriendSpawning)
		{
			EntityRegistry.addSpawn(EntityAttachedGirlfriend.class, MemeConfigGen.spawning.attachedgirlfriend.AttachedGirlfriendWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, 
					Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.billcipher.BillSpawning)
		{
			EntityRegistry.addSpawn(EntityBill.class, MemeConfigGen.spawning.billcipher.BillWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, 
					Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST, Biomes.REDWOOD_TAIGA, Biomes.REDWOOD_TAIGA_HILLS, Biomes.MUTATED_REDWOOD_TAIGA, Biomes.MUTATED_REDWOOD_TAIGA_HILLS);
		}
		
		if(MemeConfigGen.spawning.dankey.DankeySpawning)
		{
			EntityRegistry.addSpawn(EntityDankey.class, MemeConfigGen.spawning.dankey.DankeyWeigth, 1, 4, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.MUTATED_TAIGA, Biomes.MUTATED_TAIGA_COLD);
		}
		
		if(MemeConfigGen.spawning.datboi.DatBoiSpawning)
		{
			EntityRegistry.addSpawn(EntityDatBoi.class, MemeConfigGen.spawning.datboi.DatBoiWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.MESA, Biomes.MESA_ROCK, Biomes.MESA_CLEAR_ROCK, Biomes.MUTATED_MESA, Biomes.MUTATED_MESA_CLEAR_ROCK, Biomes.MUTATED_MESA_ROCK);
		}
		
		if(MemeConfigGen.spawning.doge.DogeSpawning)
		{
			EntityRegistry.addSpawn(EntityDoge.class, MemeConfigGen.spawning.doge.DogeWeigth, 1, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.MUTATED_TAIGA, Biomes.MUTATED_TAIGA_COLD);
		}
		
		if(MemeConfigGen.spawning.foreveralone.ForeverAloneSpawning)
		{
			EntityRegistry.addSpawn(EntityFA.class, MemeConfigGen.spawning.foreveralone.ForeverAloneWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.grumpy.GrumpySpawning)
		{
			EntityRegistry.addSpawn(EntityGrumpy.class, MemeConfigGen.spawning.grumpy.GrumpyWeigth, 1, 3, EnumCreatureType.CREATURE, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE, Biomes.MUTATED_JUNGLE_EDGE);
		}
		
		if(MemeConfigGen.spawning.trololo.TrololoSpawning)
		{
			EntityRegistry.addSpawn(EntityKhil.class, MemeConfigGen.spawning.trololo.TrololoWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.granddad.GrandDadSpawning)
		{
			EntityRegistry.addSpawn(EntityMario7.class, MemeConfigGen.spawning.granddad.GrandDadWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.moonman.MoonmanSpawning)
		{
			EntityRegistry.addSpawn(EntityMoonman.class, MemeConfigGen.spawning.moonman.MoonmanWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.nigel.NigelSpawning)
		{
			EntityRegistry.addSpawn(EntityNigel.class, MemeConfigGen.spawning.nigel.NigelWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.nyancat.NyanCatSpawning)
		{
			EntityRegistry.addSpawn(EntityNyanCat.class, MemeConfigGen.spawning.nyancat.NyanCatWeigth, 1, 3, EnumCreatureType.CREATURE, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE, Biomes.MUTATED_JUNGLE_EDGE);
		}
		
		if(MemeConfigGen.spawning.tacnayn.TacNaynSpawning)
		{
			EntityRegistry.addSpawn(EntityTacNayn.class, MemeConfigGen.spawning.tacnayn.TacNaynWeigth, 1, 3, EnumCreatureType.CREATURE, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE, Biomes.MUTATED_JUNGLE_EDGE);
		}
		
		if(MemeConfigGen.spawning.pepe.PepeSpawning)
		{
			EntityRegistry.addSpawn(EntityPepe.class, MemeConfigGen.spawning.pepe.PepeWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.SWAMPLAND, Biomes.MUTATED_SWAMPLAND, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.ppap.PpapSpawning)
		{
			EntityRegistry.addSpawn(EntityPpap.class, MemeConfigGen.spawning.ppap.PpapWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.robbierotten.RobbieRottenSpawning)
		{
			EntityRegistry.addSpawn(EntityRobbie.class, MemeConfigGen.spawning.robbierotten.RobbieRottenWeigth, 4, 4, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.sanic.SanicSpawning)
		{
			EntityRegistry.addSpawn(EntitySanic.class, MemeConfigGen.spawning.sanic.SanicWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.shrek.ShrekSpawning)
		{
			EntityRegistry.addSpawn(EntityShrek.class, MemeConfigGen.spawning.shrek.ShrekWeigth, 2, 3, EnumCreatureType.MONSTER, Biomes.SWAMPLAND, Biomes.MUTATED_SWAMPLAND);
		}
		
		if(MemeConfigGen.spawning.trump.TrumpSpawning)
		{
			EntityRegistry.addSpawn(EntityTrump.class, MemeConfigGen.spawning.trump.TrumpWeigth, 1, 1, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.roadmanshaq.RoadmanShaqSpawning)
		{
			EntityRegistry.addSpawn(EntityRoadmanShaq.class, MemeConfigGen.spawning.roadmanshaq.RoadmanShaqWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.philswift.PhilSwiftSpawning)
		{
			EntityRegistry.addSpawn(EntityPhilSwift.class, MemeConfigGen.spawning.philswift.PhilSwiftWeigth, 1, 3, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.dancinghotdog.HotDogSpawning)
		{
			EntityRegistry.addSpawn(EntityHotDog.class, MemeConfigGen.spawning.dancinghotdog.HotDogWeigth, 2, 4, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.heman.HeManSpawning)
		{
			EntityRegistry.addSpawn(EntityHeMan.class, MemeConfigGen.spawning.heman.HeManWeigth, 1, 2, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.clippy.ClippySpawning)
		{
			EntityRegistry.addSpawn(EntityClippy.class, MemeConfigGen.spawning.clippy.ClippyWeigth, 1, 1, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.knucklesqueen.KnucklesQueenSpawning)
		{
			EntityRegistry.addSpawn(EntityKnucklesQueen.class, MemeConfigGen.spawning.knucklesqueen.KnucklesQueenWeigth, 1, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.bongocat.BongoCatSpawning)
		{
			EntityRegistry.addSpawn(EntityBongoCat.class, MemeConfigGen.spawning.bongocat.BongoCatWeigth, 1, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.roflcopter.RoflCopterSpawning)
		{
			EntityRegistry.addSpawn(EntityBongoCat.class, MemeConfigGen.spawning.roflcopter.RoflCopterWeigth, 1, 2, EnumCreatureType.AMBIENT, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
		if(MemeConfigGen.spawning.gnome.GnomeSpawning)
		{
			EntityRegistry.addSpawn(EntityBongoCat.class, MemeConfigGen.spawning.gnome.GnomeWeigth, 1, 4, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.MUTATED_FOREST, Biomes.BIRCH_FOREST, Biomes.MUTATED_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.MUTATED_BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
		}
		
	}
}
