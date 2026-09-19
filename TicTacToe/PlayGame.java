package TicTacToe;

public class PlayGame {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame(3);
        GameStatus status = game.startGame();
        switch (status) {
            case WIN:
                System.out.print("Game won by Player:"+game.winner.getName());
                break;
            case DRAW:
                System.out.print("Game Draw");
            default:
                break;
        }
    }
}
