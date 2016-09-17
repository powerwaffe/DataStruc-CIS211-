package Chapter6;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * Created by Sean on 9/17/2016.
 */
public final class VectorStack<T> implements StackInterface<T>
{
    private Vector<T> stack; // Last element is the top entry in stack
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public VectorStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public VectorStack(int initialCapacity)
    {
        checkCapacity(initialCapacity);
        stack = new Vector<>(initialCapacity); // Size doubles as needed
        initialized = true;
    } // end constructor

    public void push(T newEntry)
    {
        checkInitialization();
        stack.add(newEntry);
    } // end push

    public T pop()
    {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack.remove(stack.size() - 1);
    } // end pop

    public T peek()
    {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack.lastElement();
    } // end peek

    public boolean isEmpty()
    {
        return stack.isEmpty();
    } // end isEmpty


    public void clear()
    {
        stack.clear();
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
}
