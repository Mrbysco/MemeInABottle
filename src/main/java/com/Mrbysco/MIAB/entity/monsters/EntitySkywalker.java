package com.Mrbysco.MIAB.entity.monsters;

import com.Mrbysco.MIAB.entity.entitybases.EntityMemeBase;
import com.Mrbysco.MIAB.init.MiabSoundEvents;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntitySkywalker extends EntityMemeBase 
{
	public static String NAME = "Anakin Skywalker";
	
	private boolean isMounted = false;
	
	public EntitySkywalker(World world) {
	    super(world);
	    }
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	};
	
	@Override
    protected SoundEvent getAmbientSound()
    {
        return MiabSoundEvents.skywalker_sand;
    }
	
	@Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return MiabSoundEvents.skywalker_sand;
    }
	
	@Override
    protected SoundEvent getDeathSound()
    {
        return MiabSoundEvents.skywalker_sand;
    }
	
	@Override
	public void onLivingUpdate()
    {
		BlockPos position = new BlockPos(this.posX, this.posY-1, this.posZ);
		
		if((this.moveForward != 0 || this.moveStrafing != 0) && this.onGround && (world.getBlockState(position).getBlock() == Blocks.SAND))
		{
			if(!this.world.isRemote)
			{
				int random = rand.nextInt(1000);
				
				if (random < 1)
				{
				Minecraft.getMinecraft().player.playSound(MiabSoundEvents.meme_music2, this.getSoundVolume(), 1F);
				}
			}
		}
		
		if (this.isRiding() && this.getAttackTarget() != null && this.getRidingEntity() instanceof EntityChicken)
        {
            ((EntityLiving)this.getRidingEntity()).getNavigator().setPath(this.getNavigator().getPath(), 1.5D);
        }
		float f = this.getBrightness();
		
		ignoreUndeadFire = true;
	       
        super.onLivingUpdate();
       
        ignoreUndeadFire = false;
    }
    private boolean ignoreUndeadFire = false;
    
    @Override
    protected ResourceLocation getLootTable()
    {
    	return new ResourceLocation("miab:entity/skywalker");
    }
}