package dev.nukecraft5419.advancedexampleplugin.players;

import org.bukkit.entity.Player;

import dev.nukecraft5419.advancedexampleplugin.AdvancedExamplePlugin;

public class OfflinePlayer extends AdvancedPlayer {
    private String username;

    public OfflinePlayer(AdvancedExamplePlugin plugin, Player bukkitPlayer, String username) {
        super(plugin, bukkitPlayer);
        this.username = username.toLowerCase();
    }

    @Override
    public String getLowerName() {
        return this.username;
    }
}