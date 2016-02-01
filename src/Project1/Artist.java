package Project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by Sean on 2/1/2016.
 */

public class Artist
{
    private String artistName;
    private int artistID;

    public Artist(int ID, String artist)
    {
        artistID = ID;
        artistName = artist;
    } // end constructor

    public String getDescription()
    {
        return artistName;
    } // end getDescription

    public int getPrice()
    {
        return artistID;
    } // end getPrice

    public String toString()
    {
        return getArtistID() + " " + getArtistName();
    } // end toString

    private String getArtistName()
    {
        return artistName;
    }

    private void setArtistName(String newName)
    {
        artistName = newName;
    }

    private int getArtistID()
    {
        return artistID;
    }

    private void setArtistID(int newID)
    {
        artistID = newID;
    }

    public static void main(String[] args)
    {
        try {
            Scanner art = new Scanner(
                    new File("C:\\Users\\Sean\\IdeaProjects\\DataStruc [CIS211]\\src\\p1artists.txt"));
            while (art.hasNext())
            {
                try {
                    //int artist = art.nextInt();
                    String name = art.nextLine();
                    System.out.println(name);
                } catch (InputMismatchException e)
                {
                    //System.out.println("Invalid ID type" + e.getStackTrace());
                    art.next();
                }
            }
            art.close();
        } catch (FileNotFoundException e) {
           // System.out.println();
        }

        // Artist[] items = {new Artist(1, "Acconci"),
             //   new Artist(2, "Ames"),
               // new Artist(3, "Aserty"),
              //  new Artist(4, "Baron"),
             //   new Artist(5, "Battenberg")};

        //for (int i = 0; i < items.length; i++)
            //System.out.println(items[i]);
    }
} // end Artist
