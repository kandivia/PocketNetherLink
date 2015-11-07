package com.kandivia.pocketnether.init;

import net.minecraft.item.Item;

import com.kandivia.pocketnether.helper.RegisterHelper;
import com.kandivia.pocketnether.items.NetherLink;

public class ItemRegister {
public static Item netherLink;
	
	public static void init(){
		initItem();
		registerItem();
	}
	
	private static void initItem(){
		netherLink = new NetherLink();
	}
	
	private static void registerItem(){
		RegisterHelper.registerItem(netherLink);
	}
}
