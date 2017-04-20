package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Help implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

		// check if command executor is a player, as opposed to the server
		if (command.getName().equals("help") && sender instanceof Player) {

			// cast sender to Player
			Player player = (Player) sender;

			// arguments 1 - first word entered after command, arguments 2 = second word after command, etc
			// second word,etc
			int length = arguments.length;

			if (length == 1) {

				boolean playerFound = false;

				for (Player playerToFeed : Bukkit.getServer().getOnlinePlayers()) {
					if (playerToFeed.getName().equalsIgnoreCase(arguments[0])) {
						sender.sendMessage(ChatColor.GRAY+ "List of Commmands");

						sender.sendMessage(ChatColor.YELLOW + "/help <user>");
						sender.sendMessage(ChatColor.YELLOW + "/setspawn <user> ");
						sender.sendMessage(ChatColor.YELLOW + "/spawn <user>");
						sender.sendMessage(ChatColor.YELLOW + "/heal <user> ");
						sender.sendMessage(ChatColor.YELLOW + "/feed <user> ");
						sender.sendMessage(ChatColor.YELLOW + "/killed <user> ");
						sender.sendMessage(ChatColor.YELLOW + "/kick <user> ");
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
