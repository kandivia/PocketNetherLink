package com.kandivia.pocketnether.items;

import com.kandivia.pocketnether.main.MainRegistry;
import com.kandivia.pocketnether.main.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NetherLink extends Item {
	public NetherLink(String name){
		super();
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MOD_ID + ":" + name);
		this.maxStackSize = 1;
		this.setMaxDamage(Reference.netherLinkDurability);
		this.setNoRepair();		
		this.setCreativeTab(MainRegistry.PNTab);	
	}
}
