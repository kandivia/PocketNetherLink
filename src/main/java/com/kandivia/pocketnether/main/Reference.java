package com.kandivia.pocketnether.main;

public class Reference {
	public static final String MOD_ID = "pocketnether";
	public static final String MOD_NAME = "Pocket Nether Link";
	public static final String VERSION = "2.0";
	public static final String CLIENT_PROXY_CLASS = "com.kandivia.pocketnether.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.kandivia.pocketnether.proxy.CommonProxy";
	
	//Config
	public static boolean enableQuartzOreSpawn, enableSkeleSkullDrop, enableAltLinkRecipe;
	public static int chanceToSpawn, minY, maxY, netherLinkDurability;
	public static double chanceToDropSkull;
}