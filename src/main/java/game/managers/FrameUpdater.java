package game.managers;

import java.awt.*;
import java.util.Map;

import game.models.BoardModel;
import game.models.BoardStatus;
import game.models.Players;

public class FrameUpdater {
    private final BoardModel boardModel;

    private final Map<BoardStatus, Color> statusColors = Map.of(
        BoardStatus.ACTIVE, Color.BLACK,
        BoardStatus.INACTIVE, Color.GRAY,
        BoardStatus.FINISHED, Color.GRAY
    );

    private final Map<Players, Color> playerColors = Map.of(
            Players.X, Color.getHSBColor(0.3f, 1.0f, 0.5f),
            Players.O, Color.BLUE,
            Players.NONE, Color.CYAN
    );

    public FrameUpdater(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        for (int i = 1; i < 3; i++) {
            g.drawLine(i * 200, 0, i * 200, 600);
            g.drawLine(0, i * 200, 600, i * 200);
        }

        for (int i = 0; i < 9; i++) {
            int xOffset = (i % 3) * 200;
            int yOffset = (i / 3) * 200;

            g.setColor(statusColors.get(boardModel.subBoards[i].boardStatus));
            for (int j = 1; j < 3; j++) {
                g.drawLine(xOffset + j * 66, yOffset, xOffset + j * 66, yOffset + 200);
                g.drawLine(xOffset, yOffset + j * 66, xOffset + 200, yOffset + j * 66);
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (boardModel.subBoards[i].fields[j][k].occupiedBy != Players.NONE) {
                        if (boardModel.subBoards[i].fields[j][k].occupiedBy == Players.X) {
                            g.setColor(playerColors.get(Players.X));
                        } else {
                            g.setColor(playerColors.get(Players.O));
                        }
                        g.drawString(boardModel.subBoards[i].fields[j][k].occupiedBy.toString(), xOffset + k * 66 + 25, yOffset + j * 66 + 40);
                    }
                }
            }
        }
    }
}
