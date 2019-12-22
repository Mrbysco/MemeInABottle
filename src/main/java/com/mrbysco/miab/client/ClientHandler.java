package com.mrbysco.miab.client;

import com.mrbysco.miab.client.render.RenderAttachedGirlfriend;
import com.mrbysco.miab.client.render.RenderBongoCat;
import com.mrbysco.miab.client.render.RenderCena;
import com.mrbysco.miab.client.render.RenderChocolateGuy;
import com.mrbysco.miab.client.render.RenderClippy;
import com.mrbysco.miab.client.render.RenderDankey;
import com.mrbysco.miab.client.render.RenderDatBoi;
import com.mrbysco.miab.client.render.RenderDoge;
import com.mrbysco.miab.client.render.RenderFA;
import com.mrbysco.miab.client.render.RenderGnome;
import com.mrbysco.miab.client.render.RenderGrandDad;
import com.mrbysco.miab.client.render.RenderGrumpy;
import com.mrbysco.miab.client.render.RenderHeMan;
import com.mrbysco.miab.client.render.RenderHotDog;
import com.mrbysco.miab.client.render.RenderKnuckles;
import com.mrbysco.miab.client.render.RenderKnucklesQueen;
import com.mrbysco.miab.client.render.RenderKnucklesSpit;
import com.mrbysco.miab.client.render.RenderNigel;
import com.mrbysco.miab.client.render.RenderNyanCat;
import com.mrbysco.miab.client.render.RenderPPAP;
import com.mrbysco.miab.client.render.RenderPepe;
import com.mrbysco.miab.client.render.RenderPhilSwift;
import com.mrbysco.miab.client.render.RenderPingu;
import com.mrbysco.miab.client.render.RenderRoadmanShaq;
import com.mrbysco.miab.client.render.RenderRobbie;
import com.mrbysco.miab.client.render.RenderRoflCopter;
import com.mrbysco.miab.client.render.RenderSanic;
import com.mrbysco.miab.client.render.RenderSans;
import com.mrbysco.miab.client.render.RenderShrek;
import com.mrbysco.miab.client.render.RenderSkywalker;
import com.mrbysco.miab.client.render.RenderTacNayn;
import com.mrbysco.miab.client.render.RenderTrololo;
import com.mrbysco.miab.client.render.RenderTrump;
import com.mrbysco.miab.entity.memes.EntityAttachedGirlfriend;
import com.mrbysco.miab.entity.memes.EntityBongoCat;
import com.mrbysco.miab.entity.memes.EntityCena;
import com.mrbysco.miab.entity.memes.EntityChocolateGuy;
import com.mrbysco.miab.entity.memes.EntityClippy;
import com.mrbysco.miab.entity.memes.EntityDankey;
import com.mrbysco.miab.entity.memes.EntityDatBoi;
import com.mrbysco.miab.entity.memes.EntityDoge;
import com.mrbysco.miab.entity.memes.EntityFA;
import com.mrbysco.miab.entity.memes.EntityGnome;
import com.mrbysco.miab.entity.memes.EntityGrumpy;
import com.mrbysco.miab.entity.memes.EntityHeMan;
import com.mrbysco.miab.entity.memes.EntityHotDog;
import com.mrbysco.miab.entity.memes.EntityKnuckles;
import com.mrbysco.miab.entity.memes.EntityKnucklesQueen;
import com.mrbysco.miab.entity.memes.EntityMario7;
import com.mrbysco.miab.entity.memes.EntityNigel;
import com.mrbysco.miab.entity.memes.EntityNyanCat;
import com.mrbysco.miab.entity.memes.EntityPPAP;
import com.mrbysco.miab.entity.memes.EntityPepe;
import com.mrbysco.miab.entity.memes.EntityPhilSwift;
import com.mrbysco.miab.entity.memes.EntityPingu;
import com.mrbysco.miab.entity.memes.EntityRoadmanShaq;
import com.mrbysco.miab.entity.memes.EntityRobbie;
import com.mrbysco.miab.entity.memes.EntityRoflCopter;
import com.mrbysco.miab.entity.memes.EntitySanic;
import com.mrbysco.miab.entity.memes.EntitySans;
import com.mrbysco.miab.entity.memes.EntityShrek;
import com.mrbysco.miab.entity.memes.EntitySkywalker;
import com.mrbysco.miab.entity.memes.EntityTacNayn;
import com.mrbysco.miab.entity.memes.EntityTrololo;
import com.mrbysco.miab.entity.memes.EntityTrump;
import com.mrbysco.miab.entity.projectile.EntityKnucklesSpit;
import com.mrbysco.miab.entity.projectile.EntitySplashMeme;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientHandler {

	@SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntitySplashMeme.class, renderManager -> new SpriteRenderer<>(renderManager, Minecraft.getInstance().getItemRenderer()));

		RenderingRegistry.registerEntityRenderingHandler(EntityCena.class, renderManager -> new RenderCena(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrump.class, renderManager -> new RenderTrump(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityDoge.class, renderManager -> new RenderDoge(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrumpy.class, renderManager -> new RenderGrumpy(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityAttachedGirlfriend.class, renderManager -> new RenderAttachedGirlfriend(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrololo.class, renderManager -> new RenderTrololo(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityPPAP.class, renderManager -> new RenderPPAP(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityRobbie.class, renderManager -> new RenderRobbie(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityMario7.class, renderManager -> new RenderGrandDad(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityHeMan.class, renderManager -> new RenderHeMan(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkywalker.class, renderManager -> new RenderSkywalker(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityRoadmanShaq.class, renderManager -> new RenderRoadmanShaq(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityDankey.class, renderManager -> new RenderDankey(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityPhilSwift.class, renderManager -> new RenderPhilSwift(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityShrek.class, renderManager -> new RenderShrek(renderManager));

		RenderingRegistry.registerEntityRenderingHandler(EntityDatBoi.class, renderManager -> new RenderDatBoi(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntitySanic.class, renderManager -> new RenderSanic(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityPepe.class, renderManager -> new RenderPepe(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityFA.class, renderManager -> new RenderFA(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityNyanCat.class, renderManager -> new RenderNyanCat(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityTacNayn.class, renderManager -> new RenderTacNayn(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityNigel.class, renderManager -> new RenderNigel(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityHotDog.class, renderManager -> new RenderHotDog(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBongoCat.class, renderManager -> new RenderBongoCat(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityRoflCopter.class, renderManager -> new RenderRoflCopter(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityGnome.class, renderManager -> new RenderGnome(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityClippy.class, renderManager -> new RenderClippy(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntitySans.class, renderManager -> new RenderSans(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityPingu.class, renderManager -> new RenderPingu(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityChocolateGuy.class, renderManager -> new RenderChocolateGuy(renderManager));

		RenderingRegistry.registerEntityRenderingHandler(EntityKnuckles.class, renderManager -> new RenderKnuckles(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityKnucklesSpit.class, renderManager -> new RenderKnucklesSpit(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityKnucklesQueen.class, renderManager -> new RenderKnucklesQueen(renderManager));
    }
}