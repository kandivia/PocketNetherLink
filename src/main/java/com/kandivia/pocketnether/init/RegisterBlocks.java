package com.kandivia.pocketnether.init;

import com.kandivia.pocketnether.blocks.OverworldQuartzOre;
import com.kandivia.pocketnether.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterBlocks {
	
	public static Block overworld_quartz_ore;
	
	public static void init(){
		initBlock();
		registerBlock();
	}
	
	private static void initBlock(){
		overworld_quartz_ore = new OverworldQuartzOre();
	}
	
	private static void registerBlock(){
		GameRegistry.registerBlock(overworld_quartz_ore, overworld_quartz_ore.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(overworld_quartz_ore);
	}
	
	public static void registerRender(Block block){
		ModelResourceLocation loc = new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, loc);			
	}
}
