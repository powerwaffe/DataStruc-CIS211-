package Demos;

/**
 * Created by Sean on 11/26/2016.
 */
import java.io.*;

public class GuessingGame
{
    /** Constructor
     *  @param file the file to read the game tree from */
    public GuessingGame(BufferedReader file) throws IOException
    {
        animal = file.readLine();
        treeRoot = readTree(file);
    } // end GuessingGame

    /** Save the (possibly modified) game tree to a file
     *  @param file the file to save the game tree to */
    public void saveTree(PrintWriter file) throws IOException
    {
        file.println(animal);
        writeTree(file, treeRoot);
    } // end saveTree

    /** Play an instance of the game, updating the tree if needed  */
    public void playGame() throws IOException
    {
        Node current = treeRoot;

        //System.out.println("Please think of a(n) " + animal);
        if (! askYesNo("Are you thinking of a(n) " + animal))
            return;

        while (current.isQuestion())
        {
            if (askYesNo(current.getQuestion()))
                current = current.getYesBranch();
            else
                current = current.getNoBranch();
        } // end while

        if (! askYesNo("Is it " + current.getGuess()))
        {
            // The user guessed wrong, so find out what he/she was thinking. Create a
            // new question for future usage.
            String userAnswer, userQuestion;

            System.out.print("What animal were you thinking of? ");
            userAnswer = consoleIn.readLine();
            System.out.println("Please enter a yes/no question that would distinguish "
                    + userAnswer + " from " + current.getGuess());
            userQuestion = consoleIn.readLine();

            // Extend binary tree
            if (askYesNo("For " + userAnswer + " the answer would be"))
                current.convertToQuestion(userQuestion,
                        new Node(current.getGuess()), new Node(userAnswer));
            else
                current.convertToQuestion(userQuestion,
                        new Node(userAnswer), new Node(current.getGuess()));
        } // end if
    } // end playGame

    public static void main(String[] args) throws IOException
    {
        // Use full filepath to read animal log file
        String filename = "C:/Users/Sean/IdeaProjects/DataStruc [CIS211]/src/Demos/Questions.txt";
        BufferedReader questions =
                new BufferedReader(new FileReader(filename));

        // Create the game
        GuessingGame theGame = new GuessingGame(questions);
        questions.close();

        // Loop game until user chooses otherwise
        do
        {
            theGame.playGame();
        }
        while (askYesNo("Would you like to play again"));

        // User's opportunity to save to file
        System.out.print("File to write the knowledge base to - blank for none? ");
        filename = consoleIn.readLine();

        if (filename.length() > 0)
        {
            PrintWriter knowledgeOut = new PrintWriter(new FileWriter(filename));
            theGame.saveTree(knowledgeOut);
            knowledgeOut.close();
        } // end if
        System.exit(0);
    } // end main

    private String animal;		// Subject the game is about
    private Node treeRoot;			// Root of internal knowledge tree

    /** Read a tree stored in preorder in a file
     *	@param file the file to read from
     *	@return treeRoot of resultant tree */
    private static Node readTree(BufferedReader file) throws IOException
    {
        // Read information for current node
        boolean isQuestion = ((char) file.read() == '1');
        file.skip(1);		// Skip over single blank space
        String contents = file.readLine();

        // Create the node
        if (isQuestion)
        {
            Node ifNo = readTree(file);
            Node ifYes = readTree(file);
            return new Node(contents, ifNo, ifYes);
        }
        else
            return new Node(contents);
    }

    /** Write a tree to a file in preorder
     *	@param file the file to write to
     *	@param root the treeRoot of the tree */
    private static void writeTree(PrintWriter file, Node root) throws IOException
    {
        file.print(root.isQuestion() ? 1 : 0);
        file.print(" ");
        if (root.isQuestion())
        {
            file.println(root.getQuestion());
            writeTree(file, root.getNoBranch());
            writeTree(file, root.getYesBranch());
        }
        else
            file.println(root.getGuess());
    }

    /** Ask the user a yes-no question
     *
     *	@param question the question to ask
     *	@returntrue if user answers yes, false if no
     *
     *  (reprompt the user if the answer is not recognizable.)
     */

    private static boolean askYesNo(String question) throws IOException
    {
        String answer;
        do
        {
            // Ask the user the question, read answer, convert to all caps

            System.out.print(question + "? ");
            answer = consoleIn.readLine();

            // Check to see if answer was yes or no.  If so, return appropriate
            // value - else ask again.

            if (answer.equalsIgnoreCase("YES".substring(0, answer.length())))
                return true;
            else if (answer.equalsIgnoreCase("NO".substring(0, answer.length())))
                return false;
            else
                System.out.println("Please answer yes or no");
        }
        while (true);
    }

    /** The game tree is composed of two kinds of nodes - question
     *	(internal) nodes and guess (leaf) nodes.  The content of
     *	a question node is the question to ask; of a guess node,
     *	the answer to propose.  A guess node can be turned into a
     * 	question node when a guess fails
     */

    private static class Node
    {
        /** Constructor for a question node
         *
         *	@param question the question to ask
         *	@param ifNo the subtree to go into if user answers no
         *	@param ifYes the subtree to go into if user answers yes
         */

        Node(String question, Node ifNo, Node ifYes)
        {
            isQuestion = true;
            contents = question;
            this.lchild = ifNo;
            this.rchild = ifYes;
        }

        /** Constructor for a guess node
         *
         *	@param guess the guess to try
         */

        Node(String guess)
        {
            isQuestion = false;
            contents = guess;
            lchild = null;
            rchild = null;
        }

        /** Accessor for whether a node represents a question or a guess
         *
         *	@return true if a question, false if a guess
         */

        boolean isQuestion()
        {
            return isQuestion;
        }

        /** Accessor for question stored in a node.
         *  Precondition: the node represents a question
         *
         *	@return the question stored
         */

        String getQuestion()
        {
            return contents;
        }

        /** Accessor for "no" branch from a question node.
         *  Precondition: the node represents a question
         *
         *	@return treeRoot of the "no" branch
         */

        Node getNoBranch()
        {
            return lchild;
        }

        /** Accessor for "yes" branch from a question node.
         *  Precondition: the node represents a question
         *
         *	@return treeRoot of the "yes" branch
         */

        Node getYesBranch()
        {
            return rchild;
        }

        /** Accessor for guess stored in a node.
         *  Precondition: the node represents a guess
         *
         *	@return the guess stored
         */

        String getGuess()
        {
            return contents;
        }

        /** Convert a guess node to a question node
         *	Precondition: the node currently represents a guess
         *
         *	@param question the question to ask
         *	@param ifNo the subtree to go into if user answers no
         *	@param ifYes the subtree to go into if user answers yes
         */

        void convertToQuestion(String question, Node ifNo, Node ifYes)
        {
            isQuestion = true;
            contents = question;
            lchild = ifNo;
            rchild = ifYes;
        }

		/* Instance variables of a Node */

        private boolean isQuestion;	// True for question, false for guess
        private String contents;	// Question or quess as the case may be
        private Node lchild, rchild;// "No" and "Yes" branches for a question
    }

	 /* Wrap System.in in a BufferedReader object so we can use readLine(),
	  * etc. on it.
	  */

    private static BufferedReader consoleIn =
            new BufferedReader(new InputStreamReader(System.in));
}
