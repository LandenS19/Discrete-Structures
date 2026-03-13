class Testing{
    public static void main(String[] x){

	int w = 3;
	int h = 4;
	char[] board = new char[]{'x','x','x','o','x','x','o','o','o','o','o','x'};
	char[] newBoard = rotateRight(h, w, board);
	System.out.println(newBoard);

    }

    public static char[] rotateRight(int h, int w, char[] board){
	int index = 0;
	char[] newboard = new char[((w*h)-1)];
	for(int col = 9; col<=11; col++){
	    for(int row = col; row >=0; row -= 3){
		newboard[index] = board[row];
		index ++;
	    }
	}
	return newboard;
    }
}
