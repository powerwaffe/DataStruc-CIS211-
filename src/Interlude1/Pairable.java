package Interlude1;

/**
 * Created by Sean on 1/17/2016.
 */
public interface Pairable<T>
{
    public T getFirst();
    public T getSecond();
    public void changeOrder();
    public void orderReset();
} //end Pairable
