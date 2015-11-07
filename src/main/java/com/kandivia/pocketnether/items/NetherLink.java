package com.kandivia.pocketnether.items;

import com.kandivia.pocketnether.main.MainRegistry;
import com.kandivia.pocketnether.main.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NetherLink extends Item {
	public NetherLink(){
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(Reference.netherLinkDurability);
		this.setNoRepair();
		this.setUnlocalizedName("nether_link");
		this.setCreativeTab(MainRegistry.nLinkTab);
	}
}
