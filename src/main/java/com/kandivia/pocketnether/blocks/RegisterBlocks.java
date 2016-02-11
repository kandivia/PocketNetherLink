package com.kandivia.pocketnether.blocks;

import com.kandivia.pocketnether.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RegisterBlocks {
	public static Block quartz_ore;
	
	public static void init() {
		initBlock();
		registerBlock();
		registerOreDictionary();
	}
	
	private static void initBlock() {
		quartz_ore = new OverworldQuartzOre("quartz_ore");		
	}
	
	private static void registerBlock() {
		GameRegistry.registerBlock(quartz_ore, quartz_ore.getUnlocalizedName().substring(5));
	}
	
	private static void registerOreDictionary() {
		OreDictionary.registerOre("oreQuartz", quartz_ore);
	}
	
	public static void registerRenders() {
		registerRender(quartz_ore);
	}
	
	public static void registerRender(Block block) {
		ModelResourceLocation loc = new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, loc);			
	}
}
