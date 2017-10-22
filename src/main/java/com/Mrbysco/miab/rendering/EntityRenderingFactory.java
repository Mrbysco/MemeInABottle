package com.Mrbysco.miab.rendering;

import com.Mrbysco.miab.entities.throwable.EntitySplashMeme;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityRenderingFactory implements IRenderFactory<EntitySplashMeme>{

	@Override
	public Render<? super EntitySplashMeme> createRenderFor(RenderManager manager) {
		RenderItem renderer = FMLClientHandler.instance().getClient().getRenderItem();
		return new EntityMemeRenderer(manager, renderer);
	}

}