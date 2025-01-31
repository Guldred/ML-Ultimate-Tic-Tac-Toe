package game.elements;

import game.system.Players;
import game.system.TicTacToePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class GameManager {
    private final BoardModel boardModel;
    private final BoardManager boardManager;
    private final TurnManager turnManager;
    private final WinStatusManager winStatusManager;

    private Players currentPlayerTurn;

    public GameManager() {
        this.boardModel = new BoardModel();
        this.boardManager = new BoardManager(boardModel);
        this.winStatusManager = new WinStatusManager(boardModel);
        this.turnManager = new TurnManager(boardModel, winStatusManager);
        this.currentPlayerTurn = Players.X;
    }

    public BoardManager getBoardManager() {
        return this.boardManager;
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
