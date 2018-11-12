package com.github.barismeral.countdown;


/**
 * @author Barış Meral
 * @since 2018.11.11
 * @version 1.0
 *
 */

/**
 * for countdown event handling interface
 */
public interface CountDownListener {
    /**
     * per second throw event
     *
     *operations to be performed every second
     * 
     */
    void perSecond(CountDown count);

    /**
     *
     * time over throw event
     *
     * Operations to be done when the time is over
     * 
     */
    void timeOver(CountDown count);



}
