/**
 * Methods that enable a game tree to be built and evaluated
 */

interface IntelligentGame {
    XXX getChildren(char[] board);

    // Return 0 for still playing, 1 or 2 for winner, 3 for tie
    int evaluateBoard(char[] board);

    // Return 1 or 2 for winner, 3 for tie
    int evaluateNode(Node n, int turn);
}
