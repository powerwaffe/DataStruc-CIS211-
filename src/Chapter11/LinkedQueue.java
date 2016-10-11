package Chapter11;

import Chapter10.EmptyQueueException;
import Chapter10.QueueInterface;

/**
 * Created by Sean on 10/3/2016.
 */
public class LinkedQueue<T> implements QueueInterface<T>
{
    private Node firstNode; // References node at front of queue
    private Node lastNode; // References node at back of que

    public LinkedQueue()
    {
        firstNode = null;
        lastNode = null;
    } // end default constructor

    public void enqueue(T newEntry)
    {
        Node newNode = new Node(newEntry, null);
        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);
        lastNode = newNode;
    } // end enqueue

    public T dequeue()
    {
        T front = getFront(); // Might throw EmptyQueueException
        assert firstNode != null;
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();
        if (firstNode == null)
            lastNode = null;
        return front;
    } // end dequeue

    public T getFront()
    {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    } // end getFront

    public boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);
    } //end isEmpty

    public void clear()
    {
        firstNode = null;
        lastNode = null;
    } // end clear

    private class Node
    {
        private T data; // Entry in queue
        private Node next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } //end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData() {
            return data;
        } //end getData


        private void setData(T newData) {
            data = newData;
        } //end setData


        private Node getNextNode() {
            return next;
        } //end getNextNode


        private void setNextNode(Node nextNode) {
            next = nextNode;
        } //end setNextNode
    } // end Node
} // end LinkedQueue
