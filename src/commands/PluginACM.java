package commands;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginACM extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("onEnable has started!");

		// note any commands must be registered in "plugin.yml"

		//// set the executor class for the "spawn" command
		Spawn Spawn = new Spawn();
		this.getCommand("Spawn").setExecutor(Spawn);

		// set the executor class for the "set spawn" command
		SetSpawn SetSpawn = new SetSpawn();
		this.getCommand("SetSpawn").setExecutor(SetSpawn);

		// set the executor class for the "heal" command
		Heal Heal = new Heal();
		this.getCommand("Heal").setExecutor(Heal);
		
		// set the executor class for the "feed" command
		Feed Feed = new Feed();
		this.getCommand("Feed").setExecutor(Feed);
		// set the executor class for the "help" command
		Help Help = new Help();
		this.getCommand("Help").setExecutor(Help);
		// set the executor class for the "kill" command
		Kill Kill = new Kill();
		this.getCommand("Kill").setExecutor(Kill);
		// set the executor class for the "kick" command
		Kick Kick = new Kick();
		this.getCommand("Kick").setExecutor(Kick);
		
	}
	@Override
	public void onDisable() {
		getLogger().info("onDisable has stated");
	}
}
