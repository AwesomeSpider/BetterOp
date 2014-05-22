package com.awsp8;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.awsp8.announcements.AnnouncementEngine;
import com.awsp8.announcements.ConfigureAnnouncements;
import com.awsp8.command.PunishCommandExecutor;
import com.awsp8.command.RewardCommandExecutor;
import com.awsp8.event.PlayerJoin;

public class BetterOp
				extends JavaPlugin{

	public static JavaPlugin instance;
	
	public File config;
	
	public static FileConfiguration playerUUIDs;
	public static File playerUUIDsFile;
	
	@Override
	public void onEnable(){
		getLogger().info("Thank you for downloading Better Op!");
		
		getLogger().info("Initializing...");
		instance = this;
		
		config = new File(this.getDataFolder(), "config.yml");
		
		playerUUIDsFile = new File(this.getDataFolder(), "UUID.yml");
		playerUUIDs = YamlConfiguration.loadConfiguration(playerUUIDsFile);
		getLogger().info("Done Initializing!");
		
		getLogger().info("Loading Commands...");
		
		// Set Executors
		getCommand("ignite").setExecutor(new PunishCommandExecutor());
		getCommand("strike").setExecutor(new PunishCommandExecutor());
		getCommand("hurt").setExecutor(new PunishCommandExecutor());
		getCommand("wither").setExecutor(new PunishCommandExecutor());
		
		getCommand("healplayer").setExecutor(new RewardCommandExecutor());
		getCommand("boostplayer").setExecutor(new RewardCommandExecutor());
		getCommand("diamond").setExecutor(new RewardCommandExecutor());
		
		getLogger().info("Done Loading Commands!");
		
		getLogger().info("Registering Events...");
		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		getLogger().info("Done Registering Events!");
		
		getLogger().info("Configuring...");
		try {
			configure();
		} catch (IOException | InvalidConfigurationException e) {
			getLogger().warning("Better Op came across a problem when configuring."
					+ " Displaying the error...");
			getLogger().warning(e.getMessage());
			e.printStackTrace();
		}
		getLogger().info("Done configuring!");
		
		if (getConfig().getBoolean("schedule.enable") == true)
			AnnouncementEngine.runLoop();
	}
	
	public void configure()
					throws IOException, InvalidConfigurationException{
		if (!this.getDataFolder().exists()){
			getLogger().info("Data Folder not found, creating...");
			this.getDataFolder().mkdir();
		}
		
		if (!config.exists()){
			getLogger().info("Config.yml not found, creating...");
			saveDefaultConfig();
			getConfig().createSection("schedule");
			getConfig().addDefault("schedule.enabled", false);
			getConfig().addDefault("schedule.time", 6000);
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		
		if(config.exists()){
			getLogger().info("Config.yml found, loading...");
			getConfig().load(config);
		}
		
		if (!playerUUIDsFile.exists()){
			getLogger().info("UUID.yml not found, creating...");
			playerUUIDs.createSection("UUIDs");
			playerUUIDs.save(playerUUIDsFile);
		}
		
		if(playerUUIDsFile.exists()){
			getLogger().info("UUID.yml found, loading...");
			playerUUIDs.load(playerUUIDsFile);
		}
		
		ConfigureAnnouncements.configure();
	}
}
