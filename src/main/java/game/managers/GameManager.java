package game.managers;

import game.models.BoardModel;
import game.models.Players;
import game.system.TicTacToePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class GameManager {
    private final BoardModel boardModel;
    private final FrameUpdater frameUpdater;
    private final TurnManager turnManager;
    private final WinStatusManager winStatusManager;

    private Players currentPlayerTurn;

    public GameManager() {
        this.boardModel = new BoardModel();
        this.frameUpdater = new FrameUpdater(boardModel);
        this.winStatusManager = new WinStatusManager(boardModel);
        this.turnManager = new TurnManager(boardModel, winStatusManager);
        this.currentPlayerTurn = Players.X;
    }

    public FrameUpdater getBoardManager() {
        return this.frameUpdater;
    }

    private void updateBoardStatus() {
        //Update all Fields before the draw call
    }

    public void mousePressed(MouseEvent e, TicTacToePanel panel) {
        if (turnManager.makeMoveByMouseClick(e, currentPlayerTurn)) {
            switchPlayer();
            panel.repaint();

            if (winStatusManager.checkBigBoardWin()) {
                switchPlayer(); //Switch back to last player because they won
                JOptionPane.showMessageDialog(panel, "Spieler " + (currentPlayerTurn.toString().charAt(0)) + " gewinnt!");
                System.exit(0);
            }
        }
    }

    private void switchPlayer() {
        if (currentPlayerTurn == Players.X) {
            currentPlayerTurn = Players.O;
        } else {
            currentPlayerTurn = Players.X;
        }
    }


}
