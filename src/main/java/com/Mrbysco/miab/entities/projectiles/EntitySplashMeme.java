package com.Mrbysco.miab.entities.projectiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Mrbysco.miab.config.MemeConfigGen;
import com.Mrbysco.miab.init.MemeItems;
import com.Mrbysco.miab.memes.MemeHelper;
import com.Mrbysco.miab.memes.MemeLists;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySplashMeme extends EntityThrowable
{
	EntityPlayer player = this.world.getClosestPlayerToEntity(this, 100.0);
    private static final DataParameter<ItemStack> ITEM = EntityDataManager.<ItemStack>createKey(EntitySplashMeme.class, DataSerializers.ITEM_STACK);
    private static final Logger LOGGER = LogManager.getLogger();
    
    public EntitySplashMeme(World worldIn)
    {
        super(worldIn);
    }

    public EntitySplashMeme(World worldIn, EntityLivingBase throwerIn, ItemStack item)
    {
        super(worldIn, throwerIn);
        this.setItem(item);
    }

    public EntitySplashMeme(World worldIn, double x, double y, double z, ItemStack item)
    {
        super(worldIn, x, y, z);

        if (!item.isEmpty())
        {
            this.setItem(item);
        }
    }
    
    @Override
    protected void entityInit()
    {
        this.getDataManager().register(ITEM, ItemStack.EMPTY);
    }

    public static void registerFixesMeme(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "ThrownMeme");
        fixer.registerWalker(FixTypes.ENTITY, new ItemStackData(EntitySplashMeme.class, new String[] {"Meme"}));

    }

    public ItemStack getItemName()
    {
        ItemStack itemstack = (ItemStack)this.getDataManager().get(ITEM);

        if (itemstack.getItem() != MemeItems.splash_meme_in_a_bottle && itemstack.getItem() != MemeItems.lingering_meme_in_a_bottle)
        {
            if (this.world != null)
            {
                LOGGER.error("Thrown meme entity {} has no item?!", (int)this.getEntityId());
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
        ItemStack itemstack = this.getItemName();

        if (this.isLingering())
        {
        	if(!world.isRemote)
        	{
        		this.makeAreaOfEffectCloud(itemstack);
        	}
            DoTheMeme(this.world, this.getPosition(), player, this);
        }
        else
        {
        	DoTheMeme(this.world, this.getPosition(), player, this);
        }

        this.world.setEntityState(this, (byte)3);
        this.setDead();
    }
    
    private static void DoTheMeme(World world, BlockPos pos, EntityPlayer playerIn, Entity entity) {
    	
    	int random = world.rand.nextInt(100);
    	if(random < MemeConfigGen.general.SpecialMemeChance)
    	{
    		MemeHelper.SpawnRandomMeme(world, pos, playerIn, entity);
    	}
    	if(random > MemeConfigGen.general.SpecialMemeChance)
        {
    		if(!world.isRemote)
    		{
				if(MemeConfigGen.general.MatureSounds == true)
				{
					entity.playSound(MemeLists.getRandomMatureSound(), 1f, 1f);
				}
				else
				{
					entity.playSound(MemeLists.getRandomSafeSound(), 1f, 1f);
				}
    		}
        }
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
        ItemStack itemstack = this.getItemName();
    }

    private boolean isLingering()
    {
    	return this.getItemName().getItem() == MemeItems.lingering_meme_in_a_bottle;
    }
}