package com.Mrbysco.miab.rendering.monsters;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.hostile.EntityDatBoi;
import com.Mrbysco.miab.models.ModelDatBoi;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDatBoi extends RenderLiving<EntityDatBoi> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/datboi.png");

	  public RenderDatBoi(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelDatBoi(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityDatBoi entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityDatBoi entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityDatBoi> {

	    @Override
	    public Render<? super EntityDatBoi> createRenderFor(RenderManager manager) {
	      return new RenderDatBoi(manager);
	    }
	  }
	  
}