package main;

import game.core.UltimateTicTacToe;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UltimateTicTacToe().setVisible(true));
    }
}
