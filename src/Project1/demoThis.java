package Project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by Sean on 2/1/2016.
 */

public class demoThis {
    private String artistName;
    private int artistID;

    public demoThis(int ID, String artist) {
        artistID = ID;
        artistName = artist;
    } // end constructor

    public String getDescription() {
        return artistName;
    } // end getDescription

    public int getPrice() {
        return artistID;
    } // end getPrice

    public String toString() {
        return getArtistID() + " " + getArtistName();
    } // end toString

    private String getArtistName() {
        return artistName;
    }

    private void setArtistName(String newName) {
        artistName = newName;
    }

    private int getArtistID() {
        return artistID;
    }

    private void setArtistID(int newID) {
        artistID = newID;
    }

    public static void main(String[] args) {
        try {
            // File myFile = new File("data_txt");
            Scanner bob = new Scanner(new File("p1artists.txt"));
            while (bob.hasNext()) {
                try {
                    String mine = bob.nextLine();
                    System.out.println("Integer read is: " + mine);
                } catch (InputMismatchException e) {
                    // System.out.println("Non-integer data was read");
                    bob.next();
                }
            }
            bob.close();

            // Artist[] items = {new Artist(1, "Acconci"),
            //   new Artist(2, "Ames"),
            // new Artist(3, "Aserty"),
            //  new Artist(4, "Baron"),
            //   new Artist(5, "Battenberg")};
            //for (int i = 0; i < items.length; i++)
            //System.out.println(items[i]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } // end Artist
}
