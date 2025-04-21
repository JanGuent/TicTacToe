import java.util.Random;
public class ComputerPlayer extends Player{
    public void setSymbol(char sym){
        this.symbol = sym;
    }
    public char getSymbol(){
        return this.symbol;
    }
    @Override
    public Move play() {
        Random rand = new Random();
        return new Move(rand.nextInt((3 - 1) + 1) + 1,rand.nextInt((3 - 1) + 1) + 1);
    }
    public ComputerPlayer(char sym){
        this.symbol = sym;
    }

    public static Move findBestMove(char[][] board, char aiPlayer) {
        int bestVal = Integer.MIN_VALUE;
        Move bestMove = new Move(-1, -1);
        boolean isMaximizing = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = aiPlayer;
                    int moveVal = minimax(board, 0, false, aiPlayer);
                    board[i][j] = ' ';

                    //System.out.println("Evaluating move at (" + i + ", " + j + ") → Score: " + moveVal);

                    if (moveVal > bestVal) {
                        bestMove = new Move(i, j);
                        bestVal = moveVal;
                    }
                }
            }
        }

        //System.out.println("Best move: (" + bestMove.row + ", " + bestMove.col + ") with score: " + bestVal);
        return bestMove;
    }

    private static int minimax(char[][] board, int depth, boolean isMaximizing, char aiPlayer) {
        char humanPlayer = (aiPlayer == 'X') ? 'O' : 'X';

        int score = evaluate(board, aiPlayer, humanPlayer);
        if (score == 10 || score == -10 || !isMovesLeft(board)) {
            return score;
        }

        if (isMaximizing) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = aiPlayer;
                        int val = minimax(board, depth + 1, false, aiPlayer);
                        board[i][j] = ' ';
                        best = Math.max(best, val);
                    }
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = humanPlayer;
                        int val = minimax(board, depth + 1, true, aiPlayer);
                        board[i][j] = ' ';
                        best = Math.min(best, val);
                    }
                }
            }
            return best;
        }
    }

    private static boolean isMovesLeft(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return true;
        return false;
    }

    private static int evaluate(char[][] board, char aiPlayer, char humanPlayer) {
        // Rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != ' ' &&
                    board[row][0] == board[row][1] &&
                    board[row][1] == board[row][2]) {
                return board[row][0] == aiPlayer ? 10 : -10;
            }
        }

        // Columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != ' ' &&
                    board[0][col] == board[1][col] &&
                    board[1][col] == board[2][col]) {
                return board[0][col] == aiPlayer ? 10 : -10;
            }
        }

        // Diagonals
        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return board[0][0] == aiPlayer ? 10 : -10;
        }

        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return board[0][2] == aiPlayer ? 10 : -10;
        }

        return 0;
    }
}
