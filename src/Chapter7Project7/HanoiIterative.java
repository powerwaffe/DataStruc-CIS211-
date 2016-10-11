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
    public static void TowersOfHanoi(int numberOfDisks,
                                     String startPole, String tempPole, String endPole)
    {
        while (numberOfDisks > 0)
        {
            System.out.println("START LOOP");
            /** MUST GO 1, 3, 2, 1 */
            TowersOfHanoi(numberOfDisks - 1, startPole, endPole, tempPole);
            System.out.println(startPole + " -> " + endPole);
            numberOfDisks = numberOfDisks - 1;
            tempPole = startPole;
            //tempPole = startPole;
            System.out.println("END LOOP");
        }
    }

    public static void main(String[] args)
    {
        //DemoIterative demoIterative = new DemoIterative();
        System.out.println("Enter amount of discs: ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();
        TowersOfHanoi(discs, "A", "B", "C");
    } // end of main

    /** Returns the disk to be moved currently */
    /**public static void getDisc()
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
     */
}
