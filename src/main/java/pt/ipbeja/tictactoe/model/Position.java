package pt.ipbeja.tictactoe.model;

public class Position {

    private final int row;
    private final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /*public boolean isAdjacent(Position other){
        return true;
    }*/

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
