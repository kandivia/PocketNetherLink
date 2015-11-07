package com.kandivia.pocketnether.creativeTabs;

import com.kandivia.pocketnether.init.RegisterItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NetherLinkTab extends CreativeTabs {

	public NetherLinkTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return RegisterItems.nether_link;
	}

}
