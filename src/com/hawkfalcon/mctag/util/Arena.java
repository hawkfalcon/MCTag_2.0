package com.hawkfalcon.mctag.util;

import org.bukkit.Location;
import org.bukkit.World;

public class Arena {
	
	Location spawnPoint;
	Location lobbyPoint;
	String name;
	ArenaGameType type = ArenaGameType.NORMAL;
	GameState state = GameState.OVER;
	
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
	
	public void setArenaGameType(ArenaGameType agt) {
		this.type = agt;
	}
	public ArenaGameType getArenaGameType() {
		return this.type;
	}
	
	public void setGameState(GameState gs) {
		this.state = gs;
	}
	public GameState getGameState() {
		return this.state;
	}
	
}
