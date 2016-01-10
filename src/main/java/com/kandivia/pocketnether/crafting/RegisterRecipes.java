package com.kandivia.pocketnether.crafting;

import com.kandivia.pocketnether.blocks.RegisterBlocks;
import com.kandivia.pocketnether.items.RegisterItems;
import com.kandivia.pocketnether.main.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RegisterRecipes {
	//Blocks
	private static ItemStack netherBrick = new ItemStack(Blocks.nether_brick);
	private static ItemStack netherrack = new ItemStack(Blocks.netherrack);
	private static ItemStack soulSand = new ItemStack(Blocks.soul_sand);
	private static ItemStack netherQuartzOre = new ItemStack(Blocks.quartz_ore);
	//Items
	private static ItemStack netherLink = new ItemStack(RegisterItems.nether_link, 1, OreDictionary.WILDCARD_VALUE);
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
	
	private static void addCraftingRecipies() {
		if(Reference.enableAltLinkRecipe)
			GameRegistry.addShapedRecipe(new ItemStack(RegisterItems.nether_link), "ooo", "ofo", "ooo", 'o', Blocks.obsidian, 'f', Items.flint_and_steel);
		else
			GameRegistry.addShapedRecipe(new ItemStack(RegisterItems.nether_link), " o ", "ofo", " o ", 'o', Blocks.obsidian, 'f', Items.flint_and_steel);
		
		GameRegistry.addShapelessRecipe(netherrack, netherLink, Blocks.cobblestone);
		GameRegistry.addShapelessRecipe(netherBrick, netherLink, Blocks.stonebrick);
	    GameRegistry.addShapelessRecipe(soulSand, netherLink, Blocks.sand, Items.bone, Items.rotten_flesh);
	    GameRegistry.addShapelessRecipe(netherWart, netherLink, soulSand, Items.wheat_seeds, Blocks.red_mushroom);
	    GameRegistry.addShapelessRecipe(blazeRod, netherLink, Items.iron_ingot, Items.coal, netherWart, glowstoneDust);
	    GameRegistry.addShapelessRecipe(ghastTear, netherLink, Items.blaze_powder, Items.gunpowder, Items.speckled_melon, waterBottle);
	    GameRegistry.addShapelessRecipe(glowstoneDust, netherLink, Items.gunpowder, Blocks.torch);
	    GameRegistry.addShapelessRecipe(netherQuartzOre, netherLink, RegisterBlocks.quartz_ore);
	    GameRegistry.addShapelessRecipe(witherSkull, netherLink, skeleSkull, Items.coal, ghastTear, Items.diamond);
	}
	
	private static void addSmeltingRecipies() {
		GameRegistry.addSmelting(RegisterBlocks.quartz_ore, quartz, 0.2F);
	}
}