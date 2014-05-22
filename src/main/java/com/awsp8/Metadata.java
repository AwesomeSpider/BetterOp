package com.awsp8;

import java.util.List;

import org.bukkit.plugin.PluginDescriptionFile;

public class Metadata {

	public static String NAME;
	public static PluginDescriptionFile DISCRIPTION;
	public static List<String> AUTHORS;
	public static String VERSION;
	public static String WEBSITE;
	
	public static void gather(){
		NAME = BetterOp.instance.getName();
		DISCRIPTION = BetterOp.instance.getDescription();
		AUTHORS = DISCRIPTION.getAuthors();
		VERSION = DISCRIPTION.getVersion();
		WEBSITE = DISCRIPTION.getWebsite();
	}
}
