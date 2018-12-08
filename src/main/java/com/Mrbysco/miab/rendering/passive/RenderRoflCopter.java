package com.Mrbysco.miab.rendering.passive;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.passive.EntityRoflCopter;
import com.Mrbysco.miab.models.ModelRoflCopter;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRoflCopter extends RenderLiving<EntityRoflCopter> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/roflcopter.png");

	  public RenderRoflCopter(RenderManager renderManagerIn) {
		  super(renderManagerIn, new ModelRoflCopter(), 1.0F);
	  }
	  
	  @Override
	  protected ResourceLocation getEntityTexture(EntityRoflCopter entity) {
		  return texture;
	  }
	  
	  @Override
	  public void doRender(EntityRoflCopter entity, double x, double y, double z, float entityYaw, float partialTicks) {
		  super.doRender(entity, x, y, z, entityYaw, partialTicks);
	  }
	  
	  public static class Factory implements IRenderFactory<EntityRoflCopter> {
		  @Override
		  public Render<? super EntityRoflCopter> createRenderFor(RenderManager manager) {
			  return new RenderRoflCopter(manager);
		  }
	  }
}