package com.Mrbysco.miab.rendering.passive;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.passive.EntityNyanCat;
import com.Mrbysco.miab.models.ModelNyan;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderNyanCat extends RenderLiving<EntityNyanCat> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/nyancat.png");

	  public RenderNyanCat(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelNyan(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityNyanCat entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityNyanCat entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityNyanCat> {

		  @Override
		  public Render<? super EntityNyanCat> createRenderFor(RenderManager manager) {
		    return new RenderNyanCat(manager);
		  }
	  }
	  
}