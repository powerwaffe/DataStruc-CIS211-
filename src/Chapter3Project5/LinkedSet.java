package Chapter3Project5;
/**
 * Created by Sean on 9/9/2016.
 */
public final class LinkedSet<T> implements SetInterface<T>
{
    private Node firstNode;       //Reference to first node
    private int numberOfEntries;
    public LinkedBag linkedBag = new LinkedBag();

    public LinkedSet()
    {
        firstNode = null;
        numberOfEntries = 0;
    } //end default constructor

    public LinkedSet(LinkedBag linkedBag)
    {
        this.linkedBag = linkedBag;
    } //end constructor

    public int getCurrentSize()
    {
        return linkedBag.getCurrentSize();
    } //end getCurrentSize

    public boolean isEmpty()
    {
        return linkedBag.isEmpty();
    } //end isEmpty

    public boolean add(T newEntry)
    {
        if(!(contains(newEntry)))
        {
            linkedBag.add(newEntry);
            return false;
        }

        return true;
    } //end add

    public boolean remove(T anEntry)
    {
        return linkedBag.remove(anEntry);
    } //end remove

    public T remove()
    {
        return (T) linkedBag.remove();
    } //end remove

    public void clear()
    {
        linkedBag.clear();
    } //end clear

    public boolean contains(T anEntry)
    {
        return linkedBag.contains(anEntry);
    } //end contains

    public T[] toArray()
    {
        return (T[]) linkedBag.toArray();
    } //end toArray

    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null))
        {
            if(anEntry.equals(currentNode.getNextNode()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } //end while

        return currentNode;
    } //end getReferenceTo

    private class Node
    {
        private T data; //Entry in bag
        private Node next; //Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } //end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } //end constructor

        private T getData()
        {
            return data;
        } //end getData


        private void setData(T newData)
        {
            data = newData;
        } //end setData


        private Node getNextNode()
        {
            return next;
        } //end getNextNode


        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } //end setNextNode
    } //end Node
}
