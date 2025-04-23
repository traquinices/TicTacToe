package pt.ipbeja.tictactoe.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeStart extends Application {
    @Override
    public void start(Stage stage) {

        TicTacToeBoard board = new TicTacToeBoard();

        Scene scene = new Scene(board);

        stage.setScene(scene);

        stage.show();


    }



    public static void main(String[] args) {
        launch();
    }
}