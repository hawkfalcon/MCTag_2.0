package com.hawkfalcon.mctag.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.hawkfalcon.mctag.MCTag;

public class CreateCommand {

	MCTag plugin;
	
	public CreateCommand(MCTag p) {
		this.plugin = p;
	}

	public void execute(CommandSender cs, String[] args) {
		if(args.length == 2) {
			String arenaName = args[1];
			for(String name:plugin.util.getArenas().getKeys(false)) {
				if(name.toLowerCase().equalsIgnoreCase(arenaName)) {
					cs.sendMessage(ChatColor.RED+"There is already an arena named that!");
					return;
				}
			}
			plugin.util.getArenas().set(arenaName+".type", "normal");
			plugin.util.getArenas().set(arenaName+".tagBacks", true);
			plugin.util.saveArenas();
			cs.sendMessage(ChatColor.GREEN+"Sucessfully created arena!s");
			return;
		}
		else {
			cs.sendMessage(ChatColor.RED+"Wrong number of arguments!");
			cs.sendMessage(ChatColor.RED+"Usage: /<command> <arenaName>");
			return;
		}
	}

}
