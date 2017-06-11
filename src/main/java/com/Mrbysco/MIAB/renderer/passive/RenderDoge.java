package com.Mrbysco.MIAB.renderer.passive;

import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDoge extends RenderWolf
	{
		public static final Factory FACTORY = new Factory();
		
		private static final ResourceLocation texture = new ResourceLocation("miab:entity/doge.png");
		
		public RenderDoge(RenderManager renderManagerIn) {
			super(renderManagerIn);
		  }
		
		@Override
		protected ResourceLocation getEntityTexture(EntityWolf entity) {
		  return texture;
		}
		
		public static class Factory implements IRenderFactory<EntityWolf> {
		
		  @Override
		  public Render<? super EntityWolf> createRenderFor(RenderManager manager) {
		    return new RenderDoge(manager);
		  }
		}
		
	}