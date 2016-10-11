package Chapter11;

import Chapter10.EmptyQueueException;
import Chapter10.QueueInterface;

import java.util.Arrays;

/**
 * Created by Sean on 10/3/2016.
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    private T[] queue; // Circular array of queue entries and one unused location

    private int frontIndex;
    private int backIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final  int MAX_CAPACITY = 10000;

    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    } //end default constructor

    public ArrayQueue(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[])new Object[initialCapacity + 1]; // Unchecked cast
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        initialized = true;
    } // end constructor

    public void enqueue(T newEntry)
    {
        checkInitialization();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    } // end enqueue

    public T dequeue()
    {
        checkInitialization();
        if (isEmpty())
            throw new EmptyQueueException();
        else {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return  front;
        } // end if
    } // end dequeue

    public T getFront()
    {
        checkInitialization();
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return queue[frontIndex];
    } // end getFront

    public boolean isEmpty()
    {
        return frontIndex == ((backIndex + 1) % queue.length);
    } // end isEmpty


    public void clear()
    {
        while (!isEmpty())
            dequeue();
    } // end clear

    private void checkCapacity(int capacity)
    {
        if(capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a ArrayQueue whose capacity exceeds" +
                    " allowed maximum of " + MAX_CAPACITY);
    } //end checkCapacity

    private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException("ArrayQueue object is not initialized properly.");
    } // end checkInitialization

    private void ensureCapacity()
    {
       if (frontIndex == ((backIndex + 1) % queue.length)) // If array is full, double size of array
       {
           T[] oldQueue = queue;
           int oldSize = oldQueue.length;
           int newSize = 2 * oldSize;
           checkCapacity(newSize);
           // The cast is safe because the new array contains null entries
           @SuppressWarnings("unchecked")
           T[] tempQueue = (T[]) new Object[newSize];
           queue = tempQueue;
           for (int index = 0; index < oldSize; index++)
           {
               queue[index] = oldQueue[frontIndex];
               frontIndex = (frontIndex + 1) % oldSize;
           } // end for
           frontIndex = 0;
           backIndex = oldSize - 2;
       } // end if
    }  // end ensureCapacity
}
