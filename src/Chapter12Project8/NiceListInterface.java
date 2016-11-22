package Chapter12Project8;

/**
 * Created by Sean on 10/13/2016.
 */
public interface NiceListInterface<T>
{
    /** Adds a new entry to the end of the nice list.
     * Entries currently in the nice list are unaffected.
     * The nice lists's size is increased by 1.
     * @param newEntry The object to be added as a new entry. */
    public void add(T newEntry);

    /** Adds a new entry ast a specified position within the nice list.
     * Entries originally at and above the specified position
     * are at the next higher position within the nice list.
     * The nice list's size is increased by 1.
     * @param newPosition An integer that specifies the desired
     *                    position of the new entry.
     * @param newEntry The object to be added as a new entry.
     * @throws IndexOutOfBoundsException if either
     * newPosition < 1 or newPosition > getLength() + 1.*/
    public void add(int newPosition, T newEntry);

    /** Removes the entry at a given position from the nice list.
     * Entries originally at positions higher than the given
     * position are at the next lower position within the nice list,
     * and the nice list's size is decreased by 1.
     * @param givenPosition An integer that indicates the position of
     *                      the entry to be removed.
     * @return A reference to the removed entry.
     * @throws IndexOutOfBoundsException if either
     *         givenPosition < 1 or givenPosition > getLength().*/
    public T remove(int givenPosition);

    /** Removes all entries from the nice list. */
    public void clear();

    /** Replaces the entry at a given position in the nice list.
     * @param givenPosition An integer that indicates te position of
     *                      the entry to be replaced.
     * @param newEntry The object that will replace the entry at the
     *                 position givenPosition.
     * @return The original entry that was replaced.
     * @throws IndexOutOfBoundsException if either
     *         givenPosition < 1 or givenPosition > getLength(). */
    public T replace(int givenPosition, T newEntry);

    /** Retrieves the entry at a given position in the nice list.
     * @param givenPosition An integer that indicates the position of
     *                      the desired entry.
     * @return A reference to the indicated entry.
     * @throws IndexOutOfBoundsException if either
     *         givenPosition < 1 or givenPosition > getLength(). */
    public T getEntry(int givenPosition);

    /** Retrieves all entries that are in the nice list in the order in which
     * they occur in the nice list.
     * @return A newly allocated array of all the entries in the nice list.
     *         If the nice list is empty, the returned array is empty */
    public T[] toArray();

    /** Sees whether the nice list contains a given entry.
     * @param anEntry The object that is the desired entry.
     * @return True if the nice list contains anEntry, or false if not. */
    public boolean contains(T anEntry);

    /** Gets the length of the nice list.
     * @return The integer number of entries currently on the nice list. */
    public int getLength();

    /** Sees whether the nice list is empty.
     * @return True if the nice list is empty, or false if not. */
    public boolean isEmpty();
} // end NiceListInterface
