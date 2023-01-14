package dev.nukecraft5419.gamecore.players;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import dev.nukecraft5419.gamecore.GameCore;

public class AdvancedPlayerManager {
    private GameCore plugin;

    private Map<Player, AdvancedPlayer> players;

    public AdvancedPlayerManager(GameCore plugin) {
        this.plugin = plugin;
        this.players = new HashMap<>();
    }

    public AdvancedPlayer addPlayer(Player bukkitPlayer) {
        AdvancedPlayer player = new AdvancedPlayer(this.plugin, bukkitPlayer);
        this.players.put(bukkitPlayer, player);
        return player;
    }

    public AdvancedPlayer removePlayer(Player bukkitPlayer) {
        return this.players.remove(bukkitPlayer);
    }

    public AdvancedPlayer getPlayer(Player bukkitPlayer) {
        return this.players.get(bukkitPlayer);
    }

    public AdvancedPlayer getPlayer(String name) {
        Player bukkitPlayer = this.plugin.getServer().getPlayerExact(name);
        if (bukkitPlayer != null && bukkitPlayer.isOnline()) {
            return this.getPlayer(bukkitPlayer);
        } else {
            return null;
        }
    }

    public Collection<AdvancedPlayer> getPlayers() {
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