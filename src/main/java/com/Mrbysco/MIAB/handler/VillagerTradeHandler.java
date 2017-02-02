package com.Mrbysco.MIAB.handler;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class VillagerTradeHandler {
	 public static class ItemstackForEmerald  implements EntityVillager.ITradeList
     {
		 public ItemStack sellingItem;
		 public EntityVillager.PriceInfo priceInfo;

         public ItemstackForEmerald(Item itemIn, EntityVillager.PriceInfo priceIn)
         {
             this.sellingItem = new ItemStack(itemIn);
             this.priceInfo = priceIn;
         }
         
        public ItemstackForEmerald(ItemStack stack, EntityVillager.PriceInfo priceIn)
 		{
 			this.sellingItem = stack;
 			this.priceInfo = priceIn;
 		}

        public static ItemStack copyStackWithAmount(ItemStack stack, int amount)
        {
            if(stack==null)
                return null;
            ItemStack s2 = stack.copy();
            s2.stackSize=amount;
            return s2;
        }
        
         /**
          * Affects the given MerchantRecipeList to possibly add or remove MerchantRecipes.
          */
        @Override
        public void modifyMerchantRecipeList(MerchantRecipeList recipeList, Random random) {
            int i = 1;
            if (this.priceInfo != null)
                i = this.priceInfo.getPrice(random);
            ItemStack itemStack1;
            ItemStack itemStack2;
            if (i < 0) {
                itemStack1 = new ItemStack(Items.EMERALD);
                itemStack2 = copyStackWithAmount(sellingItem, -i);
            } else {
                itemStack1 = new ItemStack(Items.EMERALD, i, 0);
                itemStack2 = copyStackWithAmount(sellingItem, i);
            }
            recipeList.add(new MerchantRecipe(itemStack1, itemStack2));
        	}
     }
}
