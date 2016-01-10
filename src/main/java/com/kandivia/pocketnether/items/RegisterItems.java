package com.kandivia.pocketnether.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class RegisterItems {
	public static Item nether_link;
	
	public static void init() {
		initItem();
		registerItem();
	}
	
	private static void initItem() {
		nether_link = new NetherLink("nether_link");
	}
	
	private static void registerItem() {
		GameRegistry.registerItem(nether_link, nether_link.getUnlocalizedName().substring(5));
	}

}
