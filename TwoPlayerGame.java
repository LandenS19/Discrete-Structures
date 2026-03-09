/**
 * Abstract class that actual games may extend.
 */

import java.util.Scanner;
import java.util.ArrayList;

abstact class TwoPlayerGame {
    char[] board;
    Scanner scanner;  // declare a Scanner field
    String[] playerType; // Human or Computer

    public static void main(String[] args)
    {
	//TwoPlayerGame g = new TwoPlayerGame();
	// Play the game
	//g.play();
    }

    private void play(){
	int turn = 1; // Player 1 starts the game
	
	while(!gameOver()) {
	    printBoard();
	    makeMove(turn); // Player makes a  move
	    turn = 3 - turn;
	}
	// Game is over, print the final board
	int winner = isThereAWinner(this.board);
	announce(winner);
    }

    private boolean gameOver()
    {
	int winner = isThereAWinner(this.board);
	if(winner == 0) return false;
        return true;
    }
    abstract void printBoard();
    
}
