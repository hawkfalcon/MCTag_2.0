package com.hawkfalcon.mctag;

import java.util.ArrayList;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class Arena {

	private final ArrayList<Player> 	players = new ArrayList<Player>();
	private final ConfigurationSection 	config;
	private final String 				name;
	
	public Arena(String name, ConfigurationSection sect) {
		this.name = name;
		this.config = sect;
	}
	
	public boolean addPlayer(Player p) {
		if(players.contains(p)) return false;
		players.add(p);
		return true;
	}
	public boolean removePlayer(Player p) {
		if(!players.contains(p)) return false;
		players.remove(p);
		return true;
	}
	
}
