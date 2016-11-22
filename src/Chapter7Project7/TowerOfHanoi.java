package Chapter7Project7;

/**
 * Created by Sean on 11/16/2016.
 */
import java.lang.*;
import java.util.*;

public class TowerOfHanoi
{
    // Declare static variables to be used
    private static int numberOfDisks;
    private static int moveCount = 0;

    // Static Stack to be used in methods
    private static Stack<Integer>[] tower = new Stack[4];

    public static void main(String[] args)
    {
        // Create scanner object
        Scanner input = new Scanner(System.in);

        // Towers to push disks onto
        tower[1] = new Stack<>();
        tower[2] = new Stack<>();
        tower[3] = new Stack<>();

        //Get Disk Amount
        System.out.println("Enter amount of disks:");
        int num = input.nextInt();
        numberOfDisks = num;
        towerOfHanoi(num);

        // Print amount of times disk has been moved
        System.out.println("Total moves made for " + numberOfDisks + " disks: " + moveCount);
    }

    /** Load disks into stack
     * @param numberOfDisks Amount of disks to be moved onto stack */
    private static void towerOfHanoi(int numberOfDisks)
    {
        for (int i = numberOfDisks; i > 0; i--)
            tower[1].push(i);
        getDisk();
        solveTower(numberOfDisks, tower[1], tower[2], tower[3]);
    } // end towerOfHanoi

    /** Method used to move disks
     * @param startPole Starting position for disks
     * @param tempPole Temporary placeholder pole for disks
     * @param endPole Last pole position for disks */
    static public void moveDisk(Stack startPole, Stack tempPole, Stack endPole)
    {
        tempPole.push(startPole.pop());
        moveCount++;
        getDisk();
        endPole.push(startPole.pop());
        moveCount++;
        getDisk();
        endPole.push(tempPole.pop());
        moveCount++;
        getDisk();
    } // end moveDisk

    /**Moves disks on from tower to tower
     * @param numberOfDisks Amount of disks to be moved
     * @param startPole Starting position for disks
     * @param tempPole Temporary placeholder pole for disks
     * @param endPole Last pole position for disks */
    private static int solveTower(int numberOfDisks, Stack startPole, Stack tempPole, Stack endPole)
    {
        if (numberOfDisks <= 4)
        {
            if ((numberOfDisks % 2) == 0)
            {
                moveDisk(startPole, tempPole, endPole);
                numberOfDisks = numberOfDisks - 1;
                if (numberOfDisks == 1)
                    return 1;
                tempPole.push(startPole.pop());
                moveCount++;
                getDisk();

                // Start pole becomes endPole, tempPole becomes startPole, endPole becomes tempPole
                moveDisk(endPole, startPole, tempPole);
                endPole.push(startPole.pop());
                moveCount++;
                getDisk();

                // StartPole becomes tempPole, tempPole becomes startPole, endPole becomes endPole
                solveTower(numberOfDisks, tempPole, startPole, endPole);
            }
            else
            {
                if (numberOfDisks == 1)
                    return -1;
                moveDisk(startPole, endPole, tempPole);
                numberOfDisks = numberOfDisks - 1;
                endPole.push(startPole.pop());
                moveCount++;
                getDisk();
                moveDisk(tempPole, startPole, endPole);
            }
            return 1;
        }
        else if (numberOfDisks >= 5)
        {
            solveTower(numberOfDisks - 2, startPole, tempPole, endPole);
            tempPole.push(startPole.pop());
            moveCount++;
            getDisk();
            solveTower(numberOfDisks - 2, endPole, startPole, tempPole);
            endPole.push(startPole.pop());
            moveCount++;
            getDisk();
            solveTower(numberOfDisks - 1, tempPole, startPole, endPole);
        }
        return 1;
    } // end solveTower

    /** Prints disk sorting into a table format */
    private static void getDisk()
    {
        // Create table and print disks being moved
        System.out.println("Start\t|\tTemp\t|\tEnd");
        System.out.println("------------------------------");
        for (int i = numberOfDisks - 1; i >= 0; i--)
        {
            String tower1 = " ", tower2 = " ", tower3 = " ";
            try
            {
                tower1 = String.valueOf(tower[1].get(i));
            }
            catch (Exception e)
            {
            }
            try
            {
                tower2 = String.valueOf(tower[2].get(i));
            }
            catch (Exception e)
            {
            }
            try
            {
                tower3 = String.valueOf(tower[3].get(i));
            }
            catch (Exception e)
            {
            }
            System.out.println(tower1 + " \t\t|" + tower2 + "\t\t\t| " + tower3);
        } // end for
        System.out.println("\n");
    } // end getDisk
} // end TowerOfHanoi
