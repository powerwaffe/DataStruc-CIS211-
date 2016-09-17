package Chapter6;
import java.util.EmptyStackException;

/**
 * Created by Sean on 9/17/2016.
 */
public final class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; // Reference the first node in the chain

    public LinkedStack()
    {
        topNode = null;
    } // end default constructor

    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
        // Both can be replaced with topNode = new Node(newEntry, topNode);
    } // end push

    public T pop()
    {
        T top = peek(); // Might throw EmptyStackException

        assert topNode != null;
        topNode = topNode.getNextNode();

        return top;
    } // end pop

    @Override
    public T peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    } // end peek

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    private class Node
    {
        private T data; // Entry in stack
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
} // end LinkedStack
