package TicTacToe;

public class PlayingPiece {
    private Symbol type;

    public PlayingPiece(Symbol s)
    {
        this.type=s;
    }

    public Symbol getType() {
        return type;
    }

    public void setType(Symbol type) {
        this.type = type;
    }
}
