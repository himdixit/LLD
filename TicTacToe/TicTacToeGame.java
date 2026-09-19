package TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import TicTacToe.model.Pair;
import TicTacToe.model.Player;

public class TicTacToeGame {
    private Board gameBoard;
    private Deque<Player> players;
    public Player winner;

    public void initializeGame(int size)
    {
        this.gameBoard = new Board(size);
        this.players = new LinkedList<>();
        this.players.add(new Player("Atul", new PieceX()));
        this.players.add(new Player("Rahul", new PieceO()));
    }

    public GameStatus startGame()
    {
        boolean noWinner = true;
        try (Scanner sc = new Scanner(System.in)) {
            while(noWinner)
            {
                Player currPlayer = players.removeFirst();
                gameBoard.printBoard();
                List<Pair> freeCells = gameBoard.getFreeCells();
                if(freeCells.size() == 0)
                {
                    noWinner = false;
                    continue;
                }
                System.out.println("Player-"+currPlayer.getName()+" Please Enter Row,Column:");
                String s = sc.nextLine();
                String[] cordinates = s.split(",");
                int row = Integer.valueOf(cordinates[0]);
                int column = Integer.valueOf(cordinates[1]);
                boolean validMove = gameBoard.addPiece(row, column, currPlayer.getType());
                if(!validMove)
                {
                    System.out.println("Invalid Position, Try Again");
                    players.addFirst(currPlayer);
                    continue;
                }
                players.addLast(currPlayer);
                if(checkWinner(row, column, currPlayer.getType()))
                {
                    gameBoard.printBoard();
                    winner=currPlayer;
                    return GameStatus.WIN;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return GameStatus.DRAW;
    }

    public boolean checkWinner(int row, int column, PlayingPiece playingPiece)
    {
        boolean rowMatch=true,columnMatch=true,diagonalMatch=true,antiDiagonalMatch = true;
        //check for row
        for(int i=0;i < gameBoard.getSize(); i++)
        {
            if(gameBoard.getBoard()[row][i] == null || gameBoard.getBoard()[row][i] != playingPiece)
            {
                rowMatch =false;
                break;
            }
        }
        //check for column
        for(int i=0;i < gameBoard.getSize(); i++)
        {
            if(gameBoard.getBoard()[i][column] == null || gameBoard.getBoard()[i][column] != playingPiece)
            {
                columnMatch =false;
                break;
            }
        }
        //check for diagonal
        for(int i=0,j=0; i < gameBoard.getSize();i++,j++)
        {
            if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j] != playingPiece)
            {
                diagonalMatch =false;
                break;
            }
        }
        //check for anti diagonal
        for(int i=0,j=gameBoard.getSize()-1; i < gameBoard.getSize();i++,j--)
        {
            if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j] != playingPiece)
            {
                antiDiagonalMatch =false;
                break;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
