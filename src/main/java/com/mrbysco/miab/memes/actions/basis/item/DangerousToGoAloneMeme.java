package com.mrbysco.miab.memes.actions.basis.item;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class DangerousToGoAloneMeme extends BasicFunny {

	public DangerousToGoAloneMeme() {
		super(Reference.MOD_PREFIX + "dangerous", 10);
	}

	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		super.trigger(world, pos, player);
		if(!world.isRemote) {
			ItemStack sword = new ItemStack(Items.WOODEN_SWORD);
			sword.setStackDisplayName("Zelda Sword");
			world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY() + 0.5, pos.getZ(), sword));

			if(MemeConfig.general.UseNarator)
    		{
	        	Narrator.getNarrator().say("It's dangerous to go alone, take this");
    		}
    		else
    		{
    			player.sendMessage(new TextComponentTranslation(Reference.MOD_PREFIX + "dangerous"));
    		}
		}
	}
}
