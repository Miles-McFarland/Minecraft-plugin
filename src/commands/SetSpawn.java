package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class SetSpawn implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

		// check if command executor is a player, as opposed to the server
		if (command.getName().equals("setspawn") && sender instanceof Player) {

			// cast sender to Player
			Player player = (Player) sender;

			// arguments 1 - first word entered after command, arguments 2 = second word after command, etc
			// second word,etc
			int length = arguments.length;

			if (length == 1) {

				boolean playerFound = false;

				for (Player playerToSetSpawn : Bukkit.getServer().getOnlinePlayers()) {
					if (playerToSetSpawn.getName().equalsIgnoreCase(arguments[0])) {
						playerToSetSpawn.getWorld().setSpawnLocation(getLocX(player), getLocY(player), getLocZ(player));
						playerToSetSpawn.sendMessage(ChatColor.GREEN + "Your spawn has been set by " + player.getName() + "!");
						player.sendMessage(ChatColor.GREEN + playerToSetSpawn.getName() + " spawn was successfully set!");
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
	private int getLocX(Player player) {
		return player.getLocation().getBlockX(); // get player x-location
	}

	private int getLocY(Player player) {
		return player.getLocation().getBlockY(); // get player y-location
	}

	private int getLocZ(Player player) {
		return player.getLocation().getBlockZ(); // get player z-location
	}
}