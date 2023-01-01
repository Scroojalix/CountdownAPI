package io.github.scroojalix.countdownapi;

import org.bukkit.ChatColor;

public class Style {
    // TODO add extra effects such as sfx, etc.

    private String titleFormat;
    private String subtitleFormat;

    int fadeIn, stay, fadeOut;

    public Style(String titleFormat, String subtitleFormat, int fadeIn, int stay, int fadeOut) {
        this.titleFormat = titleFormat;
        this.subtitleFormat = subtitleFormat;
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    public String getTitleRaw() {
        return this.titleFormat;
    }

    public String getTitle() {
        return ChatColor.translateAlternateColorCodes('&', titleFormat);
    }

    public void setTitleFormat(String titleFormat) {
        this.titleFormat = titleFormat;
    }

    public String getSubtitleRaw() {
        return this.subtitleFormat;
    }

    public void setSubtitleFormat(String subtitleFormat) {
        this.subtitleFormat = subtitleFormat;
    }

    public String getSubtitle() {
        return ChatColor.translateAlternateColorCodes('&', subtitleFormat);
    }

    public void setFadeInLength(int fadeIn) {
        this.fadeIn = fadeIn;
    }

    public void setStayLength(int stay) {
        this.stay = stay;
    }

    public void setFadeOutLength(int fadeOut) {
        this.fadeOut = fadeOut;
    }
}
