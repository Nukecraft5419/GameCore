package dev.nukecraft5419.gamecore.players;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import dev.nukecraft5419.gamecore.GameCore;
import dev.nukecraft5419.gamecore.commands.CommandExecutor;
import dev.nukecraft5419.gamecore.utils.PacketUtils;
import dev.nukecraft5419.gamecore.utils.PlayerUtils;
import dev.nukecraft5419.gamecore.utils.ServerUtils;
import lib__net.md_5.bungee.api.chat.BaseComponent;
import lib__net.md_5.bungee.api.chat.ComponentBuilder;
import lib__net.md_5.bungee.chat.ComponentSerializer;

import me.clip.placeholderapi.PlaceholderAPI;

public class AdvancedPlayer extends CommandExecutor {
    private Player bukkitPlayer;

    public AdvancedPlayer(GameCore plugin, Player bukkitPlayer) {
        super(plugin, bukkitPlayer);
        this.bukkitPlayer = bukkitPlayer;
    }

    public Player getBukkitPlayer() {
        return this.bukkitPlayer;
    }

    @Override
    public String formatMessage(String message) {
        String output = super.formatMessage(message);

        if (this.getPlugin().hasPlugin("PlaceholderAPI")) {
            output = PlaceholderAPI.setPlaceholders(this.getBukkitPlayer(), output);
        }

        return output;
    }

    @Override
    public String getLang() {
        String lang = null;

        if (ServerUtils.hasPlayerGetLocaleAPI()) {
            lang = this.getBukkitPlayer().getLocale();
        } else {
            lang = PlayerUtils.getPlayerLocaleInLegacyWay(this.bukkitPlayer);
        }

        return lang == null ? super.getLang() : lang;
    }

    public String getName() {
        return this.bukkitPlayer.getName();
    }

    public String getLowerName() {
        return this.getName().toLowerCase();
    }

    public boolean isOnline() {
        return this.bukkitPlayer != null && this.bukkitPlayer.isOnline();
    }

    public void download() {
        // Descargar datos del jugador de la DB.
        // Este metodo es llamado cuando el jugador se une al servidor.
    }

    public void sendRawMessage(String component, byte type) {
        if (ServerUtils.hasChatComponentAPI()) {
            this.bukkitPlayer.spigot().sendMessage(net.md_5.bungee.chat.ComponentSerializer.parse(component));
        } else {
            PacketUtils.sendJSON(this.getBukkitPlayer(), component, type);
        }
    }

    public void sendRawMessage(String component) {
        this.sendRawMessage(component, (byte) 0);
    }

    public void sendActionBar(String text) {
        this.sendRawMessage(ComponentSerializer.toString(new ComponentBuilder(text).create()), (byte) 2);
    }

    public void sendMessage(BaseComponent component) {
        this.sendRawMessage(ComponentSerializer.toString(component));
    }

    public void sendMessage(BaseComponent[] components) {
        this.sendRawMessage(ComponentSerializer.toString(components));
    }

    public void sendToServer(String server) {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("Connect");
            out.writeUTF(server);
            this.getBukkitPlayer().sendPluginMessage(this.getPlugin(), "BungeeCord", b.toByteArray());
            b.close();
            out.close();
        } catch (Exception e) {
            this.getBukkitPlayer().sendMessage(ChatColor.RED + "Error when trying to connect to " + server);
        }
    }

}