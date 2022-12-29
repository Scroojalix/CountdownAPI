package io.github.scroojalix.countdownapi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
  
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("begindebugcountdown")) {
      sender.sendMessage(ChatColor.GOLD + "Beginning debug countdown...");

      new CountdownHandler(10, () -> {
        System.out.println("Countdown complete");
      }).start(this);
    }
    return true;
  }

}
