package com.kandivia.pocketnether.main;

import com.kandivia.pocketnether.blocks.RegisterBlocks;
import com.kandivia.pocketnether.config.ConfigReader;
import com.kandivia.pocketnether.crafting.CraftingHandler;
import com.kandivia.pocketnether.crafting.RegisterRecipes;
import com.kandivia.pocketnether.creativeTab.PocketNetherTab;
import com.kandivia.pocketnether.event.MobDropEvent;
import com.kandivia.pocketnether.items.RegisterItems;
import com.kandivia.pocketnether.worldgen.RegisterOreGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class MainRegistry {
	
	public static final PocketNetherTab PNTab = new PocketNetherTab("PocketNetherTab");
	
	RegisterOreGen eventWorldGen = new RegisterOreGen();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent){
		ConfigReader.init(preEvent.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		RegisterBlocks.init();
		RegisterItems.init();
		if(Reference.enableQuartzOreSpawn)
			GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		if(Reference.enableSkeleSkullDrop)
			MinecraftForge.EVENT_BUS.register(new MobDropEvent());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegisterRecipes.init();
	}
}
