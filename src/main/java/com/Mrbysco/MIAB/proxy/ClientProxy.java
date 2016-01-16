package com.Mrbysco.MIAB.proxy;

import com.Mrbysco.MIAB.init.MIABItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders(){
		MIABItems.registerRenders();
	}
}
