package com.Mrbysco.MIAB.renderer.monsters;

import com.Mrbysco.MIAB.entity.monsters.EntitySanic;
import com.Mrbysco.MIAB.renderer.models.ModelSanic;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSanic extends RenderLiving<EntitySanic> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation("miab:entity/sanic.png");

	  public RenderSanic(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelSanic(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntitySanic entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntitySanic entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntitySanic> {

	    @Override
	    public Render<? super EntitySanic> createRenderFor(RenderManager manager) {
	      return new RenderSanic(manager);
	    }
	  }
	  
}