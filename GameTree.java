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
	evaluate(rootNode);
	    }
    // Pure recursive part of the evaluate function
    public void evaluate(Node n){
	// Evaluate our children
	for(Node child : n.children){
	    evaluate(child);
	}
	// Pick the best
	char[] bestChildBoard;
	
    }
    // This is called after the children
    // have been evaluated and given winner values
    public char[] selectBestChild(int turn){
	char[] bestChildBoard;
	int bestWinnerValue = 0;
	for(Node child : rootNode.children){
	    int w = child.winner;
	    if(turn == 1){
		if(w == 1){
		    bestWinnerValue = 1;
		    bestChildBoard = child.board;
		    break;
		}
		else if(w == 3){
		    bestWinnerValue = 3;
		    bestChildBoard = child.board;
		}else { // w = 2
		    if(bestWinnerValue == 0){
			bestWinnerValue = 2;
			bestChildBoard = child.board;
		    }
		}
	    }else { // turn = 2
		if(w == 2){
		    bestWinnerValue = 2;
		    bestChildBoard = child.board;
		    break;
		}
		else if(w == 3){
		    bestWinnerValue = 3;
		    bestChildBoard = child.board;
		}else { // w = 1
		    if(bestWinnerValue == 0){
			bestWinnerValue = 1;
			bestChildBoard = child.board;
		    }
		}	
	    }
	}
	return bestChildBoard; 
    }
    
}
