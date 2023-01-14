package dev.nukecraft5419.gamecore.api;

import org.bukkit.entity.Player;

import dev.nukecraft5419.gamecore.GameCore;
import dev.nukecraft5419.gamecore.players.GamePlayer;

public class GameCoreAPI {
    private static GameCore plugin;

    public GameCoreAPI(GameCore plugin) {
        GameCoreAPI.plugin = plugin;
    }

    public static GamePlayer getPlayer(Player player) {
        return plugin.getPlayerManager().getPlayer(player);
    }
}
