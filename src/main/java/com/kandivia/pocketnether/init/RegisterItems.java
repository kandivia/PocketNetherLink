package com.kandivia.pocketnether.init;

import com.kandivia.pocketnether.items.NetherLink;
import com.kandivia.pocketnether.main.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterItems {
	public static Item nether_link;
	
	public static void init(){
		initItem();
		registerItem();
	}
	
	public static void initItem(){
		nether_link = new NetherLink();
	}
	
	public static void registerItem(){
		GameRegistry.registerItem(nether_link, nether_link.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(nether_link);
	}
	
	public static void registerRender(Item item){
		ModelResourceLocation loc = new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, loc);			
	}

}
