package com.kandivia.pocketnether.proxy;

import com.kandivia.pocketnether.init.RegisterBlocks;
import com.kandivia.pocketnether.init.RegisterItems;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders(){
		RegisterItems.registerRenders();
		RegisterBlocks.registerRenders();
	}
}
