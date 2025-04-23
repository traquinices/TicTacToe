package pt.ipbeja.tictactoe.ui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pt.ipbeja.tictactoe.model.Mark;
import pt.ipbeja.tictactoe.model.Position;

public class TicTacToeButton extends Button {

    private final Image noPlayer = new Image("/noplayer.png");
    private final Image playerX = new Image("/player1.png");
    private final Image playerO = new Image("/player2.png");

    private final ImageView imageView;
    private final Position position;

    public TicTacToeButton(Position position) {
        this.position = position;

        imageView = new ImageView(noPlayer);
        this.setGraphic(imageView);
    }


    public void setPlayerX() {
        imageView.setImage(playerX);
        setDisable(true);

    }

    public void setPlayerO() {
        imageView.setImage(playerO);
        setDisable(true);

    }

    public void setEmpty() {
        imageView.setImage(noPlayer);
        setDisable(false);

    }

    public Position getPosition() {
        return position;
    }

    public void setMark(Mark mark) {
        switch (mark) {
            case EMPTY -> {
                imageView.setImage(noPlayer);
            }
            case X_MARK -> {
                imageView.setImage(playerX);
            }
            case O_MARK -> {
                imageView.setImage(playerO);
            }
        }

    }
}
