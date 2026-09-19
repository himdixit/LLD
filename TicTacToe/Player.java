package TicTacToe;

public class Player {
    private String name;
    private PlayingPiece type;
    
    public Player(String name,PlayingPiece value)
    {
        this.name=name;
        this.type=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingPiece getType() {
        return type;
    }

    public void setType(PlayingPiece type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", type=" + type + ", getName()=" + getName() + ", getType()=" + getType().getType().name()
                + "]";
    }
}
