class TTT
{
    static char[] board;

    public static  void main(String[] args)
    {
	// Tester
	// Initialize an array literal
	board = new char[]{'X','_','_','_','O','_','X','_','_'};
	printBoard();

    }


    private static void printBoard()
    {
	System.out.println(board[0] + "|" + board[1] + "|" + board[2] + "\n"
			  + board[3] + "|" + board[4] + "|" +board[5] + "\n"
			  + board[6] + "|" + board[7] + "|" + board[8] );
    }
       

}
