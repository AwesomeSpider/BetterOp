package com.awsp8.command;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RewardCommandExecutor
				implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
								String label, String[] args) {
		UUID playerUUID = CommandUtils.getUUID(args.toString());
		
		Player player = (Player) sender;
		
		Server server = player.getServer();
		World world = player.getWorld();
		
		Player target = server.getPlayer(playerUUID);
				
		Sound rewardSound = Sound.LEVEL_UP;
		
		if (cmd.getName().equalsIgnoreCase("healplayer")){
			if (player.isOp())
			if (args.length == 1){
				world.playSound(target.getLocation(), rewardSound, 10, 1);
				
				target.setHealth(target.getMaxHealth());
				target.sendMessage("[Better Op] the op '" +
										player.getName() +
												"' has rewarded you!");
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("boostplayer")){
			if (player.isOp())
			if (args.length == 1){
				PotionEffect regen = new PotionEffect(PotionEffectType.REGENERATION, 60, 2);
				PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 60, 10);
				PotionEffect jump = new PotionEffect(PotionEffectType.JUMP, 60, 5);
				PotionEffect healthBoost= new PotionEffect(PotionEffectType.HEALTH_BOOST, 120, 10);
				
				world.playSound(target.getLocation(), rewardSound, 10, 1);
				
				target.addPotionEffect(regen);
				target.addPotionEffect(speed);
				target.addPotionEffect(jump);
				target.addPotionEffect(healthBoost);
				target.sendMessage("[Better Op] the op '" +
										player.getName() +
											"' has rewarded you!");
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("diamond")){
			if (player.isOp())
			if (args.length == 1){
				world.playSound(target.getLocation(), rewardSound, 10, 1);
				
				world.dropItem(target.getLocation(), new ItemStack(Material.DIAMOND, 10));
				world.dropItem(target.getLocation(), new ItemStack(Material.DIAMOND_HELMET));
				world.dropItem(target.getLocation(), new ItemStack(Material.DIAMOND_CHESTPLATE));
				world.dropItem(target.getLocation(), new ItemStack(Material.DIAMOND_LEGGINGS));
				world.dropItem(target.getLocation(), new ItemStack(Material.DIAMOND_BOOTS));
				world.dropItem(target.getLocation(), new ItemStack(Material.DIAMOND_SWORD));
				target.sendMessage("[Better Op] the op '" +
										player.getName() +
											"' has rewarded you!");
			}
			return true;
		}
		return false;
	}

}
