package com.mrbysco.miab.memes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mrbysco.miab.MemeInABottle;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.init.MemeEntities;
import com.mrbysco.miab.init.MemeItems;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.memes.actions.base.BasicEntityMeme;
import com.mrbysco.miab.memes.actions.base.BasicItemMeme;
import com.mrbysco.miab.memes.actions.base.BasicSoundMeme;
import com.mrbysco.miab.memes.actions.base.BasicTranslatedMessageMeme;
import com.mrbysco.miab.memes.actions.basis.InceptionMeme;
import com.mrbysco.miab.memes.actions.basis.NyanCatMeme;
import com.mrbysco.miab.memes.actions.basis.TannerMeme;
import com.mrbysco.miab.memes.actions.basis.WastedMeme;
import com.mrbysco.miab.memes.actions.basis.entity.AnimalMeme;
import com.mrbysco.miab.memes.actions.basis.entity.CenaMeme;
import com.mrbysco.miab.memes.actions.basis.item.DangerousToGoAloneMeme;
import com.mrbysco.miab.memes.actions.basis.item.OscarMeme;
import com.mrbysco.miab.memes.actions.iFunny;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MemeRegistry {
	public static MemeRegistry INSTANCE = new MemeRegistry();

	public static List<String> nameList = Lists.newArrayList();
	public static List<iFunny> funnyList = Lists.newArrayList();
	private Map<String, iFunny> nameToFunny = Maps.newHashMap();
	private Map<String, iFunny> disabledNameToFunny = Maps.newHashMap();
	
	public static void initializeMemes() {
		//Sounds
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_ninethousand", 100, MemeSounds.ninethousand));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_barrelroll", 100, MemeSounds.barrelroll));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_biwinning", 100, MemeSounds.biwinning));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_boomheadshot", 100, MemeSounds.boomheadshot));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_callinthenext", 100, MemeSounds.callinthenext));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_charliebitme", 100, MemeSounds.charliebitme));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_chocolate", 100, MemeSounds.chocolate));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_congratz", 100, MemeSounds.congratz));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_dedidadedwam", 100, MemeSounds.dedidadedwam));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_deeznuts", 100, MemeSounds.deeznuts));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_doit", 100, MemeSounds.doit));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_justdoit", 100, MemeSounds.dontletyourdreamsbedreams));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_gaben", 100, MemeSounds.gaben));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_getitoxyclean", 100, MemeSounds.getitoxyclean));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_getnoscoped", 100, MemeSounds.getnoscoped));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_k", 100, MemeSounds.k));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_leroyjenkins", 100, MemeSounds.leroyjenkins));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_momscar", 100, MemeSounds.momscar));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_nice", 100, MemeSounds.nice));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_nicememe", 100, MemeSounds.nicememe));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_noot", 100, MemeSounds.noot));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_nothisispatrick", 100, MemeSounds.nothisispatrick));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_nothisispatrick2", 100, MemeSounds.nothisispatrick2));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_noticeme", 100, MemeSounds.noticeme));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_ohlongjohnson", 100, MemeSounds.ohlongjohnson));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_oldspicepower", 100, MemeSounds.oldspicepower));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_oxyclean", 100, MemeSounds.oxyclean));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_sandwich", 100, MemeSounds.sandwich));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_snooppengas", 100, MemeSounds.snooppengas));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_somebodystopme", 100, MemeSounds.somebodystopme));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_sparta", 100, MemeSounds.sparta));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_spongebobsound", 100, MemeSounds.spongebobsound));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_triple", 100, MemeSounds.triple));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_victoryscreech", 100, MemeSounds.victoryscreech));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_whiten", 100, MemeSounds.whiten));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_wololo", 100, MemeSounds.wololo));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_wombocombo", 100, MemeSounds.wombocombo));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_wow", 100, MemeSounds.wow));
		INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_wrong", 100, MemeSounds.wrong));
		
		if(MemeConfig.general.MatureSounds) {
			INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_cantbelieve", 100, MemeSounds.cantbelieve));
			INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_morningscrub", 100, MemeSounds.morningscrub));
			INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_gotcha", 100, MemeSounds.gotchab));
			INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_hagay", 100, MemeSounds.hagay));
			INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_rightinthe", 100, MemeSounds.rightinthe));
			INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_smokeweed", 100, MemeSounds.smokeweed));
			INSTANCE.registerMeme(new BasicSoundMeme(Reference.MOD_PREFIX + "sound_snooppengas", 100, MemeSounds.snooppengas));
		}
		
		//Item memes
		INSTANCE.registerMeme(new BasicItemMeme(Reference.MOD_PREFIX + "leather_belt", 10, MemeSounds.leather_belt, new ItemStack(MemeItems.leather_belt)));
		INSTANCE.registerMeme(new BasicItemMeme(Reference.MOD_PREFIX + "trumpet", 10, MemeSounds.doot, new ItemStack(MemeItems.trumpet)));
		INSTANCE.registerMeme(new BasicItemMeme(Reference.MOD_PREFIX + "splash_meme", 10, MemeSounds.inception, new ItemStack(MemeItems.splash_meme_in_a_bottle)));
		INSTANCE.registerMeme(new BasicItemMeme(Reference.MOD_PREFIX + "pills_here", 10, MemeSounds.pills, new ItemStack(MemeItems.pills_here)));
		INSTANCE.registerMeme(new DangerousToGoAloneMeme());
		INSTANCE.registerMeme(new OscarMeme());

		//String memes
		INSTANCE.registerMeme(new BasicTranslatedMessageMeme(Reference.MOD_PREFIX + "bee_movie", 20, new String[] { 
				Reference.MOD_PREFIX + "memebee.part1",
				Reference.MOD_PREFIX + "memebee.part2",
				Reference.MOD_PREFIX + "memebee.part3",
				Reference.MOD_PREFIX + "memebee.part4",
				Reference.MOD_PREFIX + "memebee.part5",
				Reference.MOD_PREFIX + "memebee.part6"}));
		INSTANCE.registerMeme(new BasicTranslatedMessageMeme(Reference.MOD_PREFIX + "navy_seal", 20, new String[] { 
				Reference.MOD_PREFIX + "navy.part1",
				Reference.MOD_PREFIX + "navy.part2",
				Reference.MOD_PREFIX + "navy.part3",
				Reference.MOD_PREFIX + "navy.part4",
				Reference.MOD_PREFIX + "navy.part5",
				Reference.MOD_PREFIX + "navy.part6"}));
		INSTANCE.registerMeme(new BasicTranslatedMessageMeme(Reference.MOD_PREFIX + "brainpower", 20, new String[] { 
				Reference.MOD_PREFIX + "brainpower.message"}));
		INSTANCE.registerMeme(new TannerMeme());
		INSTANCE.registerMeme(new WastedMeme());

		//Entity memes
		INSTANCE.registerMeme(new CenaMeme());
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "trump", 5, MemeEntities.DONALD_TRUMP, MemeSounds.trump_spawn));
		INSTANCE.registerMeme(new AnimalMeme(Reference.MOD_PREFIX + "grumpy_cat", 5, MemeEntities.GRUMPY_CAT, SoundEvents.ENTITY_CAT_PURR));
		INSTANCE.registerMeme(new AnimalMeme(Reference.MOD_PREFIX + "doge", 5, MemeEntities.DOGE, SoundEvents.ENTITY_WOLF_GROWL));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "overly_attached", 5, MemeEntities.ATTACHED_GIRLFRIEND));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "trololo", 5, MemeEntities.EDUARD_KHIL));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "ppap", 5, MemeEntities.PPAP, MemeSounds.ppap_spawn));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "robbie_rotten", 5, MemeEntities.ROBBIE_ROTTEN, MemeSounds.robbie_summon));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "grand_dad", 5, MemeEntities.GRAND_DAD, MemeSounds.dad_summon));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "he-man", 5, MemeEntities.HE_MAN, MemeSounds.heman_spawn));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "skywalker", 5, MemeEntities.SKYWALKER, MemeSounds.skywalker_sand));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "roadman_shaq", 5, MemeEntities.ROADMAN_SHAQ, MemeSounds.shaq_summon));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "dankey_kang", 5, MemeEntities.DANKEY_KANG, MemeSounds.dankey_summon));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "phil_swift", 5, MemeEntities.PHIL_SWIFT, MemeSounds.phil_lottadamage));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "shrek", 5, MemeEntities.SHREK, MemeSounds.shrek_summon));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "dat_boi", 5, MemeEntities.DAT_BOI, MemeSounds.boi_summon));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "sanic", 5, MemeEntities.SANIC, MemeSounds.sanic_slow));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "pepe", 5, MemeEntities.PEPE));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "forever_alone", 5, MemeEntities.FOREVER_ALONE, MemeSounds.cry));
		INSTANCE.registerMeme(new NyanCatMeme());
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "nigel_thornberry", 5, MemeEntities.NIGEL_THORNBERRY, MemeSounds.nigel_blagh));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "dancing_hotdog", 5, MemeEntities.DANCING_HOTDOG, MemeSounds.hotdog_full));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "bongo_cat", 5, MemeEntities.BONGO_CAT, SoundEvents.BLOCK_NOTE_HAT));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "roflcopter", 5, MemeEntities.ROFL_COPTER, MemeSounds.rofl_spawn));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "gnome", 5, MemeEntities.GNOME, MemeSounds.gnome_spawn));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "clippy", 5, MemeEntities.CLIPPY, MemeSounds.clippy_passive));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "knuckles_queen", 5, MemeEntities.KNUCKLES_QUEEN, MemeSounds.knuckles_passive));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "knuckles", 5, MemeEntities.KNUCKLES, MemeSounds.knuckles_passive));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "pingu", 5, MemeEntities.PINGU, MemeSounds.noot));
		INSTANCE.registerMeme(new BasicEntityMeme(Reference.MOD_PREFIX + "sans", 5, MemeEntities.SANS, MemeSounds.sans_sound));

		//Other memes
		INSTANCE.registerMeme(new InceptionMeme());
	}
	
	public void registerMeme(iFunny reward)
	{
		List<String> disabledMemes = Arrays.asList(MemeConfig.memes.disabled_memes);
		if(this.nameList.contains(reward.getName())) {
			MemeInABottle.logger.error("An attempt was made to register a meme with an ID that already exists. ID: " + reward.getName());
		} else {
			this.nameList.add(reward.getName());
		}
		if(!disabledMemes.contains(reward.getName()))
		{
			nameToFunny.put(reward.getName(), reward);
			sortList(reward);
		}
		else
		{
			this.disabledNameToFunny.put(reward.getName(), reward);
		}
	}

	public boolean isIDUnique(String ID) {
		return !this.nameList.contains(ID);
	}
	
	private void sortList(@Nullable iFunny newReward)
	{
		if(newReward != null)
			funnyList.add(newReward);

		funnyList.sort(Comparator.comparingInt(iFunny::getMemeRarity));
	}
	
	public void triggerRandomMeme(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if(this.funnyList.isEmpty())
		{
			MemeInABottle.logger.log(Level.WARN, "There are no registered memes so no meme has been triggered");
			return;
		}

		if(playerIn != null)
		{
			// Compute the total weight of all memes together
			double totalWeight = 0.0d;
			for (iFunny i : funnyList)
			{
			    totalWeight += i.getMemeRarity();
			}
			// Now choose a random meme
			int randomIndex = -1;
			double random = Math.random() * totalWeight;
			for (int i = 0; i < funnyList.size(); ++i)
			{
			    random -= funnyList.get(i).getMemeRarity();
			    if (random <= 0.0d)
			    {
			        randomIndex = i;
			        break;
			    }
			}
			iFunny randomMeme = funnyList.get(randomIndex);
			MemeInABottle.logger.log(Level.INFO, "Triggered the meme with the name: " + randomMeme.getName());
			randomMeme.trigger(worldIn, pos, playerIn);
		}
	}
	
	//TODO: Check if disabling works live
	public void checkDisabled() {
		List<String> disabledMemes = Arrays.asList(MemeConfig.memes.disabled_memes);
		for(iFunny meme : funnyList) {
			String name = meme.getName();
			if(disabledMemes.contains(name)) {
				if(disabledNameToFunny.containsKey(name)) 
					return;
				else {
					nameToFunny.remove(name);
					disabledNameToFunny.put(name, meme);
					funnyList.remove(meme);
				}
			} else {
				if(disabledNameToFunny.containsKey(name)) {
					disabledNameToFunny.remove(name);
					nameToFunny.put(name, meme);
					funnyList.add(meme);
				}
			}
		}
	}

	public void disableMeme(String[] memes) {
		for(String meme : memes) {
			if(disabledNameToFunny.containsKey(meme))
				return;
			else {
				iFunny funny = nameToFunny.get(meme);
				nameToFunny.remove(meme);
				disabledNameToFunny.put(meme, funny);
				funnyList.remove(funny);
			}
		}
	}


	public void enableMeme(String[] memes) {
		for(String meme : memes) {
			if(nameToFunny.containsKey(meme))
				return;
			else {
				iFunny funny = disabledNameToFunny.get(meme);
				disabledNameToFunny.remove(meme);
				nameToFunny.put(meme, funny);
				funnyList.remove(funny);
			}
		}
	}
}
