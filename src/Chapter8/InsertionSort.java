package Chapter8;

/**
 * Created by Sean on 9/29/2016.
 */
public class InsertionSort
{
    public static <T extends Comparable<? super T>>
        void insertionSort(T[] a, int first, int last)
    {
        if (first < last)
        {
            // Sort all but the last entry
            insertionSort(a, first, last - 1);

            // Insert the last entry in sorted order
            insertInOrder(a[last], a, first, last - 1);
        } // end if
    } // end insertionSort

    // Insert anEntry into the sorted array entries a[begin] through a[end].
    // Revised draft.
    private static <T extends Comparable<? super T>>
        void insertInOrder (T anEntry, T[] a, int begin, int end)
    {
        //if (anEntry >= a[end])
          //  a[end + 1] = anEntry;
        //else if (begin < end)
        {
            a[end + 1] = a[end];
            insertInOrder(anEntry, a, begin, end - 1);
        }
       // else
        {
         //   a[end + 1] = a[end];
           // a[end] = anEntry;
        }
    }
}
