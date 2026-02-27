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
    public Node buildTree(char[] theBoard, int turn){
	Node rv = new Node();
	rv.board = theBoard;
	rv.turn = turn;

	// Children stuff
	ArrayList<char[]> children = game.getChildren(board, turn);
	for(char[] b : children){
	    Node childNode = buildTree(b, 3-turn);
	    rv.children.add(childNode);
	}
	
	return rv;
    }

    /**
     * Evaluate the tree, so that every node has I, II, or III inside,
     * saying who will win from this node, if all players play optimaly
     */
    public void evaluate(){
	
    }
    
}
