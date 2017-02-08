package com.Mrbysco.MIAB.renderer.monsters;

import com.Mrbysco.MIAB.entity.monsters.entityBase.EntityMemeBase;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMario7 extends RenderMemeBase 
{
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation("miab:entity/granddad.png");

	  public RenderMario7(RenderManager p_i46143_1_) {
	    super(p_i46143_1_);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityMemeBase entity) {
	    return texture;
	  }

	  public static class Factory implements IRenderFactory<EntityMemeBase> {

	    @Override
	    public Render<? super EntityMemeBase> createRenderFor(RenderManager manager) {
	      return new RenderMario7(manager);
	    }
	  }
}

	  