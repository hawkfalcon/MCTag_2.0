package com.hawkfalcon.mctag.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.hawkfalcon.mctag.MCTag;

public class TagUtil {
	
	public  MCTag plugin;
	public  File arenasFile;
	public  FileConfiguration arenas;
	
	public TagUtil(MCTag plugin) {
		this.plugin = plugin;
	}
	
	
	public  void reloadArenas() {
	    if (arenasFile == null) {
	    	arenasFile = new File(plugin.getDataFolder(), "arenas.yml");
	    }
	    arenas = YamlConfiguration.loadConfiguration(arenasFile);
	}

	
	public  FileConfiguration getArenas() {
	    if (arenas == null) {
	        this.reloadArenas();
	    }
	    return arenas;
	}
	
	public  void saveArenas() {
	    if (arenas == null || arenas == null) {
	    return;
	    }
	    try {
	    	getArenas().save(arenasFile);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save config to " + arenas, ex);
	    }
	}
	
	
}
