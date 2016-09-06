package Projects;

import java.util.NoSuchElementException;

/**
 * Created by Sean on 8/31/2016.
 */
public final class ArraySet<T> implements SetInterface<T>
{
    private T[] bag; // Cannot be final due to doubling
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
    private static final int MAX_CAPACITY = 10000;
    private final int NOT_FOUND = -1;
    public ResizableArrayBag resizableArrayBag = new ResizableArrayBag(); //create object to be called

    public ArraySet(ResizableArrayBag ResizeBag)
    {
        this.resizableArrayBag = resizableArrayBag;
    } //end constructor

    public ArraySet()
    {
        this(DEFAULT_CAPACITY);
    } //end default constructor

    public ArraySet(int initialCapacity)
    {
        T[] tempBag = (T[]) new Object[initialCapacity];
        bag = tempBag;
        numberOfEntries = 0;
        initialized = true;
    } //end constructor

    public int getCurrentSize()
    {
        return resizableArrayBag.getCurrentSize();
    }
     //end getCurrentSize

    public boolean isEmpty()
    {
        return resizableArrayBag.isEmpty();
    } //end isEmpty

    public boolean add(T newEntry)
    {
        /**if(contains(newEntry))
            return false;
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;*/

        /**
        for(int index = 0; index < numberOfEntries; index++)
            if(bag[index] == newEntry)
                return false;
        return resizableArrayBag.add(newEntry);
         */
        if(!(contains(newEntry)))
        {
            resizableArrayBag.add(newEntry);
            return false;
        }
        return true;
    } //end add

    public boolean remove(T anEntry)
    {
        /**(int search = NOT_FOUND;
        if(isEmpty())
        {

        }
        for(int index = 0; index < numberOfEntries && search == NOT_FOUND; index++)
        {
            if(bag[index].equals(anEntry))
            {
                search = index;
            }
        }
        if(search == NOT_FOUND)
        {
            throw NoSuchElementException;
        }
        T result = bag[search];

        bag[search] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        resizableArrayBag.remove(anEntry);

        return result;*/
        return resizableArrayBag.remove(anEntry);
    } //end remove

    public T remove()
    {
        /**T result = null;
        if(numberOfEntries > 0)
        {
            result = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
         */
        return (T) resizableArrayBag.remove();
    } //end remove

    public void clear()
    {
        resizableArrayBag.clear();
    } //end clear

    public boolean contains(T anEntry)
    {
        return resizableArrayBag.contains(anEntry);
    } //end contains

    public T[] toArray()
    {
        return (T[])resizableArrayBag.toArray();
    } //end toArray
} //end ArraySet
