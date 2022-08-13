package main;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    public static final RightPanel INSTANCE = new RightPanel();
    public static final int TILE_SIZE = GamePanel.TILE_SIZE;
    public static final int BORDER_SIZE = GamePanel.BORDER_SIZE;
    public static final int PANEL_WIDTH = TILE_SIZE * 5 + BORDER_SIZE * 2;
    public static final int PANEL_HEIGHT = GamePanel.PANEL_HEIGHT;
    private RightPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.CYAN);
    }

    public static RightPanel getInstance() {
        return INSTANCE;
    }
}
