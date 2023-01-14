package dev.nukecraft5419.gamecore.players;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import dev.nukecraft5419.gamecore.GameCore;

public class GamePlayerManager {
    private GameCore plugin;

    private Map<Player, GamePlayer> players;

    public GamePlayerManager(GameCore plugin) {
        this.plugin = plugin;
        this.players = new HashMap<>();
    }

    public GamePlayer addPlayer(Player bukkitPlayer) {
        GamePlayer player = new GamePlayer(this.plugin, bukkitPlayer);
        this.players.put(bukkitPlayer, player);
        return player;
    }

    public GamePlayer removePlayer(Player bukkitPlayer) {
        return this.players.remove(bukkitPlayer);
    }

    public GamePlayer getPlayer(Player bukkitPlayer) {
        return this.players.get(bukkitPlayer);
    }

    public GamePlayer getPlayer(String name) {
        Player bukkitPlayer = this.plugin.getServer().getPlayerExact(name);
        if (bukkitPlayer != null && bukkitPlayer.isOnline()) {
            return this.getPlayer(bukkitPlayer);
        } else {
            return null;
        }
    }

    public Collection<GamePlayer> getPlayers() {
        return this.players.values();
    }

    public void clear() {
        this.players.clear();
    }

    public void addAll() {
        for (Player bukkitPlayer : this.plugin.getServer().getOnlinePlayers()) {
            this.addPlayer(bukkitPlayer).download();
        }
    }
}