package com.hawkfalcon.mctag.util;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.World;

public class Arena {
	
	Location spawnPoint;
	Location lobbyPoint;
	String name;
	boolean tagBacks = true;
	ArenaGameType type = ArenaGameType.NORMAL;
	GameState state = GameState.OVER;
	HashMap<String, PlayerState> players = new HashMap<String, PlayerState>();
	
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
	
	public void setTagBacks(boolean b) {
		this.tagBacks = b;
	}
	public boolean getTagBacks() {
		return this.tagBacks;
	}

	public boolean addPlayer(String p) {
		if(this.players.containsKey(p)) {
			return false;
		}
		this.players.put(p, PlayerState.INLOBBY);
		return true;
	}
	public boolean removePlayer(String p) {
		if(this.players.containsKey(p)) {
			this.players.remove(p);
			return true;
		}
		return false;
	}
	public void clearPlayers() {
		this.players.clear();
	}
	public boolean setPlayerState(String p, PlayerState ps) {
		return true;
		//TODO: Finish this when I can think straight
	}
	public HashMap<String, PlayerState> getPlayers() {
		return this.players;
	}
	
}
