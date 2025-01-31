package game.core;

import game.managers.*;
import game.system.TicTacToePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UltimateTicTacToe extends JFrame {
    private final GameManager gameManager;



    public UltimateTicTacToe() {
        setTitle("Ultimate Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gameManager = new GameManager();

        TicTacToePanel panel = new TicTacToePanel(gameManager.getBoardManager());
        add(panel);
        pack();
        setLocationRelativeTo(null);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                gameManager.mousePressed(e, panel);
            }
        });
    }
}
