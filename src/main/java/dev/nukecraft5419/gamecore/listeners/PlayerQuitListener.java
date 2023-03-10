package dev.nukecraft5419.gamecore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import dev.nukecraft5419.gamecore.GameCore;

public class PlayerQuitListener implements Listener {
  private GameCore plugin;

  public PlayerQuitListener(GameCore plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent e) {
    this.plugin.getPlayerManager().removePlayer(e.getPlayer());
  }
}
