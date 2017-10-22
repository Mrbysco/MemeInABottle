package com.Mrbysco.miab.rendering.monsters;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.hostile.EntityMoonman;
import com.Mrbysco.miab.models.ModelMoonman;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMoonman extends RenderLiving<EntityMoonman> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/moonman.png");

	  public RenderMoonman(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelMoonman(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityMoonman entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityMoonman entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityMoonman> {

	    @Override
	    public Render<? super EntityMoonman> createRenderFor(RenderManager manager) {
	      return new RenderMoonman(manager);
	    }
	  }
	  
}