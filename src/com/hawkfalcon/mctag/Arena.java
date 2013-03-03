package com.hawkfalcon.mctag;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.hawkfalcon.mctag.events.TagEvent;

public class Arena implements Listener {

	private final MCTag					plugin;
	private final ConfigurationSection 	config;
	private final String 				name;
	
	public Arena(MCTag plugin, String name, ConfigurationSection sect) {
		this.plugin = plugin;
		this.name = name;
		this.config = sect;
	}
	public boolean addPlayer(Player p) {
		if(plugin.getPlayerMap().containsKey(p.getName())) return false;
		plugin.getPlayerMap().put(p.getName(), name);
		return true;
	}
	public boolean removePlayer(Player p) {
		if(!plugin.getPlayerMap().containsKey(p.getName())) return false;
		plugin.getPlayerMap().remove(p.getName());
		return true;
	}
	
	@EventHandler
	public void onTag(TagEvent event) {
		
	}
	
	
}
