package com.hawkfalcon.mctag;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import com.hawkfalcon.mctag.util.ErrorMessage;
import com.hawkfalcon.mctag.util.GameType;

public class Game {
	
	MCTag plugin;
	FileConfiguration arenas;
	private final String name;
	private Location spawnLoc;
	private Location lobbyLoc;
	private GameType type = GameType.NORMAL;
	private boolean tagBacks = true;
	
	public Game(MCTag mct, String n) {
		this.plugin = mct;
		this.name = n;
		this.arenas = plugin.util.getArenas(); //Should that actually be static?
	}
	
	public ErrorMessage loadArena() {
		if(!this.arenas.getKeys(false).contains(name)) {
			return ErrorMessage.ARENA_INVALID;
			//Arena doesn't exist
		}
		String spawnWorld = this.arenas.getString(name+".world");
		World w = Bukkit.getWorld(spawnWorld);
		Double spawnX = this.arenas.getDouble(name+".spawnLoc.x");
		Double spawnY = this.arenas.getDouble(name+".spawnLoc.y");
		Double spawnZ = this.arenas.getDouble(name+".spawnLoc.z");
		if(spawnX == null || spawnY == null || spawnZ == null) return ErrorMessage.SPAWN_INVALID;
		this.spawnLoc = new Location(w,spawnX,spawnY,spawnZ);
		Double lobbyX = this.arenas.getDouble(name+".lobbyLoc.x");
		Double lobbyY = this.arenas.getDouble(name+".lobbyLoc.y");
		Double lobbyZ = this.arenas.getDouble(name+".lobbyLoc.z");
		if(lobbyX == null || lobbyY == null || lobbyZ == null) return ErrorMessage.LOBBY_INVALID;
		this.lobbyLoc = new Location(w,lobbyX,lobbyY,lobbyZ);
		this.type = GameType.valueOf(this.arenas.getString(name+".type","NORMAL").toUpperCase());
		this.tagBacks = this.arenas.getBoolean(name+".tagBacks",true);
		return null;
	}
	
	public Location getSpawnLocation() {
		return this.spawnLoc;
	}
	public Location getLobbyLocation() {
		return this.lobbyLoc;
	}
	public boolean getTagBacks() {
		return this.tagBacks;
	}
	public GameType getGameType() {
		return this.type;
	}

}
