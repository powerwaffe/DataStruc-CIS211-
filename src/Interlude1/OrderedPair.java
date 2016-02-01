package Interlude1;

/**
 * Created by Sean on 1/17/2016.
 */
public class OrderedPair<T> implements Pairable<T>
{
    private T first, second;

    public OrderedPair(T firstItem, T secondItem)
    {
        first = firstItem;
        second = secondItem;
    } //end constructor

    /**Returns the first object in this pair*/
    public T getFirst()
    {
        return first;
    } //end getFirst

    /**Returns the second object in this pair*/
    public T getSecond()
    {
     return second;
    } //end getSecond

    /**Returns a string representation of this pair*/
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    } //end toString

    /**Interchanges the objects in this pair*/
    public void changeOrder()
    {
        T temp = first;
        first = second;
        second = temp;
    } //end changeOrder

    /**Reverts order of the objects in this pair*/
    public void orderReset()
    {
        T temp = second;
        second = first;
        first = temp;
    } //end orderReset

    /**How to use class and interface*/
    public static void main(String[] args) {
        OrderedPair<String> fruit = new OrderedPair<>("apple", "banana");
        System.out.println(fruit);
        fruit.changeOrder();
        System.out.println(fruit);
        String firstFruit = fruit.getFirst();
        String secondFruit = fruit.getSecond();
        System.out.println(firstFruit + " has length " + firstFruit.length());
        System.out.println(secondFruit + " has length " + secondFruit.length());
        fruit.orderReset();
        System.out.println("-------------------" + "\nReverted back to original:\n" + fruit);
    } //end main
} //end orderedPair
