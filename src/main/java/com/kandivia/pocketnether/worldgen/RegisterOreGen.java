package com.kandivia.pocketnether.worldgen;

import java.util.Random;

import com.kandivia.pocketnether.blocks.RegisterBlocks;
import com.kandivia.pocketnether.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class RegisterOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionId()) { 
		case 0 :
			generateSurface(world, random, chunkX*16, chunkZ*16);
		case -1 :
			break;
		case 1 :
			break;
		}		
	}
	
	private void generateSurface(World world, Random random, int x, int z) {
		this.addOreSpawn(RegisterBlocks.quartz_ore, world, random, x, z, 16, 16, 
				4+random.nextInt(6), Reference.chanceToSpawn, Reference.minY, Reference.maxY);
	}
	
	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, 
			int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
		for(int i = 0; i < chanceToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			BlockPos coords = new BlockPos(posX, posY, posZ);
			new WorldGenMinable(RegisterBlocks.quartz_ore.getDefaultState(), maxVeinSize).generate(world, random, coords);
		}
	}
}