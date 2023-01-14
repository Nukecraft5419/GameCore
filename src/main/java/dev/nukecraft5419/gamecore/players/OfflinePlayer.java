package dev.nukecraft5419.gamecore.players;

import org.bukkit.entity.Player;

import dev.nukecraft5419.gamecore.GameCore;

public class OfflinePlayer extends AdvancedPlayer {
    private String username;

    public OfflinePlayer(GameCore plugin, Player bukkitPlayer, String username) {
        super(plugin, bukkitPlayer);
        this.username = username.toLowerCase();
    }

    @Override
    public String getLowerName() {
        return this.username;
    }
}