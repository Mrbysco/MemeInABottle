package com.Mrbysco.MIAB.renderer.monsters;

import com.Mrbysco.MIAB.entity.monsters.EntityNigel;
import com.Mrbysco.MIAB.renderer.models.ModelNigel;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderNigel extends RenderLiving<EntityNigel> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation("miab:entity/nigel.png");

	  public RenderNigel(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelNigel(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityNigel entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityNigel entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityNigel> {

	    @Override
	    public Render<? super EntityNigel> createRenderFor(RenderManager manager) {
	      return new RenderNigel(manager);
	    }
	  }
	  
}