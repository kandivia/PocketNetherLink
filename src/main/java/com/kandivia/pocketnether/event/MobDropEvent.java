package com.kandivia.pocketnether.event;

import java.util.Random;

import com.kandivia.pocketnether.main.Reference;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropEvent {
	Random rand = new Random();
	
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		if(event.source.getDamageType().equals("player")) {
			if(event.entityLiving instanceof EntitySkeleton) {
				if((rand.nextDouble() * 100) < (Reference.chanceToDropSkull + event.lootingLevel)) {
					event.entityLiving.dropItem(Items.skull, 1);
				}
			}
		}
	} 
}