package com.Mrbysco.MIAB.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Mrbysco.MIAB.init.MIABConfig;
import com.Mrbysco.MIAB.init.MIABItems;
import com.Mrbysco.MIAB.memes.memes;
import com.Mrbysco.MIAB.potion.TrollPotion;

import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackData;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityMeme extends EntityThrowable{
	EntityPlayer player = this.world.getClosestPlayerToEntity(this, 100.0);
    private static final DataParameter<ItemStack> ITEM = EntityDataManager.<ItemStack>createKey(EntityMeme.class, DataSerializers.ITEM_STACK);
    private static final Logger LOGGER = LogManager.getLogger();
    EntityAreaEffectCloud cloud;

    public EntityMeme(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityMeme(World worldIn, EntityLivingBase throwerIn, ItemStack item)
    {
        super(worldIn, throwerIn);
        this.setItem(item);
    }

    public EntityMeme(World worldIn, double x, double y, double z, ItemStack item)
    {
        super(worldIn, x, y, z);

        if (!item.isEmpty())
        {
            this.setItem(item);
        }
    }
    
    protected void entityInit()
    {
        this.getDataManager().register(ITEM, ItemStack.EMPTY);
    }

    public static void registerFixesMeme(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "ThrownMeme");
        fixer.registerWalker(FixTypes.ENTITY, new ItemStackData(EntityMeme.class, new String[] {"Meme"}));

    }

    public ItemStack getItemName()
    {
        ItemStack itemstack = (ItemStack)this.getDataManager().get(ITEM);

        if (itemstack.getItem() != MIABItems.splash_meme_in_a_bottle && itemstack.getItem() != MIABItems.lingering_meme_in_a_bottle)
        {
            if (this.world != null)
            {
                LOGGER.error("Thrown meme entity {} has no item?!", (int)this.getEntityId());
            }

            return new ItemStack(MIABItems.splash_meme_in_a_bottle);
        }
        else
        {
            return itemstack;
        }
    }

    public void setItem(ItemStack stack)
    {
        this.getDataManager().set(ITEM, stack);
        this.getDataManager().setDirty(ITEM);
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.NOTE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }
    
    protected float getGravityVelocity()
    {
        return 0.05F;
    }
    
    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {	
        	int random = rand.nextInt(MIABConfig.MemeRandomness);
            ItemStack itemstack = this.getItemName();
            int color = 13882323;

                if (this.isLingering())
                {
                    this.makeAreaOfEffectCloud(itemstack);
                	memes.doMemeStuff(this.posX, this.posY, this.posZ, world, player, this, random, true);
                }
                else
                {
                	memes.doMemeStuff(this.posX, this.posY, this.posZ, world, player, this, random, true);
                }
                
        }  
        this.setDead();
    }

    private void makeAreaOfEffectCloud(ItemStack stack)
    {
        EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(this.world, this.posX, this.posY, this.posZ);
        entityareaeffectcloud.setOwner(this.getThrower());
        entityareaeffectcloud.setRadius(3.0F);
        entityareaeffectcloud.setRadiusOnUse(-0.5F);
        entityareaeffectcloud.setWaitTime(10);
        entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());
        entityareaeffectcloud.setColor(13882323);
        entityareaeffectcloud.setPotion(new PotionType(new PotionEffect(TrollPotion.INSTANCE, 60 * 20)));
        
        this.world.spawnEntity(entityareaeffectcloud);
    }

    private boolean isLingering()
    {
    	return this.getItemName().getItem() == MIABItems.lingering_meme_in_a_bottle;
    }
}