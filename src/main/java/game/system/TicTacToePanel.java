package game.system;

import game.managers.FrameUpdater;

import javax.swing.*;
import java.awt.*;

public class TicTacToePanel extends JPanel {
    private final FrameUpdater board;

    public TicTacToePanel(FrameUpdater board) {
        this.board = board;
        setPreferredSize(new Dimension(600, 600)); // Richtige Fenstergröße setzen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.draw(g);
    }
}
