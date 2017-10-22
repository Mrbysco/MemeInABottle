package com.Mrbysco.miab.rendering.passive;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.passive.EntityClippy;
import com.Mrbysco.miab.models.ModelClippy;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderClippy extends RenderLiving<EntityClippy> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/clippy.png");

	  public RenderClippy(RenderManager renderManagerIn) {
		  super(renderManagerIn, new ModelClippy(), 0.5F);
	  }

	  protected void preRenderCallback(EntityClippy entitylivingbaseIn, float partialTickTime)
	  {
		  float f = 0.999F;
		  GlStateManager.scale(0.999F, 0.999F, 0.999F);
	      float f1 = (float)1;
	      float f2 = (entitylivingbaseIn.prevJumpFactor + (entitylivingbaseIn.jumpFactor - entitylivingbaseIn.prevJumpFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
	      float f3 = 1.0F / (f2 + 1.0F);
	      GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	  }
	  
	  @Override
	  protected ResourceLocation getEntityTexture(EntityClippy entity) {
		  return texture;
	  }
	  
	  @Override
	  public void doRender(EntityClippy entity, double x, double y, double z, float entityYaw, float partialTicks) {
		  super.doRender(entity, x, y, z, entityYaw, partialTicks);
	  }
	  
	  public static class Factory implements IRenderFactory<EntityClippy> {
		  @Override
		  public Render<? super EntityClippy> createRenderFor(RenderManager manager) {
			  return new RenderClippy(manager);
		  }
	  }
}