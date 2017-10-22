package com.Mrbysco.miab.rendering.monsters;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.hostile.EntityPepe;
import com.Mrbysco.miab.models.ModelPepe;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderPepe extends RenderLiving<EntityPepe> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/pepe.png");

	  public RenderPepe(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelPepe(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityPepe entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityPepe entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityPepe> {

	    @Override
	    public Render<? super EntityPepe> createRenderFor(RenderManager manager) {
	      return new RenderPepe(manager);
	    }
	  }
	  
}