package dev.nukecraft5419.advancedexampleplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.nukecraft5419.advancedexampleplugin.AdvancedExamplePlugin;
import dev.nukecraft5419.advancedexampleplugin.players.AdvancedPlayer;

public class PlayerJoinListener implements Listener {
  private AdvancedExamplePlugin plugin;

  public PlayerJoinListener(AdvancedExamplePlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    AdvancedPlayer player = this.plugin.getPlayerManager().addPlayer(e.getPlayer());
    player.download();
  }
}
