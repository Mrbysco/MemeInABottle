package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.entity.EntityMeme;
import com.Mrbysco.MIAB.entity.monsters.EntityBill;
import com.Mrbysco.MIAB.entity.monsters.EntityCena;
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
	}

}
