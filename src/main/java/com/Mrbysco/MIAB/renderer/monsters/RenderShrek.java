package com.Mrbysco.MIAB.renderer.monsters;

import com.Mrbysco.MIAB.entity.monsters.EntityShrek;
import com.Mrbysco.MIAB.entity.monsters.models.ModelShrek;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderShrek extends RenderLiving<EntityShrek> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation("miab:entity/Shrek.png");

	  public RenderShrek(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelShrek(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityShrek entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityShrek entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityShrek> {

	    @Override
	    public Render<? super EntityShrek> createRenderFor(RenderManager manager) {
	      return new RenderShrek(manager);
	    }
	  }
	  
	}