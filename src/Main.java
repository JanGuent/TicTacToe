import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("Welcome to command line TicTacToe!");
            System.out.println("Please choose your game mode by entering the appropriate number");
            System.out.println("(1) Human vs Human");
            System.out.println("(2) Human vs Computer (Random)");
            System.out.println("(3) Human vs Computer (Minimax Algorithm)");
            System.out.println("(4) Computer (Random) vs Computer (Random)");
            System.out.println("(5) Computer (Random) vs Computer (Minimax Algorithm)");
            System.out.println("(6) Computer (Minimax Algorithm) vs Computer (Minimax Algorithm)");
            System.out.println("(7) Exit");
            Scanner scan = new Scanner(System.in);
            while(!scan.hasNextInt()){
                System.out.println("That is not a valid number. Try again: ");
                scan.next();
            }
            int value = scan.nextInt();
            switch(value){
                case 1:
                    System.out.println("Starting a Human vs Human Match!");
                    HumanVsHuman();
                    break;
                case 2:
                    System.out.println("Starting a Human vs Computer(Random) Match!");
                    HumanVsRandom();
                    break;
                case 3:
                    System.out.println("Starting a Human vs Computer(Minimax Algorithm) Match!");
                    HumanVsMinimax();
                    break;
                case 4:
                    System.out.println("Starting a Computer(Random) vs Computer(Random) Match!");
                    RandomVsRandom();
                    break;
                case 5:
                    System.out.println("Starting a Computer(Random) vs Computer(Minimax Algorithm) Match!");
                    RandomVsMinimax();
                    break;
                case 6:
                    System.out.println("Starting a Computer(Minimax Algorithm) vs Computer(Minimax Algorithm) Match!");
                    MinimaxVsMinimax();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("That is not a valid number. Try again: ");
                    scan.nextLine();
                    break;
            }

        }
    }
    public static void HumanVsHuman() {
        HumanPlayer player1 = new HumanPlayer('X');
        HumanPlayer player2 = new HumanPlayer('O');
        Board board = new Board();
        while (true) {
            board.print();
            boolean p1SuccessfulMove = false;
            System.out.println("Player 1's("+player1.getSymbol()+") turn: ");
            while (!p1SuccessfulMove) {
                Move p1move = player1.play();
                p1SuccessfulMove = board.executeMove(p1move, player1);
                if(!p1SuccessfulMove){
                System.out.println("Invalid Move! Please enter a different Move");
                }
            }
            board.print();
            if(board.isWinner(player1.getSymbol())){
                System.out.println(player1.getSymbol()+ " wins!");
                break;
            }
            if(!board.hasMovesLeft()){
                System.out.println("A draw!");
                break;
            }
            boolean p2SuccessfulMove = false;
            System.out.println("Player 2's("+player2.getSymbol()+") turn: ");
            while (!p2SuccessfulMove) {
                Move p2move = player2.play();
                p2SuccessfulMove = board.executeMove(p2move, player2);
                if(!p2SuccessfulMove){
                    System.out.println("Invalid Move! Please enter a different Move");
                }
            }
            board.print();
            if(board.isWinner(player2.getSymbol())){
                System.out.println(player2.getSymbol()+ " wins!");
                break;
            }
        }
    }
    public static void HumanVsRandom() {
        HumanPlayer player1 = new HumanPlayer('X');
        ComputerPlayer player2 = new ComputerPlayer('O');
        Board board = new Board();
        while (true) {
            board.print();
            boolean p1SuccessfulMove = false;
            System.out.println("Player 1's("+player1.getSymbol()+") turn: ");
            while (!p1SuccessfulMove) {
                Move p1move = player1.play();
                p1SuccessfulMove = board.executeMove(p1move, player1);
                if(!p1SuccessfulMove){
                    System.out.println("Invalid Move! Please enter a different Move");
                }
            }
            board.print();
            if(board.isWinner(player1.getSymbol())){
                System.out.println(player1.getSymbol()+ " wins!");
                break;
            }
            if(!board.hasMovesLeft()){
                System.out.println("A draw!");
                break;
            }
            boolean p2SuccessfulMove = false;
            System.out.println("Player 2's("+player2.getSymbol()+") turn: ");
            while (!p2SuccessfulMove) {
                Move p2move = player2.play();
                p2SuccessfulMove = board.executeMove(p2move, player2);
            }
            board.print();
            if(board.isWinner(player2.getSymbol())){
                System.out.println(player2.getSymbol()+ " wins!");
                break;
            }
        }
    }
    public static void RandomVsRandom() {
        ComputerPlayer player1 = new ComputerPlayer('X');
        ComputerPlayer player2 = new ComputerPlayer('O');
        Board board = new Board();
        while (true) {
            board.print();
            boolean p1SuccessfulMove = false;
            System.out.println("Player 1's("+player1.getSymbol()+") turn: ");
            while (!p1SuccessfulMove) {
                Move p1move = player1.play();
                p1SuccessfulMove = board.executeMove(p1move, player1);
            }
            board.print();
            if(board.isWinner(player1.getSymbol())){
                System.out.println(player1.getSymbol()+ " wins!");
                break;
            }
            if(!board.hasMovesLeft()){
                System.out.println("A draw!");
                break;
            }
            boolean p2SuccessfulMove = false;
            System.out.println("Player 2's("+player2.getSymbol()+") turn: ");
            while (!p2SuccessfulMove) {
                Move p2move = player2.play();
                p2SuccessfulMove = board.executeMove(p2move, player2);
            }
            board.print();
            if(board.isWinner(player2.getSymbol())){
                System.out.println(player2.getSymbol()+ " wins!");
                break;
            }
        }
    }
    public static void HumanVsMinimax() {
        HumanPlayer player1 = new HumanPlayer('X');
        ComputerPlayer player2 = new ComputerPlayer('O');
        Board board = new Board();
        while (true) {
            board.print();
            boolean p1SuccessfulMove = false;
            System.out.println("Player 1's("+player1.getSymbol()+") turn: ");
            while (!p1SuccessfulMove) {
                Move p1move = player1.play();
                p1SuccessfulMove = board.executeMove(p1move, player1);
                if(!p1SuccessfulMove){
                    System.out.println("Invalid Move! Please enter a different Move");
                }
            }
            board.print();
            if(board.isWinner(player1.getSymbol())){
                System.out.println(player1.getSymbol()+ " wins!");

                break;
            }
            if(!board.hasMovesLeft()){
                System.out.println("A draw!");
                break;
            }
            boolean p2SuccessfulMove = false;
            System.out.println("Player 2's("+player2.getSymbol()+") turn: ");
            while (!p2SuccessfulMove) {
                Move p2move = player2.findBestMove(board.getBoard(),'O');
                p2SuccessfulMove = board.executeMiniMaxMove(p2move, player2);
            }
            board.print();
            if(board.isWinner(player2.getSymbol())){
                System.out.println(player2.getSymbol()+ " wins!");
                break;
            }
        }
    }
    public static void RandomVsMinimax() {
        ComputerPlayer player1 = new ComputerPlayer('X');
        ComputerPlayer player2 = new ComputerPlayer('O');
        Board board = new Board();
        while (true) {
            board.print();
            boolean p1SuccessfulMove = false;
            System.out.println("Player 1's("+player1.getSymbol()+") turn: ");
            while (!p1SuccessfulMove) {
                Move p1move = player1.play();
                p1SuccessfulMove = board.executeMove(p1move, player1);
            }
            board.print();
            if(board.isWinner(player1.getSymbol())){
                System.out.println(player1.getSymbol()+ " wins!");
                break;
            }
            if(!board.hasMovesLeft()){
                System.out.println("A draw!");
                break;
            }
            boolean p2SuccessfulMove = false;
            System.out.println("Player 2's("+player2.getSymbol()+") turn: ");
            while (!p2SuccessfulMove) {
                Move p2move = player2.findBestMove(board.getBoard(),'O');
                p2SuccessfulMove = board.executeMiniMaxMove(p2move, player2);
            }
            board.print();
            if(board.isWinner(player2.getSymbol())){
                System.out.println(player2.getSymbol()+ " wins!");
                break;
            }
        }
    }
    public static void MinimaxVsMinimax() {
        ComputerPlayer player1 = new ComputerPlayer('X');
        ComputerPlayer player2 = new ComputerPlayer('O');
        Board board = new Board();
        while (true) {
            board.print();
            boolean p1SuccessfulMove = false;
            System.out.println("Player 1's("+player1.getSymbol()+") turn: ");
            while (!p1SuccessfulMove) {
                Move p1move = player1.findBestMove(board.getBoard(),'X');
                p1SuccessfulMove = board.executeMiniMaxMove(p1move, player1);
            }
            board.print();
            if(board.isWinner(player1.getSymbol())){
                System.out.println(player1.getSymbol()+ " wins!");
                break;
            }
            if(!board.hasMovesLeft()){
                System.out.println("A draw!");
                break;
            }
            boolean p2SuccessfulMove = false;
            System.out.println("Player 2's("+player2.getSymbol()+") turn: ");
            while (!p2SuccessfulMove) {
                Move p2move = player2.findBestMove(board.getBoard(),'O');
                p2SuccessfulMove = board.executeMiniMaxMove(p2move, player2);
            }
            board.print();
            if(board.isWinner(player2.getSymbol())){
                System.out.println(player2.getSymbol()+ " wins!");
                break;
            }
        }
    }
}