/**
 * Contains all the logic for analyzing the next move
 * and who will win
 */
import java.util.ArrayList;
class GameTree
{
    Node rootNode; // The current game board
    IntelligentGame game; // The game that we are playing inside of
    
    public GameTree(char[] board, int turn, IntelligentGame game){
	this.game = game;
	this.rootNode = buildTree(board, turn);

    }
    
    /**
     * Build the game tree below node n
     */
    public Node buildTree(char[] theBoard, int turn){
	Node rv = new Node();
	rv.board = theBoard;
	rv.turn = turn;

	// Children stuff
	ArrayList<char[]> children = game.getChildren(theBoard, turn);
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
	// Base Case
	if(n.children.size() == 0){
	    n.winner = game.isThereAWinner(n.board);
	}
	// Evaluate our children
	for(Node child : n.children){
	    evaluate(child);
	}
	// Pick the best
	int bestWinnerValue = 0;
	int turn = n.turn;
	for(Node child : n.children){
	    int w = child.winner;
	    if(turn == 1){
		if(w == 1){
		    n.winner = 1; // We have found the best
		    return;
		}
		else if(w == 3){
		    bestWinnerValue = 3;
		}else { // w = 2
		    if(bestWinnerValue == 0){
			bestWinnerValue = 2;
		    }
		}
	    }else { // turn = 2
		if(w == 2){
		    n.winner = 2;
		    return;
		}
		else if(w == 3){
		    bestWinnerValue = 3;
		}else { // w = 1
		    if(bestWinnerValue == 0){
			bestWinnerValue = 1;
		    }
		}	
	    }
	    n.winner = bestWinnerValue; // Put the answer into the node
	}
	
    }
    // This is called after the children
    // have been evaluated and given winner values
    public char[] selectBestChild(int turn){
	char[] bestChildBoard = null;
	int bestWinnerValue = 0;
	for(Node child : rootNode.children){
	    int w = child.winner;
	    if(turn == 1){
		if(w == 1){
		    return child.board; // We have found the best
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
		    return child.board;
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
