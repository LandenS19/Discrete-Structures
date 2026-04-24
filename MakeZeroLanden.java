import java.util.ArrayList;
import java.util.Scanner;

public class MakeZeroLanden extends TwoPlayerGame implements IntelligentGame{

    public MakeZeroLanden(){
        scanner = new Scanner(System.in);
        board = new char[] {'2', '0'}; 
    }

    private char[] pilesToBoard(ArrayList<Integer> p){
        char[] y = new char[p.size() * 2];
        int idx = 0;
        for(int x : p){
            char firstDigit  = (char)((x/10) + '0'); 
            y[idx] = firstDigit;
            idx++;
            char secondDigit = (char)((x%10) + '0'); 
            y[idx] = secondDigit;
            idx++;
        }
        return y;
    }

    private ArrayList<Integer> boardToPiles(char[] b){
        ArrayList<Integer> rv = new ArrayList<>();
        for(int i = 0; i < b.length; i += 2 ){
            String pileNumber = "" + b[i] + b[i+1];
            rv.add(Integer.parseInt(pileNumber));
        }
        return rv;
    }

    @Override
    public ArrayList<char[]> getChildren(char[] board, int turn) {
        ArrayList<char[]> rv = new ArrayList<>();
        ArrayList<Integer> p = boardToPiles(board);
        int currentNum = p.get(0);
        for(int i = 0; i <= 3; i++){
            ArrayList<Integer> newPiles = new ArrayList<>();
            newPiles.set(0, currentNum - 1);// Change the pile to have -1 stones
            rv.add(pilesToBoard(newPiles));
        }
        return rv;
    }

    @Override
    public int isThereAWinner(char[] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isThereAWinner'");
    }

    @Override
    void printBoard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printBoard'");
    }

    @Override
    void makeMove(int turn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeMove'");
    }

    
    
}
