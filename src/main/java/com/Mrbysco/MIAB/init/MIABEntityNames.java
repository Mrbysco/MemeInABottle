package com.Mrbysco.MIAB.init;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;
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

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public final class MIABEntityNames {
	
	public static final String SPLASH_MEME = Reference.MOD_PREFIX + "memeSplash";
	public static final String JOHN_CENA = Reference.MOD_PREFIX + "JohnCena";
	public static final String BILL_CIPHER = Reference.MOD_PREFIX + "BillCipher";
	public static final String DOGE_WOLF = Reference.MOD_PREFIX + "DogeWolf";
	public static final String GRUMPY_CAT = Reference.MOD_PREFIX + "GrumpyCat";
	public static final String DONALD_TRUMP = Reference.MOD_PREFIX + "Donaldtrump";
	public static final String EDUARD_KHIL = Reference.MOD_PREFIX + "EduardKhil";
	public static final String PPAP_GUY = Reference.MOD_PREFIX + "PPAPGuy";
	public static final String SHREK = Reference.MOD_PREFIX + "Shrek";
	public static final String DAT_BOI = Reference.MOD_PREFIX + "DatBoi";
	public static final String MOON_MAN = Reference.MOD_PREFIX + "MoonMan";
	public static final String ROTTEN_ROBBIE = Reference.MOD_PREFIX + "RottenRobbie";
	public static final String GRAND_DAD = Reference.MOD_PREFIX + "GrandDad";
	public static final String SANIC = Reference.MOD_PREFIX + "Sanic";
	public static final String PEPE = Reference.MOD_PREFIX + "Pepe";
	public static final String FOREVER_ALONE = Reference.MOD_PREFIX + "ForeverAlone";
	public static final String NYAN_CAT = Reference.MOD_PREFIX + "NyanCat";
	public static final String TAC_NYAN = Reference.MOD_PREFIX + "TacNyan";
	public static final String DANKEY_KANG = Reference.MOD_PREFIX + "DankeyKang";
	public static final String NIGEL_THORNBERRY = Reference.MOD_PREFIX + "Nigelthornberry";
	
	public static final ResourceLocation SPLASH_MEME_REGISTRY = Name("meme_splash");
	public static final ResourceLocation JOHN_CENA_REGISTRY = Name("john_cena");
	public static final ResourceLocation BILL_CIPHER_REGISTRY = Name("bill_cipher");
	public static final ResourceLocation DOGE_WOLF_REGISTRY = Name("doge_wolf");
	public static final ResourceLocation GRUMPY_CAT_REGISTRY = Name("grumpy_cat");
	public static final ResourceLocation DONALD_TRUMP_REGISTRY = Name("donald_trump");
	public static final ResourceLocation EDUARD_KHIL_REGISTRY = Name("eduard_khil");
	public static final ResourceLocation PPAP_GUY_REGISTRY = Name("ppap_guy");
	public static final ResourceLocation SHREK_REGISTRY = Name("shrek");
	public static final ResourceLocation DAT_BOI_REGISTRY = Name("dat_boi");
	public static final ResourceLocation MOON_MAN_REGISTRY = Name("moon_man");
	public static final ResourceLocation ROTTEN_ROBBIE_REGISTRY = Name("rotten_robbie");
	public static final ResourceLocation GRAND_DAD_REGISTRY = Name("grand_dad");
	public static final ResourceLocation SANIC_REGISTRY = Name("sanic");
	public static final ResourceLocation PEPE_REGISTRY = Name("pepe");
	public static final ResourceLocation FOREVER_ALONE_REGISTRY = Name("forever_alone");
	public static final ResourceLocation NYAN_CAT_REGISTRY = Name("nyan_cat");
	public static final ResourceLocation TAC_NYAN_REGISTRY = Name("tac_nyan");
	public static final ResourceLocation DANKEY_KANG_REGISTRY = Name("dankey_kang");
	public static final ResourceLocation NIGEL_THORNBERRY_REGISTRY = Name("nigel_thornberry");

	private static ResourceLocation Name(String s) {
		return new ResourceLocation(Reference.MOD_ID, s);
	}
}
