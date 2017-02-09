package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.entity.EntityMeme;
import com.Mrbysco.MIAB.entity.monsters.EntityBill;
import com.Mrbysco.MIAB.entity.monsters.EntityCena;
import com.Mrbysco.MIAB.entity.monsters.EntityDatBoi;
import com.Mrbysco.MIAB.entity.monsters.EntityKhil;
import com.Mrbysco.MIAB.entity.monsters.EntityMario7;
import com.Mrbysco.MIAB.entity.monsters.EntityMoonman;
import com.Mrbysco.MIAB.entity.monsters.EntityPepe;
import com.Mrbysco.MIAB.entity.monsters.EntityPpap;
import com.Mrbysco.MIAB.entity.monsters.EntityRobbie;
import com.Mrbysco.MIAB.entity.monsters.EntitySanic;
import com.Mrbysco.MIAB.entity.monsters.EntityShrek;
import com.Mrbysco.MIAB.entity.monsters.EntityTrump;
import com.Mrbysco.MIAB.entity.passive.EntityDoge;
import com.Mrbysco.MIAB.entity.passive.EntityGrumpy;

import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MIABEntities {
	
	public static void register() {
		EntityRegistry.registerModEntity(EntityMeme.class, "memeSplash", 0, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityCena.class, "JohnCena", 1, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityBill.class, "BillCipher", 2, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityDoge.class, "DogeWolf", 3, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityGrumpy.class, "GrumpyCat", 4, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityTrump.class, "Donaldtrump", 5, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityKhil.class, "EduardKhil", 6, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityPpap.class, "PPAPGuy", 7, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityShrek.class, "Shrek", 8, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityDatBoi.class, "DatBoi", 9, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityMoonman.class, "MoonMan", 10, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityRobbie.class, "RottenRobbie", 11, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityMario7.class, "GrandDad", 12, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntitySanic.class, "Sanic", 13, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityPepe.class, "Pepe", 14, MIAB.instance, 80, 3, true);
	}

}
