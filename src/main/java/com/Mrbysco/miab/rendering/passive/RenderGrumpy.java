package com.Mrbysco.miab.rendering.passive;

import com.Mrbysco.miab.Reference;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGrumpy extends RenderOcelot
	{
		public static final Factory FACTORY = new Factory();
		
		private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/grumpy.png");
		
		public RenderGrumpy(RenderManager renderManagerIn) {
			super(renderManagerIn);
		  }
		
		@Override
		protected ResourceLocation getEntityTexture(EntityOcelot entity) {
		  return texture;
		}
		
		public static class Factory implements IRenderFactory<EntityOcelot> {
		
		  @Override
		  public Render<? super EntityOcelot> createRenderFor(RenderManager manager) {
		    return new RenderGrumpy(manager);
		  }
		}
		
	}