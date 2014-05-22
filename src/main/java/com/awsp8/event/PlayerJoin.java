package com.awsp8.event;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.awsp8.BetterOp;

public class PlayerJoin
				implements Listener{
	
	@EventHandler
	public static void onPlayerLogin(PlayerLoginEvent event){
		Player player = event.getPlayer();
		
		String UUID = player.getUniqueId().toString();
		
		BetterOp.instance.getLogger().info(player.getName() + " Joined the server, saving UUID...");
		
		BetterOp.playerUUIDs.set("UUIDs." + player.getName(), UUID);
		
		try {
			BetterOp.playerUUIDs.save(BetterOp.playerUUIDsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
