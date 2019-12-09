package de.koleon03.usables.usables;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class KitCommand implements CommandExecutor {
    public static Inventory inv = Bukkit.createInventory(null,9,"Choose Kit!");
    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int cooldownTime = 1800;
        if (sender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage("You can oly use that as a player!");
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("kit")) {
                if(cooldowns.containsKey(sender.getName())){
                    long secondsLeft = ((cooldowns.get(sender.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                    int minutesLeft = (int) (secondsLeft /60);
                    if(secondsLeft>0) {
                       if(minutesLeft>1) {
                           sender.sendMessage(ChatColor.RED + "You cant use that command for another " + minutesLeft + " minutes!");
                       }
                       else{
                           sender.sendMessage(ChatColor.RED + "You cant use that command for another " + secondsLeft + " seconds!");
                       }
                    }
                }
                else {
                    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemStack plank = new ItemStack(Material.OAK_PLANKS, 1);
                    ItemMeta swordm = sword.getItemMeta();
                    swordm.setDisplayName(ChatColor.GOLD + "Hunter");
                    ItemMeta plankm = plank.getItemMeta();
                    plankm.setDisplayName(ChatColor.GOLD + "Basics");
                    inv.setItem(0, sword);
                    inv.setItem(8, plank);
                    player.openInventory(inv);
                    cooldowns.put(sender.getName(), System.currentTimeMillis());
                }
            }
        }


        return true;
    }

    public static void hunter(Player player){
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD,1);
        ItemStack cp = new ItemStack(Material.IRON_CHESTPLATE,1);
        ItemStack hm = new ItemStack(Material.IRON_HELMET,1);
        ItemStack lg = new ItemStack(Material.IRON_LEGGINGS,1);
        ItemStack bt = new ItemStack(Material.IRON_BOOTS,1);
        ItemStack food = new ItemStack(Material.COOKED_BEEF,32);
        ItemStack ga = new ItemStack(Material.GOLDEN_APPLE,1);
        sword.addEnchantment(Enchantment.DURABILITY,1);
        cp.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        hm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        lg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        bt.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
        player.getInventory().addItem(sword,cp,hm,bt,lg,food,ga);
    }

    public static void basics(Player player){
        ItemStack sword = new ItemStack(Material.IRON_SWORD,1);
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE,1);
        ItemStack axe = new ItemStack(Material.IRON_AXE);
        ItemStack food = new ItemStack(Material.COOKED_BEEF,32);
        ItemStack planks = new ItemStack(Material.OAK_PLANKS,64);
        ItemStack hm = new ItemStack(Material.LEATHER_HELMET,1);
        ItemStack cp = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        ItemStack lg = new ItemStack(Material.LEATHER_LEGGINGS,1);
        ItemStack bt = new ItemStack(Material.LEATHER_BOOTS,1);
        player.getInventory().addItem(sword,pickaxe,axe,food,planks,hm,cp,lg,bt);


    }




}

