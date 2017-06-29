package com.Mrbysco.MIAB.potion;

import java.util.Random;

import com.Mrbysco.MIAB.MemeText;
import com.Mrbysco.MIAB.config.MIABConfigGen;
import com.Mrbysco.MIAB.init.MiabSoundEvents;
import com.mojang.text2speech.Narrator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrollPotion extends Potion{

	private Random rand = new Random();
	public static final ResourceLocation POTION_ICON = new ResourceLocation("miab:textures/potion/memedfx.png");
	public static final TrollPotion INSTANCE = new TrollPotion();
	
	public static PotionEffect effect = new PotionEffect(TrollPotion.INSTANCE, 60 * 20);
	public static PotionType type = new PotionType(effect);
	
	public TrollPotion() {
		super(true, 13882323);
		setPotionName("effect.miab.memed");
		this.setIconIndex(0, 0);
	}
	
	@Override
	public void performEffect(EntityLivingBase entityLiving, int amplifier)
	{
		if (entityLiving instanceof EntityPlayer)
        {
			int posX = (int)(entityLiving.posX+0.5);
			int posY = (int)(entityLiving.posY+0.5);
			int posZ = (int)(entityLiving.posZ+0.5);
			EntityPlayer player = (EntityPlayer)entityLiving;
            this.doMemeStuff(posX, posY, posZ, entityLiving.world, player, player, rand.nextInt(MIABConfigGen.MemeRandomness), false);
        }
	}
	public static void doMemeStuff(double posX, double posY, double posZ, World world, EntityPlayer player, Entity entity, int RandomValue, boolean canSummon)
    {	
		if (RandomValue <23) 
		{
			if(MIABConfigGen.UseNarator)
			{
				Narrator.getNarrator().say(MemeText.memebee_part);
			}
			else
			{
				player.sendMessage(new TextComponentTranslation("memebee.part1"));	
		 		player.sendMessage(new TextComponentTranslation("memebee.part2"));	
		 		player.sendMessage(new TextComponentTranslation("memebee.part3"));	
		 		player.sendMessage(new TextComponentTranslation("memebee.part4"));	
		 		player.sendMessage(new TextComponentTranslation("memebee.part5"));	
		 		player.sendMessage(new TextComponentTranslation("memebee.part6"));
			}
			
		}
	 	
		else if (RandomValue <7) 
		{
			if(MIABConfigGen.UseNarator)
			{
				Narrator.getNarrator().say(MemeText.navy_part);
			}
			else
			{
				player.sendMessage(new TextComponentTranslation("navy.part1"));	
	    		player.sendMessage(new TextComponentTranslation("navy.part2"));	
	    		player.sendMessage(new TextComponentTranslation("navy.part3"));	
	    		player.sendMessage(new TextComponentTranslation("navy.part4"));	
	    		player.sendMessage(new TextComponentTranslation("navy.part5"));	
	    		player.sendMessage(new TextComponentTranslation("navy.part6"));
			}
		}
		else if (RandomValue <15) 
		{
			if(MIABConfigGen.UseNarator)
			{
				Narrator.getNarrator().say(MemeText.lm_part);
			}
			else
			{
				player.sendMessage(new TextComponentTranslation("lm.part1"));	
				player.sendMessage(new TextComponentTranslation("lm.part2"));	
				player.sendMessage(new TextComponentTranslation("lm.part3"));	
				player.sendMessage(new TextComponentTranslation("lm.part4"));	
				player.sendMessage(new TextComponentTranslation("lm.part5"));	
			}
			
		}
		else if(MIABConfigGen.MatureSounds)
		{
			entity.playSound(MiabSoundEvents.meme_soundMature, 1F, 1F);
		}
		else
		{
			entity.playSound(MiabSoundEvents.meme_sound, 1F, 1F); 
		}
    }
	
	
	@Override
	public boolean isReady(int duration, int amplifier) {
		int time = 100 >> amplifier;
		return time > 0 ? duration % time == 0 : true;
	}
	
	@Override
	protected Potion setIconIndex(int x, int y) {
		return super.setIconIndex(x, y);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean hasStatusIcon()
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(POTION_ICON);
        return super.hasStatusIcon();
    }
}
