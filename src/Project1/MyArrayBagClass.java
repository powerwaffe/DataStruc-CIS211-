package Project1; /**
 * Created by Sean on 8/30/2016.
 */

import Chapter1.BagInterface;

/**
 * Created by Sean on 8/29/2016.
 * A class of bags whose entries are stored in a fixed-size array. */
public final class MyArrayBagClass<T> implements BagInterface<T>
{
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    /**Creates an empty bag whose initial capacity is 25. */
    public MyArrayBagClass()
    {
        this(DEFAULT_CAPACITY);
    } //end default constructor

    /**Creates an empty bag having a given initial capacity.
     * @param desiredCapacity The integer capacity desired. */
    public MyArrayBagClass(int desiredCapacity)
    {
        if(desiredCapacity <= MAX_CAPACITY)
        {
            //This cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true; //Last action
        }
        else
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds" +
                    " allowed maximum.");
    } //end constructor


    /**Adds a new entry to this bag.
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not. */
    public boolean add(T newEntry)
    {
        checkInitialization();
        boolean result = true;
        if(isArrayFull())
        {
            result = false;
        }
        else
        { //Assertion: result is true here
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        } //end if
        return result;
    } //end add

    /**Retrieves all entries that are in this bag.
     * @return A newly allovated array of all the entries in this bag. */
    public T[] toArray() {
        checkInitialization();
        //This cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for(int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        } //end for
        return result;
    } //end toArray

    /**Returns true if the ArrayBag is full, or false if not. */
    public boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    } //end isArrayFull

    /**Throws an exception if this object is not initialized. */
    private void checkInitialization()
    {
        if(!initialized)
            throw new SecurityException("ArrayBag object is not initialized properly.");
    } //end checkInitialization

    public int getCurrentSize() {
        return numberOfEntries;
    } //end getCurrentSize

    public boolean isEmpty() {
        return numberOfEntries == 0;
    } //end isEmpty

    public T remove()
    {
        checkInitialization();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    } //end remove

    /**Removes one occurrence of a given entry from this bag.
     * @param anEntry The entry to be removed
     * @return True if the removal was successful, or false if not. */
    public boolean remove(T anEntry)
    {
        checkInitialization();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    } //end remove

    /**Removes and returns the entry at a given array index.
     * If no such entry exists, returns null.
     * Preconditions: 0 <= givenIndex < numberOfEntries; check
     * initialization has been called */
    private T removeEntry(int givenIndex)
    {
        T result = null;
        if(!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex];               //Entry to remove
            bag[givenIndex] = bag[givenIndex - 1];  //Replace entry with last entry

            bag[numberOfEntries - 1] = null;        //Remove last entry
            numberOfEntries--;
        } //end if

        return result;
    } //end removeEntry

    public void clear()
    {
        while(!isEmpty())
            remove();
    } //end clear

    /**Locates a given entry within the array bag.
     *Returns the index of the entry, if located, or -1 otherwise.
     *Precondition: checkInitialization has been called */
    private int getIndexOf(T anEntry)
    {
        int where = -1;
        //boolean found = false;
        boolean stillLooking = true;
        int index = 0;
        while(stillLooking && index < numberOfEntries)
        {
            if(anEntry.equals(bag[index]))
            {
                //found = true;
                stillLooking = false;
                where = index;
            } //end if
            index++;
        } //end while

        //Assertion: If where > -1, andEntry is in the array bag, abd ut
        //equals bag[where]; otherwise, anEntry is not in the array
        return where;
    } //end getIndexOf

    public int getFrequencyOf(T anEntry)
    {
        checkInitialization();
        int counter = 0;
        for(int index = 0; index < numberOfEntries; index++)
        {
            if(anEntry.equals(bag[index]))
            {
                counter++;
            } //end if
        } //end for
        return counter;
    } //end getFrequencyOf

    public boolean contains(T anEntry)
    {
        checkInitialization();
        return getIndexOf(anEntry) > -1;
        /**boolean found = false;
         int index = 0;
         while(!found&&(index < numberOfEntries))
         {
         if(anEntry.equals(bag[index]))
         {
         found = true;
         } //end if
         index++;
         } //end while
         */
    } //end contains
} //end ArrayBag
