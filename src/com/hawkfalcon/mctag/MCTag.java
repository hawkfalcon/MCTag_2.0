package com.hawkfalcon.mctag;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.hawkfalcon.mctag.commands.TagCommand;
import com.hawkfalcon.mctag.listeners.TagListener;
import com.hawkfalcon.mctag.util.GlobalVariables;
import com.hawkfalcon.mctag.util.TagUtil;

public class MCTag extends JavaPlugin {
	Logger log;
	Listener listener;

	String commands = "Commands: \n /tag <join|leave> - join or leave the game \n /tag <start|stop> - start and stop game \n /tag it - view tagged player \n /tag players - view joined playrs \n /tag tagback <allow|forbid> - allow and forbid tagback \n /tag freezetag <on|off> - turn freeze tag on and off \n /tag reload - reloads the config \n /tag setspawn - set arena spawnpoint";


	public static TagUtil util;
	public static GlobalVariables vars;
	public static PluginManager pm;


	@Override
	public void onEnable() {
		saveDefaultConfig();
		util = new TagUtil(this);
		pm = getServer().getPluginManager();
		log = getLogger();
		pm.registerEvents(new TagListener(), this);
		getCommand("tag").setExecutor(new TagCommand(this));

		//new MetricsLite(this).start();

		//getLogger().log(Level.SEVERE, "MCTag failed to start!");
	}
}
