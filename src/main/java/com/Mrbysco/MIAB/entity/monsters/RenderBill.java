package com.Mrbysco.MIAB.entity.monsters;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBill extends RenderBiped<EntityBill> {
	
	  public static final Factory FACTORY = new Factory();
	  
	  private static final ResourceLocation texture = new ResourceLocation("miab:entity/BillCipher.png");

	  public RenderBill(RenderManager p_i46143_1_) {
		super(renderManagerIn, new modelBill(), 0.5F, 1.0F); :P
	  }

	  @Override
	  protected ResourceLocation getEntityTexture(EntityZombie entity) {
	    return texture;
	  }

	  public static class Factory implements IRenderFactory<EntityZombie> {

	    @Override
	    public Render<? super EntityZombie> createRenderFor(RenderManager manager) {
	      return new RenderCena(manager);
	    }
	  }
	  
	}