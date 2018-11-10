package com.gmail.kapteeniupponalle666.reemute;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Unmute implements CommandExecutor {

    private ReeMute plugin;

    Unmute(ReeMute p) {
        plugin = p;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null && plugin.muted.contains(target.getUniqueId().toString())) {
                plugin.muted.remove(target.getUniqueId().toString());
                plugin.getConfig().set("muted", plugin.muted);
                plugin.saveConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aPoistit hiljennyksen pelaajalta " + target.getName()));
            }
        }
        return true;
    }
}
