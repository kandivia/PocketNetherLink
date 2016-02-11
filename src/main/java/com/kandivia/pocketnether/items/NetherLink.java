package com.kandivia.pocketnether.items;

import com.kandivia.pocketnether.main.MainRegistry;
import com.kandivia.pocketnether.main.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NetherLink extends Item {
	public NetherLink(String name) {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(Reference.netherLinkDurability);
		this.setNoRepair();
		this.setUnlocalizedName(name);
		this.setCreativeTab(MainRegistry.PNTab);
	}
}