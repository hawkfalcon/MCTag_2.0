package com.hawkfalcon.mctag.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.hawkfalcon.mctag.MCTag;

public class EventListener implements Listener {
		public  MCTag plugin;
		public EventListener(MCTag plugin) {
			this.plugin = plugin;
		}
		
	    //stop placing while ingame
	 public void onBlockPlace(BlockPlaceEvent event) {
	        String player = event.getPlayer().getName();
	        if (plugin.playersPlaying.contains(player)) {
	            event.setCancelled(true);
	        }
	    }

	    //stop breaking while ingame
	    @EventHandler
	    public void onBlockBreak(BlockBreakEvent event) {
	        String player = event.getPlayer().getName();
	        if (plugin.playersPlaying.contains(player)) {
	            event.setCancelled(true);
	        }
	    }

	    //stop inventorymanagement while ingame
	    @EventHandler
	    public void onInventoryClick(InventoryClickEvent event) {
	        String player = event.getWhoClicked().getName();
	        if (plugin.playersPlaying.contains(player)) {
	            event.setCancelled(true);
	        }
	    }

}
