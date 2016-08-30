package Chapter1;

/**
 * Created by Sean on 8/29/2016.
 */
public class OrderedPair<T> implements Pairable<T>
{
    private T first, second;

    public OrderedPair(T firstItems, T secondItem) //NOTE: no <T> after constructor name
    {
        first = firstItems;
        second = secondItem;
    } //end constructor

    /**Returns the first object in this pair. */
    public T getFirst()
    {
        return first;
    } //end getFirst

    /**Returns the second object in this pair. */
    public T getSecond()
    {
        return second;
    }

    /**Returns a string representation of this pair. */
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    } //end toString

    /**Interchanges the obects in this pair. */
    public void changeOrder()
    {
        T temp = first;
        first = second;
        second = temp;
    } //end changeOrder

    public static void main(String[] cheese)
    {
        OrderedPair<String> fruit = new OrderedPair<>("apple", "banana");
        System.out.println(fruit);
        fruit.changeOrder();
        System.out.println(fruit);
        String firstFruit = fruit.getFirst();
        System.out.println(firstFruit + " has length " + firstFruit.length());

        OrderedPair<Integer> intPair = new OrderedPair<>(1, 2);
        System.out.println(intPair);
        intPair.changeOrder();
        System.out.println(intPair);
    }

} //end OrderedPair
