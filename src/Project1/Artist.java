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
    private int price;

    public Artist(int ID, String artist)
    {
        artistID = ID;
        artistName = artist;
    } // end constructor

    public String toString()
    {
        return getArtistID() + " " + getArtistName();
    } // end toString

    private String getArtistName()
    {
        return artistName;
    } //end getArtistName

    private void setArtistName(String newName)
    {
        artistName = newName;
    } //end setArtistName

    private int getArtistID()
    {
        return artistID;
    } //end getArtistID

    private void setArtistID(int newID)
    {
        artistID = newID;
    } //end setArtistID

    /**MODIFY TO DETECT INCORRECT ID*/
    public static void main(String[] args)
    {
        try {
            Scanner art = new Scanner(
                    new File("C:\\Users\\Sean\\IdeaProjects\\DataStruc [CIS211]\\src\\p1artists.txt"));
            while (art.hasNext())
            {
                try {
                    int artist = art.nextInt();
                    String name = art.next();
                    System.out.println(artist + " " + name);
                }
                catch (InputMismatchException e)
                {
                    //System.out.println("Invalid ID type");
                  //  e.printStackTrace();
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

    public int getPrice() {
        return price;
    }
} // end Artist
