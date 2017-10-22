package com.Mrbysco.miab.rendering.monsters;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.hostile.EntityHotDog;
import com.Mrbysco.miab.models.ModelHotDog;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHotDog extends RenderLiving<EntityHotDog> {
	
	public static final Factory FACTORY = new Factory();
	  
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/hotdog.png");

	public RenderHotDog(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelHotDog(), 0.5F);
	}

	@Override
		protected ResourceLocation getEntityTexture(EntityHotDog entity) {
		return texture;
	}
	  
	@Override
	public void doRender(EntityHotDog entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	public static class Factory implements IRenderFactory<EntityHotDog> {

		@Override
		public Render<? super EntityHotDog> createRenderFor(RenderManager manager) {
			return new RenderHotDog(manager);
		}
	}
	  
}