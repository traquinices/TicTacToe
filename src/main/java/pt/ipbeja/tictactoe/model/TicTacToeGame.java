package pt.ipbeja.tictactoe.model;

import javafx.css.Size;

import java.util.Arrays;

public class TicTacToeGame {

    private final int size;
    //public static final int SIZE = 3;
    private final View view;

    private int turnCounter;

    private final Mark[][] board;

    private Position selectedPosition = null;


    public TicTacToeGame(int size, View view) {
        this.board = new Mark[size][size];
        this.size = size;
        this.view = view;
        for (Mark[] marks : board) {
            Arrays.fill(marks, Mark.EMPTY);

        }
    }

    public void positionSelected(Position position){
        Player currentPlayer = getCurrentPlayer(); // todo descobrir quem está a jogar
        Mark playerMark = currentPlayer.getMark(); // todo obter a Mark do jogador atual
        int row = position.getRow();
        int col = position.getCol();

        Mark mark = board[row][col];

        /*
            if(selectedPosition != null && isAdjacent() {
            // a mover peça
            }
            else if (playerMark == mark){
            // pretente mover a peça
            selectedPosition = position;

            }
            else if (mark == Mark.EMPTY){
                // jogada normal
            }
         */

        if (mark == Mark.EMPTY) {
            if( selectedPosition != null){
                int selectedRow = selectedPosition.getRow();
                int selectedCol = selectedPosition.getCol();
                board[selectedRow][selectedCol] = Mark.EMPTY;
                view.onBoardMarkChanged(Mark.EMPTY, selectedPosition);

            }
            board[row][col] = playerMark;
            view.onBoardMarkChanged(playerMark, position);
            checkGameOver(row, col);

            turnCounter++;
        } else if (mark == playerMark) {
            selectedPosition = position;

        }
    }

    private boolean checkGameOver(int row, int col){
        if (checkRow(row) || checkCol(col) || checkDiagonal(row, col) || checkAntiDiagonal(row, col)){
            Player currentPlayer = getCurrentPlayer();
            view.onGameWon(currentPlayer);
            return true;
        }
        if (turnCounter == (size * size) -1){

          view.onGameDraw();
        }
            return false;
    }

    private boolean checkRow(int row){
        // [X,X,X] / [O,O,O]

        Mark ref = board[row][0]; // vamos usar o primeiro mark para comparar com as restantes na linha

        for (int i = 1; i < board.length; i++) {
            Mark mark = board[row][i];
            if (mark != ref)
                //se a mark atual for diferente da 1º mark, entao nao há vencedor
                return false;
        }
        return true;

    }
    private boolean checkCol(int col){
        /*
            [X]    [O]
            [X] ou [O]
            [X]    [O]
         */
        Mark ref = board[0][col];

        for (int i = 1; i < board.length; i++) {
            Mark mark = board[i][col];
            if (mark != ref)
                return false;
        }

        return true;
    }
    private boolean checkDiagonal(int row, int col){
        //↘
        // as cordenadas tem que ser iguais
        if (row != col){
            return false;
        }
        Mark ref = board[0][0];
        for (int i = 1; i < board.length; i++) {
            Mark mark = board [i][i];
            if (mark != ref)
                return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(int row, int col){
        //↙
        if (row + col != size - 1)
            return false;

        Mark ref = board[0][size - 1];
        for (int i = 1, j = size - 2; i < size; i++, j--) {
            Mark mark = board[i][j];
            if (mark != ref)
                return false;
        }

        return true;
    }

    private Player getCurrentPlayer() {

        return  turnCounter % 2 == 0 ? Player.X : Player.O;
    }
    /*private boolean areAdjacent(Position pos1, Position pos2){
        //....
        return true;
    }*/
}
