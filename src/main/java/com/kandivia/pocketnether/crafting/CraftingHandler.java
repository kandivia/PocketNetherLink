package com.kandivia.pocketnether.crafting;

import com.kandivia.pocketnether.init.RegisterItems;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event)
	{
		final IInventory craftMaxtrix = null;
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++)
		if(event.craftMatrix.getStackInSlot(i) != null)
		{
			ItemStack item0 = event.craftMatrix.getStackInSlot(i);
			if(item0 != null && item0.getItem() == RegisterItems.nether_link)
			{
				ItemStack k = new ItemStack(RegisterItems.nether_link, 2, (item0.getItemDamage() + 1));
				
				if(k.getItemDamage() >= k.getMaxDamage())
				{
					k.stackSize--;
				}
				event.craftMatrix.setInventorySlotContents(i, k);
				
			}
		}
	}

}
