package com.kandivia.pocketnether.config;

import java.io.File;

import com.kandivia.pocketnether.main.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigReader {
	
	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);		
		try {
			config.load();
			
		//General Config
			Property altLinkProp = config.get("General", "enableAltLinkRecipe", false);
			altLinkProp.comment = "Set this to true to have the Pocket Nether Link recipe use eight Obsidian instead of four.";
			Reference.enableAltLinkRecipe = altLinkProp.getBoolean(false);
			
			Property linkDurabilityProp = config.get("General", "pocketNetherLinkDurability", 512);
			linkDurabilityProp.comment = "Sets the Durability of the Pocket Nether Link.";
			Reference.netherLinkDurability = linkDurabilityProp.getInt(512);
			
			Property enableSkullProp = config.get("General", "enableSkeleSkullDrop", false);
			enableSkullProp.comment = "Set this to true to have Skeletons drop their skulls on death.";
			Reference.enableSkeleSkullDrop = enableSkullProp.getBoolean(false);
			
			Property skullChanceProp = config.get("General", "chanceToDropSkull", 2.0);
			skullChanceProp.comment = "Set the chance for Skeletons to drop their skull. 2.0 = 2%";
			Reference.chanceToDropSkull = skullChanceProp.getDouble(2.0);
			
		//World Generation Config
			Property enableQuartzProp = config.get("World Generation", "enableQuartzOreSpawn", true);
			enableQuartzProp.comment = "Set this to true to enable Overworld Quartz Ore generation.";
			Reference.enableQuartzOreSpawn = enableQuartzProp.getBoolean(true);
			
			Property spawnChanceProp = config.get("World Generation", "chanceToSpawnQuartzOre", 20);
			spawnChanceProp.comment = "Sets the chance/rarity of Quartz Ore to spawn.";
			Reference.chanceToSpawn = spawnChanceProp.getInt(20);
			
			Property minYProp = config.get("World Generation", "minY", 20);
			minYProp.comment = "Minimum Y-Level for Quartz Ore to spawn.";
			Reference.minY = minYProp.getInt(20);
			
			Property maxYProp = config.get("World Generation", "maxY", 30);
			maxYProp.comment = "Maximum Y-Level for Quartz Ore to spawn.";
			Reference.maxY = maxYProp.getInt(30);
			
		} catch(Exception e) {
			System.out.println("PocketNether: Failed to Load Config File!");			
		} finally {
			config.save();
		}				
	}
}
