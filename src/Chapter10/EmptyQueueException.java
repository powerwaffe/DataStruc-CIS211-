package Chapter10;

/**
 * Created by Sean on 9/30/2016.
 * A class of runtime exceptions thrown when an attempt
 * is made to access or removbe the front of a queue.
 */
public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException()
    {
        this (null);
    } // end default constructor

    public EmptyQueueException(String message)
    {
        super (message);
    } // end constructor
} //end EmptyQueueException
