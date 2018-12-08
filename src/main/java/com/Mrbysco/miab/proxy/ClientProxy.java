package com.Mrbysco.miab.proxy;

import com.Mrbysco.miab.init.MemeEntities;

public class ClientProxy extends ServerProxy{
	
	@Override
	public void Preinit(){
		MemeEntities.RegisterEntityRender();
	}
	
	@Override
	public void Init() {
		
	}
}
