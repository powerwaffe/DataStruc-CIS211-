package Chapter7Project7;

import java.util.Scanner;

/**
 * Created by Sean on 9/19/2016.
 */
public class HanoiIterative
{
    /** A method for moving disks on tower of Hanoi.
     * @param numberOfDisks A number of disks to be moved.
     * @param startPole First pole.
     * @param tempPole Second pole.
     * @param endPole Third pole. */
    private static void solveTowers(int numberOfDisks, int startPole, int endPole, int tempPole)
    {
        while (numberOfDisks > 0)
        {
            solveTowers(numberOfDisks - 1, startPole, endPole, tempPole);
            numberOfDisks = numberOfDisks - 1;
            startPole = tempPole;
            tempPole = startPole;
            endPole = endPole;
        } // end while
       // System.out.printf("%d -> %d\n", startPole, endPole);
    } //end solveTowers

    /** Returns the disk to be moved currently */
    public static void getDisc()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of disks:");
        int numOfDisks = input.nextInt();
        solveTowers(numOfDisks, 1, 3, 2); // Algorithm pattern should be 1, 3, 2, 1.
    } // end getDisc

    public static void main(String[] args)
    {
        getDisc();
    } // end main
}
