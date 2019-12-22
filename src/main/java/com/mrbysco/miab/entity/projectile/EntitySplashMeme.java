package com.mrbysco.miab.entity.projectile;

import com.mrbysco.miab.init.MemeEntities;
import com.mrbysco.miab.init.MemeItems;
import com.mrbysco.miab.memes.MemeRegistry;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;

@OnlyIn(
        value = Dist.CLIENT,
        _interface = IRendersAsItem.class
)
public class EntitySplashMeme extends ThrowableEntity implements IRendersAsItem {
    private static final DataParameter<ItemStack> ITEM = EntityDataManager.<ItemStack>createKey(EntitySplashMeme.class, DataSerializers.ITEMSTACK);
    
    public EntitySplashMeme(EntityType<? extends EntitySplashMeme> entityType, World worldIn)
    {
        super(entityType, worldIn);
    }

    public EntitySplashMeme(World worldIn, LivingEntity throwerIn, ItemStack item)
    {
        super(MemeEntities.SPLASH_MEME, throwerIn, worldIn);
        this.setItem(item);
    }
    
    public EntitySplashMeme(World worldIn, double x, double y, double z)
    {
        super(MemeEntities.SPLASH_MEME, x, y, z, worldIn);
    }

    public EntitySplashMeme(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
        this(MemeEntities.SPLASH_MEME, worldIn);
    }

    @Override
    protected void registerData()
    {
        this.getDataManager().register(ITEM, ItemStack.EMPTY);
    }

    public ItemStack getItem()
    {
        ItemStack stack = (ItemStack)this.getDataManager().get(ITEM);
        if (stack.getItem() != Items.SPLASH_POTION && stack.getItem() != Items.LINGERING_POTION) {
            if (this.world != null) {
                LOGGER.error("Thrown Meme entity {} has no item?!", this.getEntityId());
            }

            return new ItemStack(MemeItems.splash_meme_in_a_bottle);
        } else {
            return stack;
        }
    }

    public void setItem(ItemStack stack) {
        this.getDataManager().set(ITEM, stack.copy());
    }

    @Override
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.addParticle(ParticleTypes.NOTE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
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
        if (!this.world.isRemote) {
            ItemStack itemstack = this.getItem();

            if (this.isLingering()) {
                if(!world.isRemote) {
                    this.makeAreaOfEffectCloud(itemstack);
                }
            }

            MemeRegistry.INSTANCE.triggerRandomMeme(world, this.getPosition(), world.getClosestPlayer(this, 100.0));

            this.remove();
        }
    }
    
    private void makeAreaOfEffectCloud(ItemStack stack)
    {
        AreaEffectCloudEntity entityareaeffectcloud = new AreaEffectCloudEntity(this.world, this.posX, this.posY, this.posZ);
        entityareaeffectcloud.setOwner(this.getThrower());
        entityareaeffectcloud.setRadius(3.0F);
        entityareaeffectcloud.setRadiusOnUse(-0.5F);
        entityareaeffectcloud.setWaitTime(10);
        entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());
        entityareaeffectcloud.setColor(13882323);
        entityareaeffectcloud.setCustomName(new StringTextComponent("dankcloud"));
        
        this.world.addEntity(entityareaeffectcloud);
    }
    
    @Override
    public void readAdditional(CompoundNBT compound)
    {
        super.readAdditional(compound);
    }

    @Override
    public void writeAdditional(CompoundNBT compound)
    {
        super.writeAdditional(compound);
    }

    private boolean isLingering()
    {
    	return this.getItem().getItem() == MemeItems.lingering_meme_in_a_bottle;
    }
}
