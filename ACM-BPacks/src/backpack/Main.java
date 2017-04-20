package backpack;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{

	private HashMap<UUID, Inventory> backpacks = new HashMap<UUID, Inventory>();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Inventory inv = Bukkit.getServer().createInventory(e.getPlayer(), 9 ,"Backpack");
			backpacks.put(e.getPlayer().getUniqueId(), inv);
		}
		
public void onEnable(){
	Bukkit.getServer().getPluginManager().registerEvents(this, this);
}
public void onDisable(){
	for(Entry<UUID, Inventory> entry : backpacks.entrySet()){
		if(!getConfig().contains("backpacks." + entry.getKey())){
			getConfig().createSection("backpacks." + entry.getKey());
		}
		char c = 'a';
		for(ItemStack itemStack : entry.getValue()){
			if(itemStack != null){
				saveItem(getConfig().createSection("backpacks." + entry.getKey() + "." + c++), itemStack);
			}
		}
		saveConfig();
	}
}
@Override
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	if(!(sender instanceof Player)){
		sender.sendMessage(ChatColor.RED + "The console cannot have an backpack.");
		return true;
	}
	
	Player p = (Player) sender;
	
	if(cmd.getName().equals("backpack")){
		p.openInventory(backpacks.get(p.getUniqueId()));
	}
	return true;
}
private void saveItem(ConfigurationSection section, ItemStack itemStack){
	section.set("type", itemStack.getType().name());
	section.set("amount", itemStack.getAmount());
}

}