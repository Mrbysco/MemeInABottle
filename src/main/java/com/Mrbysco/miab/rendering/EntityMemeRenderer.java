package com.Mrbysco.miab.rendering;

import com.Mrbysco.miab.entities.projectiles.EntitySplashMeme;
import com.Mrbysco.miab.init.MemeItems;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;

public class EntityMemeRenderer extends RenderSnowball<EntitySplashMeme>
{
	public EntityMemeRenderer(RenderManager renderManagerIn, RenderItem renderItem) {
		super(renderManagerIn, MemeItems.splash_meme_in_a_bottle, renderItem);
	}

	@Override
	public ItemStack getStackToRender(EntitySplashMeme entityIn)
    {
        return entityIn.getItemName();
    }
}
