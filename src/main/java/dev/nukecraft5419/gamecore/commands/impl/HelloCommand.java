package dev.nukecraft5419.gamecore.commands.impl;

import dev.nukecraft5419.gamecore.commands.Command;
import dev.nukecraft5419.gamecore.commands.CommandContext;
import dev.nukecraft5419.gamecore.commands.CommandListener;

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
