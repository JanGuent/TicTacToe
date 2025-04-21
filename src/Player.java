abstract class Player {
    char symbol;
    public abstract Move play();
    public char getSymbol(){
        return this.symbol;
    }
}
