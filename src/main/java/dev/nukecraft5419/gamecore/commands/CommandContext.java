package dev.nukecraft5419.gamecore.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.nukecraft5419.gamecore.GameCore;
import dev.nukecraft5419.gamecore.errors.BadArgumentException;
import dev.nukecraft5419.gamecore.errors.MaterialNotFoundException;
import dev.nukecraft5419.gamecore.errors.PlayerOfflineException;
import dev.nukecraft5419.gamecore.errors.SoundNotFoundException;
import dev.nukecraft5419.gamecore.errors.WorldNotFoundException;
import dev.nukecraft5419.gamecore.players.AdvancedPlayer;

public class CommandContext {
    private GameCore plugin;
    private CommandExecutor executor;
    private CommandArguments arguments;

    public CommandContext(GameCore plugin, CommandSender sender, Argument[] requiredArguments) {
        if (sender instanceof Player) {
            this.executor = plugin.getPlayerManager().getPlayer((Player) sender);
        } else {
            this.executor = new CommandExecutor(plugin, sender);
        }

        this.plugin = plugin;
        this.arguments = new CommandArguments(plugin, requiredArguments);
    }

    public void parseArguments(String[] args) throws BadArgumentException, PlayerOfflineException,
            WorldNotFoundException, MaterialNotFoundException, SoundNotFoundException {
        this.arguments.parse(args);
    }

    public GameCore getPlugin() {
        return this.plugin;
    }

    public CommandExecutor getExecutor() {
        return this.executor;
    }

    public AdvancedPlayer getPlayer() {
        return (AdvancedPlayer) this.executor;
    }

    public boolean isPlayer() {
        return this.executor.isPlayer();
    }

    public CommandArguments getArguments() {
        return this.arguments;
    }
}