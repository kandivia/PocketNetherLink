package com.kandivia.pocketnether.main;

import com.kandivia.pocketnether.blocks.RegisterBlocks;
import com.kandivia.pocketnether.config.ConfigReader;
import com.kandivia.pocketnether.crafting.CraftingHandler;
import com.kandivia.pocketnether.crafting.RegisterRecipes;
import com.kandivia.pocketnether.creativeTab.PocketNetherTab;
import com.kandivia.pocketnether.event.MobDropEvent;
import com.kandivia.pocketnether.items.RegisterItems;
import com.kandivia.pocketnether.proxy.CommonProxy;
import com.kandivia.pocketnether.worldgen.RegisterOreGen;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MainRegistry {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final PocketNetherTab PNTab = new PocketNetherTab("PocketNetherTab");
	RegisterOreGen eventWorldGen = new RegisterOreGen();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
		ConfigReader.init(preEvent.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		RegisterItems.init();
		RegisterBlocks.init();
		if(Reference.enableQuartzOreSpawn)
			GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		if(Reference.enableSkeleSkullDrop)
			MinecraftForge.EVENT_BUS.register(new MobDropEvent());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent Event) {
		RegisterRecipes.init();
		proxy.registerRenders();
	}
}