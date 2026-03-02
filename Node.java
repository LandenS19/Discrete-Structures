/**
 * A single node in the game tree
 */
import java.util.ArrayList;

class Node{
    char[] board; // The board in this node
    int turn; // Whose turn it is
    int winner; // Is this node I, II, or III, for who wins?
    ArrayList<Node> children;

    public Node(){
	this.children = new ArrayList<>();
	this.winner = -1; // No value
    }
}
