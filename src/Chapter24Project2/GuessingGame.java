package Chapter24Project2;
import java.io.*;
/**
 * Created by Sean on 11/26/2016.
 *
 * Game guesses between 10 animals using yes or no questions. Game loops until
 * user deems otherwise. If wrong answer is available and not what the user had
 * in mind, the program can take a user made question, add it to the tree, and
 * ask if it is a yes or no question.
 * INFO: Game runs off of "Questions.txt" which is included. This text file has
 * the questions as well as the animal guesses. Each line starts integer 1 or 0.
 * Integer 1 is used for questions and integer 0 is used for guesses.
 * EXAMPLE FILE STRUCTURE:
 * 1 Does this animal walk on four legs
 * 0 Penguin
 * ...
 */

public class GuessingGame
{
    // This is so readLine() can be used on our BufferReader object
    private static BufferedReader consoleIn = new BufferedReader
            (new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        /** USE FULL FILEPATH IF DESIGNATED PATH DOES NoT RUN */
        String filename = "C:/Users/Sean/IdeaProjects/DataStruc [CIS211]" +
                "/src/Chapter24Project2/Questions.txt";
        BufferedReader questions =
                new BufferedReader(new FileReader(filename));

        // Create the game
        GuessingGame theGame = new GuessingGame(questions);
        questions.close();

        System.out.println("---WELCOME TO THE ANIMAL GUESSING GAME!---");

        // Loop game until user chooses otherwise
        do
        {
            // Loop prompt and game
            System.out.println("Allow me to guess the animal you are thinking of...");
            theGame.playGame();
        }
        while (askYesOrNo("Would you like to play again"));
    } // end main

    public GuessingGame(BufferedReader file) throws IOException
    {
        treeRoot = readMyTree(file);
    } // end constructor

    /** Method used for playing game. Expand tree as needed  */
    public void playGame() throws IOException
    {
        Node currentNode = treeRoot; // Current node position in tree

        while (currentNode.isAQuestion())
        {
            if (askYesOrNo(currentNode.getQuestions()))
                currentNode = currentNode.getYesTree();
            else
                currentNode = currentNode.getNoTree();
        } // end while

        if (! askYesOrNo("Is it a " + currentNode.getGuess()))
        {
            // The user guessed wrong, so find out what he/she was thinking. Create a
            // new question for future usage.
            String userAnswer, userQuestion;

            System.out.print("What animal were you thinking of? ");
            userAnswer = consoleIn.readLine();
            System.out.println("Please enter a yes or no question that would distinguish "
                    + userAnswer + " from " + currentNode.getGuess());
            userQuestion = consoleIn.readLine();

            // Extend binary tree
            if (askYesOrNo("For " + userAnswer + " the answer would be"))
                currentNode.convertToQuestion(userQuestion,
                        new Node(currentNode.getGuess()), new Node(userAnswer));
            else
                currentNode.convertToQuestion(userQuestion,
                        new Node(userAnswer), new Node(currentNode.getGuess()));
        } // end if
    } // end playGame

    private Node treeRoot; // Root of internal knowledge tree

    /** Read a tree stored in a file
     *	@param myFile the file to read from
     *	@return treeRoot of resultant tree */
    private static Node readMyTree(BufferedReader myFile) throws IOException
    {
        // Read information for current node
        boolean question = ((char) myFile.read() == '1');
        myFile.skip(1);		// Skip over single blank space
        String contents = myFile.readLine();

        // Create the node
        if (question)
        {
            Node ifNo = readMyTree(myFile);
            Node ifYes = readMyTree(myFile);
            return new Node(contents, ifNo, ifYes);
        }
        else
            return new Node(contents);
    } // end readMyTree

    /** Ask the user a yes or no question
     *	@param askQuestions Question to ask
     *	@returntrue if user answers yes, false if no */
    private static boolean askYesOrNo(String askQuestions) throws IOException
    {
        String answer;
        do
        {
            // Ask questions and convert answer to upper case
            System.out.print(askQuestions + "? (Yes or No)");
            answer = consoleIn.readLine();

            // Get yes or no response for user
            if (answer.equalsIgnoreCase("YES".substring(0, answer.length())))
                return true;
            else if (answer.equalsIgnoreCase("NO".substring(0, answer.length())))
                return false;
            else
                System.out.println("Please answer yes or no");
        }
        while (true);
    } // end askYesOrNo

    private static class Node
    {
        /** Constructor for a question node
         *	@param askQuestion the question to ask
         *	@param responseIsNo the subtree to go into if user answers no
         *	@param responseIsYes the subtree to go into if user answers yes */
        Node(String askQuestion, Node responseIsNo, Node responseIsYes)
        {
            isAQuestion = true;
            contents = askQuestion;
            this.leftChild = responseIsNo;
            this.rightChild = responseIsYes;
        } // end constructor

        /** Constructor for a guess node
         *	@param guess the guess to try */
        Node(String guess)
        {
            isAQuestion = false;
            contents = guess;
            leftChild = null;
            rightChild = null;
        } // end constructor

        /** Accessor for whether a node represents a question or a guess
         *	@return true if a question, false if a guess */
        boolean isAQuestion()
        {
            return isAQuestion;
        } // end isAQuestion

        /** Accessor for question stored in a node.
         *  Precondition: the node represents a question
         *	@return the question stored */
        String getQuestions()
        {
            return contents;
        } // end getQuestions

        /** Accessor for "no" tree from a question node.
         *  Precondition: the node represents a question
         *	@return treeRoot of the "no" tree */
        Node getNoTree()
        {
            return leftChild;
        } // end getNoTree

        /** Accessor for "yes" tree from a question node.
         *  Precondition: the node represents a question
         *	@return treeRoot of the "yes" tree */
        Node getYesTree()
        {
            return rightChild;
        } // end getYesTree

        /** Accessor for guess stored in a node.
         *  Precondition: the node represents a guess
         *	@return the guess stored */
        String getGuess()
        {
            return contents;
        } // end getGuess

        /** Convert a guess node to a question node
         *	Precondition: the node currently represents a guess
         *	@param question the question to ask
         *	@param ifNo the subtree to go into if user answers no
         *	@param ifYes the subtree to go into if user answers yes */
        void convertToQuestion(String question, Node ifNo, Node ifYes)
        {
            this.isAQuestion = true;
            contents = question;
            leftChild = ifNo;
            rightChild = ifYes;
        } // end convertToQuestion

		// Variables for Node
        private boolean isAQuestion;	// True for question, false for guess
        private String contents;	// Question or guess
        private Node leftChild, rightChild; // "No" and "Yes" branches for a question
    } // end Node
} // end GuessingGame
