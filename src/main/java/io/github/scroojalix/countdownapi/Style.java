package io.github.scroojalix.countdownapi;

public class Style {
    // TODO add extra effects such as sfx, action bar, xp bar etc.

    private String titleFormat;
    private String subtitleFormat;

    int fadeIn, stay, fadeOut, wait;

    private Style finalTickStyle;

    public Style() {
        this(null, null, 0, 0, 0, 0, null);
    }

    public Style(String titleFormat, String subtitleFormat, int fadeIn, int stay, int fadeOut) {
        this(titleFormat, subtitleFormat, fadeIn, stay, fadeOut, 0, null);
    }

    public Style(String titleFormat, String subtitleFormat, int fadeIn, int stay, int fadeOut, int wait) {
        this(titleFormat, subtitleFormat, fadeIn, stay, fadeOut, 0, null);
    }

    public Style(String titleFormat, String subtitleFormat, int fadeIn, int stay, int fadeOut, Style finalTickStyle) {
        this(titleFormat, subtitleFormat, fadeIn, stay, fadeOut, 0, finalTickStyle);
    }

    public Style(String titleFormat, String subtitleFormat, int fadeIn, int stay, int fadeOut, int wait, Style finalTickStyle) {
        this.titleFormat = titleFormat;
        this.subtitleFormat = subtitleFormat;
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
        this.wait = wait;
        this.finalTickStyle = finalTickStyle;
    }

    public String getTitleFormat() {
        return titleFormat;
    }

    public void setTitleFormat(String titleFormat) {
        this.titleFormat = titleFormat;
    }

    public String getSubtitleFormat() {
        return subtitleFormat;
    }

    public void setSubtitleFormat(String subtitleFormat) {
        this.subtitleFormat = subtitleFormat;
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

    public void setWaitLength(int wait) {
        this.wait = wait;
    }

    public int getWaitLength() {
        return this.wait;
    }

    public int getTotalTickLength() {
        return fadeIn + stay + fadeOut;
    }

    public Style getFinalTickStyle() {
        return this.finalTickStyle;
    }

    public void setFinalTickStyle(Style finalTickStyle) {
        this.finalTickStyle = finalTickStyle;
    }
}
