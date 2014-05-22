package com.awsp8.command;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * The Command Executor for the command that punish a player.
 * @author AwesomeSpider8
 */
public class PunishCommandExecutor
				implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
								String label, String[] args) {
		UUID playerUUID = CommandUtils.getUUID(args.toString());
		
		Player player = (Player) sender;
		
		Server server = player.getServer();
		World world = player.getWorld();
		
		Player target = server.getPlayer(playerUUID);
		
		Sound punishSound = Sound.CAT_HISS;
		
		if (cmd.getName().equalsIgnoreCase("ignite")){
			if (player.isOp() == true)
			if (args.length == 1){
				world.playSound(target.getLocation(), punishSound, 10, 1);
				
				target.setFireTicks(100);
				target.sendMessage(ChatColor.GOLD +
										"[Better Op] The Op '" +
											player.getName() + 
												"' has punished you!");
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("strike")){
			if (player.isOp() == true)
			if (args.length == 1){
				world.playSound(target.getLocation(), punishSound, 10, 1);
				
				world.strikeLightning(target.getLocation());
				target.sendMessage(ChatColor.GOLD +
										"[Better Op] The Op '" +
											player.getName() +
												"' has punished you!");
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("hurt")){
			if (player.isOp() == true)
			if (args.length == 1){
			world.playSound(target.getLocation(), punishSound, 10, 1);	
				
			double health = target.getMaxHealth();
			
			target.sendMessage(ChatColor.GOLD +
									"[Better Op] The Op '" +
										player.getName() +
											"' has punished you!");
			
			target.setHealth(health - 2);
			target.setHealth(health - 2);
			target.setHealth(health - 2);
			target.setHealth(health - 2);
			target.setHealth(health - 2);
			target.setHealth(health - 2);
			target.setHealth(health - 2);
			target.setHealth(health - 2);
			target.setHealth(health - 2);
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("wither")){
			if (player.isOp() == true)
			if (args.length == 1){
			world.playSound(target.getLocation(), punishSound, 10, 1);	
				
			PotionEffect pe = new PotionEffect(PotionEffectType.WITHER, 60, 1);
			target.addPotionEffect(pe);
			target.sendMessage(ChatColor.GOLD +
									"[Better Op] The Op '" +
										player.getName() +
											"' has punished you!");
			}
			return true;
		}
		return false;
	}

}
