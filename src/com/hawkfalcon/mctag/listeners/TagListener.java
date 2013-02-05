package com.hawkfalcon.mctag.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.hawkfalcon.mctag.MCTag;

public class TagListener implements Listener {
	 @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	    public void onTag(EntityDamageByEntityEvent event) {
	     if ((event.getEntity() instanceof Player && event.getDamager() instanceof Player)) {

	            String damager = ((Player) event.getDamager()).getName(), player = ((Player) event.getEntity()).getName();
	            if (!MCTag.vars.tag_damage) {
	                event.setCancelled(true);
	            }
	 
	 }
}
}
