package com.kandivia.pocketnether.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
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
}
