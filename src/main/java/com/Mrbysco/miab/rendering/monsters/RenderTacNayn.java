package com.Mrbysco.miab.rendering.monsters;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.hostile.EntityTacNayn;
import com.Mrbysco.miab.models.ModelNyan;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTacNayn extends RenderLiving<EntityTacNayn> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/tacnyan.png");

	  public RenderTacNayn(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelNyan(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityTacNayn entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityTacNayn entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityTacNayn> {

		  @Override
		  public Render<? super EntityTacNayn> createRenderFor(RenderManager manager) {
		    return new RenderTacNayn(manager);
		  }
	  }
	  
}