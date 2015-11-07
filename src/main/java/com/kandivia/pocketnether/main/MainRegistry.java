package com.kandivia.pocketnether.main;

import com.kandivia.pocketnether.event.MobDropEvent;
import com.kandivia.pocketnether.helper.ConfigHandler;
import com.kandivia.pocketnether.helper.CraftingHandler;
import com.kandivia.pocketnether.helper.Reference;
import com.kandivia.pocketnether.helper.RegisterHelper;
import com.kandivia.pocketnether.init.BlockRegister;
import com.kandivia.pocketnether.init.CraftingRegister;
import com.kandivia.pocketnether.init.ItemRegister;
import com.kandivia.pocketnether.worldgen.PNWorldGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class MainRegistry {
	
	public static CreativeTabs tabPocketNether = new CreativeTabs("PocketNether"){
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ItemRegister.netherLink;
		}
	};
	
	PNWorldGen eventWorldGen = new PNWorldGen();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent){
		ConfigHandler.init(preEvent.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		BlockRegister.init();
		ItemRegister.init();
		CraftingRegister.init();
		if(Reference.enableQuartzOreSpawn)
			GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		if(Reference.enableSkeleSkullDrop)
			MinecraftForge.EVENT_BUS.register(new MobDropEvent());
	}
}
