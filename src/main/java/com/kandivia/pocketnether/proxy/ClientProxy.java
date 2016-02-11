package com.kandivia.pocketnether.proxy;

import com.kandivia.pocketnether.blocks.RegisterBlocks;
import com.kandivia.pocketnether.items.RegisterItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders() {
		RegisterItems.registerRenders();
		RegisterBlocks.registerRenders();
	}
}
