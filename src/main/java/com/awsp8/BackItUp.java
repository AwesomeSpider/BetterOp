package com.awsp8;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class BackItUp
				extends JavaPlugin{
	
	public static Plugin instance;
	public File backups = new File(getDataFolder(), "/backups");
	
	@Override
	public void onEnable(){
		getLogger().info("[Back It Up]"
				+ "Why have you waken me Bukkit... Oh I have enable myself? Ok, I'm on it!");
		
		instance = this;
		configure();
		
		try {
			if (!backups.exists()){
				getLogger().info("[Back It Up] Backups folder not found, creating...");
				backups.mkdirs();
			} else {
				getLogger().info("[Back It Up] Backups folder found, loading...");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void onDisable(){
		getLogger().info("[Back It Up]"
				+ "Oh time to disable all ready? Ok, back to my nap...");
		
		instance = null;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("bit")) {
			player.sendMessage(new String[]{
				ChatColor.BLUE + "---------- Plugin Info ----------",
				ChatColor.GOLD + "Developer: AwesomeSpider8",
				ChatColor.GOLD +"Plugin Name: Back It Up",
				ChatColor.GOLD +"version: Beta 1.3.0",
				ChatColor.GOLD +"link: http://dev.bukkit.org/bukkit-plugins/back-it-up/",
				ChatColor.BLUE +"---------- End Of Message ----------"
			});
			return true;
		} else if(cmd.getName().equalsIgnoreCase("bit-backup")) {
			if (player.isOp() == true) {
					getServer().broadcastMessage(ChatColor.BLUE + "[Back It Up]" + 
													ChatColor.WHITE + "Server Backing up.");
					getServer().broadcastMessage(ChatColor.BLUE + "[Back It Up]" + 
													ChatColor.WHITE + "You may experience some lag. :)");
					
					File serverFile = new File(getConfig().get("location").toString());
					
					getLogger().info("[Back It Up] creating backup...");
					
					File serverBackupFile = new File(getDataFolder() + "/backups/server backup");
					serverBackupFile.mkdir();
					
					if (serverFile.exists() == true){
						getLogger().info("[Back It Up] Found your server, starting backup...");
						
						serverBackupFile = new File(getDataFolder() + "/backups/server backup/");
						serverFile = new File(getConfig().getString("location"));
						Copy.copyFile(serverFile.toPath(), serverBackupFile.toPath(), false, false);
						
						BackItUp.instance.getLogger().info("[Back It Up] Server Backed up without any errors :)");
						BackItUp.instance.getLogger().info("[Back It Up] You can find you backup at " + serverBackupFile.getAbsolutePath());
						
						BackItUp.instance.getServer().broadcastMessage(ChatColor.BLUE + "[Back It Up]" + ChatColor.WHITE + "Done Backing Up!");
					} else {
						BackItUp.instance.getLogger().info("[Back It Up] Server not found, stopping backup...");
					}
				} else {
				   player.sendMessage(ChatColor.RED + "You must be an op to backup the server!");
				}
		}
		return false; 
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		if (player.isOp())
			event.getPlayer().sendMessage("[Back It Up] It seems you are an op... Feel free to backup the server!");
	}
	
	public void configure(){
		try {
			File config = new File(getDataFolder(), "config.yml");
			if(!getDataFolder().exists())
				getDataFolder().mkdirs();
			if(!config.exists()){
				getLogger().info("[Back It Up] config.yml not found, creating...");
				saveConfig();
				
				getConfig().set("location", "where/is/your/server ");
				getConfig().set("schedule?", false);
				
				saveConfig();
			} else{
				getLogger().info("[Back It Up] config.yml found, loading...");
				
				boolean schedule = (boolean) getConfig().get("schedule?");
				if (schedule == true)
					getConfig().set("schedule?.time", "0:0");
			}
		} catch (Exception e){
			e.getStackTrace();
		}
		
	}
}
