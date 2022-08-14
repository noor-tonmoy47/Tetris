package main;

import controller.Direction;
import controller.GameController;
import controller.PaintController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Start extends JFrame {


    private GameController gameController = GameController.getInstance();
    private GamePanel gamePanel = GamePanel.getInstance();
    private RightPanel rightPanel = RightPanel.getInstance();
    private LeftPanel leftPanel = LeftPanel.getInstance();

    public Start() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.add(gamePanel, BorderLayout.CENTER);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.pack();
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (gameController.canMoveShape(Direction.LEFT, gameController.getCurrentShape()))
                            gameController.move(Direction.LEFT, gameController.getCurrentShape());
                        gamePanel.repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (gameController.canMoveShape(Direction.RIGHT, gameController.getCurrentShape()))
                            gameController.move(Direction.RIGHT, gameController.getCurrentShape());
                        gamePanel.repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        if (gameController.canShapeStepDown(gameController.getCurrentShape())) {
                            gameController.stepDownShape(gameController.getCurrentShape());
                        }

                        gamePanel.repaint();
                        break;
                    case KeyEvent.VK_UP:
                        gameController.rotate(gameController.getCurrentShape());
                        gamePanel.repaint();
                        break;
                    case KeyEvent.VK_P:
                        if (gameController.isGameRunning()) {
                            gameController.setPaused(!gameController.isPaused());
                        }
                        break;
                    case KeyEvent.VK_R:
                        if (gameController.isGameRunning()) {
                            gamePanel.getTimer().setDelay(gameController.getGameSpeed());
                            gameController.resetGame();
                            gameController.setGameRunning(true);
                            gamePanel.repaint();
                            leftPanel.repaint();
                            rightPanel.repaint();
                            PaintController.getInstance().setShowRecordNameInput(false);
                        }
                        break;
                    case KeyEvent.VK_ENTER:
                        if (!gameController.isGameRunning()) {
                            gameController.resetGame();
                            gameController.setGameRunning(true);
                            leftPanel.repaint();
                            gamePanel.repaint();
                        } else if (gameController.isGameOver()) {
                            gameController.resetGame();
                            leftPanel.repaint();
                            rightPanel.repaint();
                            gamePanel.repaint();
                            PaintController.getInstance().setShowRecordNameInput(false);
                        }
                        break;
                }
            }

//            @Override
//            public void keyReleased(KeyEvent e) {
//                switch (e.getKeyCode()) {
//                    case KeyEvent.VK_DOWN:
//                        gamePanel.getTimer().setDelay(gameController.getGameSpeed()
//                                + gameController.getAcceleration() - gameController.getAcceleration() * gameController.getLevel());
//                        break;
//                }
//            }
        });
    }

    public static void main(String[] args) {
        Start startGame = new Start();
    }
}
