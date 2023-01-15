package dev.nukecraft5419.gamecore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

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

    // First time entry message to new players
    if (!e.getPlayer().hasPlayedBefore()) {
      if (Boolean.parseBoolean(plugin.getConfig().getString("welcome-messages.first-join"))) {
        e.setJoinMessage(plugin.getConfig().getString("welcome-messages.announce-msg"));
      } else {
        e.setJoinMessage(null);
      }
    }

    //
    if (!e.getPlayer().hasPlayedBefore()) {
      if (Boolean.parseBoolean(plugin.getConfig().getString("first-join-welcome-title.parameters.enabled"))) {
        String title = plugin.getConfig().getString("first-join-welcome-title.title");
        String subtitle = plugin.getConfig().getString("first-join-welcome-title.subtitle");
        int fadeIn = plugin.getConfig().getInt("first-join-welcome-title.parameters.fade-in");
        int stay = plugin.getConfig().getInt("first-join-welcome-title.parameters.stay");
        int fadeOut = plugin.getConfig().getInt("first-join-welcome-title.parameters.fade-out");
        TitleAPI.sendTitle(e.getPlayer(), fadeIn, stay, fadeOut, title, subtitle);
      } else {
        e.setJoinMessage(null);
      }
    }

  }
}
