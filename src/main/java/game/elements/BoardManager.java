package game.elements;

import java.awt.*;
import java.util.Map;

import game.system.BoardStatus;

public class BoardManager {
    private final BoardModel boardModel;

    private final Map<BoardStatus, Color> statusColors = Map.of(
        BoardStatus.ACTIVE, Color.BLACK,
        BoardStatus.INACTIVE, Color.GRAY,
        BoardStatus.WON_X, Color.getHSBColor(0.3f, 1.0f, 0.5f),
        BoardStatus.WON_O, Color.BLUE,
        BoardStatus.DRAW, Color.CYAN
    );

    public BoardManager(BoardModel boardModel) {
        this.boardModel = boardModel;
        for (int i = 0; i < 9; i++) {
            boardModel.bigBoard[i] = ' ';
            boardModel.boardStatus[i] = BoardStatus.ACTIVE;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    boardModel.board[i][j][k] = ' ';
                }
            }
        }
    }

    private void updateBoardStatus() {}

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        for (int i = 1; i < 3; i++) {
            g.drawLine(i * 200, 0, i * 200, 600);
            g.drawLine(0, i * 200, 600, i * 200);
        }

        for (int i = 0; i < 9; i++) {
            int xOffset = (i % 3) * 200;
            int yOffset = (i / 3) * 200;

            g.setColor(statusColors.get(boardModel.boardStatus[i]));
            for (int j = 1; j < 3; j++) {
                g.drawLine(xOffset + j * 66, yOffset, xOffset + j * 66, yOffset + 200);
                g.drawLine(xOffset, yOffset + j * 66, xOffset + 200, yOffset + j * 66);
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (boardModel.board[i][j][k] != ' ') {
                        if (boardModel.board[i][j][k] == 'X') {
                            g.setColor(statusColors.get(BoardStatus.WON_X));
                        } else {
                            g.setColor(statusColors.get(BoardStatus.WON_O));
                        }
                        g.drawString(String.valueOf(boardModel.board[i][j][k]), xOffset + k * 66 + 25, yOffset + j * 66 + 40);
                    }
                }
            }
        }
    }
}
