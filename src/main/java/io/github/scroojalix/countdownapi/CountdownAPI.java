package io.github.scroojalix.countdownapi;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.plugin.Plugin;

public final class CountdownAPI {

    static Map<Integer, CountdownHandler> runningCountdowns = new HashMap<Integer, CountdownHandler>();
    
    // TODO finish this. Make placeholderapi optional
    // static boolean PLACEHOLDER_API_ENABLED = true;

    // static {
    //     try {
    //         Class.forName("me.clip.placeholderapi.PlaceholderAPI");
    //     } catch (ClassNotFoundException e) {
    //         PLACEHOLDER_API_ENABLED = false;
    //     }
    // }

    public static int startCountdown(Plugin plugin, int length) {
        return startCountdown(plugin, length, StyleBuilder.getDefaults().create(), () -> {});
    }

    public static int startCountdown(Plugin plugin, int length, Style style) {
        return startCountdown(plugin, length, style, () -> {});
    }

    public static int startCountdown(Plugin plugin, int length, Style style, CountdownInterfacer interfacer) {
        CountdownHandler task = new CountdownHandler(length, style, interfacer);
        return task.start(plugin);
    }

    public static void cancelCountdown(int id) {
        if (runningCountdowns.containsKey(id))
            runningCountdowns.get(id).cancel();
        }
        
    public static void cancelAllCountdowns() {
        for (int id : runningCountdowns.keySet()) {
            runningCountdowns.get(id).cancel();
            
        }
    }
    
}
