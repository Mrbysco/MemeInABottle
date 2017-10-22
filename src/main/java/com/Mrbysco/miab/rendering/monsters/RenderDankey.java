package com.Mrbysco.miab.rendering.monsters;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.hostile.EntityDankey;
import com.Mrbysco.miab.models.ModelDankey;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDankey extends RenderLiving<EntityDankey> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/dankeykang.png");

	  public RenderDankey(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelDankey(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityDankey entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityDankey entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityDankey> {

	    @Override
	    public Render<? super EntityDankey> createRenderFor(RenderManager manager) {
	      return new RenderDankey(manager);
	    }
	  }
	  
}