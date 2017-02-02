package com.Mrbysco.MIAB.proxy;

import com.Mrbysco.MIAB.entity.EntityMeme;
import com.Mrbysco.MIAB.entity.monsters.EntityBill;
import com.Mrbysco.MIAB.entity.monsters.EntityCena;
import com.Mrbysco.MIAB.entity.monsters.EntityDatBoi;
import com.Mrbysco.MIAB.entity.monsters.EntityKhil;
import com.Mrbysco.MIAB.entity.monsters.EntityPpap;
import com.Mrbysco.MIAB.entity.monsters.EntityShrek;
import com.Mrbysco.MIAB.entity.monsters.EntityTrump;
import com.Mrbysco.MIAB.entity.passive.EntityDoge;
import com.Mrbysco.MIAB.entity.passive.EntityGrumpy;
import com.Mrbysco.MIAB.init.MIABBlocks;
import com.Mrbysco.MIAB.init.MIABItems;
import com.Mrbysco.MIAB.renderer.EntityRenderingFactory;
import com.Mrbysco.MIAB.renderer.monsters.RenderBill;
import com.Mrbysco.MIAB.renderer.monsters.RenderCena;
import com.Mrbysco.MIAB.renderer.monsters.RenderDatBoi;
import com.Mrbysco.MIAB.renderer.monsters.RenderKhil;
import com.Mrbysco.MIAB.renderer.monsters.RenderPpap;
import com.Mrbysco.MIAB.renderer.monsters.RenderShrek;
import com.Mrbysco.MIAB.renderer.monsters.RenderTrump;
import com.Mrbysco.MIAB.renderer.passive.RenderDoge;
import com.Mrbysco.MIAB.renderer.passive.RenderGrumpy;

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
	}
}
