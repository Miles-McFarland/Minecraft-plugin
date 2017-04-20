package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Kick implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

		// check if command executor is a player, as opposed to the server
		if (command.getName().equals("kick") && sender instanceof Player) {

			// cast sender to Player
			Player player = (Player) sender;

			// arguments 1 - first word entered after command, arguments 2 =
			// second word after command, etc
			// second word,etc
			int length = arguments.length;

			if (length == 1) {

				boolean playerFound = false;

				for (Player playerToKick : Bukkit.getServer().getOnlinePlayers()) {
					if (playerToKick.getName().equalsIgnoreCase(arguments[0])) {
						playerToKick.kickPlayer(ChatColor.RED + "Bye");
						player.sendMessage(ChatColor.GREEN + playerToKick.getName() + " was kicked successfully!");
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
