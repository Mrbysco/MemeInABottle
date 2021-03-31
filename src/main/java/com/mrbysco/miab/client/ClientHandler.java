package com.mrbysco.miab.client;

import com.mrbysco.miab.client.render.AttachedGirlfriendRenderer;
import com.mrbysco.miab.client.render.BongoCatRenderer;
import com.mrbysco.miab.client.render.CenaRenderer;
import com.mrbysco.miab.client.render.ChocolateGuyRenderer;
import com.mrbysco.miab.client.render.ClippyRenderer;
import com.mrbysco.miab.client.render.DankeyRenderer;
import com.mrbysco.miab.client.render.DatBoiRenderer;
import com.mrbysco.miab.client.render.DogeRenderer;
import com.mrbysco.miab.client.render.FARenderer;
import com.mrbysco.miab.client.render.GnomeRenderer;
import com.mrbysco.miab.client.render.GrandDadRenderer;
import com.mrbysco.miab.client.render.GrumpyRenderer;
import com.mrbysco.miab.client.render.HeManRenderer;
import com.mrbysco.miab.client.render.HotDogRenderer;
import com.mrbysco.miab.client.render.KnucklesQueenRenderer;
import com.mrbysco.miab.client.render.KnucklesRenderer;
import com.mrbysco.miab.client.render.KnucklesSpitRenderer;
import com.mrbysco.miab.client.render.NigelRenderer;
import com.mrbysco.miab.client.render.NyanCatRenderer;
import com.mrbysco.miab.client.render.PPAPRenderer;
import com.mrbysco.miab.client.render.PepeRenderer;
import com.mrbysco.miab.client.render.PhilSwiftRenderer;
import com.mrbysco.miab.client.render.PinguRenderer;
import com.mrbysco.miab.client.render.RoadmanShaqRenderer;
import com.mrbysco.miab.client.render.RobbieRenderer;
import com.mrbysco.miab.client.render.RoflCopterRenderer;
import com.mrbysco.miab.client.render.SanicRenderer;
import com.mrbysco.miab.client.render.SansRenderer;
import com.mrbysco.miab.client.render.ShrekRenderer;
import com.mrbysco.miab.client.render.SkywalkerRenderer;
import com.mrbysco.miab.client.render.TacNyanRenderer;
import com.mrbysco.miab.client.render.TrololoRenderer;
import com.mrbysco.miab.client.render.TrumpRenderer;
import com.mrbysco.miab.init.MemeEntities;
import com.mrbysco.miab.init.MemeRegister;
import com.mrbysco.miab.items.MemeSpawnEggItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler {

	public static void onClientSetup(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.SPLASH_MEME.get(), renderManager -> new SpriteRenderer<>(renderManager, Minecraft.getInstance().getItemRenderer()));

		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.JOHN_CENA.get(), CenaRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DONALD_TRUMP.get(), TrumpRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DOGE.get(), DogeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.GRUMPY_CAT.get(), GrumpyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.ATTACHED_GIRLFRIEND.get(), AttachedGirlfriendRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.EDUARD_KHIL.get(), TrololoRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.PPAP.get(), PPAPRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.ROBBIE_ROTTEN.get(), RobbieRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.GRAND_DAD.get(), GrandDadRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.HE_MAN.get(), HeManRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.SKYWALKER.get(), SkywalkerRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.ROADMAN_SHAQ.get(), RoadmanShaqRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DANKEY_KANG.get(), DankeyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.PHIL_SWIFT.get(), PhilSwiftRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.SHREK.get(), ShrekRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DAT_BOI.get(), DatBoiRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.SANIC.get(), SanicRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.PEPE.get(), PepeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.FOREVER_ALONE.get(), FARenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.NYAN_CAT.get(), NyanCatRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.TAC_NAYN.get(), TacNyanRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.NIGEL_THORNBERRY.get(), NigelRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DANCING_HOTDOG.get(), HotDogRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.BONGO_CAT.get(), BongoCatRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.ROFL_COPTER.get(), RoflCopterRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.GNOME.get(), GnomeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.CLIPPY.get(), ClippyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.SANS.get(), SansRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.PINGU.get(), PinguRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.TOM.get(), ChocolateGuyRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.KNUCKLES.get(), KnucklesRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.KNUCKLES_SPIT.get(), KnucklesSpitRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.KNUCKLES_QUEEN.get(), KnucklesQueenRenderer::new);

		ItemModelsProperties.registerProperty(MemeRegister.FIDGET_SPINNER.get(), new ResourceLocation("spinning"), (stack, world, livingEntity) ->
				livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack ? 1.0F : 0.0F);
    }

	public static void registerItemColors(final ColorHandlerEvent.Item event) {
		ItemColors colors = event.getItemColors();

		for(MemeSpawnEggItem item : MemeSpawnEggItem.getMemeEggs()) {
			colors.register((stack, tintIndex) -> item.getColor(tintIndex), item);
		}
	}
}