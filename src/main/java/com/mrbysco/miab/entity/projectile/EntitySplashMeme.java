package com.mrbysco.miab.entity.projectile;

import com.mrbysco.miab.MemeInABottle;
import com.mrbysco.miab.init.MemeItems;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySplashMeme extends EntityThrowable {
    private static final DataParameter<ItemStack> ITEM = EntityDataManager.<ItemStack>createKey(EntitySplashMeme.class, DataSerializers.ITEM_STACK);
    
    public EntitySplashMeme(World worldIn)
    {
        super(worldIn);
    }

    public EntitySplashMeme(World worldIn, EntityLivingBase throwerIn, ItemStack item)
    {
        super(worldIn, throwerIn);
        this.setItem(item);
    }
    
    public EntitySplashMeme(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    public static void registerFixesSplashMeme(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "ThrownMeme");
    }

    @Override
    protected void entityInit()
    {
        this.getDataManager().register(ITEM, ItemStack.EMPTY);
    }

    public ItemStack getItem()
    {
        ItemStack itemstack = (ItemStack)this.getDataManager().get(ITEM);

        if (itemstack.getItem() != MemeItems.splash_meme_in_a_bottle && itemstack.getItem() != MemeItems.lingering_meme_in_a_bottle)
        {
            if (this.world != null)
            {
                MemeInABottle.logger.error("Thrown meme entity {} has no item?!", (int)this.getEntityId());
            }

            return new ItemStack(MemeItems.splash_meme_in_a_bottle);
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

    public static void registerFixesSplashmeme(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "SplashMeme");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.NOTE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }
    
    @Override
    protected float getGravityVelocity()
    {
        return 0.05F;
    }

    /**
     * Called when this splash meme hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result)
    {
        ItemStack itemstack = this.getItem();

        if (this.isLingering()) {
        	if(!world.isRemote) {
        		this.makeAreaOfEffectCloud(itemstack);
        	}
        }

        if(!world.isRemote) {
            MemeRegistry.INSTANCE.triggerRandomMeme(world, this.getPosition(), world.getClosestPlayerToEntity(this, 100.0));
        }

        this.world.setEntityState(this, (byte)3);
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
        entityareaeffectcloud.setCustomNameTag("dankcloud");
        
        this.world.spawnEntity(entityareaeffectcloud);
    }
    
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        ItemStack itemstack = new ItemStack(compound);

        if (itemstack.isEmpty())
        {
            this.setDead();
        }
        else
        {
            this.setItem(itemstack);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        ItemStack itemstack = this.getItem();
    }

    private boolean isLingering()
    {
    	return this.getItem().getItem() == MemeItems.lingering_meme_in_a_bottle;
    }
}
