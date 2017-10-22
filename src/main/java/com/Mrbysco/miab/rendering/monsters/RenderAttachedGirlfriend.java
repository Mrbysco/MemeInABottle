package com.Mrbysco.miab.rendering.monsters;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.base.EntityMemeBase;
import com.Mrbysco.miab.rendering.baserender.RenderMemeBase;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAttachedGirlfriend extends RenderMemeBase 
{
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/attachedgirlfriend.png");

	  public RenderAttachedGirlfriend(RenderManager p_i46143_1_) {
	    super(p_i46143_1_);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityMemeBase entity) {
	    return texture;
	  }

	  public static class Factory implements IRenderFactory<EntityMemeBase> {

	    @Override
	    public Render<? super EntityMemeBase> createRenderFor(RenderManager manager) {
	      return new RenderAttachedGirlfriend(manager);
	    }
	  }
}