package com.Mrbysco.MIAB.renderer;

import com.Mrbysco.MIAB.entity.EntityMeme;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
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
