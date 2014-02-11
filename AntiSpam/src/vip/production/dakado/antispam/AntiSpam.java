package vip.production.dakado.antispam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiSpam extends JavaPlugin implements Listener {
	
	
	
	public void onEnable() {
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		
		
		
	}
	public void onDisable() {}
	
	
	
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent e) {		
		FileConfiguration config = getConfig();
		final Player hrac = e.getPlayer();		
		String svet = hrac.getWorld().getName();		
		String setworld = config.getString("svet");
		String svet1 = svet; String svet2 = setworld;
		
		if (svet1.equals(svet2)) {
			
			
			
			boolean chat = config.getBoolean("Chat." + hrac.getName());
			
			if (chat == true) { 
				
				hrac.sendMessage(ChatColor.RED + "Nemuzes tipovat tak casto!");
				e.setCancelled(true);
				}
			
			if (chat == false) {
			config.set("Chat." + hrac.getName(), true);
			saveConfig();
			
			
			
			
		    getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
		    	 
		        public void run() {
		        	
		        	FileConfiguration config = getConfig();
		        	config.set("Chat." + hrac.getName(), false);
		        	saveConfig();
			
			
		        }
		      }, config.getInt("Cas")*20L); }
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	

}
