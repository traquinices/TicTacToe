package pt.ipbeja.tictactoe.ui;

import javafx.css.Size;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import pt.ipbeja.tictactoe.model.*;

public class TicTacToeBoard extends GridPane implements View {
    //esta class é usada para identificar a localização de um mark na tictactoeboard

    // constante que define o tamanho do tabuleiro
    public static final int SIZE = 3;

    private final TicTacToeGame game = new TicTacToeGame(SIZE,this);

    private TicTacToeButton[][] buttons = new TicTacToeButton[SIZE][SIZE];

    public TicTacToeBoard() {
        createBoard();
    }

    private void createBoard() {
        /* todo adicionar 2 items ao filemenu
          - botao para carregar um ficheiro
          deve invocar um metodo do TicTaccToeGame para ler
          - botao para gravar um ficheiro
          deve invocar um metodo do TicTacToeGame para gravar
          o estado do ogo para o o ficheiro indicado pelo utilizador

        */
        Menu fileMenu = new Menu("file");
        MenuBar menuBar = new MenuBar(fileMenu);

        ButtonHandler handler = new ButtonHandler();


        // para cada linha
        for (int i = 0; i < SIZE; i++) {

            // para cada coluna (elemento da linha)
            for (int j = 0; j < SIZE; j++) {
                Position position = new Position(i, j);


                TicTacToeButton button = new TicTacToeButton(position);
                buttons[i][j] = button;

                button.setOnAction(handler);
                add(button, j, i +1);
            }

        }
    }


    /**
     * Resets the game board
     */
    private void resetBoard() {

        // Para cada componente neste TicTacToeBoard (GridPane)
        for (Node child : getChildren()) {
            // Sabemos que o componente (Node) é um botão, portanto fazemos o cast para TicTacToeButton
            TicTacToeButton button = (TicTacToeButton) child;
            button.setEmpty();
        }
    }

    @Override
    public void onBoardMarkChanged(Mark mark, Position position) {
        //System.out.printf(%s on position (%d, %d)\n", mark, position.getRow(), position.getCol());
        int col = position.getCol();
        int row = position.getRow();

        TicTacToeButton button = buttons[row][col];
        button.setMark(mark);

    }

    @Override
    public void onGameWon(Player player) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Player " + player + " won!");
        alert.showAndWait();
    }

    @Override
    public void onGameDraw() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Draw!");
        alert.showAndWait();
    }


    class ButtonHandler implements EventHandler<ActionEvent> {


        @Override
        public void handle(ActionEvent actionEvent) {
            TicTacToeButton button = (TicTacToeButton) actionEvent.getSource();

            Position position = button.getPosition();

            game.positionSelected(position);
        }
    }

    private void positionSelected(Position position) {





    }
}
