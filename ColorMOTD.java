package com.loslobos1234.colormotd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ColorMotd extends JavaPlugin implements Listener{
	
	
	@Override
	public void onEnable(){
		// Registers initializations for startup.
		getServer().getPluginManager().registerEvents(this, this); // Registers events.
		getConfig().options().copyDefaults(true); // Saves default configuration file.
		saveDefaultConfig(); // Saves edited configuration file.
	}
	
	@Override
	public void onDisable(){
		saveConfig(); // Saves edited configuration file.
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(!(sender.hasPermission("colormotd.set"))){ // Checks if the CommandSender sender has the required permission to proceed else it cancels any command actions.
			sender.sendMessage(ChatColor.RED + "No Permission to use this command!");
			return true;
		} 
		
		if(cmd.getName().equalsIgnoreCase("cmotd")){ // Checks if the command is sent, initialized.
			if(args.length < 1){
				sender.sendMessage(ChatColor.RED + "/cmotd set <motd>");
				return true;
			}else{
				if(args[0].equalsIgnoreCase("set")){

					StringBuilder sb = new StringBuilder();
					
					for(int i=1;i<args.length;i++){
						sb.append(args[i]);
						sb.append(" ");
					}
					
					String res = sb.toString();
				
					getConfig().set("motd", res);
					saveConfig();
					sender.sendMessage(ChatColor.GOLD + "MOTD set to: " + ChatColor.RESET + res + ChatColor.GOLD + " !");
					
				}
			}
		}else if(cmd.getName().equalsIgnoreCase("cmotdrl")){
			reloadConfig(); // Reloads config.
			sender.sendMessage(ChatColor.GOLD + "Config Reloaded!"); // Sends player a notification.
		}
		
		return true;
	}
	
	
	@EventHandler // Required to be put above an event to tell Bukkit : "Hey this is an event and you need to run it!".
	public void onServerListPing(ServerListPingEvent e){
	    String motd = getConfig().getString("motd"); // Gets MOTD from configuration file.
	    motd = motd.replaceFirst("%newline%", "\n"); // Replaces %nl% variable with a line break.
	    motd = motd.replaceAll("%servername%", Bukkit.getServerName()); // Replaces %servername% variable with the server name.
	    motd = motd.replaceAll("%onlineplayers%", String.valueOf(e.getNumPlayers())); // replaces %onlineplayers% with the playercount in realtime!
	    motd = motd.replaceAll("%maxplayers%", String.valueOf(e.getMaxPlayers())); // replaces %maxplayers% with the server player cap!
	    motd = motd.replaceAll("%ip%", e.getAddress().toString()); // replaces %ip% with the server raw ip!
        motd = motd.replaceAll("&", "\u00A7"); // Replaces & with \u00A7 so the MOTD supports colors.
        e.setMotd(motd); // Sets MOTD.
		
	}
}
