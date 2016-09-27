package Chapter7Project7;
import java.util.*;
/**
 * Created by Sean on 9/26/2016.
 */
public class HanoiIterativeStack
{
    public static int numberOfDisks;
    public static Stack<Integer>[] tower = new Stack[4];

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        // Towers to push disks onto
        tower[1] = new Stack<>();
        tower[2] = new Stack<>();
        tower[3] = new Stack<>();

        //Get Disk Amount
        System.out.println("Enter amount of disks:");
        int num = input.nextInt();
        numberOfDisks = num;
        towersOfHanoi(num);
    }

    /** Load disks into stack
     * @param numberOfDisks Amount of disks to be moved onto stack */
    private static void towersOfHanoi(int numberOfDisks)
    {
        for (int i = numberOfDisks; i > 0; i--)
            tower[1].push(i);
        getDisk();
        solveTowers(numberOfDisks, 1, 2, 3);
    } // end towersOfHanoi

    /**Moves disks on from tower to tower
     * @param numberOfDisks Amount of disks to be moved
     * @param startPole Starting position for disks
     * @param tempPole Temporary placeholder pole for disks
     * @param endPole Last pole */
    private static void solveTowers(int numberOfDisks, int startPole, int tempPole, int endPole)
    {
        /** Try and change to iterative */
        if (numberOfDisks > 0)
        {
            solveTowers(numberOfDisks - 1, startPole, endPole, tempPole);
            int startTower = tower[startPole].pop();
            tower[endPole].push(startTower);
            getDisk();
            solveTowers(numberOfDisks - 1, tempPole, startPole, endPole);
        } // end if
    } // end solveTowers

    /** Prints disk sorting */
    private static void getDisk()
    {
        //System.out.println("Solving towers with " + numberOfDisks + " disks...\n");
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
}