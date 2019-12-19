package com.mrbysco.miab.client.render;

import com.mrbysco.miab.entity.projectile.EntitySplashMeme;
import com.mrbysco.miab.init.MemeItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;

public class RenderSplashMeme extends RenderSnowball<EntitySplashMeme>
{    
    public RenderSplashMeme(RenderManager renderManagerIn)
    {
        super(renderManagerIn, MemeItems.splash_meme_in_a_bottle, Minecraft.getMinecraft().getRenderItem());
    }
    
    public ItemStack getStackToRender(EntitySplashMeme entityIn)
    {
        return entityIn.getItem();
    }
}