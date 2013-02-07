package com.hawkfalcon.mctag.commands;

import org.bukkit.command.CommandSender;

import com.hawkfalcon.mctag.MCTag;

public class FlagCommand {

	MCTag plugin;
	
	public FlagCommand(MCTag p) {
		this.plugin = p;
	}

	public void execute(CommandSender cs, String[] args) {
		if(args.length == 3) {
			String arenaName = args[1];
		}
		
	}

}
