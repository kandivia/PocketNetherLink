package com.kandivia.pocketnether.init;

import com.kandivia.pocketnether.helper.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingRegister {
	//Blocks
		private static ItemStack netherBrick = new ItemStack(Blocks.nether_brick);
		private static ItemStack netherrack = new ItemStack(Blocks.netherrack);
	    private static ItemStack soulSand = new ItemStack(Blocks.soul_sand);
	    private static ItemStack netherQuartzOre = new ItemStack(Blocks.quartz_ore);
	    
	//Items
		private static ItemStack netherLink = new ItemStack(ItemRegister.netherLink, 1, OreDictionary.WILDCARD_VALUE);
	    private static ItemStack netherWart = new ItemStack(Items.nether_wart);
	    private static ItemStack blazeRod = new ItemStack(Items.blaze_rod);
	    private static ItemStack ghastTear = new ItemStack(Items.ghast_tear);
	    private static ItemStack waterBottle = new ItemStack(Items.potionitem, 1, 0);
	    private static ItemStack glowstoneDust = new ItemStack(Items.glowstone_dust);
	    private static ItemStack quartz = new ItemStack(Items.quartz);
	    private static ItemStack gunpowder = new ItemStack(Items.gunpowder);
	    private static ItemStack skeleSkull = new ItemStack(Items.skull, 1, 0);
	    private static ItemStack witherSkull = new ItemStack(Items.skull, 1, 1);
		
		public static void init() {
			addCraftingRecipies();
			addSmeltingRecipies();
		}
		
		public static void addCraftingRecipies() {
		//Pocket Nether Link
			if(Reference.enableAltLinkRecipe)
				GameRegistry.addShapedRecipe(new ItemStack(ItemRegister.netherLink), "ooo", "ofo", "ooo", 'o', Blocks.obsidian, 'f', Items.flint_and_steel);
			else
				GameRegistry.addShapedRecipe(new ItemStack(ItemRegister.netherLink), " o ", "ofo", " o ", 'o', Blocks.obsidian, 'f', Items.flint_and_steel);
			
		//Netherrack
			GameRegistry.addShapelessRecipe(netherrack, netherLink, Blocks.cobblestone);
		//Nether Brick
			GameRegistry.addShapelessRecipe(netherBrick, netherLink, Blocks.stonebrick);
		//Soul Sand
		    GameRegistry.addShapelessRecipe(soulSand, netherLink, Blocks.sand, Items.bone, Items.rotten_flesh);
		//Nether Wart
		    GameRegistry.addShapelessRecipe(netherWart, netherLink, soulSand, Items.wheat_seeds, Blocks.red_mushroom);
		//Blaze Rod
		    GameRegistry.addShapelessRecipe(blazeRod, netherLink, Items.iron_ingot, Items.coal, netherWart, glowstoneDust);
		//Ghast Tear
		    GameRegistry.addShapelessRecipe(ghastTear, netherLink, Items.blaze_powder, Items.gunpowder, Items.speckled_melon, waterBottle);
		//Glowstone Dust
		    GameRegistry.addShapelessRecipe(glowstoneDust, netherLink, Items.gunpowder, Blocks.torch);
		//Nether Quartz Ore
		    GameRegistry.addShapelessRecipe(netherQuartzOre, netherLink, BlockRegister.overworldQuartzOre);
		//Wither Skull
		    GameRegistry.addShapelessRecipe(witherSkull, netherLink, skeleSkull, Items.coal, ghastTear, Items.diamond);
		}
		
		public static void addSmeltingRecipies() {
			GameRegistry.addSmelting(BlockRegister.overworldQuartzOre, quartz, 0.2F);
		}
}
