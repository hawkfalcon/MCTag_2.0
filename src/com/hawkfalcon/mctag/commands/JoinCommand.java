package com.hawkfalcon.mctag.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.hawkfalcon.mctag.MCTag;

public class JoinCommand {
	MCTag plugin;
	
	public JoinCommand(MCTag mct) {
		this.plugin = mct;
	}

	public void execute(CommandSender cs, String[] args) {
		if(cs instanceof Player) {
			if(args.length == 2) {
				String arena = args[1];
				if(plugin.checkGameExists(arena)) {
					//Game in session
				}
				else {
					if(plugin.checkArenaExists(arena)) {
						plugin.makeNewGame(arena);
						//Arena exists
					}
					else {
						//Arena doesn't exist
					}
				}
			}
			else {
				//Show syntax
			}
		}
		else {
			//Console can't join a game!
		}
	}
}
