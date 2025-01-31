package game.managers;

import game.models.BoardModel;
import game.models.BoardStatus;
import game.models.Players;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

public class TurnManager {

    private final BoardModel boardModel;
    private final WinStatusManager winStatusManager;

    public TurnManager(BoardModel boardModel, WinStatusManager winStatusManager) {
        this.boardModel = boardModel;
        this.winStatusManager = winStatusManager;
    }

    public boolean makeMove(int bigX, int bigY, int smallX, int smallY, Players player) {
        int boardIndex = bigY * 3 + bigX;
        if (boardModel.subBoards[boardIndex].boardStatus != BoardStatus.ACTIVE) {
            return false;
        }
        if (boardModel.subBoards[boardIndex].fields[smallY][smallX].occupiedBy == Players.NONE) {
            boardModel.subBoards[boardIndex].fields[smallY][smallX].occupiedBy = player;
            if (winStatusManager.checkSmallBoardWin(boardIndex, player)) {
                boardModel.subBoards[boardIndex].boardStatus = BoardStatus.FINISHED;
                boardModel.subBoards[boardIndex].winner = player;
                System.out.println("Player " + player.toString() + " wins small board " + boardIndex);
            }
            return true;
        }
        return false;
    }

    public boolean makeMoveByMouseClick(@NotNull MouseEvent e, Players player) {
        int bigX = e.getX() / 200;
        int bigY = e.getY() / 200;
        int smallX = (e.getX() % 200) / 66;
        int smallY = (e.getY() % 200) / 66;
        return makeMove(bigX, bigY, smallX, smallY, player);
    }
}
