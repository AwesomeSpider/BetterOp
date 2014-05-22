package com.awsp8.announcements;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.awsp8.BetterOp;

public class ConfigureAnnouncements {

	public static FileConfiguration announcements;
	static File announcementsFile;
	
	public static void configure()
			throws IOException, InvalidConfigurationException{
		announcementsFile = new File(BetterOp.instance.getDataFolder(), "announcements.yml");
		announcements = YamlConfiguration.loadConfiguration(announcementsFile);
		
		if (!announcementsFile.exists()){
			BetterOp.instance.getLogger().info("Announcements.yml not found, creating...");			
				announcements.createSection(" announcement1");
				announcements.addDefault(" announcement1.Tag", "Default");
				announcements.addDefault(" announcement1.Message", "Default");
				announcements.addDefault(" announcement1.TagColor", "&f");
				announcements.addDefault(" announcement1.MessageColor", "&f");
			
				announcements.createSection(" announcement2");
				announcements.addDefault(" announcement2.Tag", "Default");
				announcements.addDefault(" announcement2.Message", "Default");
				announcements.addDefault(" announcement2.TagColor", "&f");
				announcements.addDefault(" announcement2.MessageColor", "&f");
			
				announcements.createSection(" announcement3");
				announcements.addDefault(" announcement3.Tag", "Default");
				announcements.addDefault(" announcement3.Message", "Default");
				announcements.addDefault(" announcement3.TagColor", "&f");
				announcements.addDefault(" announcement3.MessageColor", "&f");
			
				announcements.createSection(" announcement4");
				announcements.addDefault(" announcement4.Tag", "Default");
				announcements.addDefault(" announcement4.Message", "Default");
				announcements.addDefault(" announcement4.TagColor", "&f");
				announcements.addDefault(" announcement4.MessageColor", "&f");
		
				announcements.createSection(" announcement5");
				announcements.addDefault(" announcement5.Tag", "Default");
				announcements.addDefault(" announcement5.Message", "Default");
				announcements.addDefault(" announcement5.TagColor", "&f");
				announcements.addDefault(" announcement5.MessageColor", "&f");
		
			announcements.options().copyDefaults(true);
			announcements.save(announcementsFile);
		}
		
		if (announcementsFile.exists()){
			BetterOp.instance.getLogger().info("Announcements.yml found, loading...");
			announcements.load(announcementsFile);
			
			announcements.options().copyDefaults(true);
			announcements.save(announcementsFile);
		}
	}
}
