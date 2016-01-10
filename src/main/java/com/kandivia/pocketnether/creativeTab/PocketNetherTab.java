package com.kandivia.pocketnether.creativeTab;

import com.kandivia.pocketnether.items.RegisterItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PocketNetherTab extends CreativeTabs {
	public PocketNetherTab(String label) {
		super(label);
	}
	
	@Override
	public Item getTabIconItem() {
		return RegisterItems.nether_link;
	}

}
