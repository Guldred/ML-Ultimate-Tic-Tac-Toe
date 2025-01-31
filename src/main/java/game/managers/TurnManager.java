package game.managers;

import game.models.*;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

public class TurnManager {

    private final BoardModel boardModel;
    private final WinStatusManager winStatusManager;

    public TurnManager(BoardModel boardModel, WinStatusManager winStatusManager) {
        this.boardModel = boardModel;
        this.winStatusManager = winStatusManager;
    }

    public boolean makeMove(@NotNull SubBoardModel targetBoard, @NotNull FieldModel targetField, @NotNull Players player) {
        if (targetBoard.boardStatus != BoardStatus.ACTIVE) {
            return false;
        }
        if (targetField.occupiedBy == Players.NONE) {
            targetField.occupiedBy = player;
            return true;
        }
        return false;
    }

    public boolean makeMoveByMouseClick(@NotNull MouseEvent e, @NotNull Players player) {
        int bigX = e.getX() / 200;
        int bigY = e.getY() / 200;
        int fieldX = (e.getX() % 200) / 66;
        int fieldY = (e.getY() % 200) / 66;
        int boardIndex = bigY * 3 + bigX;
        SubBoardModel targetBoard = boardModel.subBoards[boardIndex];
        FieldModel targetField = boardModel.subBoards[boardIndex].fields[fieldY][fieldX];
        return makeMove(targetBoard, targetField, player);
    }
}
