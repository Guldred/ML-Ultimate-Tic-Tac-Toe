package game.system;

import game.elements.BoardManager;

import javax.swing.*;
import java.awt.*;

public class TicTacToePanel extends JPanel {
    private final BoardManager board;

    public TicTacToePanel(BoardManager board) {
        this.board = board;
        setPreferredSize(new Dimension(600, 600)); // Richtige Fenstergröße setzen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.draw(g);
    }
}
