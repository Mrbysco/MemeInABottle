package com.Mrbysco.MIAB.renderer.monsters;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKhil extends RenderZombie 
{
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation("miab:entity/Khil.png");

	  public RenderKhil(RenderManager p_i46143_1_) {
	    super(p_i46143_1_);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityZombie entity) {
	    return texture;
	  }

	  public static class Factory implements IRenderFactory<EntityZombie> {

	    @Override
	    public Render<? super EntityZombie> createRenderFor(RenderManager manager) {
	      return new RenderKhil(manager);
	    }
	  }
}

	  