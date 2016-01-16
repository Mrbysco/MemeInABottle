package com.Mrbysco.MIAB.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityRenderingFactory implements IRenderFactory<EntityMeme>{

	@Override
	public Render<? super EntityMeme> createRenderFor(RenderManager manager) {
		RenderItem renderer = FMLClientHandler.instance().getClient().getRenderItem();
		return new EntityMemeRenderer(manager, renderer);
	}

}
