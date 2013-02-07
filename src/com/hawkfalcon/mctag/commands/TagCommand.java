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
	public boolean onCommand(CommandSender cs, Command cmdObj, String label, String[] args) {
		if (cmdObj.getName().equalsIgnoreCase("tag")) {
			if(args.length == 0) {
				sendHelp(cs);
			}
			else {
				if(args[0].equalsIgnoreCase("create")) {
					
					return true;
				}
			}
		}
		return false;
	}

	public void sendHelp(CommandSender cs) {
		// TODO Auto-generated method stub
		
	}

}
