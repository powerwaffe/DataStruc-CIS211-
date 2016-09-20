package Chapter7;

/**
 * Created by Sean on 9/19/2016.
 */
public class ArrayRecursion
{

    public static void main(String[] args)
    {
        int[] array = {1, 2 ,3};
        displayArray(array, 0, 2);
    }

    /** Displays the integers in an array.
     * @param array An array of integers.
     * @param first The index of the first element displayed.
     * @param last The index of the last element displayed,
     *             0 <= first <= last < array.length. */
    public static void displayArray(int array[], int first, int last)
    {
        System.out.println(array[first] + " ");
        if (first < last)
            displayArray(array, first + 1, last);
    } // end displayArray

    public static void displayArray2(int array[], int first, int last)
    {
        if (first <= last)
        {
            displayArray2(array, first, last - 1);
            System.out.println(array[last] + " ");
        }
    } // end displayArray2

    public static void displayArray3(int array[], int first, int last)
    {
        if (first == last)
            System.out.println(array[first] + " ");
        else
        {
            int mid = (first + last) / 2;
            displayArray3(array, mid + 1, last);
        }
    } // end displayArray3
}
