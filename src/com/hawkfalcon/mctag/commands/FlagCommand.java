package com.hawkfalcon.mctag.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.hawkfalcon.mctag.MCTag;

public class FlagCommand {

	MCTag plugin;
	
	public FlagCommand(MCTag p) {
		this.plugin = p;
	}

	public void execute(CommandSender cs, String[] args) {
		String arenaName = args[1].toLowerCase();
		if(!plugin.util.getArenas().getKeys(false).contains(arenaName)) {
			cs.sendMessage(ChatColor.RED+"There is no arena named that!");
			return;
		}
		if(cs.hasPermission("mctag.arena.flag")) {
			if(args.length == 3) {
				if(cs instanceof Player) {
					Player p = (Player) cs;
					Location l = p.getLocation();
					String w = l.getWorld().getName();
					int x = l.getBlockX();
					int y = l.getBlockY();
					int z = l.getBlockZ();
					if(args[2].equalsIgnoreCase("spawnloc")) {
						plugin.util.getArenas().set(arenaName+".world", w);
						plugin.util.getArenas().set(arenaName+".spawnLoc.x", x);
						plugin.util.getArenas().set(arenaName+".spawnLoc.y", y);
						plugin.util.getArenas().set(arenaName+".spawnLoc.z", z);
						plugin.util.saveArenas();
						p.sendMessage(ChatColor.GREEN+"Set arena spawn for arena: "+arenaName+"!");
						return;
					}
					if(args[2].equalsIgnoreCase("lobby")) {
						plugin.util.getArenas().set(arenaName+".world", w);
						plugin.util.getArenas().set(arenaName+".lobbyLoc.x", x);
						plugin.util.getArenas().set(arenaName+".lobbyLoc.y", y);
						plugin.util.getArenas().set(arenaName+".lobbyLoc.z", z);
						plugin.util.saveArenas();
						p.sendMessage(ChatColor.GREEN+"Set lobby spawn for arena: "+arenaName+"!");
						return;
					}
					else {
						sendAvailableFlags(cs);
					}
				}
				else {
					cs.sendMessage(ChatColor.RED+"You need to be a player to do that!");
					return;
				}
			}
			else if(args.length == 4) {
				if(args[2].equalsIgnoreCase("tagbacks")) {
					if(args[3].equalsIgnoreCase("true") || args[3].equalsIgnoreCase("false")) {
						plugin.util.getArenas().set(arenaName+".tagBacks", args[3].toLowerCase());
						plugin.util.saveArenas();
						cs.sendMessage(ChatColor.GREEN+"Set TagBacks for arena: "+arenaName+"!");
						return;
					}
					else {
						cs.sendMessage(ChatColor.RED+"Wrong arguments!");
						cs.sendMessage(ChatColor.RED+"Usage: /<command> flag <arenaName> tagbacks <true|false>");
						return;
					}
				}
				else if(args[2].equalsIgnoreCase("type")) {
					if(args[3].equalsIgnoreCase("normal") || args[3].equalsIgnoreCase("freeze")) {
						plugin.util.getArenas().set(arenaName+".type", args[3].toLowerCase());
						plugin.util.saveArenas();
						cs.sendMessage(ChatColor.GREEN+"Set game type for arena: "+arenaName+"!");
						return;
					}
					else {
						cs.sendMessage(ChatColor.RED+"Wrong arguments!");
						cs.sendMessage(ChatColor.RED+"Usage: /<command> flag <arenaName> type <normal|freeze>");
						return;
					}
				}
				else {
					sendAvailableFlags(cs);
				}
			}
		}
		else {
			cs.sendMessage(ChatColor.RED+"You don't have permission to do that!");
		}
	}

	private void sendAvailableFlags(CommandSender cs) {
		// TODO Add available flags here
		
	}

}
