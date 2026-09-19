package TicTacToe;

import java.util.List;

import TicTacToe.model.Pair;

import java.util.ArrayList;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size)
    {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece p)
    {
        if(row >= size || col >= size)
            return false;
        if(board[row][col]!=null)
            return false;
        board[row][col] = p;
        return true;
    }

    public List<Pair> getFreeCells()
    {
        List<Pair> freeCells = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == null) {
                    freeCells.add(new Pair(row, col));
                }
            }
        }
        return freeCells;
    }

    public void printBoard()
    {
        for(int i=0; i<size; i++)
        {
            for(int j=0; j<size; j++)
            {
                if(board[i][j] != null)
                    System.out.print(" "+board[i][j].getType().name()+" ");
                else
                    System.out.print("   ");
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }
}
