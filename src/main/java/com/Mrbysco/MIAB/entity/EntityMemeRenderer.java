package com.Mrbysco.MIAB.entity;

import com.Mrbysco.MIAB.init.MIABItems;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class EntityMemeRenderer extends RenderSnowball<EntityMeme>{

	public EntityMemeRenderer(RenderManager renderManagerIn, RenderItem renderItem) {
		super(renderManagerIn, MIABItems.splash_meme_in_a_bottle, renderItem);
	}

}
