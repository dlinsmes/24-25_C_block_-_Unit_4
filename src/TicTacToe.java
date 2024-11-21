import java.util.Scanner;

public class TicTacToe {

    //class variables - can use them in any method within
    //the class
    static Scanner s = new Scanner(System.in);
    static String [][] board;
    static String [] name = new String [2];
    static String [] pieces = {"x", "o"};

    public static void main(String [] args) {

        //setup - sets the size of board and gets names
        //print board
        //loop turns until game over
        //-turn
        //-print board
        //-change player

        setup();
        printBoard();
        int currentPlayer = 0; //will switch between 0 and 1
        while( !gameOver(currentPlayer) ) {

            turn(currentPlayer);
            printBoard();
            currentPlayer = change(currentPlayer); //flip current between 0 and 1
        }
    }

    public static void setup() {
        System.out.println("how big is the board?");
        int size = s.nextInt();
        while (size < 1) {
            System.out.println("invalid size. enter a positive number");
            size = s.nextInt();
        }

        board = new String [size][size];

        //initialize values so not null
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "_";
            }
        }

        s.nextLine();
        System.out.println("Player 1 name?");
        name[0] = s.nextLine();
        System.out.println("Player 2 name?");
        name[1] = s.nextLine();
    }

    public static void printBoard() {
        //size cannot be accessed outside of the method it was declared in (setup)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    //return true if there's a win or tie, false if not
    public static boolean gameOver(int prevPlayer) {
        //prev player bc main() will change the player before checking for a win
        String piece = pieces[0];
        if (prevPlayer == 0)
            piece = pieces[1];

        boolean tie = true;
        for (int i = 0; i < board.length; i++) {

            int hCount = 0;
            int vCount = 0;
            int d1Count = 0;
            int d2Count = 0;

            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(piece))
                    hCount++;
                if (board[j][i].equals(piece))
                    vCount++;
                if (board[j][j].equals(piece))
                    d1Count++;
                if (board[j][board.length-j-1].equals(piece))
                    d2Count++;
                if (board[i][j].equals("_"))
                    tie = false;
            }

            if (hCount == board.length || vCount == board.length || d1Count == board.length || d2Count == board.length) {
                System.out.println("You win!");
                //return true when there's a win to stop the game loop from continuing
                return true;
            }
        }

        //if a game fill causes a win, the return for a win will run, and will
        //stop the method from continuing to run so a tie message won't get output
        if (tie) {
            System.out.println("tie game!");
            return true;
        }

        //return false when no other situations for a game over have been reached
        //so nothing else has been returned at this point
        return false;
    }

    //index will be 0 or 1 and will be used to select which player and piece is used
    public static void turn(int index) {
        System.out.println(name[index] + " - it's your turn. Place your " + pieces[index]);

        System.out.println("enter row");
        int row = s.nextInt();
        System.out.println("enter col");
        int col = s.nextInt();

        while( row < 0 || row >= board.length || col < 0 || col >= board.length || !board[row][col].equals("_") ) {
            System.out.println("invalid spot");
            System.out.println("enter row");
            row = s.nextInt();
            System.out.println("enter col");
            col = s.nextInt();
        }

        board[row][col] = pieces[index];

    }

    //current will be 0 or 1 - return the other value
    public static int change(int current) {
        //only the first return statement reached will run, then the method code
        //stops
        //-a method call can only return one value
        if (current == 0)
            return 1;
        return 0;
    }

}
