package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Spawn implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

		// check if command executor is a player, as opposed to the server
		if (command.getName().equals("spawn") && sender instanceof Player) {

			// cast sender to Player
			Player player = (Player) sender;

			// arguments 0 - first word entered after command, arguments 1 = second word after command, etc
			// second word,etc
			int length = arguments.length;

			if (length == 1) {

				boolean playerFound = false;

				for (Player playerToSpawn : Bukkit.getServer().getOnlinePlayers()) {
					if (playerToSpawn.getName().equalsIgnoreCase(arguments[0])) {
						playerToSpawn.teleport(playerToSpawn.getWorld().getSpawnLocation());
						playerToSpawn.sendMessage(ChatColor.GREEN + "You have been sent to spawn by " + player.getName() + "!");
						player.sendMessage(ChatColor.GREEN + playerToSpawn.getName() + " was successfully sent to spawn!");
						playerFound = true;
						break;
					}
				}

				if (playerFound == false) {
					player.sendMessage(ChatColor.RED + arguments[0] + " was not found!");

				}
			} else{
				
				player.sendMessage(ChatColor.RED + "Incorrect arugment");
			}
				return true;
		}
		return false;
	}

}
