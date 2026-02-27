import java.util.Scanner;


class TTT implements IntelligentGame {
    char[] board;
    Scanner scanner;  // declare a Scanner field
    String[] playerType; // Human or Computer

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

	playerType = new String[] {"", "Human", "Computer"};

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
    // Game is over, print the final board
	int winner = isThereAWinner();
	announce(winner);
    }
    
    /**
     * Method to announce who the winner is
     */
    private void announce(int winner){
	printBoard();
	if(winner == 0){
	    System.out.println("Crittical Error! No winner.");
        } else if(winner == 1){
	    System.out.println("Congrats Player 1!");
	} else if(winner == 2){
	    System.out.println("Congrats Player 2!");
	} else System.out.println("Too bad! You both lose!");
    }
	    

    /**
     * Player 1 is X, Player 2 is O
     */
    private void makeMove(int turn)
    {
	int move;
	System.out.print("It is Player " + turn + "'s turn. Move: ");
	
	if(playerType[turn].equals("Human"))
	     move = scanner.nextInt();
	else
	     move = getComputerMove(turn);
    char moveChar;
    if(!isLegalMove(move))
    {
        System.out.println("That move is not legal. Try again.");
        makeMove(turn);
    }
    else{
        if(turn == 1){
		moveChar = 'X';
        }else{
		moveChar = 'O';
        }
    board[(move-1)] = moveChar;
    }
    }

    /**
     * Get a move from the computer
     * Builds a game tree and selects a best move
     */
    private int getComputerMove(int turn){
	GameTree gt = new GameTree(board, turn, this);
	gt.evaluate();
	childBoard = gt.selectBestChild(int turn);
	int moveToMake = moveToGetHere(childBoard);
	return MoveToMake;
    }
    
    // Return true if the move is legal, given the current boar[]
    private boolean isLegalMove(int move)
    {
	if(move <= 0) return false;
	if(move > 9) return false;
	if(board[move-1] == 'X' || board[move-1] == 'O')
	    {
		return false;
	    }
	else
	    {
		return true;
	    }
    }

    private int isThereAWinner()
    {
    //winnner
    if(check('X')) return 1;  
    if(check('O')) return 2;  
    // no winner yet so check if game still going or tie
    for(int i = 1; i <= 9; i++) // Loop through the board to check if there are any available tiles left
    {
        if(isLegalMove(i)) return 0;
    }
	return 3; // If no available tiles left, return 3 for a tie
    }

    // Check for winner in horizontal, vertical and diagonal lines
    private boolean check(char c)
    {
    // Check for horizontal lines
    for(int i = 0; i <= 6; i+=3)
       {
       if(board[i] == c && board[i+1] == c && board[i+2] == c)
	   {
	       return true;
           }
       }
    // Check for vertical lines
    for(int i = 0; i <= 2; i++)
        {
        if(board[i] == c && board[i+3] == c && board[i+6] == c)
	    {
                return true;
            }
        }
    // Check for diagonal lines
    // Check for diagonal \
    if(board[0] == c && board[4] == c && board[8] == c) return true;        
    // Check for diagonal /
    if(board[2] == c && board[4] == c && board[6] == c) return true;

    // No winner so return false
    return false;
    }
    
    private boolean gameOver()
    {
	int winner = isThereAWinner();
	if(winner == 0) return false;
        return true;
    }


    private void printBoard()
    {
        // Print the board in a readable format
	System.out.println(board[0] + "|" + board[1] + "|" + board[2] + "\n"
			  + board[3] + "|" + board[4] + "|" +board[5] + "\n"
			  + board[6] + "|" + board[7] + "|" + board[8] );
    }       

    /********************
     * Tree-Building Things
     ********************/
    public ArrayList<char[]> getChildren(char[] board, int turn){

	ArrayList<char[]> childBoards = new ArrayList<>();
	
	for(int i = 0; i < 9; i++;){
	    int move = i + 1;
	    if(!(board[i] == 'X' || board[i] == 'O')){
		    char newBoard[9]; // new board
		    for(int j = 0; j < 9; j++) newBoard[j] = board[j]; // copy
		    newBoard[i] = (turn == 1 ? 'X' : 'O'); // make the move
		    childBoards.add(newBoard);
	    }
	}
	return childBoards;
    }
}
