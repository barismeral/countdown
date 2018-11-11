package com.barismeral.utils.countdown;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Barış Meral
 * @since 2018.11.11
 * @see java.lang.Runnable
 * @version 1.0
 *
 */



public class CountDown implements Runnable{

    private static Timer timer;
    private TimerTask timerTask;
    private volatile int second;
    private CountDownListener listener;
    private Thread thread;

    // private empty constructor
      private CountDown(){}


    static { timer = new Timer(); }

    /**
     * set a count second
     * 
     */
    public CountDown(int second){

        if (second<0 || second==0)
            throw new CountDownException();

        else {
            this.second = second;
            thread = new Thread(this);
        }
    }

    /**
     * set listener and second
     * 
     * 
     */
    public CountDown(int second,CountDownListener listener){
            if (second<0 || second==0)
                throw new CountDownException();

            else {
                this.second = second;
                this.listener = listener;
                thread = new Thread(this);
            }

    }

    /**
     * enabled countdown
     */
 public void enable(){

       thread.start();
 }

    /**
     *
     * @return boolean is a counting?
     */
 public boolean isCounting(){
        return thread.isAlive();
 }

    /**
     *
     * @return remaining time
     */
 public synchronized int getSecond(){

        return second;
 }

    /**
     * set new second
     * 
     */
 public synchronized void setSecond(int second){
     if (second<0 || second==0)
         throw new CountDownException();

         this.second = second;
 }

    /**
     * adding time  old second + new second
     * 
     */
 public synchronized void appendSecond(int second){

     if (second<0 || second==0) {
         throw new CountDownException();
     }
     else
         this.second += second;
 }

    /**
     * not modified is method
     *
     */
    public synchronized void run() {
        timerTask = new TimerTask() {
            @Override
            public synchronized void run() {

                second--;

                if (second%1==0){
                    if (listener!=null)
                    listener.perSecond(CountDown.this);
                }

                if (second==0){

                    if (listener!=null) {
                        listener.timeOver(CountDown.this);
                    }

                        timer.cancel();
                        second = 0;
                }
            }
        };

        timer.schedule(timerTask,0,1000);
    }

    /**
     *
     * @return is it over?
     */
    public boolean isFinish(){

        return second==0;
    }

    /**
     * set listener
     * 
     */
    public synchronized void setCountDownListener(CountDownListener listener){

        this.listener = listener;
    }

    /**
     * disable listener
     */
    public synchronized void disableListener(){
        this.listener = null;
    }


}
