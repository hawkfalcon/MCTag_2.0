package com.hawkfalcon.mctag.util;

import org.bukkit.Location;
import org.bukkit.World;

public class Arena {
	
	Location spawnPoint;
	Location lobbyPoint;
	String name;
	ArenaConfiguration config;
	
	public Arena(String n) {
		this.name = n;
	}
	
	public void setSpawnPoint(World w, double x, double y, double z) {
		this.spawnPoint = new Location(w,x,y,z);
	}
	public void setSpawnPoint(Location l) {
		this.spawnPoint = l;
	}
	public Location getSpawnPoint() {
		return this.spawnPoint;
	}
	
	public void setLobbyPoint(World w, double x, double y, double z) {
		this.lobbyPoint = new Location(w,x,y,z);
	}
	public void setLobbyPoint(Location l) {
		this.lobbyPoint = l;
	}
	public Location getLobbyPoint() {
		return this.lobbyPoint;
	}
	
	public void setArenaConfiguration(ArenaConfiguration ac) {
		this.config = ac;
	}
	public ArenaConfiguration getArenaConfiguration() {
		return this.config;
	}
}
