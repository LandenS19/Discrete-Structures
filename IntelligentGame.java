/**
   (Interface)
 * Methods that enable a game tree to be built and evaluated
 */
import java.util.ArrayList;


interface IntelligentGame {
    // Returns the child boards as char[]
    ArrayList<char[]> getChildren(char[] board, int turn);
    
    // Return 1, 2 or 3
    int isThereAWinner(char[] board);
}
