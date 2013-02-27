package com.hawkfalcon.mctag;

import java.util.ArrayList;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.hawkfalcon.mctag.events.TagEvent;

public class Arena implements Listener {

	private final MCTag					plugin;
	private final ArrayList<Player> 	players = new ArrayList<Player>();
	private final ConfigurationSection 	config;
	private final String 				name;
	
	public Arena(MCTag plugin, String name, ConfigurationSection sect) {
		this.plugin = plugin;
		this.name = name;
		this.config = sect;
	}
	
	public boolean addPlayer(Player p) {
		if(players.contains(p)) return false;
		players.add(p);
		return true;
	}
	public boolean removePlayer(Player p) {
		return players.remove(p);
	}
	
	@EventHandler
	public void onTag(TagEvent event) {
		
	}
	
	
}
