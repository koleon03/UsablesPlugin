package de.koleon03.usables.usables;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender){
            Bukkit.getConsoleSender().sendMessage("You can only use that as a player!");
        }

        if(sender instanceof Player){
            Player player = (Player)sender;
            if(label.equalsIgnoreCase("ec")){
                Inventory ec = player.getEnderChest();
                player.openInventory(ec);
            }
        }
        return true;
    }
}
