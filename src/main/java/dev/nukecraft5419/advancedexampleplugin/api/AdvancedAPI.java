package dev.nukecraft5419.advancedexampleplugin.api;

import org.bukkit.entity.Player;

import dev.nukecraft5419.advancedexampleplugin.AdvancedExamplePlugin;
import dev.nukecraft5419.advancedexampleplugin.players.AdvancedPlayer;

public class AdvancedAPI {
    private static AdvancedExamplePlugin plugin;

    public AdvancedAPI(AdvancedExamplePlugin plugin) {
        AdvancedAPI.plugin = plugin;
    }

    public static AdvancedPlayer getPlayer(Player player) {
        return plugin.getPlayerManager().getPlayer(player);
    }
}
