package com.Mrbysco.miab.rendering.monsters;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.boss.EntityMemeBigBoss;
import com.Mrbysco.miab.models.ModelDatBoi;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBigBoi extends RenderLiving<EntityMemeBigBoss> {
	
	public static final Factory FACTORY = new Factory();
	  
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/datboi.png");
	private static float scale = 2.0F;
	  
	public RenderBigBoi(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelDatBoi(), 0.5F * scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMemeBigBoss entity) {
		return texture;
	}
	
	@Override
	protected void preRenderCallback(EntityMemeBigBoss entitylivingbaseIn, float partialTickTime) {
		GlStateManager.scale(this.scale, this.scale, this.scale);
	}
	
	public static class Factory implements IRenderFactory<EntityMemeBigBoss> {
		@Override
	    public Render<? super EntityMemeBigBoss> createRenderFor(RenderManager manager) {
			return new RenderBigBoi(manager);
	    }
	}

}