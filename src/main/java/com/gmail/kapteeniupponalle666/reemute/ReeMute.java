package com.gmail.kapteeniupponalle666.reemute;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class ReeMute extends JavaPlugin implements Listener {

    List<String> muted = new ArrayList<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(this, this);
        getCommand("mute").setExecutor(new Mute(this));
        getCommand("unmute").setExecutor(new Unmute(this));

        muted.addAll(getConfig().getStringList("muted"));
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (muted.contains(e.getPlayer().getUniqueId().toString())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', e.getPlayer().getName() + " " + e.getMessage()));
        }
    }

}
