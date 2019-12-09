package de.koleon03.usables.usables;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class FeedClass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("feed")){
            if(args.length == 0){
                if(sender instanceof ConsoleCommandSender){
                    Bukkit.getConsoleSender().sendMessage("Please enter a player name!");
                }

                if(sender instanceof Player){
                    Player player1 = (Player)sender;
                    player1.setFoodLevel(20);
                }
            }
            else{
                Player hplayer = Bukkit.getPlayer(args[0]);
                hplayer.setFoodLevel(20);
            }
        }
        return true;
    }
}
