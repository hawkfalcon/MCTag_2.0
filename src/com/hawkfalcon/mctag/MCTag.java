package com.hawkfalcon.mctag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
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
	//placeholder, replaced with hashmap used to store playing players
	public ArrayList<String> playersPlaying = new ArrayList<String>();
	public Map<String, String> inGamePlayers = new HashMap<String, String>(); // <Player's Name, Arena's Name>
	public Map<String, Inventory> inventoryKeeper = new HashMap<String, Inventory>(); // <Player's Name, new Inventory with player's inventory's contents

	public TagUtil util;
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
	}
	
	public Map<String, String> getPlayerMap(){
		return inGamePlayers;
	}
	
	public ArrayList<String> getPlayerList(){
		return playersPlaying;
	}
	
	public boolean checkGameRunning(String arena){
		return false;
	}
	
	
}
