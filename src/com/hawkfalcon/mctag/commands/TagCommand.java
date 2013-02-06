package com.hawkfalcon.mctag.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.hawkfalcon.mctag.MCTag;

public class TagCommand implements CommandExecutor {

	MCTag plugin;

	public TagCommand(MCTag mct) {
		this.plugin = mct;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tag")) {
			
		}
		return false;
	}

}
