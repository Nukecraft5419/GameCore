package dev.nukecraft5419.advancedexampleplugin.commands.impl;

import dev.nukecraft5419.advancedexampleplugin.commands.Command;
import dev.nukecraft5419.advancedexampleplugin.commands.CommandContext;
import dev.nukecraft5419.advancedexampleplugin.commands.CommandListener;

@Command(name = "world")
public class WorldSubCommand extends CommandListener {
  @Override
  public void onExecute(CommandContext ctx) {
    ctx.getExecutor().sendI18nMessage("world");
  }
}
