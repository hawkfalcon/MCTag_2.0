package com.hawkfalcon.mctag.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TagEvent extends Event {
	
	private static HandlerList handlers = new HandlerList();
	private final Player tagged;
	private final Player tagger;
	
	public TagEvent(Player tagged, Player tagger) {
		this.tagged = tagged;
		this.tagger = tagger;
	}
	
	public Player getTagged() {
		return this.tagged;
	}
	public Player getTagger() {
		return this.tagger;
	}
	
	
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
}
