package io.github.scroojalix.countdownapi;

public interface CountdownInterfacer {

    /**
     * Called each tick of countdown
     */
    public default void tick() {}

    /**
     * Called after countdown is complete
     */
    public void callback();
    
}
