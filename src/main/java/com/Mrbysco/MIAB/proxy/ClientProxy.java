package com.Mrbysco.MIAB.proxy;

import com.Mrbysco.MIAB.entity.EntityMeme;
import com.Mrbysco.MIAB.entity.EntityRenderingFactory;
import com.Mrbysco.MIAB.entity.monsters.EntityBill;
import com.Mrbysco.MIAB.entity.monsters.EntityCena;
import com.Mrbysco.MIAB.entity.monsters.RenderBill;
import com.Mrbysco.MIAB.entity.monsters.RenderCena;
import com.Mrbysco.MIAB.init.MIABBlocks;
import com.Mrbysco.MIAB.init.MIABItems;

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
		RenderingRegistry.registerEntityRenderingHandler(EntityBill.class, new RenderBill.FACTORY);
	}
	
}
