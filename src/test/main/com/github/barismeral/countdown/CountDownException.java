package com.github.barismeral.countdown;


/**
 * @author Barış Meral
 * @version 1.0
 * @since 2018.11.11
 * @see java.io.Serializable
 * @see java.lang.Exception
 * @see java.lang.RuntimeException
 * @see java.lang.Throwable
 *
 */

/**
 * for countdown runtime exception class
 */
public class CountDownException extends RuntimeException {



    private final static long serialVersionUId = 95L;

   public CountDownException(){

       super("Value is negative or 0");
   }

    
    public CountDownException(String message){
       super(message);
    }





}
