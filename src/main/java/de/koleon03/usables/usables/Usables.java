package de.koleon03.usables.usables;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Usables extends JavaPlugin {
FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("nd").setExecutor(new NiceDayCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("sfly").setExecutor(new SflyCommand());
        this.getCommand("ec").setExecutor(new EcCommand());
        this.getCommand("kit").setExecutor(new KitCommand());
        this.getCommand("heal").setExecutor(new HealClass());
        this.getCommand("feed").setExecutor(new FeedClass());
        this.getCommand("clearlag").setExecutor(new ClearLag());
        getServer().getPluginManager().registerEvents(new EventCatcher(),this);
        config.addDefault("/nd time", 0);
        config.options().copyDefaults(true);
        saveConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
