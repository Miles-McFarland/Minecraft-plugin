package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Feed implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

		// check if command executor is a player, as opposed to the server
		if (command.getName().equals("feed") && sender instanceof Player) {

			// cast sender to Player
			Player player = (Player) sender;

			// arguments 1 - first word entered after command, arguments 2 =
			// second word after command, etc
			// second word,etc
			int length = arguments.length;

			if (length == 1) {

				boolean playerFound = false;

				for (Player playerToFeed : Bukkit.getServer().getOnlinePlayers()) {
					if (playerToFeed.getName().equalsIgnoreCase(arguments[0])) {
						playerToFeed.setFoodLevel(20);
						playerToFeed.sendMessage(ChatColor.GREEN + "You have been feeded by " + player.getName() + "!");
						player.sendMessage(ChatColor.GREEN + playerToFeed.getName() + " was feeded successfully!");
						playerFound = true;
						break;
					}
				}

				if (playerFound == false) {
					player.sendMessage(ChatColor.RED + arguments[0] + " was not found!");

				}
			} else {

				player.sendMessage(ChatColor.RED + "Incorrect arugment");
			}
			return true;
		}
		return false;
	}

}
