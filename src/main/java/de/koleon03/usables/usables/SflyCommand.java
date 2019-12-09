package de.koleon03.usables.usables;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SflyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender){
            Bukkit.getConsoleSender().sendMessage("You can only use this as a player!");
        }

        if(sender instanceof Player){
            Player player = (Player)sender;
            if(label.equalsIgnoreCase("sfly")){
                ItemStack elytra = new ItemStack(Material.ELYTRA,1);
                elytra.addEnchantment(Enchantment.MENDING,1);
                elytra.addEnchantment(Enchantment.DURABILITY,3);
                player.getInventory().setChestplate(elytra);
            }
        }
        return true;
    }
}
