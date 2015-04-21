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
			if(args.length < 2){
				sender.sendMessage(ChatColor.RED + "/cmotd set <motd>");
				return true;
			}else{
				if(args[0].equalsIgnoreCase("set")){
					
					// Checks for Command Length example: /<command> args[0] args[1] args[2] etc...
					
					if(args.length == 2){
						String motd = args[1]; // Gets the MOTD from the command.
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 3){
						String motd = args[1]+" "+args[2]; // Gets the MOTD from the command.
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 4){
						String motd = args[1]+" "+args[2]+" "+args[3]; // Gets the MOTD from the command.
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 5){
						String motd = args[1]+" "+args[2]+" "+args[3]+" "+args[4]; // Gets the MOTD from the command.
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 6){
						String motd = args[1]+" "+args[2]+" "+args[3]+" "+args[4]+" "+args[5]; // Gets the MOTD from the command.
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 7){
						String motd = args[1]+" "+args[2]+" "+args[3]+" "+args[4]+" "+args[5]+" "+args[6]; // Gets the MOTD from the command.
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 8){
						String motd = args[1]+" "+args[2]+" "+args[3]+" "+args[4]+" "+args[5]+" "+args[6]+" "+args[7]; // Gets the MOTD from the command
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 9){
						String motd = args[1]+" "+args[2]+" "+args[3]+" "+args[4]+" "+args[5]+" "+args[6]+" "+args[7]+" "+args[8]; // Gets the MOTD from the command
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 10){
						String motd = args[1]+" "+args[2]+" "+args[3]+" "+args[4]+" "+args[5]+" "+args[6]+" "+args[7]+" "+args[8]+" "+args[9]; // Gets the MOTD from the command
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 11){
						String motd = args[1]+" "+args[2]+" "+args[3]+" "+args[4]+" "+args[5]+" "+args[6]+" "+args[7]+" "+args[8]+" "+args[9]+" "+args[10]; // Gets the MOTD from the command
						getConfig().set("motd", motd); // Saves the MOTD into configuration file.
						saveConfig(); // Saves configuration file.
						sender.sendMessage(ChatColor.GREEN + "MOTD successfully set to: " + ChatColor.RESET + motd); // Sends sender confirmation message.
					}else if(args.length == 12){
						sender.sendMessage(ChatColor.RED + "Too many arguments, maximum 10 words allowed in an motd!"); // Sends sender Error message.
					}
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
