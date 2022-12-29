package io.github.scroojalix.countdownapi;

import org.bukkit.plugin.Plugin;

public class CountdownAPI {

    public static void startCountdown(Plugin plugin, int length) {
        startCountdown(plugin, length, StyleBuilder.getDefaultStyle(), () -> {});
    }

    public static void startCountdown(Plugin plugin, int length, Style style) {
        startCountdown(plugin, length, style, () -> {});
    }

    public static void startCountdown(Plugin plugin, int length, Style style, CountdownInterfacer interfacer) {
        CountdownHandler task = new CountdownHandler(length, style, interfacer);
        task.start(plugin);
    }
    
}
