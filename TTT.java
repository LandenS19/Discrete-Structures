import java.util.Scanner;


class TTT
{
    char[] board;

    Scanner scanner;  // declare a Scanner field

    public static void main(String[] args)
    {
	TTT ttt = new TTT();
	// Play the game
	ttt.play();
    }

    /**
     * Constructors always:
     *   1. Have the same name as the class
     *   2. Have no return type, not even void
     *   3. Are public
     */
    public TTT()
    {
	// Initialize an array literal
	board = new char[]{'1','2','3','4','5','6','7','8','9'};

	// Instantiate a new scanner
	scanner = new Scanner(System.in);
    }

    private void play()
    {
	int turn = 1; // Player 1 starts the game
	
	while(!gameOver())
	    {
		printBoard();
		makeMove(turn); // Player makes a  move
		turn = 3 - turn;
            }
    }

    /**
     * Player 1 is X, Player 2 is O
     */
    private void makeMove(int turn)
    {
	System.out.print("It is Player " + turn + "'s turn. Move: ");
	int move = scanner.nextInt();
	//if(!isLegalMove(move))
	char moveChar;
	if(turn == 1)
	    {
		moveChar = 'X';
	    }
	else
	    {
		moveChar = 'O';
	    }
	board[(move-1)] = moveChar;
	
    }
    // Return true if the move is legal, given the current boar[]
    private boolean isLegalMove(int move)
    {
	if(board[move-1] == 'X' || board[move-1] == 'O')
	    {
		return false;
	    }
	else
	    {
		return true;
	    }
    }

    private boolean gameOver()
    {
	return false;
    }


    private void printBoard()
    {
        // Print the board in a readable format
	System.out.println(board[0] + "|" + board[1] + "|" + board[2] + "\n"
			  + board[3] + "|" + board[4] + "|" +board[5] + "\n"
			  + board[6] + "|" + board[7] + "|" + board[8] );
    }
       

}
