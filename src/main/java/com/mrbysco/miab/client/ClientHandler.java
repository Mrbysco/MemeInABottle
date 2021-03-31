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

		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.JOHN_CENA.get(), renderManager -> new CenaRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DONALD_TRUMP.get(), renderManager -> new TrumpRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DOGE.get(), renderManager -> new DogeRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.GRUMPY_CAT.get(), renderManager -> new GrumpyRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.ATTACHED_GIRLFRIEND.get(), renderManager -> new AttachedGirlfriendRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.EDUARD_KHIL.get(), renderManager -> new TrololoRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.PPAP.get(), renderManager -> new PPAPRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.ROBBIE_ROTTEN.get(), renderManager -> new RobbieRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.GRAND_DAD.get(), renderManager -> new GrandDadRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.HE_MAN.get(), renderManager -> new HeManRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.SKYWALKER.get(), renderManager -> new SkywalkerRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.ROADMAN_SHAQ.get(), renderManager -> new RoadmanShaqRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DANKEY_KANG.get(), renderManager -> new DankeyRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.PHIL_SWIFT.get(), renderManager -> new PhilSwiftRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.SHREK.get(), renderManager -> new ShrekRenderer(renderManager));

		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DAT_BOI.get(), renderManager -> new DatBoiRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.SANIC.get(), renderManager -> new SanicRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.PEPE.get(), renderManager -> new PepeRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.FOREVER_ALONE.get(), renderManager -> new FARenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.NYAN_CAT.get(), renderManager -> new NyanCatRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.TAC_NAYN.get(), renderManager -> new TacNyanRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.NIGEL_THORNBERRY.get(), renderManager -> new NigelRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.DANCING_HOTDOG.get(), renderManager -> new HotDogRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.BONGO_CAT.get(), renderManager -> new BongoCatRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.ROFL_COPTER.get(), renderManager -> new RoflCopterRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.GNOME.get(), renderManager -> new GnomeRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.CLIPPY.get(), renderManager -> new ClippyRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.SANS.get(), renderManager -> new SansRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.PINGU.get(), renderManager -> new PinguRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.TOM.get(), renderManager -> new ChocolateGuyRenderer(renderManager));

		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.KNUCKLES.get(), renderManager -> new KnucklesRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.KNUCKLES_SPIT.get(), renderManager -> new KnucklesSpitRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(MemeEntities.KNUCKLES_QUEEN.get(), renderManager -> new KnucklesQueenRenderer(renderManager));

		ItemModelsProperties.registerProperty(MemeRegister.FIDGET_SPINNER.get(), new ResourceLocation("spinning"), (stack, world, livingEntity) ->
				livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack ? 1.0F : 0.0F);
    }

	public static void registerItemColors(final ColorHandlerEvent.Item event) {
		ItemColors colors = event.getItemColors();

		for(MemeSpawnEggItem item : MemeSpawnEggItem.getMemeEggs()) {
			colors.register((p_198141_1_, p_198141_2_) -> {
				return item.getColor(p_198141_2_);
			}, item);
		}
	}
}