package dev.nukecraft5419.gamecore.commands.impl;

import dev.nukecraft5419.gamecore.commands.Command;
import dev.nukecraft5419.gamecore.commands.CommandContext;
import dev.nukecraft5419.gamecore.commands.CommandListener;

@Command(name = "world")
public class WorldSubCommand extends CommandListener {
  @Override
  public void onExecute(CommandContext ctx) {
    ctx.getExecutor().sendI18nMessage("world");
  }
}
