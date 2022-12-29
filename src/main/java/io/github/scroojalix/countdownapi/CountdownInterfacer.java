package io.github.scroojalix.countdownapi;

public interface CountdownInterfacer {

    /**
     * Called before Countdown task beings
     */
    public default void start() {}

    /**
     * Called each tick of countdown
     */
    public default void tick() {}

    /**
     * Called after countdown is complete
     */
    public void callback();
}
