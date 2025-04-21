import java.util.Scanner;

public class HumanPlayer extends Player {

    @Override
    public Move play() {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("Pleaser enter a row:");
            try{
                int row = scan.nextInt();
                if(row>3 || row<1){
                    throw new Exception();
                }
                System.out.println("Pleaser enter a column:");
                int col = scan.nextInt();
                if(col>3 || col<1){
                    throw new Exception();
                }
                scan.nextLine();
                return new Move(row,col);
            } catch (Exception e) {
                System.out.println("Invalid entry, try again");
                scan.nextLine();
            }
        }
        return new Move(0,0);
    }
    public HumanPlayer(){};
    public HumanPlayer(char sym){
        this.symbol = sym;
    };
    public void setSymbol(char sym){
        this.symbol = sym;
    }
    public char getSymbol(){
        return this.symbol;
    }
}
