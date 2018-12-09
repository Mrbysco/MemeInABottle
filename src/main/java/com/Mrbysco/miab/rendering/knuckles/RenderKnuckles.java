package com.Mrbysco.miab.rendering.knuckles;

import com.Mrbysco.miab.Reference;
import com.Mrbysco.miab.entities.passive.EntityKnuckles;
import com.Mrbysco.miab.models.ModelKnuckles;
import com.Mrbysco.miab.models.ModelKnucklesAku;
import com.Mrbysco.miab.models.ModelKnucklesSaiyan;
import com.Mrbysco.miab.models.ModelKnucklesTank;
import com.Mrbysco.miab.models.ModelKnucklesYugi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKnuckles extends RenderLiving<EntityKnuckles> {
	
	public static final Factory FACTORY = new Factory();
	
	private static final ResourceLocation REGULAR = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/knuckles.png");
	private static final ResourceLocation TANK = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/tankknuckles.png");
	private static final ResourceLocation BLUE = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/blueknuckles.png");
	private static final ResourceLocation AKU = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/akuknuckles.png");
	private static final ResourceLocation YUGI = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/yugiknuckles.png");
	private static final ResourceLocation SAIYAN1 = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/saiyanknuckles.png");
	private static final ResourceLocation SAIYAN2 = new ResourceLocation(Reference.MOD_PREFIX + "textures/entity/saiyanknuckles2.png");
	
	private static final ModelBase knuckles = new ModelKnuckles();
	private static final ModelBase tankKnuckles = new ModelKnucklesTank();
	private static final ModelBase akuKnuckles = new ModelKnucklesAku();
	private static final ModelBase yugiKnuckles = new ModelKnucklesYugi();
	private static final ModelBase saiyanKnuckles = new ModelKnucklesSaiyan();
	
	public RenderKnuckles(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelKnuckles(), 0.4F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityKnuckles entity) {
        switch (entity.getType())
        {
            case 0:
                return REGULAR;
            case 1:
                return TANK;
            case 2:
            	return BLUE;
            case 3:
            	return AKU;
            case 4:
            	return YUGI;
            case 5:
            	return SAIYAN1;
            case 6:
            	return SAIYAN2;
            case 7:
            default:
                return REGULAR;
        }
	}

	@Override
	protected void preRenderCallback(EntityKnuckles entity, float partialTickTime) {
		switch (entity.getType())
        {
            case 0:
            	if(this.mainModel != this.knuckles)
				{
            		this.mainModel = this.knuckles;
				}
        		if(this.shadowSize != 0.4F)
        		{
        			this.shadowSize = 0.4F;
        		}
        		GlStateManager.scale(0.65F, 0.65F, 0.65F);

        		break;
            case 1:
            	if(this.mainModel != this.tankKnuckles)
				{
            		this.mainModel = this.tankKnuckles;
				}
        		if(this.shadowSize != 0.8F)
        		{
        			this.shadowSize = 0.8F;
        		}
            	GlStateManager.scale(0.9F, 0.9F, 0.9F);
        		break;
            case 2:
            	if(this.mainModel != this.knuckles)
				{
            		this.mainModel = this.knuckles;
				}
        		if(this.shadowSize != 0.4F)
        		{
        			this.shadowSize = 0.4F;
        		}
        		GlStateManager.scale(0.65F, 0.65F, 0.65F);

        		break;
            case 3:
            	if(this.mainModel != this.akuKnuckles)
				{
            		this.mainModel = this.akuKnuckles;
				}
        		if(this.shadowSize != 0.4F)
        		{
        			this.shadowSize = 0.4F;
        		}
        		GlStateManager.scale(0.65F, 0.65F, 0.65F);

        		break;
            case 4:
	            if(this.mainModel != this.yugiKnuckles)
				{
	        		this.mainModel = this.yugiKnuckles;
				}
	    		if(this.shadowSize != 0.4F)
	    		{
	    			this.shadowSize = 0.4F;
	    		}
	    		GlStateManager.scale(0.65F, 0.65F, 0.65F);
	
	    		break;
            case 5:
            	if(this.mainModel != this.saiyanKnuckles)
				{
	        		this.mainModel = this.saiyanKnuckles;
				}
	    		if(this.shadowSize != 0.4F)
	    		{
	    			this.shadowSize = 0.4F;
	    		}
	    		GlStateManager.scale(0.65F, 0.65F, 0.65F);
	
	    		break;
            case 6:
            	if(this.mainModel != this.saiyanKnuckles)
				{
	        		this.mainModel = this.saiyanKnuckles;
				}
	    		if(this.shadowSize != 0.4F)
	    		{
	    			this.shadowSize = 0.4F;
	    		}
	    		GlStateManager.scale(0.65F, 0.65F, 0.65F);
	
	    		break;
            case 7:
            default:
            	if(this.mainModel != this.knuckles)
				{
            		this.mainModel = this.knuckles;
				}
        		if(this.shadowSize != 0.4F)
        		{
        			this.shadowSize = 0.4F;
        		}
        		GlStateManager.scale(0.65F, 0.65F, 0.65F);
        		break;
        }

		super.preRenderCallback(entity, partialTickTime);
	}
	
	@Override
	public ModelBase getMainModel() {
		return (ModelBase)super.getMainModel();
	}

	public static class Factory implements IRenderFactory<EntityKnuckles> {

		@Override
		public Render<? super EntityKnuckles> createRenderFor(RenderManager manager) {
			return new RenderKnuckles(manager);
	    }
	}
	  
}