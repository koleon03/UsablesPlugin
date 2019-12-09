package de.koleon03.usables.usables;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;

import java.util.List;

import static org.bukkit.Bukkit.getWorld;

public class ClearLag implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("clearlag")){
            int delay = 30;
            long secondsLeft = delay - (System.currentTimeMillis()/1000);
            Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "===CLEARLAG===");
            Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "All dropped Items will be cleared in 30 seconds!");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "===CLEARLAG===");
                Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "All dropped Items will be cleared in 20 seconds!");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "===CLEARLAG===");
                Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "All dropped Items will be cleared in 10 seconds!");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "===CLEARLAG===");
                Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "All dropped Items cleared");
                List<Entity> el = Bukkit.getWorld("world").getEntities();
                for (int i = 0; i < el.size(); i++) {
                    Entity e = el.get(i);
                    if (e.getType() == EntityType.DROPPED_ITEM) {
                        el.get(i).remove();
                    }
                }


        }
        return true;
    }
}
