package Demos;

/**
 * Created by Sean on 8/27/2016.
 */
public class MultiDimenArr {
    public static void main(String[] cheese)
    {
        int[][] table = new int[10][6];

        for (int row = 0; row < 10; row++)
            for (int column = 0; column < 6; column++)
                table[row][column] = 0;

        //different way to populate
        for (int row = 0; row < table.length; row++)
            for (int column = 0; column < table[row].length; column++)
                table[row][column] = 0;
    }
}
