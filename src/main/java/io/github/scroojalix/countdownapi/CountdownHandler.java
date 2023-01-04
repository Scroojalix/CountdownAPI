package io.github.scroojalix.countdownapi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.clip.placeholderapi.PlaceholderAPI;

public class CountdownHandler implements Runnable {

    private int taskId;
    private int count;
    private Style style;
    private CountdownInterfacer interfacer;

    
    public CountdownHandler(int countdownLength, CountdownInterfacer interfacer) {
        this(countdownLength, StyleBuilder.getDefaults().create(), interfacer);
    }
    
    public CountdownHandler(int countdownLength, Style style, CountdownInterfacer interfacer) {
        this.count = countdownLength;
        this.style = style;
        this.interfacer = interfacer;
    }
    
    /** Called each second of the countdown */
    void tick(Style style) {
        if (style.getTotalTickLength() <= 0) {
            Bukkit.getLogger().warning("A countdown with no tick length attempted to be called. Consider adjusting the countdowns fadeIn, stay and fadeOut values");
        }
        interfacer.tick();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendTitle(formatCountdown(p, style.getTitleFormat()), formatCountdown(p, style.getSubtitleFormat()), style.fadeIn, style.stay, style.fadeOut);
        }
    }
    
    int start(Plugin plugin) {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this, 0, style.getTotalTickLength() + style.getWaitLength());
        CountdownAPI.runningCountdowns.put(taskId, this);
        return taskId;
    }
    
    @Override
    public void run() {
        if (count != 0) {
            tick(style);
        } else {
            if (style.getFinalTickStyle() != null) {
                tick(style.getFinalTickStyle());
            }
            cancel();
            interfacer.callback();
        }
        count--;
    }

    /** Call to cancel the countdown */
    public void cancel() {
        Bukkit.getScheduler().cancelTask(taskId);
        CountdownAPI.runningCountdowns.remove(taskId);
    }

    /** Get current count */
    public int getCount() {
        return count;
    }

    private String formatCountdown(Player reciever, String in) {
        if (in == null)
            return null;
        String out = in.replace("%count%", getCount()+"");
        out = PlaceholderAPI.setPlaceholders(reciever, out);
        return ChatColor.translateAlternateColorCodes('&', out);
    }
}