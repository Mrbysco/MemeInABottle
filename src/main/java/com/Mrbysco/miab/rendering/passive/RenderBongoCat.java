package com.Mrbysco.miab.rendering.passive;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.passive.EntityBongoCat;
import com.Mrbysco.miab.models.ModelBongoCat;
import com.Mrbysco.miab.rendering.layers.NoteBlockLayer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBongoCat extends RenderLiving<EntityBongoCat>
{
	public static final Factory FACTORY = new Factory();
	
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/bongocat.png");
	
	public RenderBongoCat(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelBongoCat(), 0.3F);
		this.addLayer(new NoteBlockLayer(this));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityBongoCat entity) {
	  return texture;
	}
	
	public static class Factory implements IRenderFactory<EntityBongoCat> {
	
	  @Override
	  public Render<? super EntityBongoCat> createRenderFor(RenderManager manager) {
	    return new RenderBongoCat(manager);
	  }
	}
	
}