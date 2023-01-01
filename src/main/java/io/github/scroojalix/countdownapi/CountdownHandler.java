package io.github.scroojalix.countdownapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.clip.placeholderapi.PlaceholderAPI;

public class CountdownHandler implements Runnable {

    private int taskId;
    private int count;
    private Style style;
    private CountdownInterfacer interfacer;

    
    public CountdownHandler(int countdownLength, CountdownInterfacer interfacer) {
        this(countdownLength, StyleBuilder.getDefaultStyle(), interfacer);
    }
    
    public CountdownHandler(int countdownLength, Style style, CountdownInterfacer interfacer) {
        this.count = countdownLength;
        this.style = style;
        this.interfacer = interfacer;
    }
    
    /** Called each second of the countdown */
    void tick(Style style) {
        interfacer.tick();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendTitle(formatCountdown(p, style.getTitle()), formatCountdown(p, style.getSubtitle()), style.fadeIn, style.stay, style.fadeOut);
        }
    }
    
    void start(Plugin plugin) {
        interfacer.start();
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this, 0, style.getTotalTickLength());
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
    }

    /** Get current count */
    public int getCount() {
        return count;
    }

    private String formatCountdown(Player reciever, String in) {
        String out = in.replace("%count%", getCount()+"");
        out = PlaceholderAPI.setPlaceholders(reciever, out);
        return out;
    }
}