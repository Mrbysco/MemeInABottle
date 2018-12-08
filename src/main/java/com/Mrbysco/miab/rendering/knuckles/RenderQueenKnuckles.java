package com.Mrbysco.miab.rendering.knuckles;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.passive.EntityKnucklesQueen;
import com.Mrbysco.miab.models.ModelKnucklesQueen;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderQueenKnuckles extends RenderLiving<EntityKnucklesQueen> {
	
	public static final Factory FACTORY = new Factory();
	
	private static final ResourceLocation QUEEN = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/queen.png");
	
	public RenderQueenKnuckles(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelKnucklesQueen(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityKnucklesQueen entity) {
		return QUEEN;
	}

	public static class Factory implements IRenderFactory<EntityKnucklesQueen> {

		@Override
		public Render<? super EntityKnucklesQueen> createRenderFor(RenderManager manager) {
			return new RenderQueenKnuckles(manager);
	    }
	}
	  
}