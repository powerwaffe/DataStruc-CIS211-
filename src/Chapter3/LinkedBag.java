package Chapter3;

/**
 * Created by Sean on 9/8/2016.
 */
public final class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode; //Referecne to first node
    private int numberOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    } //end default constructor

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isArrayFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**Adds a new entry to this bag.
     * @param newEntry the object to be added as a new entry,
     * @return True */
    public boolean add(T newEntry) {
        //Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; //Mae new node reference rest of chain (firstNode is null if chain is empty)
        firstNode = newNode;

        return true;
    } //end add

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }


    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;

        while((loopCounter < numberOfEntries) && (currentNode != null))
        {
            if(anEntry.equals(currentNode.data))
                frequency++;
            loopCounter++;
            currentNode = currentNode.next;
        }//end while

        return frequency;
    }//end getFrequencyOf

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null))
        {
            if(anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        } //end while

        return found;
    } //end contains

    /**Retrieves all entries that in this bag.
     * @return A newly allocated array of all the entries in the bag. */
    public T[] toArray() {
        //The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; //Unchecked cast

        int index = 0;
        Node currentNode = firstNode;
        while((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }//end while
        return result;
    } //end toArray

    private class Node
    {
        private T    data; // Entry in bag
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node
}//end LinkedBag
