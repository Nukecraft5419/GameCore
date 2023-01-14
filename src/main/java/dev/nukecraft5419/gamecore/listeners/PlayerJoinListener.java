package dev.nukecraft5419.gamecore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.nukecraft5419.gamecore.GameCore;
import dev.nukecraft5419.gamecore.players.GamePlayer;

public class PlayerJoinListener implements Listener {
  private GameCore plugin;

  public PlayerJoinListener(GameCore plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    GamePlayer player = this.plugin.getPlayerManager().addPlayer(e.getPlayer());
    player.download();
  }
}
