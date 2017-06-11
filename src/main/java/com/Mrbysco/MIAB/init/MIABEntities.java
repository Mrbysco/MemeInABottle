package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.entity.EntityMeme;
import com.Mrbysco.MIAB.entity.monsters.EntityBill;
import com.Mrbysco.MIAB.entity.monsters.EntityCena;
import com.Mrbysco.MIAB.entity.monsters.EntityDankey;
import com.Mrbysco.MIAB.entity.monsters.EntityDatBoi;
import com.Mrbysco.MIAB.entity.monsters.EntityFA;
import com.Mrbysco.MIAB.entity.monsters.EntityKhil;
import com.Mrbysco.MIAB.entity.monsters.EntityMario7;
import com.Mrbysco.MIAB.entity.monsters.EntityMoonman;
import com.Mrbysco.MIAB.entity.monsters.EntityNigel;
import com.Mrbysco.MIAB.entity.monsters.EntityPepe;
import com.Mrbysco.MIAB.entity.monsters.EntityPpap;
import com.Mrbysco.MIAB.entity.monsters.EntityRobbie;
import com.Mrbysco.MIAB.entity.monsters.EntitySanic;
import com.Mrbysco.MIAB.entity.monsters.EntityShrek;
import com.Mrbysco.MIAB.entity.monsters.EntityTacNyan;
import com.Mrbysco.MIAB.entity.monsters.EntityTrump;
import com.Mrbysco.MIAB.entity.passive.EntityDoge;
import com.Mrbysco.MIAB.entity.passive.EntityGrumpy;
import com.Mrbysco.MIAB.entity.passive.EntityNyanCat;

import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MIABEntities {
	
	public static void register() {
		EntityRegistry.registerModEntity(MIABEntityNames.SPLASH_MEME_REGISTRY, EntityMeme.class, MIABEntityNames.SPLASH_MEME, 0, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.JOHN_CENA_REGISTRY, EntityCena.class, MIABEntityNames.JOHN_CENA, 1, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.BILL_CIPHER_REGISTRY, EntityBill.class, MIABEntityNames.BILL_CIPHER, 2, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.DOGE_WOLF_REGISTRY, EntityDoge.class, MIABEntityNames.DOGE_WOLF, 3, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.GRUMPY_CAT_REGISTRY, EntityGrumpy.class, MIABEntityNames.GRUMPY_CAT, 4, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.DONALD_TRUMP_REGISTRY, EntityTrump.class, MIABEntityNames.DONALD_TRUMP, 5, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.EDUARD_KHIL_REGISTRY, EntityKhil.class, MIABEntityNames.EDUARD_KHIL, 6, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.PPAP_GUY_REGISTRY, EntityPpap.class, MIABEntityNames.PPAP_GUY, 7, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.SHREK_REGISTRY, EntityShrek.class, MIABEntityNames.SHREK, 8, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.DAT_BOI_REGISTRY, EntityDatBoi.class, MIABEntityNames.DAT_BOI, 9, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.MOON_MAN_REGISTRY, EntityMoonman.class, MIABEntityNames.MOON_MAN, 10, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.ROTTEN_ROBBIE_REGISTRY, EntityRobbie.class, MIABEntityNames.ROTTEN_ROBBIE, 11, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.GRAND_DAD_REGISTRY, EntityMario7.class, MIABEntityNames.GRAND_DAD, 12, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.SANIC_REGISTRY, EntitySanic.class, MIABEntityNames.SANIC, 13, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.PEPE_REGISTRY, EntityPepe.class, MIABEntityNames.PEPE, 14, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.FOREVER_ALONE_REGISTRY, EntityFA.class, MIABEntityNames.FOREVER_ALONE, 15, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.NYAN_CAT_REGISTRY, EntityNyanCat.class, MIABEntityNames.NYAN_CAT, 16, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.TAC_NYAN_REGISTRY, EntityTacNyan.class, MIABEntityNames.TAC_NYAN, 17, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.DANKEY_KANG_REGISTRY, EntityDankey.class, MIABEntityNames.DANKEY_KANG, 18, MIAB.instance, 80, 3, true);
		EntityRegistry.registerModEntity(MIABEntityNames.NIGEL_THORNBERRY_REGISTRY, EntityNigel.class, MIABEntityNames.NIGEL_THORNBERRY, 19, MIAB.instance, 80, 3, true);
	}

}
