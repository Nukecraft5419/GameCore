package dev.nukecraft5419.advancedexampleplugin.commands.impl;

import dev.nukecraft5419.advancedexampleplugin.commands.Command;
import dev.nukecraft5419.advancedexampleplugin.commands.CommandContext;
import dev.nukecraft5419.advancedexampleplugin.commands.CommandListener;

@Command(name = "hello")
public class HelloCommand extends CommandListener {
  public HelloCommand() {
    this.addSubcommand(new WorldSubCommand());
  }

  @Override
  public void onExecute(CommandContext ctx) {
    ctx.getExecutor().sendI18nMessage("hello");
  }
}
