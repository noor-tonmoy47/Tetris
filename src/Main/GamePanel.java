package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    public static final int ROW_COUNT = 20;
    public static final int COLUMNS_COUNT = 10;
    public static final int BORDER_SIZE = 5;
    public static final int TILE_SIZE = 25;

    private static final GamePanel  INSTANCE = new GamePanel();
    public static final int PANEL_WIDTH = TILE_SIZE * COLUMNS_COUNT + BORDER_SIZE * 2;

    public static final int PANEL_HEIGHT = TILE_SIZE * ROW_COUNT + BORDER_SIZE * 2;
    private Timer timer;
    private GamePanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        timer = new Timer(500, this);
        timer.start();
    }

    public static GamePanel getINSTANCE(){
        return INSTANCE ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
