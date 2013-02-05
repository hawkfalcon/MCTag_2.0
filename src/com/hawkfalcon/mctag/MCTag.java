package com.hawkfalcon.mctag;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.hawkfalcon.mctag.commands.TagCommand;
import com.hawkfalcon.mctag.listeners.TagListener;
import com.hawkfalcon.mctag.util.TagPlayer;
import com.hawkfalcon.mctag.util.TagUtil;

public class MCTag extends JavaPlugin implements Listener {
	Logger log;
    Listener listener;

	String commands = "Commands: \n /tag <join|leave> - join or leave the game \n /tag <start|stop> - start and stop game \n /tag it - view tagged player \n /tag players - view joined playrs \n /tag tagback <allow|forbid> - allow and forbid tagback \n /tag freezetag <on|off> - turn freeze tag on and off \n /tag reload - reloads the config \n /tag setspawn - set arena spawnpoint";


    public static TagUtil util;
    public static GlobalVariables vars;
    public static PluginManager pm;
	//public CommandExecutor TagCommand = new TagCommand(this);


    @Override
    public void onEnable() {
    	final File f = new File(getDataFolder(), "config.yml");
		if (!f.exists()){
			saveDefaultConfig();
		}
        try {
            util = new TagUtil();
            pm = getServer().getPluginManager();
            log = getLogger();
    		pm.registerEvents(new TagListener(), this);
			//getCommand("Tag").setExecutor(TagCommand);

           // new MetricsLite(this).start();

        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "MCTag failed to start!");
        }
    }

    @Override
    public void onDisable() {
    }
}
