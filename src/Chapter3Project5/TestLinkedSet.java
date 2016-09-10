package Chapter3Project5;
/**
 * Created by Sean on 9/9/2016.
 */
public class TestLinkedSet
{
    public static void main(String[] args) {
        //create string array to test set
        String[] contentsOfSet = {"A", "B", "C", "D", "E", "F"};

        //Test on an empty set
        SetInterface<String> aSet = new LinkedSet<>();
        System.out.println("Testing an initially empty bag:");
        testIsEmpty(aSet, true);

        //Test if set contains an item
        String[] testStrings1 = {"A", "B"};
        testContains(aSet, testStrings1);

        //Test adding to an initially empty set
        System.out.println("\nAdding " + contentsOfSet.length + " strings to an initially empty linked set ");
        testAdd(aSet, contentsOfSet);

        //Test removing a strings from linked set
        System.out.println("Testing the removal of an unspecified entry from the linked set");
        String[] testStrings2 = {""};
        testRemove(aSet, testStrings2);

        //Test removing a specific item from set
        String[] testStrings3 = {"B"};
        testRemove(aSet, testStrings3);

        //Try adding duplicate string
        System.out.println("Trying to add duplicate string to linked set:");
        String[] testStrings4 = {"C"};
        testAdd(aSet, testStrings4);

        //Clear linked set
        System.out.println("Removing all strings from linked set:");
        aSet.clear();
        displaySet(aSet);
    } //end main

    private static void testIsEmpty(SetInterface<String> aSet, boolean correctResult)
    {
        System.out.print("Testing isEmpty with ");
        if (correctResult)
            System.out.println("an empty set:");
        else
            System.out.println("a set that is not empty:");

        System.out.print("isEmpty finds the set ");
        if (correctResult && aSet.isEmpty())
            System.out.println("empty: OK.");
        else if (correctResult)
            System.out.println("not empty, but it is empty: ERROR.");
        else if (!correctResult && aSet.isEmpty())
            System.out.println("empty, but it is not empty: ERROR.");
        else
            System.out.println("not empty: OK.");
        System.out.println();
    } //end testIsEmpty

    private static void testContains(SetInterface<String> aSet, String[] tests)
    {
        System.out.println("\nTesting the method contains:");
        for (int index = 0; index < tests.length; index++)
            System.out.println("Does this bag contain " + tests[index] +
                    "? " + aSet.contains(tests[index]));
    } // end testContains

    private static void testAdd(SetInterface<String> aSet, String[] content)
    {
        for (int index = 0; index < content.length; index++)
        {
            if(aSet.contains(content[index]))
            {
                System.out.println("Already in set, cannot add duplicates.");
            } //end if
            else
            {
                aSet.add(content[index]);
                System.out.print("Adding ");
                System.out.print(content[index] + " ");
            } //end else
        } // end for
        System.out.println();
        displaySet(aSet);
    } //end testAdd

    private static void testRemove(SetInterface<String> aSet, String[] tests)
    {
        for (int index = 0; index < tests.length; index++)
        {
            String aString = tests[index];
            if (aString.equals("") || (aString == null))
            {
                // test remove()
                System.out.println("Removing a string from the set:");
                String removedString = aSet.remove();
                System.out.println("remove() returns " + removedString);
            }
            else
            {
                // test remove(aString)
                System.out.println("Removing \"" + aString + "\" from the set:");
                boolean result = aSet.remove(aString);
                System.out.println("remove(\"" + aString + "\") returns " + result);
            } // end if
            displaySet(aSet);
        } // end for
    } // end testRemove

    private static void displaySet(SetInterface<String> aSet)
    {
        System.out.println("\nThe set contains " + aSet.getCurrentSize() +
                " string(s), as follows:");
        Object[] setArray = aSet.toArray();
        for (int index = 0; index < setArray.length; index++)
        {
            System.out.print(setArray[index] + " ");
        } // end for
        System.out.println("\n");
    } //end displaySet
} //end TestLinkedSet
