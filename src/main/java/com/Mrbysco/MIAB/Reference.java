package com.Mrbysco.MIAB;

public class Reference {
	public static final String MOD_ID = "miab";
	public static final String MOD_PREFIX = "miab:";
	public static final String MOD_NAME = "Meme In A Bottle";
	public static final String VERSION = "1.5.0.5";
	public static final String ACCEPTED_VERSIONS = "[1.12]";
	
	public static final String CLIENT_PROXY_CLASS = "com.Mrbysco.MIAB.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.Mrbysco.MIAB.proxy.CommonProxy";

public static enum MIABItems {
	
	MEMEINABOTTLE("memeinabottle", "itemmemeinabottle"),
	SPLASHMEMEINABOTTLE("splashmemeinabottle", "itemsplashmemeinabottle"),
	LINGERINGMEMEINABOTTLE("lingeringmemeinabottle", "itemlingeringmemeinabottle"),
	MCWBELT("mcwbelt", "itemmcwbelt"),
	TRUMPHAIR("trumphair", "itemtrumphair"),
	TROLLMASK("trollmask", "itemtrollmask"),
	RIPOFFHAT("rippoffhat", "itemripoffhat"),
	LEATHERBELT("leatherbelt", "itemleatherbelt"),
	PINEAPPLE("pineapple", "itempineapple"),
	PEN("pen", "itempen"),
	APPLE("apple", "itemapple"),
	ONION("onion", "itemonion"),
	MINEBURGER("mineburger", "itemmineburger"),
	SAX("sax", "itemsax"),
	WAFFLE("waffle", "itemwaffle"),
	POPTART("poptart", "itempoptart");
	
	private String unlocalisedName;
	private String registryName;
	
	MIABItems(String unlocalisedName, String registryName) {
		this.unlocalisedName = unlocalisedName;
		this.registryName = registryName;
	}
	
	public String getUnlocalisedName() {
		return unlocalisedName;
	}
	
	public String getRegistryName() {
		return registryName;
	}
}

public static enum MIABBlocks {
	
	BOTTLEBLOCK("bottleblock", "bottle_block"),
	KEYBOARD("keyboardmechanical", "blockkeyboardmechanical");
	
	private String unlocalisedName;
	private String registryName;
	
	MIABBlocks(String unlocalisedName, String registryName) {
		this.unlocalisedName = unlocalisedName;
		this.registryName = registryName;
	}
	
	public String getUnlocalisedName() {
		return unlocalisedName;
	}
	
	public String getRegistryName() {
		return registryName;
	}
}
}