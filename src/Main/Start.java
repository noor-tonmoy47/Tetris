package Main;

import javax.swing.*;
import java.awt.*;


public class Start extends JFrame {

    private GamePanel gamePanel = GamePanel.getINSTANCE();
    private RightPanel rightPanel = RightPanel.getINSTANCE();
    private LeftPanel leftPanel = LeftPanel.getINSTANCE();

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
    }

    public static void main(String[] args) {
        Start startGame = new Start();
    }
}
