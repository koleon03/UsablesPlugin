package de.koleon03.usables.usables;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(label.equalsIgnoreCase("fly")){
                Player player = (Player)sender;
                if(player.getAllowFlight()==true){
                    player.setAllowFlight(false);
                    player.setFlying(false);
                }
                if(player.getAllowFlight()==false){
                    player.setAllowFlight(true);
                }
            }
        }
        if(sender instanceof ConsoleCommandSender){
            Bukkit.getConsoleSender().sendMessage("You can only use this as a player!");
        }
                return true;
    }
}
