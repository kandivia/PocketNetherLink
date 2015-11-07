package com.kandivia.pocketnether.blocks;

import java.util.Random;

import com.kandivia.pocketnether.helper.Reference;
import com.kandivia.pocketnether.main.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class OverworldQuartzOre extends Block {
	public OverworldQuartzOre() {
		super(Material.rock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.setBlockName("overworldQuartzOre");
		this.setBlockTextureName("overworldQuartzOre");
		this.setCreativeTab(MainRegistry.tabPocketNether);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	 public Item getItemDropped(int damage, Random random, int fortune)
	    {
	        return Items.quartz;
	    }

	    public int quantityDropped(Random random)
	    {
	        return 1;
	    }

	    public int quantityDroppedWithBonus(int fortune, Random random)
	    {
	        if (fortune > 0)
	        {
	            int j = random.nextInt(fortune + 2) - 1;

	            if (j < 0)
	            {
	                j = 0;
	            }

	            return quantityDropped(random) * (j + 1);
	        }
	        else
	        {
	            return quantityDropped(random);
	        }
	    }
	    
	    private Random rand = new Random();
	    @Override
	    public int getExpDrop(IBlockAccess a, int x, int y)
	    {
	        if (this.getItemDropped(x, rand, y) != Item.getItemFromBlock(this))
	        {
	            return MathHelper.getRandomIntegerInRange(rand, 2, 5);
	        }
	        return 0;
	    }
}
