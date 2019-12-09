package de.koleon03.usables.usables;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class NiceDayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        long time = Usables.getPlugin(Usables.class).getConfig().getLong("/nd time");
       if(label.equalsIgnoreCase("nd")) {
           Bukkit.getServer().getWorld("world").setTime(time);
           Bukkit.getServer().getWorld("world").setStorm(false);

       }

        return true;
    }
}
