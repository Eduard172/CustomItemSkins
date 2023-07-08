package me.eduard.customitemskins;

import me.eduard.customitemskins.Commands.EduardTest;
import me.eduard.customitemskins.Commands.test;
import me.eduard.customitemskins.Events.OpenGUI;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItemSkins extends JavaPlugin {

    @Override
    public void onEnable() {
        sendConsoleMessage("&eRegistering commands...");
        registerCommands();
        sendConsoleMessage("&eRegistering listeners...");
        registerListeners();
        sendConsoleMessage("&eInitializing config file...");
        initializeConfig();
        sendConsoleMessage("&a[CustomItemSkins] The plugin has been loaded!\nPlugin made by Edward76 & naphy");
    }

    @Override
    public void onDisable() {
        sendConsoleMessage("&c[CustomItemSkins] The plugin has been unloaded!");
    }

    private void initializeConfig(){
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
    @SuppressWarnings("all")
    private void registerCommands() {
        getCommand("test").setExecutor(new test());
        getCommand("etest").setExecutor(new EduardTest());
    }
    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new OpenGUI(), this);
    }
    public static String format(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    private void sendConsoleMessage(String message){
        getServer().getConsoleSender().sendMessage(format(message));
    }
}
