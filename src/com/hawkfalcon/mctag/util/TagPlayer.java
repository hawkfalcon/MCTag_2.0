package com.hawkfalcon.mctag.util;

import com.hawkfalcon.mctag.MCTag;

public class TagPlayer {
	
	MCTag plugin;
	private final String name;

	public TagPlayer(String n, MCTag p) {
		this.name = n.toLowerCase();
		this.plugin = p;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	
	
}
