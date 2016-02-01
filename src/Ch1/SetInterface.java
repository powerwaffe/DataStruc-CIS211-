package Ch1;

/**
 * Created by Sean on 1/15/2016.
 */
/**An interface that describes the operations of a set of objects*/
public interface SetInterface<T>
{
    public int getCurrentSize();
    public boolean isEmpty();

    /** Adds a new erntry to this set, avoiding duplicates.
     @param newEntry The object to be added as a new entry
     @return  True if the addition is successful, or
        false if the item already is in the set. */
    public boolean add(T newEntry);

    /** Removes a specific entry from this set, if possible
        @param anEntry The entry to be removed
        @return True if the removal was successful, or false if not */
    public boolean remove(T anEntry);

    public T remove();
    public void clear();
    public boolean contains(T anEntry);
    public T[] toArray();
} //end interface
