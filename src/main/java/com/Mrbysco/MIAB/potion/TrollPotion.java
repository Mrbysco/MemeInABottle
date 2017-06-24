package com.Mrbysco.MIAB.potion;

import java.util.Random;

import com.Mrbysco.MIAB.init.MIABConfig;
import com.Mrbysco.MIAB.memes.memes;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrollPotion extends Potion{

	private Random rand = new Random();
	public static final ResourceLocation POTION_ICON = new ResourceLocation("miab:textures/potion/memedfx.png");
	public static final TrollPotion INSTANCE = new TrollPotion();
	public static PotionType type = new PotionType(new PotionEffect(INSTANCE, 60 * 20));
	
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
            memes.doMemeStuff(posX, posY, posZ, entityLiving.world, player, player, rand.nextInt(MIABConfig.MemeRandomness), false);
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
