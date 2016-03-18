package com.Mrbysco.MIAB.renderer;

import com.Mrbysco.MIAB.entity.EntityMeme;
import com.Mrbysco.MIAB.init.MIABItems;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class EntityMemeRenderer extends RenderSnowball<EntityMeme>{

	public EntityMemeRenderer(RenderManager renderManagerIn, RenderItem renderItem) {
		super(renderManagerIn, MIABItems.splash_meme_in_a_bottle, renderItem);
	}

}
