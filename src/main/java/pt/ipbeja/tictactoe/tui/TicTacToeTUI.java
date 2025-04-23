package pt.ipbeja.tictactoe.tui;

import pt.ipbeja.tictactoe.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeTUI implements View {
    private static final Scanner scanner = new Scanner(System.in);

    private final TicTacToeGame game;

    private final String[][] board;

    public TicTacToeTUI(int size) {
        board = new String[size][size];
        for (String[] row : board) {
            Arrays.fill(row,"_");
        }
        this.game = new TicTacToeGame(size, this);
        //inicialiar variaveis

    }

    public void play() {
        while (true) {


            printBoard();
            System.out.println("Enter Cooordinates: "); // 0 0
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Position position = new Position(row, col);
            this.game.positionSelected(position);
            //criar Posisiton
            //invocar positionSelected com position
        }
    }

    private void printBoard() {
        for (String[] row : board){
            System.out.println(Arrays.toString(row));
        }
    }

    @Override
        public void onBoardMarkChanged (Mark mark, Position position){
            int row = position.getRow();
            int col = position.getCol();

            switch (mark){
                case EMPTY -> board[row][col] = "_";
                case X_MARK -> board[row][col] = "X";
                case O_MARK -> board[row][col] = "O";
            }

        //atualizar a bord
        }

        @Override
        public void onGameWon (Player player){
            printBoard();
            System.out.printf("Player %s won!",player);
            System.exit(0);
        }

        @Override
        public void onGameDraw () {
        printBoard();
            System.out.printf("Draw!");
            System.exit(0);
        }

}
