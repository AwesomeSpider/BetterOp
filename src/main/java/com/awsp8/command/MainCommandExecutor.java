package com.awsp8.command;

//import java.util.UUID;

//import org.bukkit.Server;
//import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;

public class MainCommandExecutor
					implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
								String label, String[] args) {
		//UUID playerUUID = CommandUtils.getUUID(args.toString());
		
		//Player player = (Player) sender;
		
		//Server server = player.getServer();
		//World world = player.getWorld();
		
		//Player target = server.getPlayer(playerUUID);
		
		/*if(cmd.getName().equalsIgnoreCase("betteropinfo")){
			if (args.length == 0) {
				String[] infoMessage = new String[] {
						ChatColor.GOLD + "--" + ChatColor.MAGIC + "-" + ChatColor.GOLD + "--" +
								ChatColor.DARK_BLUE + "BetterOp Info" + ChatColor.GOLD
									+ ChatColor.GOLD + "--" + ChatColor.MAGIC + "-" + ChatColor.GOLD + "--",
									
						ChatColor.DARK_PURPLE + "Name:" + ChatColor.GOLD + Metadata.NAME,
						ChatColor.DARK_PURPLE + "Version:" + ChatColor.GOLD + Metadata.VERSION,
						ChatColor.DARK_PURPLE + "Author:" + ChatColor.GOLD + Metadata.AUTHORS,
						ChatColor.DARK_PURPLE + "Website:" + ChatColor.GOLD + Metadata.WEBSITE,
						
						ChatColor.GOLD + "--" + ChatColor.MAGIC + "-" + ChatColor.GOLD + "--" +
								ChatColor.DARK_BLUE + "End Of Message" + ChatColor.GOLD
									+ ChatColor.GOLD + "--" + ChatColor.MAGIC + "-" + ChatColor.GOLD + "--"
						};
				
				player.sendMessage(infoMessage);
			}
			
			if (args.length == 1){
				if (args.toString() == "help"){
					String[] helpMessage = new String[] {
							ChatColor.GOLD + "--" + ChatColor.MAGIC + "-" + ChatColor.GOLD + "--" +
									ChatColor.DARK_BLUE + "Help with BetterOp" + ChatColor.GOLD
										+ ChatColor.GOLD + "--" + ChatColor.MAGIC + "-" + ChatColor.GOLD + "--",
										
							ChatColor.DARK_BLUE + BetterOp.instance.getCommand("ignite").getUsage()
														+ ChatColor.GOLD + " - " + ChatColor.GREEN +
															BetterOp.instance.getCommand("ignite").getDescription(),
							ChatColor.DARK_BLUE + BetterOp.instance.getCommand("strike").getUsage()
														+ ChatColor.GOLD + " - " + ChatColor.GREEN +
															BetterOp.instance.getCommand("strike").getDescription(),
							ChatColor.DARK_BLUE + BetterOp.instance.getCommand("killplayer").getUsage()
														+ ChatColor.GOLD + " - " + ChatColor.GREEN +
															BetterOp.instance.getCommand("killplayer").getDescription(),
							ChatColor.DARK_BLUE + BetterOp.instance.getCommand("wither").getUsage()
														+ ChatColor.GOLD + " - " + ChatColor.GREEN +
															BetterOp.instance.getCommand("wither").getDescription(),
							
							ChatColor.DARK_BLUE + BetterOp.instance.getCommand("healplayer").getUsage()
														+ ChatColor.GOLD + " - " + ChatColor.GREEN +
															BetterOp.instance.getCommand("healplayer").getDescription(),
							ChatColor.DARK_BLUE + BetterOp.instance.getCommand("boostplayer").getUsage()
														+ ChatColor.GOLD + " - " + ChatColor.GREEN +
															BetterOp.instance.getCommand("boostplayer").getDescription(),
							ChatColor.DARK_BLUE + BetterOp.instance.getCommand("diamond").getUsage()
														+ ChatColor.GOLD + " - " + ChatColor.GREEN +
															BetterOp.instance.getCommand("diamond"),
															
							ChatColor.AQUA + "For more information please go to " + Metadata.WEBSITE,
							
							ChatColor.GOLD + "--" + ChatColor.MAGIC + "-" + ChatColor.GOLD + "--" +
									ChatColor.DARK_BLUE + "End Of Message" + ChatColor.GOLD
										+ ChatColor.GOLD + "--" + ChatColor.MAGIC + "-" + ChatColor.GOLD + "--"
					};
					
					player.sendMessage(helpMessage);
				}
			}
			return true;	
		}*/
		return false;
	}

}
