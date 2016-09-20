package Chapter7;

/**
 * Created by Sean on 9/19/2016.
 */
public class TailRecursion
{
    public static void countDown(int integer)
    {
        if (integer >= 1)
        {
            System.out.println(integer);
            countDown(integer - 1);
        } // end if
    } // end countDown


    /** Iterative version of countDown
     * @param integer An integer to count down. */
    public static void countDownIterative(int integer)
    {
        while (integer >= 1)
        {
            System.out.println(integer);
            integer = integer - 1;
        } // end while
    } // end countDownIterative

    public static void main(String[] args)
    {
        System.out.println("Tail recursive method countDown");
        countDown(9);
        System.out.println("Iterative version of method countDownIterative");
        countDownIterative(9);

    }
}
