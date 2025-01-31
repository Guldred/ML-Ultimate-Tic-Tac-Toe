package game.elements;

import game.system.BoardStatus;
import game.system.Players;
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
        if (boardModel.boardStatus[boardIndex] != BoardStatus.ACTIVE) {
            return false;
        }
        if (boardModel.board[boardIndex][smallY][smallX] == ' ') {
            boardModel.board[boardIndex][smallY][smallX] = player.toString().charAt(0);
            if (winStatusManager.checkSmallBoardWin(boardIndex, player)) {
                boardModel.bigBoard[boardIndex] = player.toString().charAt(0);
                System.out.println("Player " + player.toString().charAt(0) + " wins small board " + boardIndex);
                boardModel.boardStatus[boardIndex] = player.toString().equals("X") ? BoardStatus.WON_X : BoardStatus.WON_O;
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
