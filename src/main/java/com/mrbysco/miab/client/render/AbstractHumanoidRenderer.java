package com.mrbysco.miab.client.render;

import com.mrbysco.miab.client.models.HumanBaseModel;
import com.mrbysco.miab.entity.AbstractMeme;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;

public abstract class AbstractHumanoidRenderer<T extends AbstractMeme, M extends HumanBaseModel<T>> extends HumanoidMobRenderer<T, M> {

	protected AbstractHumanoidRenderer(EntityRendererProvider.Context context, M model, M modelInner, M modelOuter) {
		super(context, model, 0.5F);
		this.addLayer(new HumanoidArmorLayer<>(this, modelInner, modelOuter));
	}
}