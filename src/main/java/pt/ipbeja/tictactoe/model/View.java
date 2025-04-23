package pt.ipbeja.tictactoe.model;

public interface View {
    void onBoardMarkChanged(Mark mark, Position position);

    void onGameWon(Player player);

    void onGameDraw();

}
