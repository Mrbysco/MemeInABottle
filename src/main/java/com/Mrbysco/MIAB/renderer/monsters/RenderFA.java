package com.Mrbysco.MIAB.renderer.monsters;

import com.Mrbysco.MIAB.entity.monsters.EntityFA;
import com.Mrbysco.MIAB.renderer.models.ModelFA;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFA extends RenderLiving<EntityFA> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation("miab:entity/foreveralone.png");

	  public RenderFA(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelFA(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityFA entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityFA entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityFA> {

	    @Override
	    public Render<? super EntityFA> createRenderFor(RenderManager manager) {
	      return new RenderFA(manager);
	    }
	  }
	  
}