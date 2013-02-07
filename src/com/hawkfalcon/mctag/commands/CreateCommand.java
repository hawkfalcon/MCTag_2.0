package com.hawkfalcon.mctag.commands;

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
			plugin.util.getArenas().set(arenaName+".tagBacks", true);
			plugin.util.getArenas().set(arenaName+".type", "normal");
			plugin.util.saveArenas();
			//TODO: Send success message
		}
		else {
			//TODO: Send not enough args message
		}
	}

}
