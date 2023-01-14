package dev.nukecraft5419.advancedexampleplugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.nukecraft5419.advancedexampleplugin.AdvancedExamplePlugin;
import dev.nukecraft5419.advancedexampleplugin.errors.BadArgumentException;
import dev.nukecraft5419.advancedexampleplugin.errors.MaterialNotFoundException;
import dev.nukecraft5419.advancedexampleplugin.errors.PlayerOfflineException;
import dev.nukecraft5419.advancedexampleplugin.errors.SoundNotFoundException;
import dev.nukecraft5419.advancedexampleplugin.errors.WorldNotFoundException;
import dev.nukecraft5419.advancedexampleplugin.players.AdvancedPlayer;

public class CommandContext {
    private AdvancedExamplePlugin plugin;
    private CommandExecutor executor;
    private CommandArguments arguments;

    public CommandContext(AdvancedExamplePlugin plugin, CommandSender sender, Argument[] requiredArguments) {
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

    public AdvancedExamplePlugin getPlugin() {
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