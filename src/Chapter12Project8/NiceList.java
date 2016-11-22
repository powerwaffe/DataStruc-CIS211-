package Chapter12Project8;

/**
 * Created by Sean on 10/13/2016.
 */
public class NiceList<T> implements NiceListInterface<T>
{

    // Adds an entry to the nice list where newEntry is the object to be added.
    // Precondition: newEntry is an object.
    // Postcondition: newEntry will be added to the nice list.
    public void add(T newEntry)
    {
    }

    // Adds an entry newEntry at specified position in the nice list.
    // newPosition is the starting position to be added where 1 indicates the
    // first entry in the nice list.
    // Precondition: newPosition is an integer and newEntry is an object.
    // Postcondition: newEntry will be added to position newPosition, or if invalid,
    // an exception will be thrown if newPosition is an invalid position.
    public void add(int newPosition, T newEntry)
    {
    }

    // Removes an entry from the nice list at a given position.
    // givenPosition is the position in the nice list to remove the entry.
    // Precondition: givenPosition is an integer
    // Postcondition: Removed entry will be returned, or if invalid,
    // an exception will be thrown if givenPosition is invalid.
    public T remove(int givenPosition)
    {
        return null;
    }

    // Clears all entries from the nice list.
    // Precondition: None.
    // Postcondition: None.
    public void clear()
    {

    }

    // Replaces the entry in the nice list where givenPosition is the position of
    // the item on the list and newEntry is the entry to replace it.
    // Precondition: givenPosition is an integer and newEntry is an object.
    // Postcondition: Either returns the replaced entry or throws an exception
    // if givenPostion is invalid.
    public T replace(int givenPosition, T newEntry)
    {
        return null;
    }

    // Retrieves the entry at a given position where givenPosition is the position to find.
    // Precondition:  givenPosition is an integer.
    // Postcondition: Either returns the entry at givenPosition or throws an
    // exception if givenPosition is invalid.
    public T getEntry(int givenPosition)
    {
        return null;
    }

    // Retrieves all the entries that are in the nice list in the order in which
    // they occur.
    // Precondition: None.
    // Postcondition: Returns a new array of the entries currently in the nice list.
    public T[] toArray()
    {
        return null;
    }

    // Sees whether the nice list contains anEntry. anEntry is the object in the nice list to be found.
    // Precondition: anEntry is an object.
    // Postcondition: Returns true if anEntry is in the nice list, or false if not.
    public boolean contains(T anEntry)
    {
        return false;
    }

    // Gets the number of entries in the nice list.
    // Precondition: None.
    // Postcondition: Returns the number of entries currently in the nice list.
    public int getLength()
    {
        return 0;
    }

    // Checks if the nice list is empty.
    // Precondition: None.
    // Postcondition: Returns true if nice list is empty, or false if not.
    public boolean isEmpty()
    {
        return false;
    }
} // end NiceList
