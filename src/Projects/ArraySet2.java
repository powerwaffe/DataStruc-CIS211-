package Projects;
import java.util.Arrays;
/**
 * Created by Sean on 8/31/2016.
 */
public final class ArraySet2<T> implements SetInterface<T>
{
    private T[] bag; // Cannot be final due to doubling
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
    public ResizableArrayBag resizableArrayBag = new ResizableArrayBag(); //create object to be called

    public ArraySet2(ResizableArrayBag ResizeBag)
    {
        this.resizableArrayBag = resizableArrayBag;
    } //end constructor

    public ArraySet2()
    {
        this(DEFAULT_CAPACITY);
    } //end default constructor

    public ArraySet2(int initialCapacity)
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
        if(!(contains(newEntry)))
        {
            if(resizableArrayBag.isArrayFull() == false)
            {
                int newLength = 2 * bag.length;
                bag = Arrays.copyOf(bag, newLength);
            }
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return false;
        }
        return true;
    } //end add

    public boolean remove(T anEntry)
    {
        return resizableArrayBag.remove(anEntry);
    } //end remove

    public T remove()
    {
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