package Chapter1;

/**
 * Created by Sean on 8/29/2016.
 */
public interface Pairable<T>
{
    public T getFirst();
    public T getSecond();
    public void changeOrder();
}
