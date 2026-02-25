/**
 * Contains all the logic for analyzing the next move
 * and who will win
 */

class GameTree
{
    Node rootNode; // The current game board
    IntelligentGame game; // The game that we are playing inside of
    
    public GameTree(char[] board, int turn, IntelligentGame game){
	this.rootNode = buildTree(board, turn);
	this.game = game;
    }
    
    /**
     * Build the game tree below node n
     */
    public Node buildTree(char[] board, int turn){
	Node rv = new Node();
	rv.board = board;
	rv.turn = turn;

	// Children stuff
	ArrayList<char[]> children = game.getChildren(board);
	
	return rv;
    }
    
}
