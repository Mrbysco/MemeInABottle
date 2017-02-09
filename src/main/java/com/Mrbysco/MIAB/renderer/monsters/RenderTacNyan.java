package com.Mrbysco.MIAB.renderer.monsters;

import com.Mrbysco.MIAB.entity.monsters.EntityTacNyan;
import com.Mrbysco.MIAB.renderer.models.ModelNyan;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTacNyan extends RenderLiving<EntityTacNyan> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation("miab:entity/tacnyan.png");

	  public RenderTacNyan(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelNyan(), 0.5F);
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityTacNyan entity) {
	    return texture;
	  }
	  
	  @Override
	public void doRender(EntityTacNyan entity, double x, double y, double z, float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	  
	  public static class Factory implements IRenderFactory<EntityTacNyan> {

		  @Override
		  public Render<? super EntityTacNyan> createRenderFor(RenderManager manager) {
		    return new RenderTacNyan(manager);
		  }
	  }
	  
}