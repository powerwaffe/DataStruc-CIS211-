package Chapter7;

/**
 * Created by Sean on 9/18/2016.
 */
public class Recursion
{
    public static void main(String[] args)
    {
        System.out.println("Recursive method that returns void.");
        countDown(10);

        System.out.println("Recursive method that returns a value.");
        System.out.println(sumOf(3));
    } // end main

    /** Counts down from a given integer
     * @param integer An integer > 0 */
    public static void countDown(int integer)
    {
        System.out.println(integer);
        if (integer > 1)
            countDown(integer - 1);
    } // end countDown

    /** Counts down from a given integer
     * @param integer An integer > 0 */
    public static void countDown2(int integer)
    {
        if (integer >= 1)
        {
            System.out.println(integer);
            countDown2(integer - 1);
        } // end if
    } // end countDown2

    /** Counts down from a given integer
     * @param integer An integer > 0 */
    public static void countDown3(int integer)
    {
        if (integer == 1)
            System.out.println(integer);
        else
        {
            System.out.println(integer);
            countDown3(integer - 1);
        } // end if
    } // end countDown3

    /** @param n An integer > 0
     * @return The sum 1 + 2 + ... + n. */
    public static int sumOf(int n)
    {
        int sum;
        if (n == 1)
            sum = 1;                // Base Case
        else
            sum = sumOf(n - 1) + n; // Recursive call
        return sum;
    } // end sumOf
} // end Recursion
