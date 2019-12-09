package de.koleon03.usables.usables;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventCatcher implements Listener {


    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(ChatColor.AQUA + "Welcome to the Server " + ChatColor.GOLD + event.getPlayer().getDisplayName() + "!");
    }

    @EventHandler
    public void PlayerSleep(PlayerBedEnterEvent event){
        event.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "Good Night!");
    }

    @EventHandler
    public void PlayerWake(PlayerBedLeaveEvent event){
        event.getPlayer().sendMessage(ChatColor.DARK_PURPLE + "Good Morning " + ChatColor.UNDERLINE + event.getPlayer().getDisplayName() + ChatColor.UNDERLINE + "!");
    }

    @EventHandler
    public void PlayerDrop(PlayerDropItemEvent event){
        event.getPlayer().sendMessage(ChatColor.RED + "You just dropped something!");
    }

    @EventHandler
    public void InvClick(InventoryClickEvent event){
        Player player = (Player)event.getWhoClicked();
        Inventory ei = event.getInventory();
        ItemStack IsE = event.getCurrentItem();

        if(event.getClickedInventory().equals(KitCommand.inv)){
            if(IsE.getType() == Material.DIAMOND_SWORD){
                event.setCancelled(true);
                player.closeInventory();
                KitCommand.hunter(player);
            }

            if(IsE.getType() == Material.OAK_PLANKS){
                event.setCancelled(true);
                player.closeInventory();
                KitCommand.basics(player);
            }
        }
    }

}
