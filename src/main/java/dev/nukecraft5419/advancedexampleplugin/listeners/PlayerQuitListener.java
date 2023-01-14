package dev.nukecraft5419.advancedexampleplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import dev.nukecraft5419.advancedexampleplugin.AdvancedExamplePlugin;

public class PlayerQuitListener implements Listener {
  private AdvancedExamplePlugin plugin;

  public PlayerQuitListener(AdvancedExamplePlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent e) {
    this.plugin.getPlayerManager().removePlayer(e.getPlayer());
  }
}
