package com.hawkfalcon.mctag.util;

import org.bukkit.entity.Player;

import com.hawkfalcon.mctag.MCTag;

public class TagPlayer {

	public static MCTag plugin;
	
	protected Player player;
	
	
	public TagPlayer(MCTag plugin, Player player){
		TagPlayer.plugin = plugin;
		this.player = player;
	}
	
	public static TagPlayer getPlayer(Player player){
		return new TagPlayer(plugin, player);
	}
	
	public String getName(){
		return player.getName();
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public String getArena(){
		if(plugin.getPlayerMap().containsKey(player.getName()))return plugin.getPlayerMap().get(player.getName());
		return "none";
	}
}
