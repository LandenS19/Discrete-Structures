/**
 * A single node in the game tree
 */
import java.util.ArrayList;

class Node{
    char[] board; // The board in this node
    int turn; // Whose turn it is
    ArrayList<Node> children;

    public Node(){
	children = new ArrayList<>();
    }
}
