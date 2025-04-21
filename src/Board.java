public class Board {
    public char[][] board = new char[3][3];
    public Board(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j] = ' ';
            }
        }
    }
    public char[][] getBoard(){
        return this.board;
    }
    public void print(){
        System.out.println("      1     2     3");
        System.out.println("----------------------");
        for(int i=0;i<3;i++){
            System.out.print((i+1)+"  |");
            for(int j=0;j<3;j++){
                System.out.print("  "+board[i][j]+"  |");
            }
            System.out.print("\n");
            System.out.println("----------------------");
        }
    }
    public boolean executeMove(Move move,Player player){
        if(board[move.getRow()-1][move.getCol()-1] == ' '){
            board[move.getRow()-1][move.getCol()-1] = player.getSymbol();
            return true;
        }
        else{
            return false;
        }
    }
    public boolean executeMiniMaxMove(Move move, Player player){
        if(board[move.getRow()][move.getCol()] == ' '){
            board[move.getRow()][move.getCol()] = player.getSymbol();
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isWinner(char c){
        for (int i = 0; i < 3; i++){
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == c){
                    return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == c){
                    return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == c){
                return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == c){
                return true;
        }
        return false;
    }
    public boolean hasMovesLeft(){
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==' '){
                    return true;
                }
            }
        }
        return false;
    }

}
