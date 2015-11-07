package com.kandivia.pocketnether.init;

import com.kandivia.pocketnether.blocks.OverworldQuartzOre;
import com.kandivia.pocketnether.helper.RegisterHelper;

import net.minecraft.block.Block;

public class BlockRegister {
	public static Block overworldQuartzOre;
	
	public static void init(){
		initBlock();
		registerBlock();
	}
	
	private static void initBlock(){
		overworldQuartzOre = new OverworldQuartzOre();
	}
	
	private static void registerBlock(){
		RegisterHelper.registerBlock(overworldQuartzOre);
	}

}
