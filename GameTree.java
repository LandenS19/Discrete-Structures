/**
 * Contains all the logic for analyzing the next move
 * and who will win
 */

class GameTree
{
    Node rootNode; // The current game board

    public GameTree(char[] board){
	rootNode = new Node();
	rootNode.board = board;
	rootNode.winner = -1;
    }
    /**
     * Build the game tree below node n
     */
    public Node buildTree(char[] board, int turn){
	Node rv = new Node();
	rv.board = board;
	
    }
    
}
