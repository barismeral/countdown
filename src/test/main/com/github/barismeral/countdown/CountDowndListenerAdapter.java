package com.github.barismeral.countdown;


/**
 * @author Barış Meral
 * @see com.barismeral.utils.CountDownListener
 * @since  2018.11.11
 * @version 1.0
 */

/**
 * countdown event adapter class
 */
public class CountDowndListenerAdapter implements CountDownListener{

    public CountDowndListenerAdapter(){ }

    /**
     * operations to be performed every second
     * 
     */
    @Override
    public void perSecond(CountDown count) {

    }

    /**
     * Operations to be done when the time is over
     * 
     */
    @Override
    public void timeOver(CountDown count) {
       // time over
    }
}
