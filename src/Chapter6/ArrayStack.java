package Chapter6;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Sean on 9/17/2016.
 */
public final class ArrayStack<T> implements StackInterface<T>
{
    private T[] stack;  // Array of stack entries
    private int topIndex;   // Index of the top entry
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayStack(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
                T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;
    } // end constructor

    public void push(T newEntry)
    {
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    public T pop()
    {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    public T peek()
    {
        checkInitialization();;
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    public boolean isEmpty()
    {
        return topIndex < 0;
    } // end isEmpty

    /** Not sure if functional, needs testing. */
    public void clear()
    {
        while (!isEmpty())
        {
            pop();
        } // end while
    } // end clear

    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                    "allowed maximum of " + MAX_CAPACITY);
    } // end checkCapacity

    private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException ("Uninitialized object used " +
                    "to call an ArrayBag method.");
    } // end checkInitialization

    private void ensureCapacity()
    {
        if (topIndex == stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    }  // end ensureCapacity
}
