package Chapter9;

/**
 * Created by Sean on 9/30/2016.
 */
public class MergeSort
{
    public static <T extends Comparable<? super T>>
        void mergeSort(T[] a, int first, int last)
    {
        // The cast is safe because the new array contains null entries
        //@SuppressWarnings("unchecked");
        T[] tempArray = (T[])new Comparable<?>[a.length]; // Unchecked cast
        //mergeSort(a, tempArray, first, last);
    } // end mergeSort
}
