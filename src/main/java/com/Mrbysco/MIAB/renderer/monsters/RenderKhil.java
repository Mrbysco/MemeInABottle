package com.Mrbysco.MIAB.renderer.monsters;

import com.Mrbysco.MIAB.entity.monsters.EntityMemeBase;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKhil extends RenderMemeBase 
{
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation("miab:entity/khil.png");

	  public RenderKhil(RenderManager p_i46143_1_) {
	    super(p_i46143_1_);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityMemeBase entity) {
	    return texture;
	  }

	  public static class Factory implements IRenderFactory<EntityMemeBase> {

	    @Override
	    public Render<? super EntityMemeBase> createRenderFor(RenderManager manager) {
	      return new RenderKhil(manager);
	    }
	  }
}

	  