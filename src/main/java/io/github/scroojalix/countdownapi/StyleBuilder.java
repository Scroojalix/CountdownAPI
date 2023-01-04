package io.github.scroojalix.countdownapi;

import org.bukkit.ChatColor;

public class StyleBuilder {

    private Style style;

    public StyleBuilder() {
        this.style = new Style();
    }

    public StyleBuilder(Style style) {
        this.style = style;
    }

    public static StyleBuilder getDefaults() {
        return new StyleBuilder(new Style(ChatColor.GOLD + "Countdown ends in", ChatColor.WHITE + "%count%", 0, 20, 0));
    }

    public Style create() {
        return style;
    }

    public StyleBuilder setTitleFormat(String titleFormat) {
        style.setTitleFormat(titleFormat);
        return this;
    }

    public StyleBuilder setSubtitleFormat(String subtitleFormat) {
        style.setSubtitleFormat(subtitleFormat);
        return this;
    }
    
    public StyleBuilder setFadein(int fadeIn) {
        style.setFadeInLength(fadeIn);
        return this;
    }
    
    public StyleBuilder setStay(int stay) {
        style.setStayLength(stay);
        return this;
    }
    
    public StyleBuilder setFadeout(int fadeout) {
        style.setFadeOutLength(fadeout);
        return this;
    }

    public StyleBuilder setWait(int wait) {
        style.setWaitLength(wait);
        return this;
    }

    public StyleBuilder setFinalTickStyle(Style finalTickStyle) {
        style.setFinalTickStyle(finalTickStyle);
        return this;
    }
    
}
