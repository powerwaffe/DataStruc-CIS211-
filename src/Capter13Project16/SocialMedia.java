package Capter13Project16;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * Created by Sean on 11/2/2016.
 * Specifications: Account must be created beforehand for searching and management
 * to display correct results if account exists or not.
 */
public class SocialMedia
{
    static String name = "";
    static String friends = "";

    public static void main(String[] args)
    {
        try {
            // Create scanner object
            Scanner input = new Scanner(System.in);

            // This will be used to consume new line characters
            String consume;

            // Ask for user input
            System.out.println("Welcome to the social media management system\nPlease enter your option (1-2)");
            System.out.println("1 - Join Network");
            System.out.println("2 - Leave Network");

            // User's response
            int selection = input.nextInt();

            // Create array list to hold profiles
            List<String> socialArray = new ArrayList();

            // Friends array list
            List<String> friendsList = new ArrayList<>();

            /** Join network to create, modify, or search of a profile
             * Social media menu options */

            if (selection == 1) {
                System.out.println("Joining...");
                boolean end = false;
                while (end != true) {
                    // Ask user to create, modify, or search for a profile
                    System.out.println("Make a selection:");
                    System.out.println("1 - Create a Profile");
                    System.out.println("2 - Modify a Profile");
                    System.out.println("3 - Search For a Profile");
                    System.out.println("4 - Leave network");
                    int management = input.nextInt();

                    /** CREATE PROFILE */
                    if (management == 1) {
                        System.out.println("Enter your first and last name to create a profile:");

                        // Consume new line character
                        consume = input.nextLine();
                        name = input.nextLine().toUpperCase();
                        System.out.println("Welcome, " + name.toUpperCase());

                        // Add name to ArrayList
                        socialArray.add(name.toUpperCase());
                    } // end if

                    /** MODIFY PROFILE */
                    else if (management == 2) {
                        System.out.println("Enter the first and last name of the profile you would like to modify");
                        consume = input.nextLine();
                        name = input.nextLine().toUpperCase();

                        // Modify entered profile
                        for (int i = 0; i < socialArray.size(); i++) {
                            // Search for matches
                            if (socialArray.contains(name)) {
                                System.out.println("Now modifying profile of " + name);
                                boolean endLoop = false;
                                while (endLoop != true) {
                                    // Ask for friends
                                    System.out.println("Enter name of friend to add");
                                    friends = input.nextLine();

                                    // Add friends to list friendsList
                                    friendsList.add(friends);
                                    System.out.println("Add more friends? Yes or no");

                                    String yesOrNo = input.next();
                                    consume = input.nextLine();
                                    if (yesOrNo.toUpperCase().equals("NO")) {
                                        endLoop = true;
                                    } // end if
                                } // end while

                                // print friends list before exiting
                                System.out.println(name + "'s friends: ");
                                System.out.println(friendsList.toString().replace("[", "").replace("]", ""));
                            } else if (!socialArray.contains(name)) {
                                System.out.println("Profile, " + name + " not found.");
                                break;
                            }
                            break;  // To prevent multiple runs of while loop
                        } // end for loop
                    } // end else if

                    /** SEARCH FOR PROFILE */
                    else if (management == 3) {
                        System.out.println("Enter a first and last to search for profile:");
                        consume = input.nextLine();
                        name = input.nextLine().toUpperCase();

                        // Search list for name
                        for (int i = 0; i < socialArray.size(); i++) {
                            // Search for matches
                            if (socialArray.contains(name)) {
                                System.out.println("Profile found for " + name);
                                break;
                            } else if (!socialArray.contains(name)) {
                                System.out.println("Profile, " + name + " not found.");
                                break;
                            }
                        } // end for loop
                    } // end if

                    /** LEAVE NETWORK */
                    else if (management == 4) {
                        System.out.println("Leaving network, goodbye " + name);
                        System.exit(0);
                    } // end else if
                } // end while
            } // end if

            /** LEAVE NETWORK */
            else if (selection == 2) {
                System.out.println("Leaving network");
            } // end else if
        }
        catch (InputMismatchException ex)
        {
            System.out.println("Invalid input...");
        }
    } // end main
} // end SocialMedia
