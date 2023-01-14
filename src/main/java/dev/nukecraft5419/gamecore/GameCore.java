package dev.nukecraft5419.gamecore;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import dev.nukecraft5419.gamecore.api.GameCoreAPI;
import dev.nukecraft5419.gamecore.api.events.GameCoreEvent;
import dev.nukecraft5419.gamecore.commands.CommandListener;
import dev.nukecraft5419.gamecore.commands.impl.HelloCommand;
import dev.nukecraft5419.gamecore.config.ConfigManager;
import dev.nukecraft5419.gamecore.config.Configuration;
import dev.nukecraft5419.gamecore.i18n.LanguageManager;
import dev.nukecraft5419.gamecore.listeners.PlayerJoinListener;
import dev.nukecraft5419.gamecore.listeners.PlayerQuitListener;
import dev.nukecraft5419.gamecore.players.AdvancedPlayerManager;

public class GameCore extends JavaPlugin {
    private ConfigManager configManager;
    private LanguageManager languageManager;
    private AdvancedPlayerManager playerManager;

    private void addCommand(CommandListener command) {
        command.register(this, false);
    }

    private void addListener(Listener listener) {
        this.getServer().getPluginManager().registerEvents(listener, this);
    }

    public boolean callEvent(GameCoreEvent event) {
        this.getServer().getPluginManager().callEvent(event);
        return !event.isCancelled();
    }

    @Override
    public void onEnable() {
        // Initialize API
        new GameCoreAPI(this);

        // Instantiate managers.
        this.configManager = new ConfigManager(this);
        this.languageManager = new LanguageManager(this);
        this.playerManager = new AdvancedPlayerManager(this);

        // Load data.
        this.languageManager.loadLanguagesSafe();
        this.playerManager.addAll();

        // Register listeners.
        this.addListener(new PlayerJoinListener(this));
        this.addListener(new PlayerQuitListener(this));

        // Register commands.
        this.addCommand(new HelloCommand());
    }

    // Configuration getters
    public Configuration getConfig() {
        return this.configManager.getConfig("config.yml");
    }

    // Managers getters
    public LanguageManager getLanguageManager() {
        return this.languageManager;
    }

    public AdvancedPlayerManager getPlayerManager() {
        return this.playerManager;
    }

    // Others getters
    public boolean hasPlugin(String pluginName) {
        Plugin plugin = this.getServer().getPluginManager().getPlugin(pluginName);
        return plugin != null && plugin.isEnabled();
    }
}