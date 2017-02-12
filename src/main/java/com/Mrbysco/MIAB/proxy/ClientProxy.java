package com.Mrbysco.MIAB.proxy;

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
import com.Mrbysco.MIAB.init.MIABBlocks;
import com.Mrbysco.MIAB.init.MIABItems;
import com.Mrbysco.MIAB.renderer.EntityRenderingFactory;
import com.Mrbysco.MIAB.renderer.monsters.RenderBill;
import com.Mrbysco.MIAB.renderer.monsters.RenderCena;
import com.Mrbysco.MIAB.renderer.monsters.RenderDankey;
import com.Mrbysco.MIAB.renderer.monsters.RenderDatBoi;
import com.Mrbysco.MIAB.renderer.monsters.RenderFA;
import com.Mrbysco.MIAB.renderer.monsters.RenderKhil;
import com.Mrbysco.MIAB.renderer.monsters.RenderMario7;
import com.Mrbysco.MIAB.renderer.monsters.RenderMoonman;
import com.Mrbysco.MIAB.renderer.monsters.RenderNigel;
import com.Mrbysco.MIAB.renderer.monsters.RenderPepe;
import com.Mrbysco.MIAB.renderer.monsters.RenderPpap;
import com.Mrbysco.MIAB.renderer.monsters.RenderRobbie;
import com.Mrbysco.MIAB.renderer.monsters.RenderSanic;
import com.Mrbysco.MIAB.renderer.monsters.RenderShrek;
import com.Mrbysco.MIAB.renderer.monsters.RenderTacNyan;
import com.Mrbysco.MIAB.renderer.monsters.RenderTrump;
import com.Mrbysco.MIAB.renderer.passive.RenderDoge;
import com.Mrbysco.MIAB.renderer.passive.RenderGrumpy;
import com.Mrbysco.MIAB.renderer.passive.RenderNyanCat;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders(){
		MIABBlocks.registerRenders();
		MIABItems.registerRenders();
	}
	
	@Override
	public void registerRenderingFactories(){
		RenderingRegistry.registerEntityRenderingHandler(EntityMeme.class, new EntityRenderingFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityCena.class, RenderCena.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityBill.class, RenderBill.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityDoge.class, RenderDoge.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityGrumpy.class, RenderGrumpy.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityTrump.class, RenderTrump.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityKhil.class, RenderKhil.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityPpap.class, RenderPpap.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityShrek.class, RenderShrek.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityDatBoi.class, RenderDatBoi.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityMoonman.class, RenderMoonman.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityRobbie.class, RenderRobbie.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityMario7.class, RenderMario7.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntitySanic.class, RenderSanic.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityPepe.class, RenderPepe.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityFA.class, RenderFA.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityNyanCat.class, RenderNyanCat.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityTacNyan.class, RenderTacNyan.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityDankey.class, RenderDankey.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityNigel.class, RenderNigel.FACTORY);
	}
}
