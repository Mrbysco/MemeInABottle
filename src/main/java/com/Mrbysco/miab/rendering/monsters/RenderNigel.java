package com.Mrbysco.miab.rendering.monsters;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.hostile.EntityNigel;
import com.Mrbysco.miab.models.ModelNigel;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderNigel extends RenderLiving<EntityNigel> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/nigel.png");

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