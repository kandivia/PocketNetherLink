package com.kandivia.pocketnether.items;

import com.kandivia.pocketnether.helper.Reference;
import com.kandivia.pocketnether.main.MainRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NetherLink extends Item {
	public NetherLink(){
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(Reference.netherLinkDurability);
		this.setNoRepair();
		this.setUnlocalizedName("netherLink");
		this.setTextureName(Reference.MOD_ID + ":" + getUnlocalizedName().substring(5));
		this.setCreativeTab(MainRegistry.tabPocketNether);	
	}
}
